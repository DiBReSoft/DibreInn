<%-- 
    Document   : index
    Created on : 14/05/2015, 12:18:15
    Author     : Thi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Buscar Unidades
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
    <script type="text/javascript" src="<c:url value="/assets/js/cadastrar.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/unidades.js" />"></script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Buscar Unidades
    </h1>

    <!-- page start-->

    <form role="form" method="get" class="form-di"
          action="visualizar" name="formSelecionaQuarto">
      <h4>
        Informações das Unidades Cadastradas
      </h4>
      <hr />
      <div class="row">
        <div class= "form-di">
          <table class="table table-responsive table-hover table-striped table-condensed">
            <thead>
              <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cnpj</th>
                <th>Categoria</th>
                <th>Cep</th>
                <th>Número</th>
                <th>Complemento</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${lista}" var="unidade" varStatus="stat">
                <tr>
                  <td scope="row" id="tableId"><c:out value="${unidade.id}" /></td>
                  <td class ="nome" id="tableNome" ><c:out value="${unidade.nome}" /></td>
                  <td class ="Cnpj" id="tableCnpj"><c:out value="${unidade.cnpj}" /></td>
                  <td class ="Categoria" id="tableCategoria"><c:out value="${unidade.tipo}" /></td>
                  <td class ="Cep" id="tableCep"><c:out value="${unidade.cep}" /></td>
                  <td class ="Numero" id="tableNumero"><c:out value="${unidade.numero}" /></td>
                  <td class ="Complemento" id="tableComplemento"><c:out value="${unidade.complemento}" /></td>
                  <td class="seleciona">
                    <a href="" class="selecionado">
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
        <div class="col-sm-6">

          <h4>
            Dados
          </h4>

          <hr />

          <div class="row">

            <div class="col-xs-6">

              <div class="form-group">
                <label for="formNome">
                  Nome da Unidade:
                </label>
                <input readonly="true" type="text" class="form-control"
                       tabindex="1"
                       name="formNome" id="formNome" 
                       placeholder="1"
                       required="true" />
              </div>

            </div>

            <div class="col-xs-6">
              <div class="form-group">
                <label for="formCnpj">
                  Cnpj:
                </label>
                <input readonly="true" type="number" class="form-control"
                       tabindex="2"
                       name="formCnpj" id="formCnpj" 
                       placeholder="LebreHotel 1"
                       required="true" 
                       value="" />
              </div>

            </div>

            <div class="col-xs-6">

              <div class="form-group">
                <label for="formCategoria">
                  Categoria:
                </label>
                <select readonly="true" class="form-control"
                        tabindex="2"
                        name="formCategoria" id="formCategoria"                         
                        placeholder="Filial"
                        required="true">
                  <option value="1">
                    Matriz
                  </option>
                  <option value="0">
                    Filial
                  </option>
                </select>
              </div>
            </div>
          </div>
        </div>

        <!-- Início da segunda coluna: lado direito - ENDEREÇO -->
        <div class="col-sm-6">

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
                <input readonly="true" type="text" class="form-control"
                       tabindex="10"
                       name="formCep" id="formCep"                                                     
                       placeholder="04696-000"/>
              </div>

            </div>

            <div class="col-sm-6 hidden-xs">
              <label>
                <i class="fa fa-lg fa-question-circle"></i>
              </label>
              <div style="padding: 5px;"></div>
              <small class="text-muted">
                <i>
                  Digite o CEP que o endereço será preenchido
                  automaticamente com os dados geográficos
                </i>
              </small>
            </div>

            <div class="col-xs-8">

              <div class="form-group">
                <label for="formLogradouro">
                  Logradouro:
                </label>
                <input readonly="true" type="text" class="form-control"
                       tabindex="11"
                       name="formLogradouro" id="formLogradouro" 
                       placeholder="Av. Engenheiro Eusébio Stevaux" />
              </div>

            </div>

            <div class="col-xs-4">

              <div class="form-group">
                <label for="formNumero">
                  Número:
                </label>
                <input readonly="true" type="number" class="form-control" 
                       tabindex="12"
                       name="formNumero" id="formNumero"
                       placeholder="823" />
              </div>

            </div>

            <div class="col-xs-6">

              <div class="form-group">
                <label for="formComplemento">
                  Complemento:
                </label>                  
                <input readonly="true" type="text" class="form-control"
                       tabindex="13"
                       name="formComplemento" id="formComplemento" 
                       placeholder="Sala C143" />
              </div>

            </div>

            <div class="col-xs-6">

              <div class="form-group">                    
                <label for="formBairro">
                  Bairro:
                </label>
                <input readonly="true" type="text" class="form-control"
                       tabindex="14"
                       name="formBairro" id="formBairro" 
                       placeholder="Campo Grande" />
              </div>

            </div>

            <div class="col-sm-5">

              <div class="form-group">
                <label for="formCidade">
                  Cidade:
                </label>
                <input readonly="true" type="text" class="form-control" 
                       tabindex="15"
                       name="formCidade" id="formCidade" 
                       placeholder="São Paulo" />
              </div>

            </div>

            <div class="col-sm-3">

              <div class="form-group">
                <label for="formEstado" title="Estado">
                  UF:
                </label>
                <input readonly="true" type="text" class="form-control" 
                       tabindex="16"
                       name="formEstado" id="formEstado" 
                       placeholder="SP" />
              </div>

            </div>


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



  </jsp:body>

</t:defaultTemplate>