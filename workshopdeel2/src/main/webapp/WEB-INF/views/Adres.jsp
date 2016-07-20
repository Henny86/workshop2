<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adres</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Voeg een adres toe</h1>
	<form method="POST">
		Straatnaam: <input type="text" name="straatnaam" /><br/>
		Huisnummer: <input type="text" name="huisnummer" /><br/>
		Toevoeging: <input type="text" name="toevoeging" /><br/>
		Postcode: <input type="text" name="postcode" /><br/>
		Woonplaats: <input type="text" name="woonplaats" /><br/>
		
		<input type="submit" value="Maak adres" />
	</form>
</body>
</html>