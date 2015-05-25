<%--
  Created on : 14/05/2015, 15:18:15
  Authors    : udimberto, fabio, thiago, luciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Adicionar Unidade
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
    <script type="text/javascript" src="<c:url value="/assets/js/cadastrar.js" />"></script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Adicionar Unidade
    </h1>

    <!-- Início do Formulário -->
    <form role="form" method="post" class="form-di"
          action="adicionar" name="unidadeAdicionar"
            accept-charset="UTF-8"
            enctype="application/x-www-form-urlencoded">

      <div style="padding: 5px;"></div>

      <div class="row">

        <div class="col-md-2"></div>

        <div class="col-md-8">

          <h4>
            Dados
          </h4>

          <hr />

          <div class="row">

            <div class="col-sm-4">
              
              <div class="form-group">
                <label for="formNome">
                  Nome da Unidade:
                </label>
                <input type="text" class="form-control"
                       tabindex="1"
                       name="unidadeNome" id="formNome" 
                       placeholder="SAO PAULO III"
                       required="true" 
                       value="" />
              </div>

            </div>

            <div class="col-sm-5">
              
              <div class="form-group">
                <label for="formCnpj">
                  CNPJ:
                </label>
                <input type="text" class="form-control"
                       tabindex="2"
                       name="unidadeCnpj" id="formCnpj" 
                       placeholder=""
                       required="true" 
                       value="" />
              </div>

            </div>

            <div class="col-sm-3">

              <div class="form-group">
                <label for="formTipo">
                  Tipo:
                </label>
                <select class="form-control"
                        tabindex="3"
                        name="unidadeTipo" id="formTipo"                         
                        placeholder="Filial"
                        required="true">
                  <option value="0">
                    Filial
                  </option>
                  <option value="1">
                    Matriz
                  </option>
                </select>
              </div>

            </div>

          </div>
          <!-- Fim da #1 linha de GRID do formulário -->

          <h4>
            Endereço
          </h4>

          <hr />

          <div class="row">

            <div class="col-sm-6">

              <div class="form-group">
                <label for="formCep">
                  CEP: 
                  <span class="badge badge-event">
                    autocompleta
                  </span>
                </label>
                <input type="text" class="form-control"
                       tabindex="4"
                       name="unidadeCep" id="formCep"                                                     
                       placeholder="04696-000"
                       onblur="consultacep(this.value)"
                       required="true" />
              </div>

            </div>

            <div class="col-sm-6 hidden-xs">
              <label>
                <i class="fa fa-lg fa-question-circle"></i>
              </label>
              <div>
                <small class="text-muted">
                  <i>
                    Digite o CEP que o endereço será preenchido
                    automaticamente com os dados geográficos
                  </i>
                </small>
              </div>
            </div>

            <div class="col-xs-8">

              <div class="form-group">
                <label for="formLogradouro">
                  Logradouro:
                </label>
                <input type="text" class="form-control"
                       name="unidadeLogradouro" id="formLogradouro" 
                       placeholder="Av. Engenheiro Eusébio Stevaux"
                       readonly />
              </div>

            </div>

            <div class="col-xs-4">

              <div class="form-group">
                <label for="formNumero">
                  Número:
                </label>
                <input type="number" class="form-control" 
                       tabindex="5"
                       name="unidadeNumero" id="formNumero"
                       placeholder="823"
                       required="true" />
              </div>

            </div>

            <div class="col-xs-6">

              <div class="form-group">
                <label for="formComplemento">
                  Complemento:
                </label>                  
                <input type="text" class="form-control"
                       tabindex="6"
                       name="unidadeComplemento" id="formComplemento" 
                       placeholder="Sala C143" />
              </div>

            </div>

            <div class="col-xs-6">

              <div class="form-group">                    
                <label for="formBairro">
                  Bairro:
                </label>
                <input type="text" class="form-control"
                       name="unidadeBairro" id="formBairro" 
                       placeholder="Campo Grande" 
                       readonly />
              </div>

            </div>

            <div class="col-sm-5">

              <div class="form-group">
                <label for="formCidade">
                  Cidade:
                </label>
                <input type="text" class="form-control" 
                       name="unidadeCidade" id="formCidade" 
                       placeholder="São Paulo" 
                       readonly />
              </div>

            </div>

            <div class="col-sm-3">

              <div class="form-group">
                <label for="formEstado" title="Estado">
                  UF:
                </label>
                <input type="text" class="form-control" 
                       name="unidadeEstado" id="formEstado" 
                       placeholder="SP" 
                       readonly />
              </div>

            </div>

          </div>

          <div style="padding: 10px 0px;"></div>

          <p>
            Os campos marcados com
            <i class="fa fa-fw fa-lg fa-asterisk text-success"></i>
            são obrigatórios.
          </p>

        </div>

      </div>

      <div style="padding: 10px 0px;"></div>

      <!-- Linha de botões do formulário -->
      <div class="row">

        <div class="col-sm-3 hidden-xs"></div>

        <div class="col-xs-6 col-sm-3">

          <button type="reset" class="btn btn-block btn-lg btn-primary" 
                  tabindex="8">
            <i class="fa fa-eraser"></i>
            LIMPAR
          </button>

        </div>

        <div class="col-xs-6 col-sm-3">

          <button type="submit" class="btn btn-block btn-lg btn-default" 
                  tabindex="7">
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