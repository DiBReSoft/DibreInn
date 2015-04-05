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
    Cliente: Cadastrar
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    
  </jsp:attribute>

  <jsp:body>

    <h1>
      <i class="fa fa-angle-right"></i> 
      Cadastrar Cliente
    </h1>
    <!-- page start-->
    <div class="row mt">

      <div class="form-panel">

        <div class="row">
          <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form">
              <h2>Dados Cadastrais</h2>
              <hr class="colorgraph">
              <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                  <div class="form-group">
                    <input type="text" name="first_name" id="first_name" class="form-control input-lg" 
                           placeholder="Nome" tabindex="1">
                  </div>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6">
                  <div class="form-group">
                    <input type="text" name="last_name" id="last_name" class="form-control input-lg" 
                           placeholder="Sobrenome" tabindex="2">
                  </div>
                </div>
              </div>
              <div class="form-group">
                <input type="text" name="display_name" id="display_name" class="form-control input-lg" 
                       placeholder="Apelido" tabindex="3">
              </div>
              <div class="form-group">
                <input type="email" name="email" id="email" class="form-control input-lg" 
                       placeholder="Endereço" tabindex="4">
              </div>

              <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                  <div class="form-group">
                    <input type="password" name="password" id="password" 
                           class="form-control input-lg" 
                           placeholder="Número" tabindex="5">
                  </div>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6">
                  <div class="form-group">
                    <input type="password" name="password_confirmation" id="password_confirmation" 
                           class="form-control input-lg" placeholder="Complemento" tabindex="6">
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                  <div class="form-group">
                    <input type="password" name="password" id="password" 
                           class="form-control input-lg" 
                           placeholder="Cidade" tabindex="5">
                  </div>
                </div>
                <div class="col-xs-3 col-sm-3 col-md-3">
                  <div class="form-group">
                    <input type="password" name="password_confirmation" id="password_confirmation" 
                           class="form-control input-lg" placeholder="Estado" tabindex="6">
                  </div>
                </div>
                <div class="col-xs-3 col-sm-3 col-md-3">
                  <div class="form-group">
                    <input type="password" name="password_confirmation" id="password_confirmation" 
                           class="form-control input-lg" placeholder="País" tabindex="6">
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-6 text-center">
                  <h4>Recebe visitas</h4>
                </div>
                <div class="col-sm-6 text-center">
                  <div style="padding: 2px 0px;"></div>
                  <div class="switch switch-square has-switch" data-on-label="<i class=' fa fa-check'></i>" data-off-label="<i class='fa fa-times'></i>">
                    <div class="switch-on switch-animate"><input type="checkbox" checked=""><span class="switch-left"><i class=" fa fa-check"></i></span><label>&nbsp;</label><span class="switch-right"><i class="fa fa-times"></i></span></div>
                  </div>
                </div>
              </div>
              <hr class="colorgraph">
              <div class="row">
                <div class="col-xs-6 col-md-6">
                  <input type="submit" value="Cancelar" 
                         class="btn btn-block btn-lg btn-primary" tabindex="7"></div>
                <div class="col-xs-6 col-md-6">
                  <a href="#" class="btn btn-block btn-lg btn-default">
                    Prosseguir
                  </a>
                </div>
              </div>                    
            </form>
          </div>
        </div>

        <div style="padding: 15px 0px;"></div>

      </div>

    </div>

  </jsp:body>

</t:defaultTemplate>