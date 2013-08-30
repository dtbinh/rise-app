package com.rise.common.util.database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.rise.common.util.checker.Precondition;
import com.rise.common.util.constants.HibernateHelperConstants;
import com.rise.common.util.exception.DatabaseException;

public class TableDataExporter extends AbstractDataImporterExporter implements
		DataExporter {

	private static final String SELECT_FROM = "select * from `";
	private static final String APOSTROPHE = "`";

	public TableDataExporter() {
		super();
	}

	public TableDataExporter(String argTableName, String argDataFileName,
			String argFieldDelimiter, String argRecordDelimiter) {
		super(argTableName, argDataFileName, argFieldDelimiter,
				argRecordDelimiter);
	}

	public TableDataExporter(String argTableName, String argFileExtension) {
		super(argTableName, argFileExtension);
	}

	@Override
	public void exportData() throws DatabaseException {
		BufferedWriter bufferedWriter = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSetMetaData resultSetMetaData = null;
		try {
			connection = DatabaseUtil.getInstance().getConnection();
			String sqlQuery = SELECT_FROM + this.getTableName() + APOSTROPHE;
			preparedStatement = connection.prepareStatement(sqlQuery);
			resultSet = preparedStatement.executeQuery();
			resultSetMetaData = resultSet.getMetaData();
			bufferedWriter = new BufferedWriter(new FileWriter(
					getDataFileName()));
			String columnHeadersToken = getColumnHeadersToken(resultSetMetaData);
			bufferedWriter.write(columnHeadersToken);
			bufferedWriter.write(this.getRecordDelimiter());

			writeRows(bufferedWriter, resultSet, resultSetMetaData);
			DatabaseUtil.getInstance().commit(connection);
		} catch (Exception e) {
			DatabaseUtil.getInstance().rollback(connection);
			throw new DatabaseException("Exception while exporting table: "
					+ this.getTableName() + " to file:"
					+ this.getDataFileName(), e);
		} finally {
			DatabaseUtil.getInstance().close(resultSet);
			DatabaseUtil.getInstance().close(preparedStatement);
			DatabaseUtil.getInstance().close(connection);
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

	private void writeRows(BufferedWriter bufferedWriter, ResultSet resultSet,
			ResultSetMetaData resultSetMetaData) throws SQLException,
			IOException {
		while (resultSet.next()) {
			StringBuilder recordBuilder = new StringBuilder();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int i = 1; i < columnCount; i++) {
				recordBuilder.append(resultSet.getObject(i));
				if (i < columnCount) {
					recordBuilder.append(this.getFieldDelimiter());
				}
			}
			bufferedWriter.write(recordBuilder.toString());
			bufferedWriter.write(this.getRecordDelimiter());
		}
	}

	private String getColumnHeadersToken(ResultSetMetaData argResultSetMetaData) {
		ResultSetMetaData resultSetMetaData = Precondition.ensureNotNull(
				argResultSetMetaData,
				HibernateHelperConstants.RESULT_SET_META_DATA);
		try {
			int columnCount = resultSetMetaData.getColumnCount();
			columnCount = Precondition.ensureNonNegative(columnCount,
					HibernateHelperConstants.COLUMN_LENGTH);
			StringBuilder headerBuilder = new StringBuilder();
			for (int i = 1; i < columnCount; i++) {
				headerBuilder.append(resultSetMetaData.getColumnName(i));
				if (i < columnCount) {
					headerBuilder.append(this.getFieldDelimiter());
				}
			}
			return headerBuilder.toString();
		} catch (Exception e) {
			throw new DatabaseException(
					"Exception while getting the result set meta data: ", e);
		}
	}

	@Override
	public void exportData(String argTableName) throws DatabaseException {

	}

}
