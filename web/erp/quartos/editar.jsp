<%-- 
    Document   : index
    Created on : 12/05/2015, 12:18:15
    Author     : Thi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Quartos: Cadastrados
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-switch.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/form-component.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/quartos.js" />"></script>
  </jsp:attribute>

  <jsp:body>
    
      <h1 class="page-title">
        Visualizar Quarto
      </h1>

      <!-- page start-->
       
  <form role="form" method="get" class="form-di"
        action="visualizar" name="formSelecionaQuarto">
    <h4>
      Informações dos quartos Cadastrados
    </h4>
    <hr />
<div class="row">
  <div class="col-md-9 col-sm-8 form-di">
    <table class="table table-responsive table-hover table-striped table-condensed">
      <thead>
        <tr>
          <th>ID</th>
          <th>Número</th>
          <th>Andar</th>
          <th>Ramal</th>
          <th>Valor da Diaria</th>
          <th>Ocupado</th>
          <th>Editar</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${lista}" var="quarto" varStatus="stat">
          <tr>
              <td class ="id" id="tableId" scope="row"><c:out value="${quarto.id}" /></td>
            <td class ="numero" id="tableNumero"><c:out value="${quarto.numero}" /></td>
            <td class ="andar" id="tableAndar"><c:out value="${quarto.andar}" /></td>
            <td class ="ramal" id="tableRamal"><c:out value="${quarto.ramal}" /></td>
            <td class ="valor" id="tableValor"><c:out value="${quarto.valorDiaria}" /></td>
            <td class ="ocupado" id="tableOcupado"><c:out value="${quarto.ocupado}" /></td>
            <td class="seleciona" id="tableSeleciona">
              <a href="" class="selecionado" id="tableSelecionado">
                Selecionar
              </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
    </div>
      
  </form>

  <!-- Fim da #1 linha de GRID dos formulários -->

      
      
      

        <!-- Início do Formulário -->
        <form role="form" method="post" class="form-di"
              action="editar" name="formEditar">

          <!-- Início da #1 linha de GRID do formulário -->
          <div class="row">

            <!-- Início da primeira coluna: lado esquerdo - DADOS -->
            <div class="col-md-9 col-sm-8 form-di">

              <h4>
                Resultado da busca
              </h4>

              <hr />

              
                  <div class="form-group">
                    <label for="formNumero">
                      Número do quarto:
                    </label>
                    <input readonly="true" type="text" class="form-control"
                           tabindex="1"
                           name="formNumero" id="formNumero" 
                           placeholder="1"
                           required="true" />
                  </div>

                </div>

                <div class="col-xs-6">

                  <div class="form-group">
                    <label for="formAndar">
                      Andar
                    </label>
                    <input readonly="true" type="text" class="form-control" 
                           tabindex="2"
                           name="formAndar" id="formAndar"
                           placeholder="11"
                           required="true" />
                  </div>

                </div>


                <div class="col-sm-4">

                  <div class="form-group">                    
                    <label for="formRamal">
                      Ramal:
                    </label>                  
                    <input readonly="true" type="text" class="form-control"
                           tabindex="3"
                           name="formRamal" id="formRamal" 
                           placeholder="55" 
                           maxlength="20" 
                           required="true"/>
                  </div>

                </div>

                <div class="col-sm-4">

                  <div class="form-group">                    
                    <label for="formValor">
                      Valor da Diaria:
                    </label>
                    <input readonly="true" type="number" class="form-control"
                           tabindex="4"
                           name="formValor" id="formValor" 
                           placeholder="120" 
                           maxlength="50" 
                           required="true"/>
                  </div>

                </div>
              </div>
            
          
      
  </form>
  <!-- Fim do Formulário -->
 
  <div style="padding: 15px 0px;"></div>

  <!-- Linha de botões do formulário -->
  <div class="row">

    <div class="col-sm-3 hidden-xs"></div>

    <div class="col-xs-6 col-sm-3">

      <button type="reset" class="btn btn-block btn-lg btn-primary" 
              tabindex="5">
        <i class="fa fa-lg fa-times"></i>
        EXCLUIR
      </button>

    </div>

    <div class="col-xs-6 col-sm-3">

      <button type="submit" class="btn btn-block btn-lg btn-default" 
              tabindex="6">
        EDITAR
        <i class="fa fa-lg fa-edit"></i>
      </button>

    </div>

  </div>   
  <!-- Linha de botões do formulário -->


  <div style="padding: 15px 0px;"></div>

</div>

</jsp:body>

</t:defaultTemplate>