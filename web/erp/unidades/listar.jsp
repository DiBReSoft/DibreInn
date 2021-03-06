<%-- 
    Document   : buscar
    Created on : 25/05/2015, 00:32:12
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Unidades
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
    <style>
      .form-di label {
        margin-bottom: 0px;
      }
      .table td {
        vertical-align: middle !important;
      }
    </style>
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
    <script type="text/javascript">
      $(document).load(function () {

      });
    </script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Unidades
    </h1>

    <div class="form-di">

      <h4>
        Listagem de registros
      </h4>
      <hr />

      <c:if test="${!lista.isEmpty()}">
        <table class="table table-responsive table-hover table-striped table-condensed">
          <thead>
            <tr>
              <th>
                <i class="fa fa-fw fa-lg fa-barcode"></i>
                ID
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-tag"></i>
                Nome
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-tags"></i>
                Tipo
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-briefcase"></i>
                CNPJ
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-map-marker"></i>
                Cidade
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-map-marker"></i>
                Estado
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-check"></i>
                Status
              </th>
              <th>
                <i class="fa fa-fw fa-lg"></i>
              </th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${lista}" var="unidade" varStatus="stat">
              <tr>
                <td scope="row">
                  <i class="fa fa-fw fa-lg"></i>
                  <c:out value="${unidade.id}" />
                </td>
                <td>
                  <i class="fa fa-fw fa-lg"></i>
                  <c:out value="${unidade.nome}" />
                </td>
                <td>
                  <i class="fa fa-fw fa-lg"></i>
                  <c:if test="${unidade.tipo eq '1'}">
                    Matriz
                  </c:if>
                  <c:if test="${unidade.tipo eq '0'}">
                    Filial
                  </c:if>
                </td>
                <td>
                  <i class="fa fa-fw fa-lg"></i>
                  <c:out value="${unidade.cnpj}" />
                </td>
                <td>
                  <i class="fa fa-fw fa-lg"></i>
                  <c:out value="${unidade.cidade}" />
                </td>
                <td>
                  <i class="fa fa-fw fa-lg"></i>
                  <c:out value="${unidade.estado}" />
                </td>
                <c:if test="${unidade.status == '0'}">
                  <td class="text-center warning">
                    Inativa
                  </td>
                </c:if>
                <c:if test="${unidade.status == '1'}">
                  <td class="text-center success">
                    Ativa
                  </td>
                </c:if>
                <td class="text-center">
                  <a class="btn btn-sm btn-default"
                    title="Edite as propriedades completas desta unidade"
                     href="<c:url value="/erp/unidades/editar?id=${unidade.id}" />">
                    <i class="fa fa-fw fa-lg fa-edit"></i> 
                    Editar Propriedades
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
                <i class="fa fa-user fa-stack-1x text-success"></i>
                <i class="fa fa-search fa-stack-2x text-muted"></i>
              </span>
            </h1>
            <h2>
              Desculpe.
            </h2>
            <h3>
              Não pudemos encontrar quartos registrados na unidade.
            </h3>
          </div>

        </div>

      </c:if>

    </div>

    <div style="padding: 15px 0px;"></div>

  </jsp:body>

</t:defaultTemplate>