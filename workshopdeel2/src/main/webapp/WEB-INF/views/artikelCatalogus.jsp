<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
  <head>
    <title>formulier</title>
    <link rel="stylesheet" type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>neem artikel op in de catalogus</h1>

    <sf:form method="POST" commandName="artikel"  enctype="multipart/form-data">
      <sf:errors path="*" element="div" cssClass="errors" />
      <sf:label path="artikelNaam" 
          cssErrorClass="error">naam artikel</sf:label>: 
        <sf:input path="artikelNaam" cssErrorClass="error" /><br/>
      <sf:label path="artikelBeschrijving" 
          cssErrorClass="error">beschrijving</sf:label>: 
        <sf:input path="artikelBeschrijving" cssErrorClass="error" /><br/>
      <sf:label path="artikelPrijs" 
          cssErrorClass="error">prijs artikel</sf:label>: 
        <sf:input path="artikelPrijs" cssErrorClass="error" /><br/>
     
      <input type="submit" value="Registreer" />
      
      <label>Profile Picture</label>:
          <input type="file"
                 name="profilePicture"
                 accept="image/jpeg,image/png,image/gif" /><br/>
      
    </sf:form>
          
          
          
  </body>
</htm