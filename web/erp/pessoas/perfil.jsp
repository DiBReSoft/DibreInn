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
    <c:choose>
      <c:when test="${pessoa.get(0).id != null}">
        Perfil de
        <c:out value="${pessoa.get(0).nome}" />
        <c:out value="${pessoa.get(0).sobrenome}" />
      </c:when>
      <c:otherwise>
        Meu Perfil
      </c:otherwise>
    </c:choose>
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
    <style>
      .form-di h4 {
        margin-top: 10px;
      }
    </style>
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      <c:choose>
        <c:when test="${pessoa.get(0).id != null}">
          Perfil do
          <c:if test="${pessoa.get(0).tipo eq 'Hospede'}">
            Hospede
          </c:if>
          <c:if test="${pessoa.get(0).tipo eq 'Funcionário'}">
            Funcionário
          </c:if>
        </c:when>
        <c:otherwise>
          Meu Perfil
        </c:otherwise>
      </c:choose>
    </h1>


    <c:choose>
      <c:when test="${pessoa.get(0).id != null}">

        <div class="form-di">

          <h2>                
            <c:out value="${pessoa.get(0).nome}" />
            <c:out value="${pessoa.get(0).sobrenome}" />
          </h2>

          <div class="row">

            <div class="col-sm-6">

              <div class="row">

                <div class="col-sm-4">

                  <h3>
                    Sexo
                    <br />
                    <small>                      
                      <c:choose>
                        <c:when test="${pessoa.get(0).sexo eq 'm'}">
                          Masculino
                        </c:when>
                        <c:otherwise>
                          Feminino
                        </c:otherwise>
                      </c:choose>
                    </small>
                  </h3>

                </div>

                <div class="col-sm-4">

                  <h3>
                    RG
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).rg}" />
                    </small>
                  </h3>

                </div>

                <div class="col-sm-4">

                  <h3>
                    CPF
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).cpf}" />
                    </small>
                  </h3>

                </div>

                <div class="col-sm-4">

                  <h3>
                    Nascimento
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).dataNascimento}" />
                    </small>
                  </h3>

                </div>

                <div class="col-sm-4">

                  <h3>
                    Telefone
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).telefone}" />
                    </small>
                  </h3>

                </div>

                <div class="col-sm-4">

                  <h3>
                    Celular
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).celular}" />
                    </small>
                  </h3>

                </div>

                <div class="col-xs-8">

                  <h3>
                    E-mail
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).email}" />
                    </small>
                  </h3>

                </div>

                <div class="col-xs-4">

                  <h3>
                    Newsletter
                    <br />
                    <small>
                      <c:choose>
                        <c:when test="${pessoa.get(0).newsletter == 1}">
                          <i class="fa fa-fw fa-lg fa-check-square"></i>
                          Recebe
                        </c:when>
                        <c:otherwise>
                          <i class="fa fa-fw fa-lg fa-times"></i>
                          Não recebe
                        </c:otherwise>
                      </c:choose>
                    </small>
                  </h3>

                </div>

              </div>

            </div>

            <div class="col-sm-6">

              <div class="row">

                <div class="col-xs-8">

                  <h3>
                    Logradouro
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.logradouro}" />--%>
                    </small>
                  </h3>

                </div>

                <div class="col-xs-4">

                  <h3>
                    Número
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.numero}" />--%>
                    </small>
                  </h3>

                </div>

                <div class="col-xs-6 col-sm-4">

                  <h3>
                    Complemento
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.Complemento}" />--%>
                    </small>
                  </h3>

                </div>

                <div class="col-xs-6 col-sm-4">

                  <h3>
                    Bairro
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.bairro}" />--%>
                    </small>
                  </h3>

                </div>

                <div class="col-xs-5 col-sm-4">

                  <h3>
                    Cidade
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.cidade:}" />--%>
                    </small>
                  </h3>

                </div>

                <div class="col-xs-3">

                  <h3>
                    Cidade
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.estado}" />--%>
                    </small>
                  </h3>

                </div>

                <div class="col-sm-4">

                  <h3>
                    País
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.pais}" />--%>
                    </small>
                  </h3>

                </div>

              </div>

            </div>

          </div>

          <hr />

          <c:if test="${pessoa.get(0).tipo eq 'Hospede'}">

            <h2>
              Adicionais sobre o Hospede
            </h2>

            <h3>
              Número do Cartão
              <br />
              <small>
                <%--<c:out value="${pessoa.get(0).nCartao}" />--%>
              </small>
            </h3>

            <br />

            <h3>
              Histórico de Reservas
            </h3>

            <table class="table table-condensed table-hover table-responsive">
              <thead>
                <tr>
                  <th>
                    <i class="fa fa-fw fa-calendar"></i>
                    Checkin
                  </th>
                  <th>
                    <i class="fa fa-fw fa-calendar"></i>
                    Checkout
                  </th>
                  <th>
                    <i class="fa fa-fw fa-building"></i>
                    Unidade
                  </th>
                  <th>
                    <i class="fa fa-fw fa-bed"></i>
                    Quarto
                  </th>
                  <th>
                    <i class="fa fa-fw fa-money"></i>
                    Valor
                  </th>
                </tr>
              </thead>
              <tbody>
                <!-- Rodar o loop -->
              </tbody>
            </table>

          </c:if>

          <c:if test="${pessoa.get(0).tipo eq 'Funcionário'}">

            <h2>
              Adicionais do funcionário
              <%--
              <c:if test="${pessoa.get(0).isUsuario}">
                (usuário do sistema)
              </c:if>
              --%>
            </h2>

            <div class="row">

              <div class="col-sm-3">

                <h3>
                  Unidade
                  <br />
                  <small>
                    <%--<c:out value="${pessoa.get(0).unidade}" />--%>
                  </small>
                </h3>

              </div>

              <div class="col-sm-3">

                <h3>
                  Departamento
                  <br />
                  <small>
                    <%--<c:out value="${pessoa.get(0).departamento}" />--%>
                  </small>
                </h3>

              </div>

              <div class="col-sm-3">

                <h3>
                  Cargo
                  <br />
                  <small>
                    <%--<c:out value="${pessoa.get(0).cargo}" />--%>
                  </small>
                </h3>

              </div>

              <div class="col-sm-3">

                <h3>
                  Salário
                  <br />
                  <small>
                    <%--<c:out value="${pessoa.get(0).salario}" />--%>
                  </small>
                </h3>

              </div>

            </div>

          </c:if>

          <!-- Início: ABAS de Hospede e Funcionário -->
          <div class="tab-content">

            <!-- Início: Adicionais sobre o Funcionário -->
            <div id="abaFuncionario" class="tab-pane fade">

              <h4>
                Adicionais sobre o Funcionário
              </h4>
              <hr />

              <div class="row" id="formFuncionario">

                <div class="col-md-2 col-sm-6">

                  <div class="form-group">
                    <label for="formUnidade">
                      Unidade:
                    </label>
                    <input type="text" class="form-control"
                           tabindex="18"
                           name="formUnidade" id="formUnidade" 
                           placeholder="Hotel 2" />
                  </div>

                </div>

                <div class="col-md-3 col-sm-6">

                  <div class="form-group">
                    <label for="formDepartamento">
                      Departamento:
                    </label>
                    <input type="text" class="form-control" 
                           tabindex="19"
                           name="formDepartamento" id="formDepartamento"
                           placeholder="Recepção"/>
                  </div>

                </div>

                <div class="col-md-3">

                  <div class="form-group">
                    <label for="formCargo">

                    </label>                  
                    <input type="text" class="form-control"
                           tabindex="20"
                           name="formCargo" id="formCargo" 
                           placeholder="Recepcionista" />
                  </div>

                </div>

                <div class="col-md-2 col-xs-6">

                  <div class="form-group">                    
                    <label for="formSalario">
                      Sálario:
                    </label>
                    <input type="number" class="form-control" 
                           tabindex="22"
                           name="formSalario" id="formSalario"
                           placeholder="1400" />
                  </div>

                </div>

              </div>
              <!-- Fim da linha de GRID do formulário -->

              <div class="form-group">
                <label for="formUsuario">
                  Cadastrar como usuário do sistema?
                </label>
                <br style="clear: both;" />
                <div class="switch switch-square"
                     data-toggle="collapse" data-target="#collapseExample"
                     data-on-label="<i class='fa fa-check'></i>"
                     data-off-label="<i class='fa fa-times'></i>"
                     id="checkOpUsuario">
                  <input type="checkbox" value="1"
                         name="formOpUsuario" id="formOpUsuario"
                         checked
                         />
                </div>
                <!-- Check Option de Criação de id e senha -->
              </div>
              <div class="collapsed in" id="collapseExample">
                <div class="row" id="formUsuario">
                  <div class="col-md-3">
                    <div class="form-group">
                      <label for="formLogin">
                        Login:
                      </label>                  
                      <input type="text" class="form-control"
                             name="formLogin" id="formLogin" 
                             placeholder="Nome de Usuário" 
                             disabled/>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-group">
                      <label for="formSenha">
                        Senha:
                      </label>                  
                      <input type="password" class="form-control"
                             name="formSenha" id="formSenha" 
                             placeholder="********" />
                    </div>
                  </div>
                </div>
              </div>
              <!-- DIV com os campos de id e senha -->
            </div>
            <!-- Fim: Adicionais sobre o Funcionário -->

          </div>
          <!-- Fim: ABAS de Hospede e Funcionário -->         

        </div>

      </c:when>

      <c:otherwise>
        Nome:
        ${sessionScope.usuario.nome}
      </c:otherwise>

    </c:choose>

    <div style="padding: 15px 0px;"></div>

  </jsp:body>

</t:defaultTemplate>