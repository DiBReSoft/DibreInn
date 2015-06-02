<%-- 
    Document   : index
    Created on : 31/05/2015, 14:47:15
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Confirmar e Efetuar Check-In de Reserva
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
      Confirmar e Efetuar Check-In de Reserva
    </h1>

    <div class="form-di">

      <form method="post" action="efetuar-checkin"
            accept-charset="UTF-8"
            enctype="application/x-www-form-urlencoded">

        <div class="row">

          <div class="col-md-4 col-sm-3"></div>

          <div class="col-md-4 col-sm-6">

            <div class="form-group">

              <h4>
                <label for="checkInResponsavel">
                  Responsável pela Liberação:
                </label>
                <input type="text" class="form-control input-lg"
                       id="checkInResponsavel"
                       value="${sessionScope.usuario.nome}" 
                       readonly
                       />
                <input type="hidden" name="checkInResponsavel"
                       value="${sessionScope.usuario.id}" 
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="checkInHospede">
                  Hospede:
                </label>
                <input type="text" class="form-control input-lg"
                       id="checkInHospede"
                       value="${hospede.nome}" 
                       readonly
                       />
                <input type="hidden" name="checkInHospede"
                       value="${hospede.id}" 
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="checkInData">
                  Data de Check-In:
                </label>
                <input type="text" class="form-control input-lg"
                       id="checkInData" name="checkInData"
                       value="<fmt:formatDate type="date" value="${reserva.checkIn}" />" 
                       readonly
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="checkInQuarto">
                  Quarto:
                </label>
                <input type="text" class="form-control input-lg"
                       id="checkInQuarto"
                       value="${quarto.numero}" 
                       readonly
                       />
                <input type="hidden" name="checkInQuarto"
                       value="${quarto.id}" 
                       />
              </h4>

            </div>

            <div style="padding: 10px;"></div>

            <button type="submit" class="btn btn-lg btn-block btn-default">
              <i class="fa fw-fw fa-sign-in"></i>
              INICIAR ESTADIA
            </button>

          </div>

        </div>

      </form>

      <div style="padding: 30px;"></div>

    </div>

  </jsp:body>

</t:defaultTemplate>