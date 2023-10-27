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
  <title>Liste des Tâches</title>
</head>
<body>
<h1>Liste des Tâches</h1>
<table border="1">
  <tr>
    <th>Titre</th>
    <th>Description</th>
    <th>Date d'échéance</th>
    <th>Statut</th>
    <th>Action</th>
  </tr>
  <c:forEach var="task" items="${tasks}">
    <tr>
      <td>${task.titre}</td>
      <td>${task.description}</td>
      <td>${task.dateEcheance}</td>
      <td>${task.statut}</td>
      <td>
        <a href="Tache?action=updateStatus&taskId=${task.id}&newStatus=${!task.statut}">Mettre à jour</a>
        <a href="Tache?action=delete&taskId=${task.id}">Supprimer</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>