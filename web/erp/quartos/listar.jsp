<%-- 
    Document   : buscar
    Created on : 25/05/2015, 11:57:25
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

    <jsp:attribute name="paginaTitulo">
        Quartos
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <!-- CSS e outros que vão no <head> da página -->
        <style>
            .form-di label {
                margin-bottom: 0px;
            }
            .table td {
                vertical-align: middle !important;
            }
        </style>
    </jsp:attribute>

    <jsp:attribute name="paginaBottom">
        <!-- JavaScript e outros que vão ao final da página -->
        <script type="text/javascript">
            $(document).load(function () {

            });
        </script>
    </jsp:attribute>

    <jsp:body>

        <h1 class="page-title">
            Quartos
        </h1>
        <div class="row">
            <div class="col-sm-4">


                <form role="form" method="get" enctype="utf-8" class="form-di"
                      action="listar" name="formUnidade">

                    <h4>
                        <label for="unidade">
                            Buscar por Unidade
                        </label>
                    </h4>
                    <hr />

                    <div class="input-group">

                        <select class="form-control" tabindex="18" aria-describedby="basic-addon2"
                                name="unidade" id="formUnidade">
                            <option value="0">
                                
                            </option>
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

                        <span class="input-group-btn">              

                            <button type="submit" class="btn btn-default" 
                                    tabindex="1">

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
            </div>

            <div class="col-sm-4">
                <!-- Formulário #2 | Buscar por e-mail -->
                <form role="form" method="get" enctype="utf-8" class="form-di"
                      action="listar" name="formBuscarEmail">

                    <h4>
                        <label for="email">
                            Buscar por Numero
                        </label>
                    </h4>
                    <hr />

                    <div class="input-group">            

                        <input type="number" class="form-control" 
                               tabindex="2"
                               name="numero" id="formNumero"
                               min="0"
                               value="<c:out value="${numeroQuarto}" />" />

                        <span class="input-group-btn">

                            <button type="submit" class="btn btn-default" 
                                    tabindex="3">

                                <span class="hidden-sm hidden-xs">
                                    Buscar
                                </span>

                                <i class="fa fa-fw fa-lg fa-search"></i>

                            </button>

                        </span>

                    </div>

                </form>
                <!-- Formulário #2 | Buscar por e-mail -->
            </div>
        </div>
        <div class="form-di">
            <h4>
                Listagem de registros
            </h4>
            <hr />

            <c:if test="${!lista.isEmpty()}">
                <table class="table table-responsive table-hover table-condensed">
                    <thead>
                        <tr>
                            <th>
                                <i class="fa fa-fw fa-lg fa-barcode"></i>
                                ID
                            </th>
                            <th>
                                <i class="fa fa-fw fa-lg fa-building"></i>
                                Unidade
                            </th>
                            <th>
                                <i class="fa fa-fw fa-lg fa-building-o"></i>
                                Andar
                            </th>
                            <th>
                                <i class="fa fa-fw fa-lg fa-tag"></i>
                                Número
                            </th>
                            <th>
                                <i class="fa fa-fw fa-lg fa-phone"></i>
                                Ramal
                            </th>
                            <th>
                                <i class="fa fa-fw fa-lg fa-usd"></i>
                                Diária
                            </th>
                            <th>
                                <i class="fa fa-fw fa-lg fa-check"></i>
                                Status
                            </th>
                            <th>
                                <i class="fa fa-fw fa-lg"></i>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaQuartos}" var="quarto" varStatus="stat">
                            <tr>
                                <td scope="row">
                                    <i class="fa fa-fw fa-lg"></i>
                                    ${quarto.id}
                                </td>
                                <td>
                                    <i class="fa fa-fw fa-lg"></i>
                                    <c:forEach items="${listaUnidades}" var="unidade" varStatus="stat">
                                        <c:if test="${quarto.idUnidade == unidade.id}">
                                            <c:out value="${unidade.estado}" />
                                            -
                                            <c:out value="${unidade.nome}" />
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <i class="fa fa-fw fa-lg"></i>
                                    <c:out value="${quarto.andar}" />
                                    º
                                </td>
                                <td>
                                    <i class="fa fa-fw fa-lg"></i>
                                    <c:out value="${quarto.numero}" />
                                </td>
                                <td>
                                    <i class="fa fa-fw fa-lg"></i>
                                    <c:out value="${quarto.ramal}" />
                                </td>
                                <td>
                                    <i class="fa fa-fw fa-lg"></i>
                                    R$
                                    <c:out value="${quarto.valorDiaria}" />
                                </td>
                                <c:if test="${quarto.status == '0'}">
                                    <td class="text-center warning">
                                        Inativo
                                    </td>
                                </c:if>
                                <c:if test="${quarto.status == '1'}">
                                    <td class="text-center success">
                                        Ativo
                                    </td>
                                </c:if>
                                </td>
                                <td class="text-center">
                                    <a class="btn btn-sm btn-default"
                                       title="Edite as propriedades completas deste cômodo"
                                       href="<c:url value="/erp/quartos/editar?id=${quarto.id}" />">
                                        <i class="fa fa-fw fa-lg fa-edit"></i>
                                        Editar Propriedades
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
                            Não pudemos encontrar quartos registrados na unidade.
                        </h3>
                    </div>

                </div>

            </c:if>
        </div>

    </div>

    <div style="padding: 15px 0px;"></div>

</jsp:body>

</t:defaultTemplate>