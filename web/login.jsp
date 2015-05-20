<%-- 
    Document   : index
    Created on : 19/03/2015, 21:18:15
    Author     : udimberto.sjunior
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:lockTemplate>

  <jsp:attribute name="paginaTitulo">
    Login
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final -->
  </jsp:attribute>

  <jsp:body>

    <div class="lock-panel">

      <div class="lock-panel-header">
        <strong>DiBRe Inn</strong>
        <small>Acesso</small>
      </div>

      <div class="lock-panel-body">

        <form class="form-horizontal">
          <div class="form-group">
            <label class="col-sm-2 control-label"
                   for="loginEmail">
              <small>
                E-mail:
              </small>
            </label>
            <div class="col-sm-10">
              <input class="form-control input-sm" 
                     type="email" id="loginEmail"
                     placeholder="exemplo@lebrehotel.com.br"
                     required="true" />
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label"
                   for="loginSenha">
              <small>
                Senha:
              </small>
            </label>
            <div class="col-sm-10">
              <input class="form-control input-sm" 
                     type="password" id="loginSenha"
                     required="true" />
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-6 pull-right">
              <!-- 
              Precisa criar o controle de acesso para habilitar esse botão
              <button class="btn btn-block btn-sm btn-default" 
                     type="submit" id="loginSubmit">
                Entrar
                <i class="fa fa-sign-in"></i>
              </button>
              -->
              <button class="btn btn-block btn-sm btn-default" 
                      type="button" id="loginSubmit" onclick="location.href='erp/inicio'">
                Entrar
                <i class="fa fa-sign-in"></i>
              </button>
            </div>
            <div class="col-sm-6">
              <button class="btn btn-block btn-sm btn-primary" 
                     type="button" id="loginForgot">
                Esqueci a senha
              </button>
            </div>
          </div>
        </form>

      </div>

    </div>

  </jsp:body>

</t:lockTemplate>