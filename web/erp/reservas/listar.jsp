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
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/jquery-ui.min.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/reservas.css" />" />
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-calendar-configs.js" />"></script>
    <script type="text/javascript">
      // a variável dataParametro está recebendo o valor da URL, passando pelo Servlet      
      var dataParametro = "<c:out value="${dataParaListar}" />";
      document.getElementById("reservaData").value = dataParametro;
    </script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Reservas
    </h1>

    <div class="row">

      <div class="col-md-3 col-sm-4">

        <!-- Formulário #1 | Buscar por data -->
        <form role="form" method="get" class="form-di"
              accept-charset="UTF-8"
              enctype="application/x-www-form-urlencoded"
              action="listar">

          <h4>
            Reservas do dia
          </h4>
          <hr />
          <div class="input-group">

            <input type="text" class="form-control calendar"
                   tabindex="1"
                   name="data" id="reservaData" 
                   placeholder="dd/mm/aaaa" 
                   value="<c:out value="${dataBuscada}" />" 
                   required />

            <span class="input-group-btn">

              <button type="submit" class="btn btn-default" 
                      tabindex="2">

                <span class="hidden-sm hidden-xs">
                  Listar
                </span>                

                <i class="fa fa-fw fa-lg fa-search"></i>

              </button>

            </span>
          </div>

        </form>
        <!-- Formulário #1 | Buscar por data -->

      </div>

      <div class="col-md-9 col-sm-8 form-di ${visibilidadeResultados}">

        <h4>
          Resultado(s) da busca
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
                Não pudemos encontrar reservas na data 
                <div><strong><c:out value="${dataParaListar}" /></strong></div>
              </h3>
            </div>

          </div>

        </c:if>

      </div>

    </div>

  </jsp:body>

</t:defaultTemplate>