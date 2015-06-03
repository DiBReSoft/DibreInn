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
    Cancelar Reserva
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
      Cancelar Reserva
    </h1>

    <div class="form-di">

      <form method="post" action="cancelar"
            accept-charset="UTF-8"
            enctype="application/x-www-form-urlencoded">

        <input type="hidden" name="cancelarReservaID"
               value="${reserva.id}" 
               />

        <div class="row">

          <div class="col-md-4 col-sm-3"></div>

          <div class="col-md-4 col-sm-6">

            <div class="form-group">

              <h4>
                <label for="cancelarResponsavel">
                  Responsável pela reserva:
                </label>
                <input type="text" class="form-control input-lg"
                       id="cancelarResponsavel"
                       value="${sessionScope.usuario.nome}" 
                       readonly
                       />
                <input type="hidden" name="cancelarResponsavel"
                       value="${sessionScope.usuario.id}" 
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="cancelarHospede">
                  Hospede:
                </label>
                <input type="text" class="form-control input-lg"
                       id="cancelarHospede"
                       value="${hospede.nome} ${hospede.sobrenome} (CPF: ${hospede.cpf})" 
                       readonly
                       />
                <input type="hidden" name="cancelarHospede"
                       value="${hospede.id}" 
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="cancelarData">
                  Data de Check-In:
                </label>
                <input type="text" class="form-control input-lg"
                       id="cancelarData" name="cancelarData"
                       value="<fmt:formatDate type="date" value="${reserva.checkIn}" />" 
                       readonly
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="cancelarData">
                  Data de Check-Out:
                </label>
                <input type="text" class="form-control input-lg"
                       id="cancelarData" name="cancelarDataCheckOut"
                       value="<fmt:formatDate type="date" value="${reserva.checkOut}" />" 
                       readonly
                       />
              </h4>

            </div>

            <div style="padding: 10px;"></div>

            <button type="submit" class="btn btn-lg btn-block btn-default">
              <i class="fa fw-fw fa-sign-in"></i>
              CANCELAR RESERVA
            </button>

          </div>

        </div>

      </form>

      <div style="padding: 30px;"></div>

    </div>

  </jsp:body>

</t:defaultTemplate>