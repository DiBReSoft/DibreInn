<%-- 
    Document   : index
    Created on : 19/03/2015, 21:18:15
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Reservas
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap-fullcalendar.css" />" />
    <style type="text/css">
      .fc-time{
        visibility: hidden !important;
        display: none !important;
      }
      .fc-event {
        text-align: center;
        padding: 3px 0px;
        margin: 2.5px;
      }
    </style>
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui-1.9.2.custom.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar-moment.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar-lang-all.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/calendar-conf-events.js" />"></script>
  </jsp:attribute>

  <jsp:body>

    <div class="row">

      <div class="col-sm-4">

        <h1 class="page-title">
          Reservas
        </h1>
        
        <h3>
          Dicas de uso
        </h3>
        <p>
          Clique na data desejada para consultar reservas já realizadas ou 
          realizar uma nova reserva.
        </p>
      </div>

      <div class="col-sm-8">

        <section class="panel">
          <div class="panel-body">
            <div id="calendar" class="has-toolbar"></div>
          </div>
        </section>

      </div>

    </div>

  </jsp:body>

</t:defaultTemplate>