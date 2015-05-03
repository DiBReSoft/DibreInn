<%-- 
    Document   : perfil
    Created on : 02/05/2015, 23:50:49
    Author     : jSilverize
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

  <jsp:attribute name="paginaTitulo">
    Pessoa: Perfil
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Meu perfil
    </h1>
    
    Nome:
    ${sessionScope.usuario.nome}

    <div style="padding: 15px 0px;"></div>

  </jsp:body>

</t:defaultTemplate>