<%-- 
    Document   : nova
    Created on : 03/05/2015, 10:30:15
    Author     : udimberto.sjunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.maskedinput.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/validacoes.js" />"></script>
    <script type="text/javascript">
      $(window).load(function () {
        var stepTwo = $("[data-target=#stepTwo]");
        var stepTree = $("[data-target=#stepTree]");
        ${selecionouHospede}
            
        /*
        var minMilli = 1000 * 60;
        var hrMilli = minMilli * 60;
        var dyMilli = hrMilli * 24;

        var dataCheckIn = new Date("" + $("#reservaCheckIn").val() + "");
        var dataCheckOut = new Date("" + $("#reservaCheckOut").val() + "");

        var ms = Date.parse(dataCheckIn);
        var ms2 = Date.parse(dataCheckOut);
        var days = Math.round(ms / dataCheckOut);
        days = days + 1;

        var valorDiaria = $("#valorDiariaQuarto2").text();
        var valorEstadia = valorDiaria * days;

        var campoValorDiaria = $("#reservaValor");
        campoValorDiaria.val("" + valorEstadia);
        */
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
        #2 ESTADIA
      </li>
      <li role="presentation"
          class="${ativarTab3}"
          id="stepTreeTab">
        #3 CONFIRMAR
      </li>
    </ul>

    <div class="tab-content">


      <a class="hidden" data-toggle="tab" data-target="#stepTwo"></a>
      <a class="hidden" data-toggle="tab" data-target="#stepTree"></a>


      <div role="tabpanel" class="tab-pane fade in active" id="stepOne">

        <div class="steps-container">

          <!-- Início da #1 linha de GRID dos formulários -->
          <div class="row">

            <div class="col-sm-4">

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

                    <button type="submit" id="btnBuscarNome" class="btn btn-default" 
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

            </div>

            <div class="col-sm-4">

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

            </div>

            <div class="col-sm-4">

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

              <div style="padding: 5px 0px;"></div>

            </div>            

          </div>

          <div style="padding: 15px 0px;"></div>

          <div class="form-di ${visibilidadeResultados}">

            <h4>
              Resultado(s) da busca
            </h4>

            <c:if test="${!listaHospedes.isEmpty()}">

              <table class="table table-responsive table-hover table-striped table-condensed">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>E-mail</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${listaHospedes}" var="hospede" varStatus="stat">
                    <tr>
                      <td scope="row">
                        <c:out value="${hospede.id}" />
                      </td>
                      <td>
                        <c:out value="${hospede.nome}" />
                        <c:out value="${hospede.sobrenome}" />
                      </td>
                      <td>
                        <c:out value="${hospede.cpf}" />
                      </td>
                      <td>
                        <c:out value="${hospede.email}" />
                      </td>
                      <td>
                        <a href="<c:url value="/erp/reservas/nova?hospedeID=${hospede.id}" />" 
                           class="btn btn-sm btn-default">
                          <i class="fa fa-fw fa-lg fa-check"></i>
                          Selecionar
                        </a>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>

            </c:if>

            <c:if test="${listaHospedes.isEmpty()}">

              <div class="col-sm-2"></div>

              <div class="col-sm-8">

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
                    Não podemos encontrar hospedes com 
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

        <form role="form" class="form-di" method="get"
              accept-charset="UTF-8"
              enctype="application/x-www-form-urlencoded"
              action="nova">

          <input type="hidden" name="hospede" value="${idHospede}" />

          <div class="steps-container">

            <div class="row">

              <div class="col-sm-4"></div>

              <div class="col-sm-4">

                <div class="form-group">

                  <h4>
                    <label for="checkIn">
                      Data de Check-in:
                    </label>
                    <div class="input-group input-group-lg">

                      <span class="input-group-addon" id="addonCheckin">
                        <i class="fa fa-fw fa-lg fa-calendar"></i>
                      </span>

                      <input type="text" class="form-control calendar" placeholder="dd/mm/aaaa"
                             tabindex="1" aria-describedby="addonCheckin"
                             name="in" id="checkIn" 
                             required="true" />

                    </div>
                  </h4>

                </div>

                <div class="form-group">

                  <h4>
                    <label for="checkOut">
                      Data de Check-out:
                    </label>
                    <div class="input-group input-group-lg">

                      <span class="input-group-addon" id="addonCheckout">
                        <i class="fa fa-fw fa-lg fa-calendar"></i>
                      </span>

                      <input type="text" class="form-control calendar" placeholder="dd/mm/aaaa"
                             tabindex="2" aria-describedby="addonCheckout"
                             name="out" id="checkOut" 
                             required="true" />

                    </div>
                  </h4>
                </div>

              </div>

            </div>

            <br style="clear: both;" />

            <div class="row">

              <div class="col-md-3"></div>

              <div class="col-md-3 col-xs-6">

                <a class="btn btn-lg btn-block btn-primary"
                   href="<c:url value="/erp/reservas/nova" />"
                   tabindex="9"
                   >
                  <i class="fa fa-fw fa-lg fa-arrow-left"></i>
                  VOLTAR
                </a>

              </div>

              <div class="col-md-3 col-xs-6">

                <button class="btn btn-lg btn-block btn-default"
                        type="submit" tabindex="8">
                  CONTINUAR
                  <i class="fa fa-fw fa-lg fa-arrow-right"></i>
                </button>

              </div>

            </div>

          </div>          

        </form>

      </div>


      <div role="tabpanel" class="tab-pane fade" id="stepTree">

        <div class="steps-container">

          <form role="form" class="form-di" method="post"
                accept-charset="UTF-8"
                enctype="application/x-www-form-urlencoded"
                action="nova">

            <input type="hidden" name="reservaFuncionarioID"
                   value="${sessionScope.usuario.id}" />

            <input type="hidden" name="reservaHospedeID"
                   value="${hospede}" />

            <div class="row">

              <div class="col-sm-4"></div>

              <div class="col-sm-4">

                <div class="form-group">

                  <h4>

                    <label for="reservaHospedeID">
                      Hospede:
                    </label>
                    <div class="input-group input-group-lg">

                      <span class="input-group-addon" id="addonHospede">
                        <i class="fa fa-fw fa-lg fa-user"></i>
                      </span>

                      <input type="text" class="form-control" 
                             aria-describedby="addonHospede"
                             id="reservaHospedeID" 
                             readonly
                             value="${listarHospedes.get(0).nome} ${listarHospedes.get(0).sobrenome} (ID: ${hospede})"
                             />
                    </div>

                  </h4>

                </div>

                <div class="form-group">

                  <h4>

                    <label for="reservaCheckIn">
                      Data de Check-In:
                    </label>
                    <div class="input-group input-group-lg">

                      <span class="input-group-addon" id="addonCheckIn3">
                        <i class="fa fa-fw fa-lg fa-calendar"></i>
                      </span>

                      <input type="text" class="form-control" 
                             aria-describedby="addonCheckIn3"
                             id="reservaCheckIn" name="reservaCheckIn"
                             readonly
                             value="<fmt:formatDate type="date" 
                                             value="${in}" />"
                             />
                    </div>

                  </h4>

                </div>

                <div class="form-group">

                  <h4>

                    <label for="reservaCheckOut">
                      Data de Check-Out:
                    </label>
                    <div class="input-group input-group-lg">

                      <span class="input-group-addon" id="addonCheckOut3">
                        <i class="fa fa-fw fa-lg fa-calendar"></i>
                      </span>

                      <input type="text" class="form-control" 
                             aria-describedby="addonCheckOut3"
                             id="reservaCheckOut" name="reservaCheckOut"
                             readonly
                             value="<fmt:formatDate type="date" 
                                             value="${out}" />"
                             />
                    </div>

                  </h4>

                </div>

                <div class="form-group">

                  <h4>

                    <label for="reservaQuarto">
                      Quarto:
                    </label>
                    <div class="input-group input-group-lg">

                      <span class="input-group-addon" id="addonQuarto">
                        <i class="fa fa-fw fa-lg fa-bed"></i>
                      </span>

                      <select class="form-control" tabindex="4" aria-describedby="addonQuarto"
                              name="reservaQuarto" id="reservaQuarto" required="true">
                        <c:forEach items="${listaQuartos}" var="quarto" varStatus="stat">
                          <c:if test="${sessionScope.usuario.unidadeId == quarto.idUnidade}">
                            <option value="<c:out value="${quarto.id}" />">
                              <c:out value="${quarto.numero}" />
                              (Diária R$ <c:out value="${quarto.valorDiaria}" />)
                            </option>
                          </c:if>
                        </c:forEach>
                      </select>

                      <c:forEach items="${listaQuartos}" var="quarto" varStatus="stat">
                        <c:if test="${sessionScope.usuario.unidadeId == quarto.idUnidade}">
                          <span class="hidden" id="valorDiariaQuarto${quarto.id}"
                                >${quarto.valorDiaria}</span>
                        </c:if>
                      </c:forEach>

                    </div>

                  </h4>

                </div>

                <div class="form-group">

                  <h4>

                    <label for="reservaValor">
                      Valor Total:
                    </label>
                    <div class="input-group input-group-lg">

                      <span class="input-group-addon" id="addonReservaValor">
                        <i class="fa fa-fw fa-lg fa-usd"></i>
                      </span>

                      <input type="text" class="form-control" 
                             aria-describedby="addonReservaValor"
                             id="reservaValor" name="reservaValor"
                             readonly
                             value=""
                             />

                    </div>

                  </h4>

                </div>

              </div>

            </div>

            <br style="clear: both;" />

            <div class="row">

              <div class="col-md-3"></div>

              <div class="col-md-3 col-xs-6">

                <a class="btn btn-lg btn-block btn-primary"
                   href="<c:url value="/erp/reservas/nova?hospedeID=" />${hospede}"
                   tabindex="9"
                   >
                  <i class="fa fa-fw fa-lg fa-arrow-left"></i>
                  VOLTAR
                </a>

              </div>

              <div class="col-md-3 col-xs-6">

                <button class="btn btn-lg btn-block btn-default"
                        type="submit" tabindex="8">
                  RESERVAR
                  <i class="fa fa-fw fa-lg fa-check"></i>
                </button>

              </div>

            </div>      

          </form>

          <br style="clear: both;" />

        </div>

      </div>

    </div>

    <br style="clear: both;" />
    <br style="clear: both;" />

  </jsp:body>

</t:defaultTemplate>