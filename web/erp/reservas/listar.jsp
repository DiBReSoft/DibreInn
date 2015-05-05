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
    Reserva: Ldistar
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap-fullcalendar.css" />" />
    <style type="text/css">
      .input-group-addon .fa-lg {
        padding-bottom: 1px;
      }
      label[for] {
        cursor: pointer;
      }
    </style>
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-ui-1.9.2.custom.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar-moment.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/fullcalendar-lang-all.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/calendar-conf-events.js" />"></script>
    <script type="text/javascript">
      // a variável dataParametro está recebendo o valor da URL, passando pelo Servlet
      var dataParametro = new Date("${dataParaListar}");
      var mes = dataDecimal(dataParametro.getMonth() + 1);
      var dia = dataDecimal(dataParametro.getDate());

      // para caso não haja parâmetro na URL, a data para reserva será a presente
      var dataHoje = new Date();
      var mesHoje = dataDecimal(dataHoje.getMonth() + 1);
      var diaHoje = dataDecimal(dataHoje.getDate());
      var dataFormato1 = dataParametro.getFullYear() + "-" + mes + "-" + dia;
      var dataFormato2 = diaHoje + "/" + mesHoje + "/" + dataHoje.getFullYear();
      var dataFormato3 = dia + "/" + mes + "/" + dataParametro.getFullYear();

      // variáveis que detectam o browser
      var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
      var isFirefox = typeof InstallTrigger !== 'undefined';
      var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
      var isChrome = !!window.chrome && !isOpera;
      var isIE = false || !!document.documentMode;

      if (isChrome) {
        // se o browser for Chrome, insira este formato de data: AAAA-MM-DD
        document.getElementById("reservaData").value = dataFormato1;
        console.log("Browser Chrome.\nData inserida no formulário: " + dataFormato1);
      } else {
        // se não for o Chrome, verifique se a data é inválida
        if (document.getElementById("reservaData").value === "NaN/NaN/NaN") {
          // caso a data seja inválida, insira a data atual
          document.getElementById("reservaData").value = dataFormato2;
          console.log("Browser diferente do Chrome.\nData inserida no formulário: " + dataFormato2);
        } else {
          // caso a data seja válida, insira ela no campo de data do formulário de reserva
          document.getElementById("reservaData").value = dataFormato3;
          console.log("Browser diferente do Chrome.\nData inserida no formulário: " + dataFormato3);
        }
      }

      // esta função adiciona o caracter "0" ao número que for menor que 10
      function dataDecimal(dt) {
        if (dt < 10 && dt > 0) {
          dt = "0" + dt;
        }
        return dt;
      }
    </script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Reserva: Listar
    </h1>
    
    

  </jsp:body>

</t:defaultTemplate>