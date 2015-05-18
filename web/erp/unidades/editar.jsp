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
        Quartos: Cadastrados
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <!-- CSS e outros que vão no <head> da página -->
    </jsp:attribute>

    <jsp:attribute name="paginaBottom">
        <!-- JavaScript e outros que vão ao final da página -->
        <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-switch.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/form-component.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/cadastrar.js" />"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="col-md-9 col-sm-8 form-di ${visibilidadeResultados}">
            <h1 class="page-title">
                Visualizar Unidades
            </h1>

            <!-- page start-->
            <div>

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
                                               name="formCnpj" id="formNome" 
                                               placeholder="LebreHotel 1"
                                               required="true" 
                                               value="<c:out value="${unidade.get(0).cnpj}" />" />
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
                        </div>
                    </div>


                </form>
                <!-- Fim do Formulário -->

                <form role="form" method="get" class="form-di"
                      action="visualizar" name="formSelecionaQuarto">
                    <h4>
                        Informações dos quartos Cadastrados
                    </h4>
                    <hr />

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
                            <c:forEach items="${lista}" var="unidade" varStatus="stat">
                                <tr>
                                    <td scope="row"><c:out value="${unidade.id}" /></td>
                                    <td class ="numero"><c:out value="${unidade.nome}" /></td>
                                    <td class ="andar"><c:out value="${unidade.tipo}" /></td>
                                    <td class="seleciona">
                                        <a href="<c:url value="/erp/unidade/editar?id=${unidade.id}" />" class="selecionado">
                                            Selecionar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>

                <!-- Fim da #1 linha de GRID dos formulários -->




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