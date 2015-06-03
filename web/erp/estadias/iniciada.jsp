<%-- 
    Document   : index
    Created on : 02/06/2015, 14:47:15
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Check-In realizado com sucesso
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/jquery-ui.min.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/reservas.css" />" />
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-calendar-configs.js" />"></script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Check-In realizado com sucesso
    </h1>

    <p class="lead">

      <i class="fa fw-fw fa-lg fa-check-square"></i>

      A estadia foi iniciada.

    </p>

    <div style="padding: 30px;"></div>

  </jsp:body>

</t:defaultTemplate>