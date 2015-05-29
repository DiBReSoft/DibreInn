<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="paginaTitulo" fragment="true" %>
<%@attribute name="paginaHead" fragment="true" %>
<%@attribute name="paginaBottom" fragment="true" %>
<!DOCTYPE html>
<html>
  <head>
    
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
    <meta name="author" content="Luciano Lourenço, Thiago Medeiros, Fabio Ernanni, Udimberto Junior" />

    <link rel="shortcut icon" href="<c:url value="/assets/img/favicon.ico" />" type="image/x-icon" />

    <title>
      <jsp:invoke fragment="paginaTitulo"/>
      - Lebre Hotel | D.I.
    </title>

    <!-- CSS Base -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/style.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/style-responsive.css" />" />

    <!-- CSS Externo: icones -->
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" />

    <jsp:invoke fragment="paginaHead"/>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  </head>
  <body>

    <t:defaultNavbar/>    
    <t:defaultSidebar/>

    <section id="main-content">

      <section class="wrapper site-min-height" id="paginaConteudo">

        <jsp:doBody/>

      </section>

      <footer class="site-footer">
        <div class="text-center">
          <span id="mostrarAno"></span> 
          <i class="fa fa-copyright"></i> 
          Desenvolvido pela DiBRe Soft
          <a class="go-top" title="voltar ao topo">
            <i class="fa fa-angle-up"></i>
          </a>
        </div>
      </footer>

    </section>

    <!-- JS Base -->
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-2.1.3.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap.min.js" />"></script>    
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-dcjqaccordion.2.7.js" />" class="include"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.nicescroll.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.scrollTo.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/dibre-inn.js" />"></script>

    <script type="text/javascript">
      var today = new Date();
      var y = today.getFullYear();
      document.getElementById('mostrarAno').innerHTML = y;
      
      $("[type=submit]").on("click", function() {
        $("#paginaConteudo").load("<c:url value="/assets/loading.html" />");
      });
    </script>

    <jsp:invoke fragment="paginaBottom"/>

  </body>
</html>