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
    </jsp:attribute>

    <jsp:attribute name="paginaBottom">
        <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui-1.9.2.custom.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/calendar-conf-events.js" />"></script>
    </jsp:attribute>

    <jsp:body>

        <h1 class="page-title">
          Reservas
        </h1>
        
        <!-- page start-->
        <div class="row mt">
          <aside class="col-lg-3 mt">
            <h2>
              <i class="fa fa-angle-right"></i> 
              Cômodos
            </h2>
            <div id="external-events">

              <div class="external-event label label-theme">
                Quarto #101
              </div>
              <div class="external-event label label-success">
                Quarto #102
              </div>
              <div class="external-event label label-info">
                Quarto #103
              </div>
              <div class="external-event label label-warning">
                Quarto #104
              </div>

              <div class="external-event label label-danger">
                Quarto #201
              </div>
              <div class="external-event label label-default">
                Quarto #202
              </div>
              <div class="external-event label label-theme">
                Quarto #203
              </div>
              <div class="external-event label label-info">
                Quarto #204
              </div>


              <div class="external-event label label-theme">
                Quarto #301
              </div>
              <div class="external-event label label-success">
                Quarto #302
              </div>
              <div class="external-event label label-info">
                Quarto #303
              </div>
              <div class="external-event label label-warning">
                Quarto #304
              </div>

              <div class="external-event label label-danger">
                Quarto #401
              </div>
              <div class="external-event label label-default">
                Quarto #402
              </div>
              <div class="external-event label label-theme">
                Quarto #403
              </div>
              <div class="external-event label label-info">
                Quarto #404
              </div>

              <p class="drop-after">
                <input type="checkbox" id="drop-remove">
                <label for="drop-remove">
                  Remover depois de reservar
                </label>                  
              </p>
              <p class="drop-after">
                Arraste e solte para reservar
              </p>

            </div>
          </aside>

          <aside class="col-lg-9 mt">
            <section class="panel">
              <div class="panel-body">
                <div id="calendar" class="has-toolbar"></div>
              </div>
            </section>
          </aside>

        </jsp:body>

    </t:defaultTemplate>