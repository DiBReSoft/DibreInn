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
    <style type="text/css">
      .input-group-addon .fa-lg {
        padding-bottom: 1px;
      }
      label[for] {
        cursor: pointer;
      }
      .nav-steps {
        display: block;
        padding-left: 0;
        list-style-type: none;
        margin: 15px -2.5px 0px -2.5px;

      }
      .nav-steps li {
        display: inline-block;
        border: 1px solid #eee;
        border-bottom: none;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
        padding: 10px 15px;
        margin: 0px 2.5px;
        font-size: 18px;
        width: 32%;
      }
      .nav-steps li.active {
        font-weight: bold;
        border-bottom: 1px solid #fff;
        margin-bottom: -1px;
        color: #009688;
      }
      .steps-container {
        padding: 30px 15px;
        border: 1px solid #eee;
      }
      .steps-container h4 {
        margin-top: 10px !important;
      }
    </style>
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui.min.js" />"></script>
    <script type="text/javascript">
      // a variável dataParametro está recebendo o valor da URL, passando pelo Servlet      
      var dataParametro = "<c:out value="${dataParaReserva}" />";
      document.getElementById("reservaData").value = dataParametro;
      $(function () {
        $("#reservaData").datepicker({
          dateFormat: 'dd/mm/yy',
          dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo'],
          dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D'],
          dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb', 'Dom'],
          monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
          monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez']
        });

        $("[data-target=#stepOne]").click(function () {
          $("#stepOneTab").removeClass("disabled");
          $("#stepOneTab").addClass("active");

          $("#stepTwoTab").removeClass("active");
          $("#stepTwoTab").addClass("disabled");

          $("#stepTreeTab").removeClass("active");
          $("#stepTreeTab").addClass("disabled");
        });

        $("[data-target=#stepTwo]").click(function () {
          $("#stepOneTab").removeClass("active");
          $("#stepOneTab").addClass("disabled");

          $("#stepTwoTab").removeClass("disabled");
          $("#stepTwoTab").addClass("active");

          $("#stepTreeTab").removeClass("active");
          $("#stepTreeTab").addClass("disabled");
        });

        $("[data-target=#stepTree]").click(function () {
          $("#stepOneTab").removeClass("active");
          $("#stepOneTab").addClass("disabled");

          $("#stepTwoTab").removeClass("active");
          $("#stepTwoTab").addClass("disabled");

          $("#stepTreeTab").removeClass("disabled");
          $("#stepTreeTab").addClass("active");
        });

      });

      var reservaData = document.getElementById("reservaData");
      reservaData.addEventListener("blur", carregarInfos(reservaData, "ReservaData"));

      var reservaQuarto = document.getElementById("reservaQuarto");
      reservaQuarto.addEventListener("blur", carregarInfos(reservaQuarto, "ReservaQuarto"));

      var reservaHospede = document.getElementById("reservaHospede");
      reservaHospede.addEventListener("blur", carregarInfos(reservaHospede, "ReservaHospede"));

      function carregarInfos(input, string) {
        var selecionarRecipiente = document.getElementById("exibir" + string);
        console.log("exibir" + string);
        selecionarRecipiente.textContent = "" + input.value;
      }

      function recarregarPagina() {
        console.log("Data na URL: " + dataParametro);
        console.log("Data no calendário: " + reservaData.value);
        /*
         var dataReserva = "" +  reservaData.value;
         dataReserva = dataReserva.replace("%2F", "-");
         $.get('/DibreInn/erp/reservas/nova', {data: dataReserva}, function (responseText) {
         $('#welcometext').text(responseText);
         });
         */
      }

    </script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Nova Reserva
    </h1>

    <div class="row">

      <div class="col-sm-2 hidden-xs"></div>

      <div class="col-sm-8">

        <ul class="nav-steps">
          <li role="presentation" 
              class="active"
              id="stepOneTab">
            #1 DETALHES
          </li>
          <li role="presentation"
              class="disabled"
              id="stepTwoTab">
            #2 HOSPEDE
          </li>
          <li role="presentation"
              class="disabled"
              id="stepTreeTab">
            #3 CONFIRMAÇÃO
          </li>
        </ul>

        <form role="form" class="form-di"
              action="reservar" method="post">

          <div class="tab-content">          

            <div role="tabpanel" class="tab-pane fade in active" id="stepOne">

              <div class="steps-container">

                <div class="row">

                  <div class="col-sm-3"></div>

                  <div class="col-sm-6">

                    <div class="form-group">
                      <h4>
                        <label for="reservaData">
                          Data:
                        </label>
                        <div class="input-group input-group-lg">

                          <span class="input-group-addon" id="basic-addon1">
                            <i class="fa fa-fw fa-lg fa-calendar"></i>
                          </span>

                          <input type="text" class="form-control" placeholder="dd/mm/aaaa"
                                 tabindex="1" aria-describedby="basic-addon1"
                                 name="reservaData" id="reservaData" 
                                 onchange="recarregarPagina()"/>

                        </div>
                      </h4>
                    </div>

                  </div>

                </div>

                <div class="row">

                  <div class="col-sm-3"></div>

                  <div class="col-sm-6">

                    <div class="form-group">  
                      <h4>
                        <label for="reservaQuarto">
                          Quarto:
                        </label>
                        <div class="input-group input-group-lg">

                          <span class="input-group-addon" id="basic-addon2"><i class="fa fa-fw fa-lg fa-bed"></i></span>

                          <select class="form-control" tabindex="2" aria-describedby="basic-addon2"
                                  name="reservaQuarto" id="reservaQuarto">
                            <option disabled="true">
                              selecione um quarto
                            </option>
                            <c:forEach items="${lista}" var="quarto" varStatus="stat">
                              <option>
                                Quarto <c:out value="${quarto.numero}" />
                              </option>
                            </c:forEach>
                          </select>              

                        </div>
                      </h4>
                    </div>

                  </div>

                </div>

                <br style="clear: both;" />

                <div class="row">

                  <div class="col-md-4"></div>

                  <div class="col-md-4">

                    <a class="btn btn-lg btn-block btn-default"
                       data-toggle="tab" 
                       data-target="#stepTwo"
                       href="#stepTwo">
                      AVANÇAR
                      <i class="fa fa-fw fa-lg fa-arrow-right"></i>
                    </a>

                  </div>

                </div>

              </div>


            </div>

            <div role="tabpanel" class="tab-pane fade" id="stepTwo">

              <div class="steps-container">

                <div class="row">

                  <div class="col-sm-3"></div>

                  <div class="col-sm-6">

                    <div class="form-group">
                      <h4>
                        <label for="buscarHospedeNome">
                          Buscar por nome:
                        </label>
                        <div class="input-group input-group-lg">

                          <span class="input-group-addon" id="basic-addon3">
                            <i class="fa fa-fw fa-lg fa-user"></i>
                          </span>

                          <input type="text" class="form-control" placeholder="Ex.: Fulano"
                                 tabindex="3" aria-describedby="basic-addon3"
                                 name="reservaHospede" id="reservaHospede" />

                          <input type="hidden"
                                 name="reservaHospedeId" id="reservaHospedeId" />

                        </div>
                      </h4>
                    </div>

                  </div>

                </div>

                <div class="row">

                  <div class="col-sm-3"></div>

                  <div class="col-sm-6">

                    <div class="form-group">  
                      <h4>
                        <label for="buscarHospedeCpf">
                          Buscar por CPF:
                        </label>
                        <div class="input-group input-group-lg">

                          <span class="input-group-addon" id="basic-addon4">
                            <i class="fa fa-fw fa-lg fa-barcode"></i>
                          </span>

                          <input type="text" class="form-control" placeholder="Ex.: 100.200.300-40"
                                 tabindex="4" aria-describedby="basic-addon4"
                                 name="buscarHospedeCpf" id="buscarHospedeCpf" />

                        </div>
                      </h4>
                    </div>

                  </div>

                </div>

                <br style="clear: both;" />

                <div class="row">

                  <div class="col-md-2"></div>

                  <div class="col-md-4 col-xs-6">                  

                    <a class="btn btn-lg btn-block btn-primary"
                       data-toggle="tab" 
                       data-target="#stepOne"
                       href="#stepOne">
                      <i class="fa fa-fw fa-lg fa-arrow-left"></i>
                      VOLTAR
                    </a>

                  </div>

                  <div class="col-md-4 col-xs-6">

                    <a class="btn btn-lg btn-block btn-default"
                       data-toggle="tab" 
                       data-target="#stepTree"
                       href="#stepTree">
                      AVANÇAR
                      <i class="fa fa-fw fa-lg fa-arrow-right"></i>
                    </a>

                  </div>

                </div>

              </div>

            </div>

            <div role="tabpanel" class="tab-pane fade" id="stepTree">

              <div class="steps-container">

                <div class="row">

                  <div class="col-sm-3"></div>

                  <div class="col-sm-6 text-center">

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

                    <h4>
                      <label for="exibirReservaHospede">
                        Hospede
                      </label>
                      <br />
                      <small id="exibirReservaHospede"></small>
                    </h4>

                  </div>

                </div>

                <br style="clear: both;" />

                <div class="row">

                  <div class="col-md-2"></div>

                  <div class="col-md-4 col-xs-6">                  

                    <a class="btn btn-lg btn-block btn-primary"
                       data-toggle="tab" 
                       data-target="#stepTwo"
                       href="#stepTwo">
                      <i class="fa fa-fw fa-lg fa-arrow-left"></i>
                      VOLTAR
                    </a>

                  </div>

                  <div class="col-md-4 col-xs-6">

                    <button class="btn btn-lg btn-block btn-default"
                            type="submit">
                      RESERVAR
                      <i class="fa fa-fw fa-lg fa-check"></i>
                    </button>

                  </div>

                </div>

              </div>

            </div>

          </div>

        </form>

      </div>

    </div>

    <br style="clear: both;" />
    <br style="clear: both;" />

  </jsp:body>

</t:defaultTemplate>