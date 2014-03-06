//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.05 at 05:34:30 PM IST 
//


package com.generator.data.xmlns.configuration.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataSourceConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataSourceConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.data.generator.com/configuration/v1}BaseObject">
 *       &lt;sequence>
 *         &lt;element name="mainDataSource" type="{http://xmlns.data.generator.com/configuration/v1}DataSource"/>
 *         &lt;element name="additionalDataSource" type="{http://xmlns.data.generator.com/configuration/v1}AdditionalDataSource" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSourceConfiguration", propOrder = {
    "mainDataSource",
    "additionalDataSource"
})
public class DataSourceConfiguration
    extends BaseObject
{

    @XmlElement(required = true)
    protected DataSource mainDataSource;
    protected List<AdditionalDataSource> additionalDataSource;

    /**
     * Gets the value of the mainDataSource property.
     * 
     * @return
     *     possible object is
     *     {@link DataSource }
     *     
     */
    public DataSource getMainDataSource() {
        return mainDataSource;
    }

    /**
     * Sets the value of the mainDataSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSource }
     *     
     */
    public void setMainDataSource(DataSource value) {
        this.mainDataSource = value;
    }

    /**
     * Gets the value of the additionalDataSource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalDataSource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalDataSource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalDataSource }
     * 
     * 
     */
    public List<AdditionalDataSource> getAdditionalDataSource() {
        if (additionalDataSource == null) {
            additionalDataSource = new ArrayList<AdditionalDataSource>();
        }
        return this.additionalDataSource;
    }

}
