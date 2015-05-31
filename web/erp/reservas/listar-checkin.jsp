<%-- 
    Document   : index
    Created on : 31/05/2015, 14:47:15
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Efetuar CheckIn de Reserva
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
      Efetuar CheckIn de Reserva
    </h1>

    <div class="form-di">

      <h4>
        Reservas do dia ${exibirData}
      </h4>
      <hr />

      <c:if test="${!lista.isEmpty()}">

        <table class="table table-responsive table-hover table-striped table-condensed">
          <thead>
            <tr>
              <th>ID</th>
              <th>Atendente</th>
              <th>Hospede</th>
              <th>Checkin</th>
              <th>Quarto</th>
              <th>Editar</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${lista}" var="reserva" varStatus="stat">
              <tr>
                <td scope="row">
                  <c:out value="${reserva.id}" />
                </td>
                <td class="nome">
                  <c:out value="${reserva.idFuncionario}" />
                </td>
                <td class="nome">
                  <c:out value="${reserva.idHospede}" />
                </td>
                <td class="cpf">
                  <c:out value="${reserva.checkIn}" />
                </td>
                <td class="cpf">
                  <c:out value="${reserva.idQuarto}" />
                </td>
                <td class="seleciona">
                  <a href="<c:url value="/erp/reservas/editar?id=${reserva.id}" />" 
                     class="selecionado">
                    <i class="fa fa-fw fa-lg fa-edit"></i>
                    Selecionar
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>

      </c:if>

      <c:if test="${lista.isEmpty()}">

        <div class="col-sm-3"></div>

        <div class="col-sm-6">

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
              <strong><c:out value="${dataParaListar}" /></strong>
            </h3>
          </div>

        </div>

      </c:if>

    </div>

  </jsp:body>

</t:defaultTemplate>