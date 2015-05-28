<%-- 
    Document   : index
    Created on : 19/03/2015, 21:18:15
    Author     : udimberto.sjunior
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Início
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final -->
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Página Inicial
    </h1>

    <h3>
      Novidades sobre o
      <strong>Lebre Hotel</strong>
    </h3>

    <hr />

    <div class="row">

      <div class="col-sm-4 mb">

        <div class="weather pn">
          <i class="fa fa-cloud fa-4x"></i>
          <h2>17º C</h2>
          <h4>SÃO PAULO</h4>
        </div>

      </div>

      <div class="col-sm-4 mb">
        <div class="twitter-panel pn">
          <i class="fa fa-twitter fa-4x"></i>
          <p>Dashgum is here! Take a look and enjoy this new Bootstrap Dashboard theme.</p>
          <p class="user">@Alvrz_is</p>
        </div>
      </div>

      <div class="col-lg-4 col-md-4 col-sm-4 mb">
        <div class="steps pn">
          <input id="op1" name="op1" type="checkbox" checked="">
          <label for="op1">Update Profile</label>
          <input id="op2" name="op2" type="checkbox">
          <label for="op2">Contact Paul</label>
          <input id="op3" name="op3" type="checkbox">
          <label for="op3">Enjoy Life</label>
          <input type="submit" value="All Done!" id="submit">
        </div>
      </div>

      <div class="col-md-4 col-sm-4 mb">
        <div class="stock card">
          <div class="stock-chart">
            <div id="chart"></div>
          </div>
          <div class="stock current-price">
            <div class="row">
              <div class="info col-sm-6 col-xs-6"><abbr>AAPL</abbr>
                <time>Yesterday</time>
              </div>
              <div class="changes col-sm-6 col-xs-6">
                <div class="value up"><i class="fa fa-caret-up hidden-sm hidden-xs"></i> 694.00</div>
                <div class="change hidden-sm hidden-xs">+4.95 (3.49%)</div>
              </div>
            </div>
          </div>
          <div class="summary">
            <strong>18.3 M</strong> <span>SHARES TRADED</span>
          </div>
        </div>
      </div>

    </div>

  </jsp:body>

</t:defaultTemplate>