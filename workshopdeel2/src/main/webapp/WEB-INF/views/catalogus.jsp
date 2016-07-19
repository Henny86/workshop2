<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>Catalogus</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
  
    <div class="listTitle">
      <h1>Alle Artikelen</h1>
      <ul class="artikelList">
        <c:forEach items="${artikelList}" var="artikel" >
          <li id="artikel_<c:out value="artikel.artikelID"/>">
            <div class="artikelNaam"><c:out value="${artikel.artikelNaam}  :  ${artikel.artikelBeschrijving}" /></div>
            <div class="artikelPrijs"><c:out value="Euro ${artikel.artikelPrijs}" /></div>
            <a href="<c:url value="/" />">voeg toe aan winkelmandje</a> 
          </li>
        </c:forEach>
      </ul>
      <c:if test="${fn:length(artikelList) gt 15}">
        <hr />
        <s:url value="/artikelen?count=${nextCount}" var="more_url" />
        <a href="${more_url}">Show more</a>
      </c:if>
    </div>
    <a href="<c:url value="catalogus/register" />">voeg toe aan catalogus</a>   
  </body>
