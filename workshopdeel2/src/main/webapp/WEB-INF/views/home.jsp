<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>RSvier</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Welcome to Workshop</h1>

    <a href="<c:url value="/spittles" />">Koop hier</a> | 
    <a href="<c:url value="/klanten" />">Registreer</a>
  </body>
</html>