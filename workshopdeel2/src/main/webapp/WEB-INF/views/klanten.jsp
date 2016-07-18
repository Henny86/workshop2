<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>Klanten</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
  
    <div class="listTitle">
      <h1>Alle Klanten</h1>
      <ul class="klantList">
        <c:forEach items="${klantList}" var="klant" >
          <li id="klant_<c:out value="klant.klant_id"/>">
            <div class="klantVoornaam"><c:out value="${klant.voornaam}" /></div>
           
          </li>
        </c:forEach>
      </ul>
      <c:if test="${fn:length(klantList) gt 5}">
        <hr />
        <s:url value="/klanten?count=${nextCount}" var="more_url" />
        <a href="${more_url}">Show more</a>
      </c:if>
    </div>
  </body>
</html>