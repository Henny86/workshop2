<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
  <head>
    <title>Catalogus</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
             
    <div class="listTitle">
      <h1>Onze luchtjes</h1>
      <ul class="artikelList">
        <c:forEach items="${artikelList}" var="artikel" >
          <li id="artikel_<c:out value="artikel.artikelID"/>">
      
            <img src="<s:url value="/resources" />/images/artikel/${artikel.artikelNaam}" style="width:304px;height:228px;" border="0"/> 
            <div class="artikelNaam"><c:out value="${artikel.artikelNaam}  :  ${artikel.artikelBeschrijving}" /></div>
            <div class="artikelPrijs"><c:out value="Euro ${artikel.artikelPrijs}" /></div>
            <a href="<c:url value="/" />">voeg toe aan winkelmandje</a> 
            
           <sf:form method="POST" commandName="artikel"  action = "catalogus/remover/${artikel.artikelID}" enctype="form-data">  
            <input type="submit" value="Remove" />
           </sf:form>  
            
          </li>
        </c:forEach>
      </ul>
      
    </div>
    <a href="<c:url value="catalogus/register" />">voeg toe aan catalogus</a>   
  </body>
