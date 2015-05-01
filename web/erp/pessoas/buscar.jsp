<%-- 
    Document   : buscar
    Created on : 01/05/2015, 10:21:49
    Author     : Thi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:defaultTemplate>

    <jsp:attribute name="paginaTitulo">
        Pessoa: Cadastrar
    </jsp:attribute>

    <jsp:attribute name="paginaHead">
        <!-- CSS e outros que vão no <head> da página -->
    </jsp:attribute>

    <jsp:attribute name="paginaBottom">
        <!-- JavaScript e outros que vão ao final da página -->
        <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-switch.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/form-component.js" />"></script>

    </jsp:attribute>

    <jsp:body>

        <h1 class="page-title">
          Consultar Pessoas
        </h1>
        
        <!-- page start-->
        <div class="mt">

          <!-- Início do Formulário -->
          <form role="form" method="post" class="form-di"
                action="consulta" name="formConsulta">

            <!-- Início da #1 linha de GRID do formulário -->
            <div class="row">

              <!-- Início da primeira coluna: lado esquerdo - dados de busca -->
              <div class="col-sm-6">

                <h4>
                  BUSQUE POR:
                </h4>

                <hr />

                <div class="row">

                  <div class="col-xs-6">

                    <div class="form-group">
                      <label for="formNome">
                        Nome:
                      </label>
                      <input type="text" class="form-control"
                             tabindex="1"
                             name="formNome" id="formNome" 
                             placeholder="Fulano"/>
                    </div>

                  </div>

                  <div class="col-sm-4">

                    <div class="form-group">                    
                      <label for="formCpf">
                        CPF:
                      </label>
                      <input type="text" class="form-control"
                             tabindex="2"
                             name="formCpf" id="formCpf" 
                             placeholder="CPF" />
                    </div>

                  </div>

                  <div class="col-xs-8">

                    <div class="form-group">
                      <label for="formEmail">
                        E-mail:
                      </label>
                      <input type="email" class="form-control" 
                             tabindex="3"
                             name="formEmail" id="formEmail"
                             placeholder="fulano@dasilva.com.br" />
                    </div>

                  </div>

                  </div>

                </div>

              </div>
              <!-- Fim da primeira coluna: lado esquerdo - dados de busca -->
              
                <div style="padding: 15px 0px;"></div>

            <!-- Linha de botões do formulário -->
            <div class="row">

              <div class="col-sm-3 hidden-xs"></div>

              <div class="col-xs-6 col-sm-3">

                <button type="reset" class="btn btn-block btn-lg btn-primary" 
                        tabindex="5">
                  <i class="fa fa-lg fa-times"></i>
                  Limpar
                </button>

              </div>

              <div class="col-xs-6 col-sm-3">

                <button type="submit" class="btn btn-block btn-lg btn-default" 
                        tabindex="4">
                  Buscar
                  <i class="fa fa-lg fa-edit"></i>
                </button>

              </div>

            </div>   
            <!-- Linha de botões do formulário -->
            <br>
            <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
              <span class="sr-only">45% Complete</span>
            </div>
          </div>
            
              <!-- Início da segunda coluna: lado direito - Tabela Consulta -->
              <div class="col-sm-12">

                <h4>
                  Vizualizar Consulta
                </h4>

                <hr />

                <div class="row">

                  <div class="col-sm-12">

                    <div class="form-group">
                     <div class="panel panel-default">
                    <!-- Default panel contents -->
                        <div class="panel-heading">Pessoas Cadastradas</div>
                        
                        <ul class="nav navbar-nav navbar-left">
                        <li class="dropdown">
                          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">filtrar<span class="caret"></span></a>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Hospede</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Funcionario</a></li>
                          </ul>
                        </li>
                      </ul>
                        <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">ordenar<span class="caret"></span></a>
                                  <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Crescente</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Decrescente</a></li>
                                  </ul>
                                </li>
                              </ul>
                        <!-- Table -->
                          <table class="table table-responsive table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Email</th>
            <th>Tipo</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td class ="nome">Thiago</td>
            <td class ="cpf">999.999.999-99</td>
            <td class ="email">thiago@novatela.com.br</td>
            <td class ="tipoPessoa">Funcionario</td>
            <td class="seleciona"><a class="selecionado">Selecionar</a></td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td class ="nome">Udiberto</td>
            <td class ="cpf">999.999.999-99</td>
            <td class ="email">jr@bol.com.br</td>
            <td class ="tipoPessoa">Hospede</td>
            <td class="seleciona"><a class="selecionado">Selecionar</a></td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td class ="nome">Mark</td>
            <td class ="cpf">999.999.999-99</td>
            <td class ="email">mark@hotmail.com.br</td>
            <td class ="tipoPessoa">Funcionario</td>
            <td class="seleciona"><a class="selecionado">Selecionar</a></td>
          </tr>
        </tbody>
     
                        </table>
                      </div>
                    </div>

                  </div>

                  </div>

                </div>

              <!-- Fim da segunda coluna: lado direito - Tabela Consulta -->
 </form>
          <!-- Fim do Formulário -->
            <div style="padding: 15px 0px;"></div>
            </div>

         
    </jsp:body>

</t:defaultTemplate>