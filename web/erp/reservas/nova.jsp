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
        padding: 10px 15px;
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
      });
    </script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Nova Reserva
    </h1>

    <ul class="nav-steps">
      <li role="presentation" 
          class="active">
        #1 DETALHES
      </li>
      <li role="presentation"
          class="disabled">
        #2 CLIENTE
      </li>
      <li role="presentation"
          class="disabled">
        #3 CONFIRMAÇÃO
      </li>
    </ul>

    <div class="steps-container">

      <form role="form" class="form-di"
            action="reservar" method="post">

        <div class="row">

          <div class="col-sm-3">

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
                         name="reservaData" id="reservaData" />

                </div>
              </h4>
            </div>

          </div>

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
                    <c:forEach items="${lista}" var="quarto" varStatus="stat">
                      <option>
                        <c:out value="${quarto.numero}" />
                      </option>
                    </c:forEach>
                  </select>              

                </div>
              </h4>
            </div>

          </div>

        </div>

      </form>

    </div>

  </jsp:body>

</t:defaultTemplate>