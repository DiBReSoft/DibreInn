<%--
  Created on : 14/05/2015, 15:18:15
  Authors    : udimberto, fabio, thiago, luciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

    <jsp:attribute name="paginaTitulo">
        <c:choose>
            <c:when test="${pessoa.get(0).id != null}">
                Atualizar
            </c:when>
            <c:otherwise>
                Cadastrar
            </c:otherwise>
        </c:choose>
        Pessoa
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <!-- CSS e outros que vão no <head> da página -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/cadastrar-pessoa.css" />" />
    </jsp:attribute>

    <jsp:attribute name="paginaBottom">
        <!-- JavaScript e outros que vão ao final da página -->
        <script type="text/javascript" src="<c:url value="/assets/js/jquery.maskedinput.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-switch.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/form-component.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/cadastrar.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/jquery.numeric.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/jquery.maskedinput.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/validacoes.js" />"></script>
    </jsp:attribute>

    <jsp:body>

        <h1 class="page-title">
            <c:choose>
                <c:when test="${pessoa.get(0).id != null}">
                    Atualizar
                </c:when>
                <c:otherwise>
                    Cadastrar
                </c:otherwise>
            </c:choose>
            Pessoa
        </h1>

        <!-- page start-->
        <div>

            <!-- Início do Formulário -->
            <form role="form" method="post" class="form-di"
                  action="adicionar" name="formAdicionar">

                <div style="padding: 5px;"></div>

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
                                    <input type="text" class="form-control"
                                           tabindex="1"
                                           name="formNome" id="formNome" 
                                           placeholder="LebreHotel 1"
                                           required="true" 
                                           value="" />
                                </div>

                            </div>

                            <div class="col-xs-6">
                                <div class="form-group">
                                    <label for="formCnpj">
                                        Cnpj:
                                    </label>
                                    <input type="number" class="form-control"
                                           tabindex="2"
                                           name="formCnpj" id="formNome" 
                                           placeholder="LebreHotel 1"
                                           required="true" 
                                           value="" />
                                </div>

                            </div>


                            <div class="col-sm-4">

                                <div class="form-group">
                                    <label for="formCategoria">
                                        Categoria:
                                    </label>
                                    <select class="form-control"
                                            tabindex="3"
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

                            <!-- Fim da primeira coluna: lado esquerdo - DADOS -->

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
                                            <input type="text" class="form-control"
                                                   tabindex="4"
                                                   name="formCep" id="formCep"                                                     
                                                   placeholder="04696-000"
                                                   onblur="consultacep(this.value)"/>
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
                                                   tabindex="6"
                                                   name="formLogradouro" id="formLogradouro" 
                                                   placeholder="Av. Engenheiro Eusébio Stevaux" />
                                        </div>

                                    </div>

                                    <div class="col-xs-4">

                                        <div class="form-group">
                                            <label for="formNumero">
                                                Número:
                                            </label>
                                            <input type="number" class="form-control" 
                                                   tabindex="7"
                                                   name="formNumero" id="formNumero"
                                                   placeholder="823" />
                                        </div>

                                    </div>

                                    <div class="col-xs-6">

                                        <div class="form-group">
                                            <label for="formComplemento">
                                                Complemento:
                                            </label>                  
                                            <input type="text" class="form-control"
                                                   tabindex="8"
                                                   name="formComplemento" id="formComplemento" 
                                                   placeholder="Sala C143" />
                                        </div>

                                    </div>

                                    <div class="col-xs-6">

                                        <div class="form-group">                    
                                            <label for="formBairro">
                                                Bairro:
                                            </label>
                                            <input type="text" class="form-control"
                                                   tabindex="9"
                                                   name="formBairro" id="formBairro" 
                                                   placeholder="Campo Grande" />
                                        </div>

                                    </div>

                                    <div class="col-sm-5">

                                        <div class="form-group">
                                            <label for="formCidade">
                                                Cidade:
                                            </label>
                                            <input type="text" class="form-control" 
                                                   tabindex="10"
                                                   name="formCidade" id="formCidade" 
                                                   placeholder="São Paulo" />
                                        </div>

                                    </div>

                                    <div class="col-sm-3">

                                        <div class="form-group">
                                            <label for="formEstado" title="Estado">
                                                UF:
                                            </label>
                                            <input type="text" class="form-control" 
                                                   tabindex="11"
                                                   name="formEstado" id="formEstado" 
                                                   placeholder="SP" />
                                        </div>

                                    </div>

                                </div>

                            </div>
                            <!-- Fim da segunda coluna: lado direito - ENDEREÇO -->

                        </div>
                        <!-- Fim da #1 linha de GRID do formulário -->

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
                                        tabindex="13">
                                    <i class="fa fa-eraser"></i>
                                    LIMPAR
                                </button>

                            </div>

                            <div class="col-xs-6 col-sm-3">

                                <button type="submit" class="btn btn-block btn-lg btn-default" 
                                        tabindex="12">
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