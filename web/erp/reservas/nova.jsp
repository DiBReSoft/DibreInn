<%-- 
    Document   : nova
    Created on : 03/05/2015, 10:30:15
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

    <jsp:attribute name="paginaTitulo">
        Nova Reserva
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/jquery-ui.min.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/reservas.css" />" />
    </jsp:attribute>

    <jsp:attribute name="paginaBottom">
        <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/jquery-calendar-configs.js" />"></script>
        <script type="text/javascript">
            $(window).load(function () {
                var stepTwo = $("[data-target=#stepTwo]");
            ${selecionouHospede}
            });
        </script>
    </jsp:attribute>

    <jsp:body>

        <h1 class="page-title">
            Nova Reserva
        </h1>

        <ul class="nav-steps">
            <li role="presentation" 
                class="${ativarTab1}"
                id="stepOneTab">
                #1 HOSPEDE
            </li>
            <li role="presentation"
                class="${ativarTab2}"
                id="stepTwoTab">
                #2 RESERVA
            </li>
        </ul>

        <div class="tab-content">

            <a class="hidden" data-toggle="tab" data-target="#stepTwo"></a>

            <div role="tabpanel" class="tab-pane fade in active" id="stepOne">

                <div class="steps-container">

                    <!-- Início da #1 linha de GRID dos formulários -->
                    <div class="row">

                        <div class="col-md-4 col-sm-5">

                            <!-- Formulário #1 | Buscar por nome -->
                            <form role="form" method="get" class="form-di"
                                  accept-charset="UTF-8"
                                  enctype="application/x-www-form-urlencoded"
                                  action="nova">

                                <h4>
                                    <label for="formNome">
                                        Buscar por nome
                                    </label>
                                </h4>

                                <div class="input-group">

                                    <input type="text" class="form-control"
                                           tabindex="1"
                                           name="nome" id="formNome" 
                                           placeholder="Fulano" 
                                           value="<c:out value="${nomeBuscado}" />" />

                                    <span class="input-group-btn">              

                                        <button type="submit" class="btn btn-default" 
                                                tabindex="2">

                                            <span class="hidden-sm hidden-xs">
                                                Buscar
                                            </span>                

                                            <i class="fa fa-fw fa-lg fa-search"></i>

                                        </button>

                                    </span>
                                </div>

                            </form>
                            <!-- Formulário #1 | Buscar por nome -->

                            <div style="padding: 5px 0px;"></div>

                            <!-- Formulário #2 | Buscar por e-mail -->
                            <form role="form" method="get" class="form-di"
                                  accept-charset="UTF-8"
                                  enctype="application/x-www-form-urlencoded"
                                  action="nova">

                                <h4>
                                    <label for="formEmail">
                                        Buscar por e-mail
                                    </label>
                                </h4>

                                <div class="input-group">            

                                    <input type="email" class="form-control" 
                                           tabindex="3"
                                           name="email" id="formEmail"
                                           placeholder="fulano@dasilva.com.br"
                                           value="<c:out value="${emailBuscado}" />" />

                                    <span class="input-group-btn">

                                        <button type="submit" class="btn btn-default" 
                                                tabindex="4">

                                            <span class="hidden-sm hidden-xs">
                                                Buscar
                                            </span>

                                            <i class="fa fa-fw fa-lg fa-search"></i>

                                        </button>

                                    </span>

                                </div>

                            </form>
                            <!-- Formulário #2 | Buscar por e-mail -->

                            <div style="padding: 5px 0px;"></div>

                            <!-- Formulário #3 | Buscar por CPF -->
                            <form role="form" method="get" class="form-di"
                                  accept-charset="UTF-8"
                                  enctype="application/x-www-form-urlencoded"
                                  action="nova">

                                <h4>
                                    <label for="formCpf">
                                        Buscar por CPF
                                    </label>
                                </h4>

                                <div class="input-group">

                                    <input type="text" class="form-control"
                                           tabindex="5"
                                           name="cpf" id="formCpf" 
                                           placeholder="111.222.333-44"
                                           value="<c:out value="${cpfBuscado}" />" />

                                    <span class="input-group-btn">

                                        <button type="submit" class="btn btn-default" 
                                                tabindex="6">

                                            <span class="hidden-sm hidden-xs">
                                                Buscar
                                            </span>

                                            <i class="fa fa-fw fa-lg fa-search"></i>

                                        </button>

                                    </span>

                                </div>

                            </form>
                            <!-- Formulário #3 | Buscar por CPF -->

                        </div>

                        <div class="col-md-8 col-sm-7 form-di ${visibilidadeResultados}">

                            <h4 class="text-center">
                                Resultado(s) da busca
                            </h4>

                            <c:if test="${!lista.isEmpty()}">

                                <table class="table table-responsive table-hover table-striped table-condensed">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nome</th>
                                            <th>CPF</th>
                                            <th>E-mail</th>
                                            <th>Selecionar</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${lista}" var="pessoa" varStatus="stat">
                                            <tr>
                                                <td scope="row">
                                                    <c:out value="${pessoa.id}" />
                                                </td>
                                                <td class="nome">
                                                    <c:out value="${pessoa.nome}" />
                                                    <c:out value="${pessoa.sobrenome}" />
                                                </td>
                                                <td class="cpf">
                                                    <c:out value="${pessoa.cpf}" />
                                                </td>
                                                <td class="email">
                                                    <c:out value="${pessoa.email}" />
                                                </td>
                                                <td class="seleciona">
                                                    <a href="<c:url value="/erp/reservas/nova?id=${pessoa.id}" />" 
                                                       class="selecionado">
                                                        <i class="fa fa-fw fa-lg fa-edit"></i>
                                                        Selecionar
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </c:if>

                            <c:if test="${lista.isEmpty()}">

                                <div class="col-sm-3"></div>

                                <div class="col-sm-6">

                                    <div class="text-center">
                                        <h1>
                                            <span class="fa-stack fa-lg">
                                                <i class="fa fa-user fa-stack-1x text-success"></i>
                                                <i class="fa fa-search fa-stack-2x text-muted"></i>
                                            </span>
                                        </h1>
                                        <h2>
                                            Desculpe.
                                        </h2>
                                        <h3>
                                            Não pudemos encontrar pessoas com 
                                            <c:choose>
                                                <c:when test="${nomeBuscado != null}">
                                                    o nome <div>"<c:out value="${nomeBuscado}" />"</div>
                                                </c:when>
                                                <c:when test="${emailBuscado != null}">
                                                    o e-mail <div>"<c:out value="${emailBuscado}" />"</div>
                                                </c:when>
                                                <c:when test="${cpfBuscado != null}">
                                                    o CPF <div>"<c:out value="${cpfBuscado}" />"</div>
                                                </c:when>
                                            </c:choose>
                                        </h3>
                                    </div>

                                </div>

                            </c:if>

                        </div>

                    </div>
                    <!-- Fim da #1 linha de GRID dos formulários -->

                    <br style="clear: both;" />
                    <br style="clear: both;" />

                    <a class="btn btn-lg btn-block btn-primary hidden"
                       data-toggle="tab" 
                       data-target="#stepTwo"
                       href="#stepTwo">
                        <i class="fa fa-fw fa-lg fa-arrow-right"></i>
                    </a>

                </div>

            </div>


            <div role="tabpanel" class="tab-pane fade" id="stepTwo">

                <form role="form" class="form-di" method="post"
                      accept-charset="UTF-8"
                      enctype="application/x-www-form-urlencoded"
                      action="nova">

                    <div class="steps-container">

                        <div class="row">

                            <div class="col-md-3"></div>

                            <div class="col-md-4">

                                <div class="form-group">
                                    <h4>
                                        <label for="checkIn">
                                            Check-in:
                                        </label>
                                        <div class="input-group input-group-lg">

                                            <span class="input-group-addon" id="basic-addon1">
                                                <i class="fa fa-fw fa-lg fa-calendar"></i>
                                            </span>

                                            <input type="text" class="form-control calendar" placeholder="dd/mm/aaaa"
                                                   tabindex="7" aria-describedby="basic-addon1"
                                                   name="checkIn" id="checkIn" 
                                                   required="true" />

                                        </div>
                                    </h4>

                                    <h4>
                                        <label for="checkOut">
                                            Check-out:
                                        </label>
                                        <div class="input-group input-group-lg">

                                            <span class="input-group-addon" id="basic-addon1">
                                                <i class="fa fa-fw fa-lg fa-calendar"></i>
                                            </span>

                                            <input type="text" class="form-control calendar" placeholder="dd/mm/aaaa"
                                                   tabindex="7" aria-describedby="basic-addon1"
                                                   name="checkOut" id="checkOut" 
                                                   required="true" />

                                        </div>
                                    </h4>
                                </div>

                                <div class="form-group">  
                                    <h4>
                                        
                                        <label for="escolheUnidade">
                                            Unidade:
                                        </label>
                                        <div class="input-group input-group-lg">

                                            <select class="form-control" tabindex="8" aria-describedby="basic-addon2"
                                                    name="reservaQuarto" id="reservaQuarto" required="true">
                                                <!--
                                                <c:forEach items="${listaQuartos}" var="quarto" varStatus="stat">
                                                    <option value="<c:out value="${quarto.id}" />">
                                                        Quarto <c:out value="${quarto.numero}" />
                                                    </option>
                                                </c:forEach>
                                                -->
                                                <option value="Exemplo">
                                                    Unidade Exemplo
                                                </option>
                                            </select>
                                        </div>
                                        
                                        
                                        
                                        <label for="reservaQuarto">
                                            Quarto:
                                        </label>
                                        <div class="input-group input-group-lg">

                                            <span class="input-group-addon" id="basic-addon2"><i class="fa fa-fw fa-lg fa-bed"></i></span>

                                            <select class="form-control" tabindex="8" aria-describedby="basic-addon2"
                                                    name="reservaQuarto" id="reservaQuarto" required="true">
                                                <c:forEach items="${listaQuartos}" var="quarto" varStatus="stat">
                                                    <option value="<c:out value="${quarto.id}" />">
                                                        Quarto <c:out value="${quarto.numero}" />
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <br/>  
                                        <div class="input-group input-group-lg">
                                            <span class="input-group-addon" id="basic-addon2"><i class="fa fa-fw fa-lg fa-bed"></i></span>

                                            <select class="form-control" tabindex="8" aria-describedby="basic-addon2"
                                                    name="reservaQuarto" id="reservaQuarto" required="true">
                                                <option value="casal" />
                                                1 Cama de Casal
                                                </option>
                                                <option value="solteiro" />
                                                2 Camas Solteiro
                                                </option>
                                            </select>

                                        </div>
                                        <div class="input-group input-group-lg"> 
                                            <label for="numAcompanhante">
                                                Acompanhantes:
                                            </label>
                                            <div class="input-group input-group-lg">
                                                <input type="number" class="form-control" min="0"
                                                       tabindex="7" aria-describedby="basic-addon1"
                                                       name="numAcompanhante" 
                                                       id="numAcompanhante" />

                                            </div>
                                            <label for="numAcompanhante">
                                                Crianças:
                                            </label>
                                            <div class="input-group input-group-lg">
                                                <input type="number" class="form-control" max="2" min="0"
                                                       tabindex="7" aria-describedby="basic-addon1"
                                                       name="numAcompanhante" id="numAcompanhante" 
                                                       placeholder="2"/>

                                            </div>
                                        </div>
                                        
                                        <label>
                                                Valor total: 
                                            </label>

                                    </h4>
                                </div>

                            </div>

                            <div class="col-md-5">

                                <c:if test="${!lista.isEmpty()}">

                                    <c:forEach items="${lista}" var="pessoa" varStatus="stat">

                                        <input type="hidden"
                                               name="reservaHospedeID"
                                               value="<c:out value="${pessoa.id}" />" />

                                        <h4>
                                            Hospede:
                                        </h4>

                                        <h4>
                                            <small>
                                                ID <c:out value="${pessoa.id}" />
                                            </small>
                                        </h4>

                                        <h4>
                                            <small>
                                                <c:out value="${pessoa.nome}" />
                                                <c:out value="${pessoa.sobrenome}" />                        
                                            </small>
                                        </h4>

                                        <h4>
                                            <small>
                                                <c:out value="${pessoa.cpf}" />                    
                                            </small>
                                        </h4>

                                        <h4>
                                            <small>
                                                <c:out value="${pessoa.email}" />                    
                                            </small>
                                        </h4>

                                    </c:forEach>

                                </c:if>

                            </div>

                        </div>

                        <br style="clear: both;" />

                        <div class="row">

                            <div class="col-md-3"></div>

                            <div class="col-md-3 col-xs-6">

                                <a class="btn btn-lg btn-block btn-primary"
                                   href="<c:url value="/erp/reservas/nova" />"
                                   >
                                    <i class="fa fa-fw fa-lg fa-arrow-left"></i>
                                    VOLTAR
                                </a>

                            </div>

                            <div class="col-md-3 col-xs-6">

                                <button class="btn btn-lg btn-block btn-default"
                                        type="submit" tabindex="9">
                                    RESERVAR
                                    <i class="fa fa-fw fa-lg fa-check"></i>
                                </button>

                            </div>

                        </div>

                    </div>          

                </form>

            </div>


            <div role="tabpanel" class="tab-pane fade" id="stepTree">

                <div class="steps-container">

                    <div class="row">

                        <div class="col-sm-3"></div>

                        <div class="col-sm-6 text-center">

                            <h4>
                                <label for="exibirReservaHospede">
                                    Hospede
                                </label>
                                <br />
                                <small id="exibirReservaHospede"></small>
                            </h4>

                            <h4>
                                <label for="exibirReservaData">
                                    Data da Reserva
                                </label>
                                <br />
                                <small id="exibirReservaData"></small>
                            </h4>

                            <h4>
                                <label for="exibirReservaQuarto">
                                    Quarto
                                </label>
                                <br />
                                <small id="exibirReservaQuarto"></small>
                            </h4>

                        </div>

                    </div>

                    <br style="clear: both;" />

                </div>

            </div>

        </div>

        <br style="clear: both;" />
        <br style="clear: both;" />

    </jsp:body>

</t:defaultTemplate>