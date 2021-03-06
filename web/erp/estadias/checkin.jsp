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
    Reservas para Check-In na Data
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
      Reservas para Check-In na Data
    </h1>

    <div class="form-di">

      <form method="get" action="checkin"
            accept-charset="UTF-8"
            enctype="application/x-www-form-urlencoded">

        <div class="row">

          <div class="col-lg-2 col-md-3 col-sm-4">
            <h4 class="text-right">
              Reservas do dia:
            </h4>
          </div>

          <div class="col-lg-2 col-md-3 col-sm-4">
            <h4 style="margin-top: 18px;">            
              <input type="text" class="form-control calendar"
                     tabindex="1" name="data"
                     value="${exibirData}" />
            </h4>
          </div>

          <div class="col-lg-2 col-md-3 col-sm-4">
            <h4 style="margin-top: 18px;">            
              <button type="submit" class="btn btn-block btn-default">
                <i class="fa fa-fw fa-lg fa-search"></i>
                Listar
              </button>
            </h4>
          </div>

        </div>

      </form>

      <hr />

      <div style="padding: 10px;"></div>

      <c:if test="${!reservasNaData.isEmpty()}">

        <table class="table table-responsive table-hover table-striped table-condensed">
          <thead>
            <tr>
              <th>
                <i class="fa fa-fw fa-lg fa-barcode"></i>
                ID
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-exchange"></i>
                Status
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-user"></i>
                Hospede
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-calendar"></i>
                Check-In
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-calendar-o"></i>
                Check-Out
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-tag"></i>
                Quarto
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-user"></i>
                Responsável
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-bed"></i>
                Estadia
              </th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${reservasNaData}" var="reserva" varStatus="stat">
              <c:if test="${reserva.idUnidade == sessionScope.usuario.unidadeId}">
                <tr
                  <c:if test="${reserva.status == 'A'}">
                    class="info"
                  </c:if>
                  <c:if test="${reserva.status == 'F'}">
                    class="success"
                  </c:if>
                  <c:if test="${reserva.status == 'C'}">
                    class="danger"
                  </c:if>
                  >
                  <td scope="row">
                    <i class="fa fa-fw fa-lg"></i>
                    <c:out value="${reserva.id}" />
                  </td>
                  <td>
                    <i class="fa fa-fw fa-lg"></i>
                    <c:if test="${reserva.status == 'A'}">
                      Aberta
                    </c:if>
                    <c:if test="${reserva.status == 'P'}">
                      Progresso
                    </c:if>
                    <c:if test="${reserva.status == 'F'}">
                      Fechada
                    </c:if>
                    <c:if test="${reserva.status == 'C'}">
                      Cancelada
                    </c:if>
                  </td>
                  <td>
                    <i class="fa fa-fw fa-lg"></i>
                    <c:out value="${reserva.hospede.nome}" />
                    <c:out value="${reserva.hospede.sobrenome}" />
                  </td>
                  <td>
                    <i class="fa fa-fw fa-lg"></i>
                    <strong>
                      <fmt:formatDate type="date" value="${reserva.checkIn}" />                    
                    </strong>
                  </td>
                  <td>
                    <i class="fa fa-fw fa-lg"></i>
                    <fmt:formatDate type="date" value="${reserva.checkOut}" />
                  </td>
                  <td>
                    <i class="fa fa-fw fa-lg"></i>
                    <c:out value="${reserva.quarto.numero}" />
                  </td>
                  <td>
                    <i class="fa fa-fw fa-lg"></i>
                    <c:out value="${reserva.funcionario.nome}" />
                    <c:out value="${reserva.funcionario.sobrenome}" />
                  </td>
                  <td>
                    <c:if test="${reserva.status == 'A'}">
                      <a href="<c:url value="/erp/estadias/efetuar-checkin?id=${reserva.id}" />" 
                         class="btn btn-sm btn-block btn-default">
                        <i class="fa fa-fw fa-lg fa-play"></i>
                        INICIAR
                      </a>
                    </c:if>
                    <c:if test="${reserva.status == 'P'}">
                      <a class="btn btn-sm btn-block btn-info disabled">
                        <i class="fa fa-fw fa-lg fa-ellipsis-h"></i>
                        EM PROGRESSO
                      </a>
                    </c:if>
                    <c:if test="${reserva.status == 'F'}">
                      <a class="btn btn-sm btn-block btn-success disabled">
                        <i class="fa fa-fw fa-lg fa-ellipsis-h"></i>
                        FECHADA
                      </a>
                    </c:if>
                    <c:if test="${reserva.status == 'C'}">
                      <a class="btn btn-sm btn-block btn-danger disabled">
                        <i class="fa fa-fw fa-lg fa-ellipsis-h"></i>
                        CANCELADA
                      </a>
                    </c:if>
                  </td>
                </tr>
              </c:if>
            </c:forEach>
          </tbody>
        </table>

      </c:if>

      <c:if test="${reservasNaData.isEmpty() or reservasNaData == null}">

        <div class="col-sm-2"></div>

        <div class="col-sm-8">

          <div class="text-center">
            <h1>
              <span class="fa-stack fa-lg">
                <i class="fa fa-bed fa-stack-1x text-success"></i>
                <i class="fa fa-search fa-stack-2x text-muted"></i>
              </span>
            </h1>
            <h2>
              Desculpe.
            </h2>
            <h3>
              Não existem reservas agendadas para o dia 
              <strong><c:out value="${exibirData}" /></strong>
            </h3>
          </div>

        </div>

      </c:if>

    </div>

  </jsp:body>

</t:defaultTemplate>