<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Artikel</title>
    <link rel="stylesheet" type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Registreer Artikel</h1>

    <form method="POST">
      Artikel Naam: <input type="text" name="artikelNaam" /><br/>
      Beschrijf Artikel: <input type="text" name="artikelBeschrijving" /><br/>
      Prijs in Euro: <input type="text" name="artikelPrijs" /><br/>
      
      <input type="submit" value="Registeer" />
    </form>
  </body>
</html>