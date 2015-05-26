<%-- 
    Document   : adicionar
    Created on : 12/05/2015, 11:13:45
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Adicionar Quarto
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Adicionar Quarto
    </h1>

    <!-- Início do Formulário -->
    <form role="form" method="post" class="form-di"
          action="adicionar" name="formQuarto"
          accept-charset="UTF-8"
          enctype="application/x-www-form-urlencoded">

      <div class="row">

        <div class="col-md-2"></div>

        <div class="col-md-8">

          <h4>
            Dados
          </h4>

          <hr />

          <div class="row">

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formUnidade">
                  <i class="fa fa-lg fa-building"></i>
                  Unidade:
                </label>            
                <select class="form-control"
                        tabindex="1"
                        name="formUnidade" id="formUnidade"
                        required="true">
                  <c:forEach items="${listaUnidades}" var="unidade" varStatus="stat">
                    <c:if test="${unidade.status == '1'}">
                      <option value="${unidade.id}">
                        <c:out value="${unidade.estado}" />
                        -
                        <c:out value="${unidade.nome}" />
                      </option>
                    </c:if>
                  </c:forEach>
                </select>
              </div>

            </div>

            <div class="col-sm-6">

              <div class="form-group">

                <label for="formStatus">
                  <i class="fa fa-lg fa-building"></i>
                  Status:
                </label>

                <div class="row">

                  <div class="col-xs-6">

                    <label for="formStatus1">
                      <i class="fa fa-fw fa-lg"></i>
                      Ativo
                    </label>

                    <input type="hidden"
                           tabindex="2"
                           name="formStatus" id="formStatus1"
                           value="1"
                           required="true"
                           readonly />

                  </div>

                </div>

              </div>

            </div>

          </div>

          <div class="row">

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formAndar">
                  <i class="fa fa-lg fa-building"></i>
                  Andar:
                </label>
                <input type="text" class="form-control" 
                       tabindex="4"
                       name="formAndar" id="formAndar"
                       placeholder="Ex.: 5"
                       required="true" />
              </div>

            </div>

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formNumero">
                  <i class="fa fa-lg fa-tag"></i>
                  Número:
                </label>
                <input type="text" class="form-control" 
                       tabindex="5"
                       name="formNumero" id="formNumero"
                       placeholder="Ex.: 525"
                       required="true" />
              </div>

            </div>

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formRamal">
                  <i class="fa fa-lg fa-phone"></i>
                  Ramal:
                </label>                  
                <input type="text" class="form-control"
                       tabindex="6"
                       name="formRamal" id="formRamal" 
                       placeholder="Ex.: 5525" 
                       maxlength="20" 
                       required="true"/>
              </div>

            </div>

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formValor">
                  <i class="fa fa-lg fa-usd"></i>
                  Valor da Diária:
                </label>
                <input type="number" class="form-control"
                       tabindex="7"
                       name="formValor" id="formValor" 
                       placeholder="Ex.: 125"
                       maxlength="50" 
                       required="true"/>
              </div>

            </div>

          </div>

          <div style="padding: 10px 0px;"></div>

          <p>
            Os campos marcados com
            <i class="fa fa-fw fa-lg fa-asterisk"></i>
            são obrigatórios.
          </p>

          <div style="padding: 10px 0px;"></div>

        </div>

      </div>

      <!-- Linha de botões do formulário -->
      <div class="row">

        <div class="col-sm-3 hidden-xs"></div>

        <div class="col-xs-6 col-sm-3">

          <button type="reset" class="btn btn-block btn-lg btn-primary" 
                  tabindex="9">
            <i class="fa fa-eraser"></i>
            LIMPAR
          </button>

        </div>

        <div class="col-xs-6 col-sm-3">

          <button type="submit" class="btn btn-block btn-lg btn-default" 
                  tabindex="8">
            CADASTRAR
            <i class="fa fa-check-square"></i>
          </button>

        </div>

      </div>   
      <!-- Linha de botões do formulário -->

    </form>
    <!-- Fim do Formulário -->

    <div style="padding: 15px 0px;"></div>

  </jsp:body>

</t:defaultTemplate>
