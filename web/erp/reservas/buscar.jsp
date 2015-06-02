<%-- 
    Document   : index
    Created on : 19/03/2015, 21:18:15
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Buscar &amp; Cancelar Reservas do Período
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/jquery-ui.min.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/reservas.css" />" />
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-calendar-configs.js" />"></script>
    <script type="text/javascript">
      // a variável dataParametro está recebendo o valor da URL, passando pelo Servlet      
      var dataInicial = "<c:out value="${dataInicial}" />";
      var dataFinal = "<c:out value="${dataFinal}" />";
      document.getElementById("dataInicio").value = dataInicial;
      document.getElementById("dataFim").value = dataFinal;
    </script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Buscar &amp; Cancelar Reservas no Período
    </h1>

    <!-- Formulário #1 | Buscar por data -->
    <form role="form" method="get" class="form-di"
          accept-charset="UTF-8"
          enctype="application/x-www-form-urlencoded"
          action="buscar">

      <div class="row">

        <div class="col-sm-4">

          <h4>
            Data Inicial
          </h4>
          <hr />
          <input type="text" class="form-control calendar"
                 tabindex="1"
                 name="inicial" id="dataInicio" 
                 placeholder="dd/mm/aaaa" 
                 value="<c:out value="${dataInicio}" />" 
                 required />

        </div>

        <div class="col-sm-4">
          <h4>
            Data Final
          </h4>
          <hr />
          <input type="text" class="form-control calendar"
                 tabindex="2"
                 name="final" id="dataFim" 
                 placeholder="dd/mm/aaaa" 
                 value="<c:out value="${dataFim}" />" 
                 required />

        </div>

        <div class="col-sm-4">
          <h4>
            ...
          </h4>
          <hr />
          <button type="submit" class="btn btn-default" 
                  tabindex="3">
            Listar
            <i class="fa fa-fw fa-lg fa-search"></i>
          </button>
        </div>

      </div>

    </form>
    <!-- Formulário #1 | Buscar por data -->

    <div style="padding: 10px;"></div>

    <div class="form-di ${visibilidadeResultados}">

      <h4>
        Resultado(s) da busca
      </h4>
      <hr />

      <c:if test="${!reservasNoPeriodo.isEmpty()}">

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
                <i class="fa fa-fw fa-lg"></i>
              </th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${reservasNoPeriodo}" var="reserva" varStatus="stat">
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
                <a href="<c:url value="/erp/reservas/cancelar?id=${reserva.id}" />" 
                   class="btn btn-sm btn-danger">
                  <i class="fa fa-fw fa-lg fa-times"></i>
                  Cancelar
                </a>
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
            </tr>
          </c:forEach>
          </tbody>
        </table>

      </c:if>

      <c:if test="${reservasNoPeriodo.isEmpty()}">

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
              Não pudemos encontrar reservas no período de
              <div>
                <strong>
                  <c:out value="${dataInicial}" />
                </strong>
                e                
                <strong>
                  <c:out value="${dataFinal}" />
                </strong>
              </div>
            </h3>
            <div class="center-block" style="padding: 10px 0px;"></div>
            <a class="btn btn-lg btn-default"
               href="<c:url value="/erp/reservas/nova" />">
              AGENDAR NOVA RESERVA
            </a>
          </div>

          <div class="center-block" style="padding: 15px 0px;"></div>

        </div>

      </c:if>

    </div>

  </jsp:body>

</t:defaultTemplate>