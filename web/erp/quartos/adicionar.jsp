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
    Cadastrar Quarto
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Cadastrar Quarto
    </h1>

    <!-- page start-->
    <div>

      <!-- Início do Formulário -->
      <form role="form" method="post" class="form-di"
            action="adicionar" name="formQuarto">

        <!-- Início da #1 linha de GRID do formulário -->
        <div class="row">

          <!-- Início da primeira coluna: lado esquerdo - DADOS -->
          <div class="col-sm-6">

            <h4>
              Dados
            </h4>

            <hr />

            <div class="row">

              <div class="col-sm-6">

                <div class="form-group">
                  <label for="formAndar">
                    Andar:
                  </label>
                  <input type="text" class="form-control" 
                         tabindex="1"
                         name="formAndar" id="formAndar"
                         placeholder="Ex.: 5"
                         required="true" />
                </div>

              </div>

              <div class="col-sm-6">

                <div class="form-group">
                  <label for="formNumero">
                    Número do quarto:
                  </label>
                  <input type="number" class="form-control"
                         tabindex="2"
                         name="formNumero" id="formNumero" 
                         placeholder="Ex.: 525"
                         required="true" />
                </div>

              </div>

              <div class="col-sm-6">

                <div class="form-group">                    
                  <label for="formRamal">
                    Ramal:
                  </label>                  
                  <input type="text" class="form-control"
                         tabindex="3"
                         name="formRamal" id="formRamal" 
                         placeholder="Ex.: 5525" 
                         maxlength="20" 
                         required="true"/>
                </div>

              </div>

              <div class="col-sm-6">

                <div class="form-group">                    
                  <label for="formValor">
                    Valor da Diária:
                  </label>
                  <input type="number" class="form-control"
                         tabindex="4"
                         name="formValor" id="formValor" 
                         placeholder="Ex.: 125"
                         maxlength="50" 
                         required="true"/>
                </div>

              </div>
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

        <!-- Linha de botões do formulário -->
        <div class="row">

          <div class="col-sm-3 hidden-xs"></div>

          <div class="col-xs-6 col-sm-3">

            <button type="reset" class="btn btn-block btn-lg btn-primary" 
                    tabindex="6">
              <i class="fa fa-eraser"></i>
              LIMPAR
            </button>

          </div>

          <div class="col-xs-6 col-sm-3">

            <button type="submit" class="btn btn-block btn-lg btn-default" 
                    tabindex="5">
              CADASTRAR
              <i class="fa fa-check-square"></i>
            </button>

          </div>

        </div>   
        <!-- Linha de botões do formulário -->

      </form>
      <!-- Fim do Formulário -->

      <div style="padding: 15px 0px;"></div>

    </div>

  </jsp:body>

</t:defaultTemplate>
