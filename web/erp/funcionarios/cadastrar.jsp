<%--
  Created on : 19/03/2015, 21:18:15
  Authors    :  thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Cadastrar Funcionário
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/cadastrar-pessoa.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/jquery-ui.min.css" />" />
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.maskedinput.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-calendar-configs.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/cadastrar.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.numeric.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.maskedinput.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/validacoes.js" />"></script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Cadastrar Funcionário
    </h1>

    <!-- page start-->
    <div class="row">

      <div class="col-md-2 hidden-sm hidden-xs"></div>

      <div class="col-md-8">

        <!-- Início do Formulário -->
        <form role="form" method="post" class="form-di"
              action="cadastrar"
              accept-charset="UTF-8"
              enctype="application/x-www-form-urlencoded">

          <div style="padding: 5px;"></div>

          <!-- Início:- DADOS -->
          <h4>
            Dados
          </h4>

          <hr />

          <div class="row">

            <div class="col-xs-6">
              <div class="form-group">
                <label for="formNome">
                  Nome:
                </label>
                <input type="text" class="form-control"
                       tabindex="1"
                       name="formNome" id="formNome" 
                       placeholder="Fulano"
                       required />
              </div>

            </div>

            <div class="col-xs-6">

              <div class="form-group">
                <label for="formSobrenome">
                  Sobrenome:
                </label>
                <input type="text" class="form-control" 
                       tabindex="2"
                       name="formSobrenome" id="formSobrenome"
                       placeholder="da Silva"
                       required />
              </div>

            </div>

            <div class="col-sm-4">

              <div class="form-group">
                <label for="formSexo">
                  Sexo:
                </label>
                <select class="form-control"
                        tabindex="3"
                        name="formSexo" id="formSexo"                         
                        placeholder="Sexo"
                        required>
                  <option value="M">
                    Masculino
                  </option>
                  <option value="F">
                    Feminino
                  </option>
                </select>
              </div>

            </div>

            <div class="col-sm-4">

              <div class="form-group">                    
                <label for="formRg">
                  RG:
                </label>                  
                <input type="text" class="form-control"
                       tabindex="4"
                       name="formRg" id="formRg" 
                       placeholder="RG" 
                       maxlength="50" />
              </div>

            </div>

            <div class="col-sm-4">

              <div class="form-group">                    
                <label for="formCpf">
                  CPF:
                </label>
                <input type="text" class="form-control"
                       tabindex="5"
                       name="formCpf" id="formCpf" 
                       placeholder="CPF" 
                       maxlength="50"
                       required />
              </div>

            </div>

            <div class="col-sm-4">

              <div class="form-group">
                <label for="formDataNasc">
                  Data de Nascimento:
                </label>
                <input type="text" class="form-control calendar" 
                       tabindex="6"
                       name="formDataNasc" id="formDataNasc" 
                       placeholder="DD/MM/AAAA"
                       required 
                       min="10"
                       maxlength="10" />
              </div>

            </div>

            <div class="col-sm-4">

              <div class="form-group">
                <label for="formTel">
                  Telefone:
                </label>
                <input type="tel" class="form-control" 
                       tabindex="7"
                       name="formTel" id="formTel"
                       placeholder="(11) 5555-5555" 
                       min="15"
                       maxlength="15" />
              </div>

            </div>

            <div class="col-sm-4">

              <div class="form-group">
                <label for="formCel">
                  Celular:
                </label>
                <input type="tel" class="form-control" 
                       tabindex="7"
                       name="formCel" id="formCel"
                       placeholder="(11) 9999-9999" 
                       maxlength="15" />
              </div>

            </div>

            <div class="col-xs-8">

              <div class="form-group">
                <label for="formEmail">
                  E-mail:
                </label>
                <input type="email" class="form-control" 
                       tabindex="8"
                       name="formEmail" id="formEmail"
                       placeholder="fulano@dasilva.com.br"
                       required />
              </div>

            </div>

            <div class="col-xs-4">

              <div class="form-group">
                <label for="formNewsletter">
                  Aceita receber Newsletter:
                </label>
                <input type="checkbox" class="form-control"
                       tabindex="9"
                       name="formNewsletter" id="formNewsletter"
                       value="1"
                       checked
                       />
              </div>

            </div>

          </div>

          <h4>
            Adicionais sobre o Funcionario
          </h4>

          <hr />                   
          <div class="row" id="formFuncionario">
            <div class="col-sm-6">

              <div class="form-group">
                <label for="formUnidade">
                  Unidade:
                </label>
                <c:if test="${sessionScope.usuario.privilegioId == 2}">
                  <input type="hidden" 
                         name="formUnidade"
                         value="${sessionScope.usuario.unidadeId}" />
                  <input type="text" class="form-control" tabindex="10"
                         value="${sessionScope.usuario.unidadeNome}"
                         readonly/>
                </c:if>
                <c:if test="${sessionScope.usuario.privilegioId == 3}">
                  <select class="form-control" tabindex="10" aria-describedby="basic-addon2"
                          name="formUnidade" id="formUnidade">
                    <c:forEach items="${lista}" var="unidade" varStatus="stat">
                      <c:if test="${unidade.status == '1'}">
                        <option value="${unidade.id}"
                                <c:if test="${unidade.status == '0'}">
                                  disabled
                                </c:if>
                                <c:if test="${unidade.id == funcionario.unidade}">
                                  selected
                                </c:if>
                                >
                          <c:out value="${unidade.estado}" />
                          -
                          <c:out value="${unidade.nome}" />
                        </option>
                      </c:if>
                    </c:forEach>
                  </select>
                </c:if>

              </div>

            </div>

            <div class="col-md-3 col-sm-6">

              <div class="form-group">
                <label for="formPrivilegio">
                  Cargo:
                </label>
                <select class="form-control" tabindex="18" aria-describedby="basic-addon2"
                        name="formPrivilegio" id="formPrivilegio" required >
                  <c:forEach items="${listaPrivilegios}" var="privilegio" varStatus="stat">
                    <c:if test="${privilegio.status == '1'}">
                      <option value="${privilegio.id}">
                        <c:out value="${privilegio.titulo}" />
                      </option>
                    </c:if>
                  </c:forEach>
                </select>
              </div>
              <!-- Fim da linha de GRID do formulário -->
            </div>
            <div class="col-sm-6">
              <div class="form-group">
                <label for="formLogin">
                  Login:
                </label>                  
                <input type="text" class="form-control"
                       name="formLogin" id="formLogin" 
                       placeholder="Nome de Usuário" 
                       disabled />
              </div>
            </div>
            <div class="col-md-3 col-sm-6">
              <div class="form-group">
                <label for="formSenha">
                  Senha:
                </label>                  
                <input type="password" class="form-control"
                       name="formSenha" id="formSenha" 
                       placeholder="********"
                       required />
              </div>
            </div>
            <!-- DIV com os campos de id e senha -->


          </div>

          <!-- Fim: Adicionais sobre o Funcionário -->



          <div style="padding: 10px 0px;"></div>

          <p>
            Os campos marcados com
            <i class="fa fa-fw fa-lg fa-asterisk"></i>
            são obrigatórios.
          </p>

          <div style="padding: 10px 0px;"></div>

          <!-- Linha de botões do formulário -->
          <div class="row">

            <div class="col-sm-2 hidden-xs"></div>

            <div class="col-xs-6 col-sm-4">

              <button type="reset" class="btn btn-block btn-lg btn-primary" 
                      tabindex="12">
                <i class="fa fa-eraser"></i>
                LIMPAR
              </button>

            </div>

            <div class="col-xs-6 col-sm-4">

              <button type="submit" 
                      class="btn btn-block btn-lg btn-default" 
                      tabindex="11">
                SALVAR
                <i class="fa fa-check-square"></i>
              </button>

            </div>

          </div>
          <!-- Linha de botões do formulário -->

          <div style="padding: 15px 0px;"></div>

        </form>
        <!-- Fim do Formulário -->

      </div>

    </div>

  </jsp:body>

</t:defaultTemplate>