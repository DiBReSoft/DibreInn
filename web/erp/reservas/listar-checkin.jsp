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
    Efetuar Check-In de Reserva
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
      Efetuar Check-In de Reserva
    </h1>

    <div class="form-di">

      <h4>
        Reservas do dia ${exibirData}
      </h4>
      <hr />

      <c:if test="${!reservasNaData.isEmpty()}">

        <table class="table table-responsive table-hover table-striped table-condensed">
          <thead>
            <tr>
              <th>
                <i class="fa fa-fw fa-lg fa-barcode"></i>
                ID
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
              <tr
                <c:if test="${reserva.status == 'A'}">
                  class="info"
                </c:if>
                <c:if test="${reserva.status == 'P'}">
                  class="warning"
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
                  <c:out value="${reserva.hospede.nome}" />
                  <c:out value="${reserva.hospede.sobrenome}" />
                </td>
                <td>
                  <i class="fa fa-fw fa-lg"></i>
                  <fmt:formatDate type="date" value="${reserva.checkIn}" />
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
                  <i class="fa fa-fw fa-lg"></i>
                  <c:if test="${reserva.status == 'A'}">
                    <a href="<c:url value="/erp/reservas/iniciar?id=${reserva.id}" />" 
                       class="btn btn-sm btn-default">
                      <i class="fa fa-fw fa-lg fa-play"></i>
                      Iniciar
                    </a>
                  </c:if>
                  <c:if test="${reserva.status == 'P'}">
                    EM PROGRESSO...
                  </c:if>
                  <c:if test="${reserva.status == 'F'}">
                    FECHADA
                  </c:if>
                  <c:if test="${reserva.status == 'C'}">
                    CANCELADA
                  </c:if>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>

      </c:if>

      <c:if test="${reservasNaData.isEmpty()}">

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
              Não existem reservas agendadas para hoje, dia 
              <strong><c:out value="${exibirData}" /></strong>
            </h3>
          </div>

        </div>

      </c:if>

    </div>

  </jsp:body>

</t:defaultTemplate>