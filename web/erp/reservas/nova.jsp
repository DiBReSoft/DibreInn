<%-- 
    Document   : nova
    Created on : 03/05/2015, 10:30:15
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Reserva: Nova
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap-fullcalendar.css" />" />
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui-1.9.2.custom.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar-moment.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar-lang-all.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/calendar-conf-events.js" />"></script>
    <script type="text/javascript">
      var dataAtual = new Date("${dataParaReserva}");
      var mes = dataDecimal(dataAtual.getMonth() + 1);
      var dia = dataDecimal(dataAtual.getDate());
      
      document.getElementById("reservaData").value = dataAtual.getFullYear() + "-" + mes + "-" + dia;
      
      function dataDecimal(dt) {
        if(dt < 10 && dt > 0) {
          dt = "0" + dt;
        }
        return dt;
      }
    </script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Reserva: Nova
    </h1>

    <form role="form" class="form-di"
          action="reservar" method="post">

      <h4>
        Detalhes da reserva 
      </h4>
      <hr />

      <div class="row">

        <div class="col-sm-3">

          <div class="form-group">        
            <label for="reservaData">
              Data:
            </label>
            <input type="date" class="form-control"
                   tabindex="1"
                   name="reservaData" id="reservaData" />        
          </div>

        </div>

      </div>

    </form>

  </jsp:body>

</t:defaultTemplate>