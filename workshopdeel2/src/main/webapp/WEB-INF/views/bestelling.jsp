<%-- 
    Document   : bestelling
    Created on : 22-jul-2016, 15:04:12
    Author     : maurice
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Bestelling</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Person
</h1>

<c:url var="addAction" value="/person/add" ></c:url>

<form:form action="${addAction}" commandName="bestelling">
<table>
    <c:if test="${!empty bestelling.bestelling_id}">
	<tr>
		<td>
			<form:label path="bestelling_id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="bestelling_id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="bestelling_id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="bestelNummer">
				<spring:message text="bestelNummer"/>
			</form:label>
		</td>
		<td>
			<form:input path="bestelNummer" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="country">
				<spring:message text="Country"/>
			</form:label>
		</td>
		<td>
			<form:input path="country" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty person.name}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty person.name}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Bestelling List</h3>
<c:if test="${!empty listBestelling}">
	<table class="tg">
	<tr>
		<th width="80">Bestelling ID</th>
		<th width="120">Artikel ID</th>
		<th width="120">Artikel Aantal</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listBestelling}" var="bestelartikel">
		<tr>
			<td>${listArtikel.id}</td>
			<td>${person.name}</td>
			<td>${person.country}</td>
			<td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
