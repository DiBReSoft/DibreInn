<%-- 
    Document   : estadias-canceladas
    Created on : 03/06/2015, 12:58:35
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Relatório de Estadias Canceladas
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
    <link type="text/css" rel="stylesheet" href="//cdn.oesmith.co.uk/morris-0.4.3.min.css" />
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="//cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
    <script type="text/javascript">
      Morris.Bar({
        element: 'hero-bar',
        data: [
      ${estadiasCanceladasPorUnidades}
        ],
        xkey: 'unidade',
        ykeys: ['vendas'],
        labels: ['Total de vendas'],
        barRatio: 0.2,
        xLabelAngle: 15,
        hideHover: 'auto',
        barColors: ['#FF3300']
      });

      Morris.Donut({
        element: 'hero-donut',
        data: [
          ${estadiasCanceladasGeral}
        ],
        colors: ['#FF5050', '#FF3300', '#CC0000'],
        formatter: function (y) {
          return y;
        }
      });
    </script>
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Relatórios de Estadias Canceladas
    </h1>

    <div class="row">

      <div class="col-md-6">

        <div class="content-panel">
          <h4>
            <i class="fa fa-angle-right"></i> 
            Canceladas por Unidade
          </h4>
          <div class="panel-body">
            <div id="hero-bar" class="graph"></div>
          </div>
        </div>

      </div>

      <div class="col-md-6">

        <div class="content-panel">
          <h4>
            <i class="fa fa-angle-right"></i> 
            Canceladas em Todas as Unidades
          </h4>
          <div class="panel-body">
            <div id="hero-donut" class="graph"></div>
          </div>
        </div>

      </div>

    </div>

  </jsp:body>

</t:defaultTemplate>