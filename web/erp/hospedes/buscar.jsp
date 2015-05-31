<%-- 
    Document   : buscar
    Created on : 26/05/2015, 08:29:13
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Buscar Hospede
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
    <style>
      .form-di label {
        margin-bottom: 0px;
      }
      .table td {
        font-size: 13px;
      }
    </style>
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.numeric.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.maskedinput.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/validacoes.js" />"></script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Buscar Hospede
    </h1>

    <!-- Início da #1 linha de GRID dos formulários -->
    <div class="row">

      <div class="col-sm-4">

        <!-- Formulário #1 | Buscar por nome -->
        <form role="form" method="get" enctype="utf-8" class="form-di"
              action="buscar" name="formNome">

          <h4>
            <label for="nome">
              Buscar por nome
            </label>
          </h4>
          <hr />

          <div class="input-group">

            <input type="text" class="form-control"
                   tabindex="1"
                   name="nome" id="formNome" 
                   placeholder="Fulano" 
                   value="<c:out value="${nomeBuscado}" />" />

            <span class="input-group-btn">              

              <button type="submit" class="btn btn-default" 
                      tabindex="2">

                <span class="hidden-sm hidden-xs">
                  Buscar
                </span>                

                <i class="fa fa-fw fa-lg fa-search"></i>

              </button>

            </span>
          </div>

        </form>
        <!-- Formulário #1 | Buscar por nome -->

        <div style="padding: 5px 0px;"></div>

      </div>

      <div class="col-sm-4">

        <!-- Formulário #2 | Buscar por e-mail -->
        <form role="form" method="get" enctype="utf-8" class="form-di"
              action="buscar" name="formBuscarEmail">

          <h4>
            <label for="email">
              Buscar por e-mail
            </label>
          </h4>
          <hr />

          <div class="input-group">            

            <input type="email" class="form-control" 
                   tabindex="3"
                   name="email" id="formEmail"
                   placeholder="fulano@dasilva.com.br"
                   value="<c:out value="${emailBuscado}" />" />

            <span class="input-group-btn">

              <button type="submit" class="btn btn-default" 
                      tabindex="4">

                <span class="hidden-sm hidden-xs">
                  Buscar
                </span>

                <i class="fa fa-fw fa-lg fa-search"></i>

              </button>

            </span>

          </div>

        </form>
        <!-- Formulário #2 | Buscar por e-mail -->

        <div style="padding: 5px 0px;"></div>

      </div>

      <div class="col-sm-4">

        <!-- Formulário #3 | Buscar por CPF -->
        <form role="form" method="get" enctype="utf-8" class="form-di"
              action="buscar" name="formBuscarCPF">

          <h4>
            <label for="cpf">
              Buscar por CPF
            </label>
          </h4>
          <hr />

          <div class="input-group">

            <input type="text" class="form-control"
                   tabindex="5"
                   name="cpf" id="formCpf" 
                   placeholder="111.222.333-44"
                   value="<c:out value="${cpfBuscado}" />" />

            <span class="input-group-btn">

              <button type="submit" class="btn btn-default" 
                      tabindex="6">

                <span class="hidden-sm hidden-xs">
                  Buscar
                </span>

                <i class="fa fa-fw fa-lg fa-search"></i>

              </button>

            </span>

          </div>

        </form>
        <!-- Formulário #3 | Buscar por CPF -->

        <div style="padding: 5px 0px;"></div>

      </div>

    </div>

    <!-- Fim da #1 linha de GRID dos formulários -->

    <div class="form-di ${visibilidadeResultados}">

      <h4>
        Resultado(s) da busca
      </h4>
      <hr />

      <c:if test="${!lista.isEmpty()}">

        <table class="table table-responsive table-hover table-striped table-condensed">
          <thead>
            <tr>
              <th>
                <i class="fa fa-fw fa-barcode"></i>
                ID
              </th>
              <th>
                <i class="fa fa-fw fa-tag"></i>
                Nome
              </th>
              <th>
                <i class="fa fa-fw fa-code"></i>
                CPF
              </th>
              <th>
                <i class="fa fa-fw fa-envelope"></i>
                E-mail
              </th>
              <th class="text-center">
                Visualizar
              </th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${lista}" var="hospede" varStatus="stat">
              <tr>
                <td scope="row">
                  <i class="fa fa-fw"></i>
                  <c:out value="${hospede.id}" />
                </td>
                <td>
                  <i class="fa fa-fw"></i>
                  <c:out value="${hospede.nome}" />
                  <c:out value="${hospede.sobrenome}" />
                </td>
                <td>
                  <i class="fa fa-fw"></i>
                  <c:out value="${hospede.cpf}" />
                </td>
                <td>
                  <i class="fa fa-fw"></i>
                  <c:out value="${hospede.email}" />
                </td>
                <td class="text-center">
                  <i class="fa fa-fw"></i>
                  <a href="<c:url value="/erp/hospedes/editar?id=${hospede.id}" />"
                     class="btn btn-sm btn-default">
                    <i class="fa fa-fw fa-lg fa-edit"></i>
                    Cadastro Completo
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        
        <div class="center-block" style="padding: 15px 0px;"></div>

      </c:if>

      <c:if test="${lista.isEmpty()}">

        <div class="col-sm-2"></div>

        <div class="col-sm-8">

          <div class="text-center">
            <h1>
              <span class="fa-stack fa-lg">
                <i class="fa fa-stack-1x fa-users text-muted"></i>
                <i class="fa fa-stack-2x fa-search text-success"></i>
              </span>
            </h1>
            <h2>
              Desculpe.
            </h2>
            <h3>
              Não pudemos encontrar hospedes com o
              <c:choose>
                <c:when test="${nomeBuscado != null}">
                  nome <div>"<strong><c:out value="${nomeBuscado}" /></strong>"</div>
                </c:when>
                <c:when test="${emailBuscado != null}">
                  e-mail <div>"<strong><c:out value="${emailBuscado}" /></strong>"</div>
                </c:when>
                <c:when test="${cpfBuscado != null}">
                  CPF <div>"<strong><c:out value="${cpfBuscado}" /></strong>"</div>
                </c:when>
              </c:choose>
            </h3>
            <div class="center-block" style="padding: 10px 0px;"></div>
            <a class="btn btn-lg btn-default"
               href="<c:url value="/erp/hospedes/cadastrar" />">
              CADASTRAR NOVO HOSPEDE
            </a>
          </div>

          <div class="center-block" style="padding: 15px 0px;"></div>

        </div>

      </c:if>

    </div>

  </jsp:body>

</t:defaultTemplate>