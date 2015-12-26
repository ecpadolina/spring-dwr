<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Spring Activity - Person Management</title>

</head>
<body>
	<jsp:include page="headers.jsp"/>
	<h1>Person Management</h1>
	Sort By: <select id="column" name="column">
			<option value="id">Id</option>
			<option value="name.lastName">Last Name</option>
			<option value="gwa">Gwa</option>
		</select>
		<select id="order" name="order">
			<option value="1">Ascending</option>
			<option value="2">Descending</option>
		</select>
		<select id="role" name="role">
		</select>
		<input type="submit" value="Search" onclick="listPersons()" />
	<br>
	<table>
		<thead>
			<tr>
	            <th>ID</th>
	            <th>First Name</th>
	            <th>Last Name</th>
	            <th><spring:message code="label.birthday"/></th>
	            <th><spring:message code="label.grade"/></th>
	            <th><spring:message code="label.action"/></th>
			</tr>
		</thead>
		<tbody id="person">
		</tbody>
	</table>
	 <br>
	 <h2> Action: </h2>
	 User Id: <input type="text" id="personId" size="10"/> <input type="button" value="Delete" onclick="deletePerson()"/>
	 
	<script type='text/javascript' src="/dwr/engine.js"></script>
    <script type='text/javascript' src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/DWRService.js"></script>
	 <script src="/resources/personDWR.js"></script>
</body>
</html>
