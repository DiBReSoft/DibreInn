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
    <script type="text/javascript">
      $(document).ready(function () {
      ${exibirMsgErro}
      });
    </script>

    <!-- Modal -->
    <div class="modal fade" id="informarErroModal" tabindex="-1" role="dialog" aria-labelledby="informarErroModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
            <h1 class="modal-title" id="informarErroModalLabel">
              ${erroTitulo}
            </h1>
          </div>
          <div class="modal-body">
            <h3>
              <c:out value="${erroMsg}" />
            </h3>
            <div style="padding: 10px 0px;"></div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-lg btn-default" data-dismiss="modal">
              Fechar
            </button>
          </div>
        </div>
      </div>
    </div>
  </jsp:attribute>

  <jsp:body>

    <div class="container-fluid">

      <div class="row">
        
        <div class="col-sm-6 hidden-xs"></div>

        <div class="col-sm-6">

          <div class="logo-lebrehotel text-center">

            <img src="<c:url value="/assets/img/logo-lebre.svg" />"
                 alt="Lebre Hotel"
                 class="center-block"/>

            <h3>
              Lebre Hotel
            </h3>

          </div>

        </div>

      </div>

      <div class="row">

        <div class="col-sm-6 col-sm-push-6">

          <div class="lock-panel center-block">

            <div class="lock-panel-header">
              <strong>
                DiBRe 
                <span class="text-success">Inn</span>
              </strong>
              <small>Acesso</small>
            </div>

            <div class="lock-panel-body">

              <form class="form-horizontal"
                    role="form" method="post"
                    action="login"
                    accept-charset="UTF-8"
                    enctype="application/x-www-form-urlencoded">
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
                           required="true" 
                           name="loginEmail" />
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
                           required="true"
                           name="loginSenha"
                           placeholder="****************************" />
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-xs-6 col-xs-push-6">

                    <button class="btn btn-block btn-sm btn-default" 
                            type="submit" id="loginSubmit" data-loading-text="Loading...">
                      Entrar
                      <i class="fa fa-sign-in"></i>
                    </button>
                  </div>
                  <div class="col-xs-6 col-xs-pull-6">
                    <button class="btn btn-block btn-sm btn-link" 
                            type="button" id="loginForgot"
                            onclick="window.location.href = 'recuperar-senha'">
                      <i class="fa fa-lock"></i>
                      Esqueci a senha
                    </button>
                  </div>
                </div>
              </form>

            </div>

          </div>

        </div>

        <div class="col-sm-6 col-sm-pull-6">

          <span id="showtime"></span>

        </div>

      </div>

    </div>

  </jsp:body>

</t:lockTemplate>