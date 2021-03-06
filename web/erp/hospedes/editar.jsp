<%--
  Created on : 19/03/2015, 21:18:15
  Authors    : udimberto, fabio, thiago, luciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Editar Hospede
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
    <c:set var="now" value="<%=new java.util.Date()%>" />
    <h1 class="page-title">
      Editar Hospede
    </h1>

    <!-- page start-->
    <div class="row">

      <div class="col-md-8">

        <!-- Início do Formulário -->
        <form role="form" method="post" class="form-di"
              action="editar"
              accept-charset="UTF-8"
              enctype="application/x-www-form-urlencoded">

          <input type="hidden" name="formId" value="${hospede.id}" />

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
                       required 
                       value="${hospede.nome}" />
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
                       required
                       value="${hospede.sobrenome}" />
              </div>

            </div>

          </div>

          <div class="row">

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
                  <c:if test="${hospede.sexo == 'M' or hospede.sexo == 'm'}">                         
                    <option value="M">
                      Masculino
                    </option>
                    <option value="F">
                      Feminino
                    </option>
                  </c:if>                    
                  <c:if test="${hospede.sexo == 'F' or hospede.sexo == 'f'}">    
                    <option value="F">
                      Feminino
                    </option>                     
                    <option value="M">
                      Masculino
                    </option>
                  </c:if>
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
                       maxlength="50"
                       value="${hospede.rg}" />
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
                       required
                       value="${hospede.cpf}"
                       readonly />
              </div>

            </div>

          </div>

          <div class="row">

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
                       maxlength="10"
                       value="<fmt:formatDate type="date" 
                                       value="${hospede.dataNascimento}" />" 
                       />
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
                       maxlength="15"
                       value="${hospede.telefone}" />
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
                       placeholder="(11) 999-999-999" 
                       maxlength="15"
                       value="${hospede.celular}" />
              </div>

            </div>

          </div>

          <div class="row">

            <div class="col-md-6">

              <div class="form-group">
                <label for="formEmail">
                  E-mail:
                </label>
                <input type="email" class="form-control" 
                       tabindex="8"
                       name="formEmail" id="formEmail"
                       placeholder="fulano@dasilva.com.br"
                       value="${hospede.email}" />
              </div>

            </div>

            <div class="col-md-3">

              <div class="form-group">
                <label for="formNewsletter">
                  Newsletter:
                </label>
                <br style="clear: both;" />
                <input type="checkbox"
                       tabindex="9"
                       name="formNewsletter" id="formNewsletter"
                       value="1"
                       <c:if test="${hospede.newsletter == '1'}">
                         checked                         
                       </c:if>
                       />                
                <label for="formNewsletter">
                  Recebe
                </label>
              </div>

            </div>

            <div class="col-md-3">

              <div class="form-group">
                <label>
                  Status cadastral:
                </label>
                <label for="formStatus1">
                  Ativo
                </label>                
                <input type="radio"
                       tabindex="10"
                       name="formStatus" id="formStatus1"
                       value="1"
                       <c:if test="${hospede.status == '1'}">
                         checked                         
                       </c:if>
                       />
                <input type="radio"
                       tabindex="11"
                       name="formStatus" id="formStatus2"
                       value="0"
                       <c:if test="${hospede.status == '0'}">
                         checked                         
                       </c:if>
                       />
                <label for="formStatus2">
                  Inativo
                </label>
              </div>

            </div>

          </div>

          <h4>
            Adicionais sobre o Hospede
          </h4>

          <hr />

          <div class="row" id="formHospede">

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formCartao">
                  Número do Cartão:
                </label>
                <input type="text" class="form-control" 
                       tabindex="12"
                       name="formCartao" id="formCartao"
                       placeholder="0000 1111 2222 3333"
                       required
                       value="${hospede.nCartao}" />
              </div>

            </div>

            <div class="col-sm-6">
              <label>
                <i class="fa fa-lg fa-question-circle"></i>
              </label>
              <div>
                <small class="text-muted">
                  <i>
                    Informação necessária para fins de no-show.
                  </i>
                </small>
              </div>
            </div>

          </div>        
          <!-- Fim: DADOS -->

          <div style="padding: 10px 0px;"></div>

          <p>
            Os campos marcados com
            <i class="fa fa-fw fa-lg fa-asterisk"></i>
            são obrigatórios.
          </p>

          <div style="padding: 10px 0px;"></div>

          <!-- Linha de botões do formulário -->
          <div class="row">

            <div class="col-sm-4 hidden-xs"></div>

            <div class="col-xs-6 col-sm-4">

              <button type="submit" 
                      class="btn btn-block btn-lg btn-default" 
                      tabindex="11">
                ATUALIZAR
                <i class="fa fa-check-square"></i>
              </button>

            </div>

          </div>
          <!-- Linha de botões do formulário -->

          <div style="padding: 15px 0px;"></div>

        </form>
        <!-- Fim do Formulário -->

      </div>

      <div class="col-md-4">

        <div class="form-di">

          <h4>
            Histórico de Reservas
          </h4>

          <hr />

          <table class="table table-condensed table-hover table-responsive">
            <thead>
              <tr>
                <th>
                  <i class="fa fa-fw fa-calendar"></i>
                  Checkin
                </th>
                <th>
                  <i class="fa fa-fw fa-calendar"></i>
                  Checkout
                </th>
                <th>
                  <i class="fa fa-fw fa-building"></i>
                  Unidade
                </th>
                <th>
                  <i class="fa fa-fw fa-bed"></i>
                  Quarto
                </th>
                <th>
                  <i class="fa fa-fw fa-money"></i>
                  Valor
                </th>
              </tr>
            </thead>
            <tbody>
              <!-- Rodar o loop -->
            </tbody>
          </table>

        </div>

      </div>

    </div>

  </jsp:body>

</t:defaultTemplate>