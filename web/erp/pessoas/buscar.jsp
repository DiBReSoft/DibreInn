<%-- 
    Document   : buscar
    Created on : 01/05/2015, 10:21:49
    Author     : Thi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Pessoa: Buscar
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
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-switch.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/form-component.js" />"></script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Buscar Pessoa
    </h1>

    <!-- Início da #1 linha de GRID dos formulários -->
    <div class="row">

      <div class="col-md-3 col-sm-4">

        <!-- Formulário #1 | Buscar por nome -->
        <form role="form" method="get" class="form-di"
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
                   name="nome" id="nome" 
                   placeholder="Fulano" />

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

        <!-- Formulário #2 | Buscar por e-mail -->
        <form role="form" method="get" class="form-di"
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
                   name="email" id="email"
                   placeholder="fulano@dasilva.com.br" />

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

        <!-- Formulário #3 | Buscar por CPF -->
        <form role="form" method="get" class="form-di"
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
                   name="cpf" id="cpf" 
                   placeholder="111.222.333-44" />

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

      </div>

      <div class="col-md-9 col-sm-8 form-di ${visibilidadeResultados}">

        <h4>
          Resultado(s) da busca
        </h4>
        <hr />

        <table class="table table-responsive table-hover table-striped table-condensed">
          <thead>
            <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>CPF</th>
              <th>Email</th>
              <th>Tipo</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td scope="row">1</td>
              <td class ="nome">Thiago</td>
              <td class ="cpf">999.999.999-99</td>
              <td class ="email">thiago@novatela.com.br</td>
              <td class ="tipoPessoa">Funcionario</td>
              <td class="seleciona"><a class="selecionado">Selecionar</a></td>
            </tr>
            <tr>
              <td scope="row">2</td>
              <td class ="nome">Udiberto</td>
              <td class ="cpf">999.999.999-99</td>
              <td class ="email">jr@bol.com.br</td>
              <td class ="tipoPessoa">Hospede</td>
              <td class="seleciona"><a class="selecionado">Selecionar</a></td>
            </tr>
            <tr>
              <td scope="row">3</td>
              <td class ="nome">Mark</td>
              <td class ="cpf">999.999.999-99</td>
              <td class ="email">mark@hotmail.com.br</td>
              <td class ="tipoPessoa">Funcionario</td>
              <td class="seleciona"><a class="selecionado">Selecionar</a></td>
            </tr>
          </tbody>

        </table>

        <br />

        <div class="progress">
          <div class="progress-bar progress-bar-success progress-bar-striped active" 
               role="progressbar" aria-valuenow="45" aria-valuemin="0" 
               aria-valuemax="100" style="width: 45%;">
            <span class="sr-only">45% Complete</span>
          </div>
        </div>

      </div>

    </div>
    <!-- Fim da #1 linha de GRID dos formulários -->

    <div style="padding: 15px 0px;"></div>

  </jsp:body>

</t:defaultTemplate>