<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript">
      var jq = jQuery.noConflict();
    </script>
    <script type='text/javascript' src="/dwr/engine.js"></script>
    <script type='text/javascript' src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/personDWRService.js"></script>
 <title>Spring MVC - DWR </title>
</head>
<body>
    Sort By: <select id="column" name="column">
      <option value="id">Id</option>
      <option value="name.lastName">Last Name</option>
      <option value="gwa">Gwa</option>
    </select>
    <select id="order" name="order">
      <option value="1">Ascending</option>
      <option value="2">Descending</option>
    </select>
    <select id="role" name="role"/>
  <input type="submit" value="Search" onclick="listPersons()" />

 <table>
  <thead>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Birthday</th>
    <th>Grade</th>
  </thead>
  <tbody id="person">
  </tbody>
 </table>
 <span id="id"></span>

 <br>
 <h2> Action: </h2>
 User Id: <input type="text" id="personId" size="10"/> <input type="button" value="Delete" onclick="deletePerson()"/>


<script src="/resources/personDWR.js"></script>
</body>
</html>