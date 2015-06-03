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
    Confirmar e Efetuar Check-Out de Estadia
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
      Confirmar e Efetuar Check-Out de Estadia
    </h1>

    <div class="form-di">

      <form method="post" action="efetuar-checkout"
            accept-charset="UTF-8"
            enctype="application/x-www-form-urlencoded">

        <input type="hidden" name="checkOutReservaID"
               value="${reserva.id}" 
               />

        <div class="row">

          <div class="col-md-4 col-sm-3"></div>

          <div class="col-md-4 col-sm-6">

            <div class="form-group">

              <h4>
                <label for="checkOutResponsavel">
                  Responsável pela reserva:
                </label>
                <input type="text" class="form-control input-lg"
                       id="checkOutResponsavel"
                       value="${sessionScope.usuario.nome}" 
                       readonly
                       />
                <input type="hidden" name="checkOutResponsavel"
                       value="${sessionScope.usuario.id}" 
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="checkOutHospede">
                  Hospede:
                </label>
                <input type="text" class="form-control input-lg"
                       id="checkOutHospede"
                       value="${hospede.nome} ${hospede.sobrenome} (CPF: ${hospede.cpf})" 
                       readonly
                       />
                <input type="hidden" name="checkOutHospede"
                       value="${hospede.id}" 
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="checkOutData">
                  Data de Check-Out:
                </label>
                <input type="text" class="form-control input-lg"
                       id="checkOutData" name="checkOutData"
                       value="<fmt:formatDate type="date" value="${reserva.checkOut}" />" 
                       readonly
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="checkOutQuarto">
                  Quarto:
                </label>
                <input type="text" class="form-control input-lg"
                       id="checkOutQuarto"
                       value="${quarto.numero}" 
                       readonly
                       />
                <input type="hidden" name="checkOutQuarto"
                       value="${quarto.id}" 
                       />
              </h4>

            </div>

            <div class="form-group">

              <h4>
                <label for="checkOutValor">
                  Valor total da estadia:
                </label>
                <input type="text" class="form-control input-lg"
                       id="checkOutValor"
                       value="${reserva.valorEstadia}" 
                       readonly
                       />
              </h4>

            </div>

            <div style="padding: 10px;"></div>

            <button type="submit" class="btn btn-lg btn-block btn-default">
              <i class="fa fw-fw fa-sign-in"></i>
              FECHAR ESTADIA
            </button>

          </div>

        </div>

      </form>

      <div style="padding: 30px;"></div>

    </div>

  </jsp:body>

</t:defaultTemplate>