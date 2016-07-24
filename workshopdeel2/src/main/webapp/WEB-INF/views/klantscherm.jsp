<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Klantgegevens</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Your Profile</h1>
    <c:out value="${klant.klantID}" /><br/>
    <c:out value="${klant.voornaam}" /> <c:out value="${klant.achternaam}" /><br/>
    <c:out value="${klant.email}" />
    
    <c:out value="${adres.straatnaam}" />
    <c:out value="${adres.huisnummer}" />
    <c:out value="${adres.postcode}" />
    <c:out value="${adres.woonplaats}" />
    
  </body>
</html>