<%-- 
    Document   : adicionar
    Created on : 25/05/2015, 13:26:10
    Author     : Thiago, udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Editar Quarto
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Editar Quarto
    </h1>

    <!-- Início do Formulário -->
    <form role="form" method="post" class="form-di"
          action="editar" name="formQuarto"
          accept-charset="UTF-8"
          enctype="application/x-www-form-urlencoded">

      <div class="row">

        <div class="col-md-2"></div>

        <div class="col-md-8">

          <h4>
            Dados do Quarto
          </h4>

          <hr />

          <div class="row">

            <div class="col-xs-2">

              <div class="form-group">

                <label for="formId">
                  <i class="fa fa-lg fa-barcode"></i>
                  ID:
                </label>

                <input type="text" class="form-control"
                       tabindex="1"
                       name="formId" id="formId"
                       value="<c:out value="${quarto.id}" />"
                       readonly 
                       title="Não é possível mudar o ID do quarto" />

              </div>

            </div>

            <div class="col-xs-4">

              <div class="form-group">

                <label for="formUnidade">
                  <i class="fa fa-lg fa-building"></i>
                  Unidade:
                </label>

                <!-- USUÁRIO NÃO PODE EDITAR A UNIDADE DO QUARTO -->
                <input type="hidden" 
                       name="formId"
                       value="<c:out value="${quarto.id}" />" />

                <input type="hidden" 
                       name="formUnidade"
                       value="<c:out value="${unidade.id}" />" />
                <!-- USUÁRIO NÃO PODE EDITAR A UNIDADE DO QUARTO -->

                <input type="text" class="form-control"
                       tabindex="1"
                       value="${unidade.estado} - ${unidade.nome}"
                       readonly 
                       title="Não é possível mudar um quarto de sua primeira unidade" />

              </div>

            </div>

            <div class="col-sm-6">

              <div class="form-group">

                <label for="formStatus">
                  <i class="fa fa-lg fa-building"></i>
                  Status:
                </label>

                <div class="row">

                  <div class="col-xs-6 text-right">

                    <label for="formStatus1">
                      Ativo
                    </label>

                    <input type="radio"
                           tabindex="2"
                           name="formStatus" id="formStatus1"
                           value="1"
                           required="true"
                           <c:if test="${quarto.status == '1'}">
                             checked
                           </c:if>
                           />

                  </div>

                  <div class="col-xs-6 text-left">

                    <input type="radio"
                           tabindex="3"
                           name="formStatus" id="formStatus2"
                           value="0"
                           required="true" 
                           <c:if test="${quarto.status == '0'}">
                             checked
                           </c:if>
                           />

                    <label for="formStatus2">
                      Inativo
                    </label>

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
                       tabindex="2"
                       name="formAndar" id="formAndar"
                       placeholder="Ex.: 5"
                       required="true"
                       value="<c:out value="${quarto.andar}" />" />
              </div>

            </div>

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formNumero">
                  <i class="fa fa-lg fa-tag"></i>
                  Número:
                </label>
                <input type="text" class="form-control" 
                       tabindex="3"
                       name="formNumero" id="formNumero"
                       placeholder="Ex.: 525"
                       required="true"
                       value="<c:out value="${quarto.numero}" />" />
              </div>

            </div>

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formRamal">
                  <i class="fa fa-lg fa-phone"></i>
                  Ramal:
                </label>                  
                <input type="text" class="form-control"
                       tabindex="4"
                       name="formRamal" id="formRamal" 
                       placeholder="Ex.: 5525" 
                       maxlength="20" 
                       required="true"
                       value="<c:out value="${quarto.ramal}" />" />
              </div>

            </div>

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formValor">
                  <i class="fa fa-lg fa-usd"></i>
                  Valor da Diária:
                </label>
                <input type="text" class="form-control"
                       tabindex="5"
                       name="formValor" id="formValor" 
                       placeholder="Ex.: 125"
                       maxlength="50" 
                       required="true"
                       value="<c:out value="${quarto.valorDiaria}" />" />
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

        <div class="col-xs-3 col-sm-4"></div>

        <div class="col-xs-6 col-sm-4">

          <button type="submit" class="btn btn-block btn-lg btn-default" 
                  tabindex="6">
            ATUALIZAR
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
