<%--
  Created on : 19/03/2015, 21:18:15
  Authors    : udimberto, fabio, thiago, luciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

    <jsp:attribute name="paginaTitulo">
        Editar Funcionario
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
            Editar Usuario
        </h1>

        <!-- page start-->
        <div class="row">

            <div class="col-md-8">

                <!-- Início do Formulário -->
                <form role="form" method="post" class="form-di"
                      action="editar"
                      accept-charset="UTF-8"
                      enctype="application/x-www-form-urlencoded">

                    <input type="hidden" name="formId" value="${usuario.id}" />

                    <div style="padding: 5px;"></div>

                    <!-- Início:- DADOS -->
                    <h4>
                        Dados
                    </h4>

                    <hr />
                    <div class="row" id="formUsuario">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="formLogin">
                                    Login:
                                </label>                  
                                <input type="text" class="form-control"
                                       name="formLogin" id="formLogin" 
                                       placeholder="Nome de Usuário" 
                                       disabled 
                                        value="${usuario.login}"/>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="form-group">
                                <label for="formSenha">
                                    Nova Senha:
                                </label>                  
                                <input type="password" class="form-control"
                                       name="formSenha" id="formSenha" 
                                       placeholder="********" 
                                        value="${usuario.senha}"/>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- DIV com os campos de id e senha -->

        </div>
    </div>>        
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