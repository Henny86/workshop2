<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Klant</title>
    <link rel="stylesheet" type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Registreer een Klant</h1>

    <form method="POST">
		Vooraam: <input type="text" name="voornaam" /><br/>
		Achternaam: <input type="text" name="achternaam" /><br/>
		Tussenvoegsel: <input type="text" name="tussenvoegsel" /><br/>
		Email: <input type="text" name="email" /><br/>
		
		<input type="submit" value="Registreer" />
	</form>            
        <a href="<c:url value="/adres/register" />">voeg een adres toe</a>
  </body>
</html>
