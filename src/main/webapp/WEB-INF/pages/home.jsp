<%--
  Created by IntelliJ IDEA.
  User: benny
  Date: 29.09.15
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Handlekurv</title>
</head>
<body>
<div align="center">
  <h1>Handleliste</h1>
  <h3><a href="/newVare">Ny Vare</a></h3>
  <table border="1">
    <th>No</th>
    <th>Navn</th>
    <th>Pris</th>


    <c:forEach var="vare" items="${listVare}" varStatus="status">
      <tr>
        <td>${status.index + 1}</td>
        <td>${vare.navn}</td>
        <td>${vare.pris}</td>

        <td>
          <a href="/editVare?id=${vare.id}">Endre</a>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <a href="/deleteVare?id=${vare.id}">Slette</a>
        </td>

      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
