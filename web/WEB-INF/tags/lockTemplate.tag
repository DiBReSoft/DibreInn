<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="paginaTitulo" fragment="true" %>
<%@attribute name="paginaHead" fragment="true" %>
<%@attribute name="paginaBottom" fragment="true" %>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
    <meta name="author" content="Luciano Lourenço, Thiago Medeiros, Fabio Ernani, Udimberto Junior" />

    <link rel="shortcut icon" href="<c:url value="/assets/img/favicon.ico" />" type="image/x-icon" />

    <title>
      <jsp:invoke fragment="paginaTitulo"/>
      - Lebre Hotel | D.I.
    </title>

    <!-- CSS Base -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/style.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/style-responsive.css" />" />

    <!-- CSS Especial para este tipo de pagina -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/lockscreen.css" />" />

    <!-- CSS Externo: icones -->
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" />

    <jsp:invoke fragment="paginaHead"/>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- JS Especial para o relogio exibido neste tipo de pagina -->
    <script type="text/javascript">
      function getTime() {
        var today = new Date();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();

        m = checkTime(m);
        s = checkTime(s);
        document.getElementById('showtime').innerHTML = h + ":" + m;
        t = setTimeout(function () {
          getTime()
        }, 500);
      }

      function checkTime(i) {
        if (i < 10) {
          i = "0" + i;
        }
        return i;
      }
    </script>

  </head>
  <body onload="getTime()">

    <section>

      <jsp:doBody/>

    </section>

    <br style="clear: both;" />

    <footer>

      <div class="container-fluid">

        <div class="row">

          <div class="col-sm-6 creditos">
            <span id="mostrarAno"></span> 
            <i class="fa fa-fw fa-lg fa-copyright"></i>
            <br class="visible-xs-inline-block" />
            Desenvolvido pela DiBRe Soft
          </div>
          <div class="col-sm-6 creditos">
            Imagens disponibilizadas 
            <br class="visible-xs-inline-block" />
            por
            <i class="fa fa-fw fa-lg fa-camera"></i>
            <a href="http://unsplash.com"
               title="Free High-Resolution Photos"
               target="_blank">
              Unsplash
            </a>
          </div>

        </div>

      </div>

    </footer>

    <!-- JS Base -->
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-2.1.3.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.backstretch.min.js" />"></script>

    <!-- JS Especial para este tipo de pagina -->
    <script type="text/javascript" src="<c:url value="/assets/js/lockscreen.js" />"></script>
    <script type="text/javascript">
    $.backstretch([
      "<c:url value="/assets/img/login-bg-2.jpg" />",
      "<c:url value="/assets/img/login-bg-1.jpg" />",
      "<c:url value="/assets/img/login-bg-3.jpg" />",
      "<c:url value="/assets/img/login-bg-4.jpg" />"
    ], {duration: 3000, fade: 250, speed: 2000});
    </script>

    <script type="text/javascript">
      var today = new Date();
      var y = today.getFullYear();
      document.getElementById('mostrarAno').innerHTML = y;
    </script>

    <jsp:invoke fragment="paginaBottom"/>

  </body>
</html>