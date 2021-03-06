<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.rise.common.model.Address"%>
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Rural integration Sustainable Employment</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<!--   <link rel="shortcut icon" href="../favicon.ico">  -->
<link rel="stylesheet" type="text/css"
	href="/rise/resources/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="/rise/resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="/rise/resources/css/animate-custom.css" />
<link rel="stylesheet" type="text/css"
	href="/rise/resources/css/menu.css" />
<!-- <script type="text/javascript">
	function changeContent(){
		document.getElementById('divcontainer').load('/rise/candidate');
	}
	</script> -->
</head>
<body>
	<div class="container">
		<header>
			<h1>Rural integration Sustainable Employment</h1>
		</header>
		<div id="menubar" style="width: auto">
			<ul id="menu">
				<li><a name="home" href="/rise/home">Home</a></li>
				<li><a name="person" href="/rise/person/personcreate"
					class="activesection">Person</a></li>
				<li><a name="trainer" href="/rise/trainer">Trainer</a></li>
				<li><a name="agents" href="/rise/agents">Agents</a></li>
				<li><a name="overview" href="/rise/overview">Overview</a></li>
				<li><a name="contactus" href="/rise/contactus">Contact Us</a></li>
			</ul>
		</div>
		<form:form modelAttribute="person" action="update" method="post">
			<form:input path="id" value="${editPerson.getId()}" type="hidden" />
			<div class="buttondiv">
				<input type="submit" value="save" class="buttonstyle"> <input
					type="button" value="Cancel" onClick="history.go(-1);return true;"
					class="buttonstyle" />
			</div>
			<div id="divcontainer" class="content">
				<h1 align="left" class="headersection">
					<b>Personal Information</b>
				</h1>
				<table>
					<tr>
						<td>
							<table>
								<%-- <tr>
									<td align="right"><form:label path="id" for="id">
											<spring:message code="label.id" />
										</form:label></td>
									<td><form:input path="id" value="${person.getId()}"/></td>
								</tr> --%>
								<tr>
									<td align="right"><form:label path="personName.title"
											for="personName.title">
											<spring:message code="label.title" />
										</form:label></td>
									<td><form:input path="personName.title"
											value="${person.getPersonName().getTitle()}" /></td>
								</tr>
								<tr>
									<td align="right"><form:label path="personName.firstName"
											for="personName.firstName">
											<spring:message code="label.firstName" />
										</form:label></td>
									<td><form:input path="personName.firstName"
											value="${person.getPersonName().getFirstName()}" /></td>
								</tr>
								<tr>
									<td align="right"><form:label path="personName.middleName"
											for="personName.middleName">
											<spring:message code="label.middleName" />
										</form:label></td>
									<td><form:input path="personName.middleName"
											value="${person.getPersonName().getMiddleName()}" /></td>
								</tr>
								<tr>
									<td align="right"><form:label path="personName.lastName"
											for="personName.lastName">
											<spring:message code="label.lastName" />
										</form:label></td>
									<td><form:input path="personName.lastName"
											value="${person.getPersonName().getLastName()}" /></td>
								</tr>
								<tr>
									<td align="right"><form:label path="personName.suffix"
											for="personName.suffix">
											<spring:message code="label.suffix" />
										</form:label></td>
									<td><form:input path="personName.suffix"
											value="${person.getPersonName().getSuffix()}" />
									</td>
								</tr>
							</table></td>
						<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>
							<table>
								<tr>
									<td align="right"><form:label path="dateOfBirth"
											for="dateOfBirth">
											<spring:message code="label.dateOfBirth" />
										</form:label></td>
									<td><form:input path="dateOfBirth"
											value="${person.getDateOfBirth()}" /></td>
								</tr>
								<tr>
									<td align="right"><form:label path="aadhaarNumber"
											for="aadhaarNumber">
											<spring:message code="label.aadhaarNumber" />
										</form:label></td>
									<td><form:input path="aadhaarNumber"
											value="${person.getAadhaarNumber()}" /></td>
								</tr>
							</table></td>
					</tr>
				</table>
				<h1 align="left" class="headersection">
					<b>Address Information</b>
				</h1>
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<td align="right"><form:label
											path="contactInformation.primaryAddress.streetAddress"
											for="contactInformation.primaryAddress.streetAddress">
											<spring:message code="label.streetAddress" />
										</form:label></td>
									<td><form:input
											path="contactInformation.primaryAddress.streetAddress"
											value="${person.getContactInformation().getPrimaryAddress().getStreetAddress()}" />
									</td>
								</tr>
								<tr>
									<td align="right"><form:label
											path="contactInformation.primaryAddress.state"
											for="contactInformation.primaryAddress.state">
											<spring:message code="label.state" />
										</form:label></td>
									<td><form:input
											path="contactInformation.primaryAddress.state"
											value="${person.getContactInformation().getPrimaryAddress().getState()}" />
									</td>
								</tr>
								<tr>
									<td align="right"><form:label
											path="contactInformation.primaryAddress.city"
											for="contactInformation.primaryAddress.city">
											<spring:message code="label.city" />
										</form:label></td>
									<td><form:input
											path="contactInformation.primaryAddress.city"
											value="${person.getContactInformation().getPrimaryAddress().getCity()}" />
									</td>
								</tr>
							</table></td>
						<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>
							<table>
								<tr>
									<td align="right"><form:label
											path="contactInformation.primaryAddress.postalCode"
											for="contactInformation.primaryAddress.postalCode">
											<spring:message code="label.postalCode"
												value="${person.getContactInformation().getPrimaryAddress().getPostalCode()}" />
										</form:label></td>
									<td><form:input
											path="contactInformation.primaryAddress.postalCode" /></td>
								</tr>
								<tr>
									<td align="right"><form:label
											path="contactInformation.primaryAddress.country"
											for="contactInformation.primaryAddress.country">
											<spring:message code="label.country" />
										</form:label></td>
									<td><form:input
											path="contactInformation.primaryAddress.country"
											value="${person.getContactInformation().getPrimaryAddress().getCountry()}" />
									</td>
								</tr>
							</table></td>
					</tr>
				</table>
				<h1 align="left" class="headersection">
					<b>Contact Information</b>
				</h1>
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<td align="right"><form:label
											path="contactInformation.email1"
											for="contactInformation.email1">
											<spring:message code="label.email1" />
										</form:label></td>
									<td><form:input path="contactInformation.email1"
											value="${person.getContactInformation().getEmail1()}" /></td>
									<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td align="right"><form:label
											path="contactInformation.email2"
											for="contactInformation.email2">
											<spring:message code="label.email2" />
										</form:label></td>
									<td><form:input path="contactInformation.email2"
											value="${person.getContactInformation().getEmail2()}" /></td>
									<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td align="right"><form:label
											path="contactInformation.email3"
											for="contactInformation.email3">
											<spring:message code="label.email3" />
										</form:label></td>
									<td><form:input path="contactInformation.email3"
											value="${person.getContactInformation().getEmail3()}" /></td>
								</tr>
								<!-- </table>
						</td>
						<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>
							<table> -->
								<tr>
									<td align="right"><form:label
											path="contactInformation.phone1"
											for="contactInformation.phone1">
											<spring:message code="label.phone1" />
										</form:label></td>
									<td><form:input path="contactInformation.phone1"
											value="${person.getContactInformation().getPhone1()}" /></td>
									<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td align="right"><form:label
											path="contactInformation.phone2"
											for="contactInformation.phone2">
											<spring:message code="label.phone2" />
										</form:label></td>
									<td><form:input path="contactInformation.phone2"
											value="${person.getContactInformation().getPhone2()}" /></td>
									<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td align="right"><form:label
											path="contactInformation.phone3"
											for="contactInformation.phone3">
											<spring:message code="label.phone3"
												value="${person.getContactInformation().getPhone3()}" />
										</form:label></td>
									<td><form:input path="contactInformation.phone3" /></td>

								</tr>
								<!-- </table>
						</td>
						<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>
							<table> -->
								<tr>
									<td align="right"><form:label
											path="contactInformation.mobile1"
											for="contactInformation.mobile1">
											<spring:message code="label.mobile1"
												value="${person.getContactInformation().getMobile1()}" />
										</form:label></td>
									<td><form:input path="contactInformation.mobile1" /></td>
									<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td align="right"><form:label
											path="contactInformation.mobile2"
											for="contactInformation.mobile2">
											<spring:message code="label.mobile2" />
										</form:label></td>
									<td><form:input path="contactInformation.mobile2"
											value="${person.getContactInformation().getMobile2()}" /></td>
									<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td align="right"><form:label
											path="contactInformation.mobile3"
											for="contactInformation.mobile3">
											<spring:message code="label.mobile3" />
										</form:label></td>
									<td><form:input path="contactInformation.mobile3"
											value="${person.getContactInformation().getMobile3()}" /></td>
								</tr>
								<tr>
									<td align="right"><form:label
											path="contactInformation.website"
											for="contactInformation.website">
											<spring:message code="label.website" />
										</form:label></td>
									<td><form:input path="contactInformation.website"
											value="${person.getContactInformation().getWebsite()}" />
									</td>
								</tr>
							</table>
				</table>
			</div>
			<div class="buttondiv">
				<input type="submit" value="save" class="buttonstyle"> <input
					type="button" value="Cancel" onClick="history.go(-1);return true;"
					class="buttonstyle" />
			</div>
		</form:form>
	</div>
</body>
</html>