<%--
  Created by IntelliJ IDEA.
  User: benny
  Date: 29.09.15
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Ny Vare</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script type="text/javascript">
    function doAjaxPost() {
      // form verdiene
      var navn = $('#navn').val();
      var pris = $('#pris').val();

      $.ajax({
        type: "POST",
        url: "saveVare",
        data: "navn=" + navn + "&pris=" + pris,
        success: function(response){

          $('#info').html(response);
          $('#navn').val('');
          $('#pris').val('');
        },
        error: function(e){
          alert('Error: ' + e);
        }
      });
    }
  </script>



</head>
<body>
<div align="center">
  <h1>Ny Vare</h1>
  <table>
      <tr><td>Navn:</td><td><input type="navn" id="navn" /></td>
      </tr>
      <tr><td>Pris:</td><td><input type="pris" id="pris" /></td>
      </tr>

      <tr>
        <td colspan="2" align="center"><input type="button" class="styla-knapp" value="Lagre" onclick="doAjaxPost()"></td>
        <h3><a href="/">Handlelisten</a></h3>

      </tr>
    </table>

</div>
</body>
</html>
