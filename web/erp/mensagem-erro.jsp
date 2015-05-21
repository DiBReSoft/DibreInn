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
    Erro na Operação
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Erro na operação
    </h1>
    
    <h2>
      <c:out value="${mensagem}" />
    </h2>
    
    <h1 class="text-center">
      <i class="fa fa-fw fa-5x fa-crash"></i>
    </h1>

  </jsp:body>

</t:defaultTemplate>