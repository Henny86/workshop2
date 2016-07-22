<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
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

    <a id="HomeImage" href="<s:url value="/" />"><img 
    src="<s:url value="/resources" />/images/oven.jpg" width="375" height="269"/></a>
    <br>
    <a href="<c:url value="/catalogus" />">Koop hier</a> | 
    <a href="<c:url value="/klanten" />">Registreer</a>
  </body>
</html>