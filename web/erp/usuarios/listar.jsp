<%-- 
    Document   : buscar
    Created on : 26/05/2015, 21:57:25
    Author     : thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Usuarios
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
      Usuarios
    </h1>

    <div class="form-di">

      <h4>
        Listagem de registros
      </h4>
      <hr />

      <c:if test="${!lista.isEmpty()}">
        <table class="table table-responsive table-hover table-condensed">
          <thead>
            <tr>
              <th>
                <i class="fa fa-fw fa-lg fa-barcode"></i>
                ID
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-building"></i>
                Login
              </th>
              <th>
                <i class="fa fa-fw fa-lg fa-building-o"></i>
                Senha
              </th>            
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${lista}" var="usuario" varStatus="stat">
              <tr>
                <td scope="row">
                  <i class="fa fa-fw fa-lg"></i>
                  ${usuario.id}
                </td>               
                <td>
                  <i class="fa fa-fw fa-lg"></i>
                  login
                  <c:out value="${usuario.login}" />
                </td>
                <td>
                  <i class="fa fa-fw fa-lg"></i>
                  
                  <c:out value="******" />
                </td>
                <c:if test="${usuario.status == '0'}">
                  <td class="text-center warning">
                    Inativo
                  </td>
                </c:if>
                <c:if test="${usuario.status == '1'}">
                  <td class="text-center success">
                    Ativo
                  </td>
                </c:if>
                </td>
                <td class="text-center">
                  <a class="btn btn-sm btn-default"
                     title="Edite as propriedades completas deste cômodo"
                     href="<c:url value="/erp/usuarios/editar?id=${usuario.id}" />">
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
              Não pudemos encontrar usuarios registrados no sistema.
            </h3>
          </div>

        </div>

      </c:if>

    </div>

    <div style="padding: 15px 0px;"></div>

  </jsp:body>

</t:defaultTemplate>