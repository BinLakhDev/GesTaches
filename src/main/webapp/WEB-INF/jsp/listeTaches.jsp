<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 27/10/2023
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ajouter une Tâche</title>
</head>
<body>
<h1>Ajouter une Tâche</h1>
<form action="Tache" method="post">
    Titre: <input type="text" name="titre" required><br>
    Description: <input type="text" name="description" required><br>
    Date d'échéance: <input type="date" name="dateEcheance" required><br>
    Statut: <input type="checkbox" name="statut"><br>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
