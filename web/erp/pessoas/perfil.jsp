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

                  <h4>
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
                  </h4>

                </div>

                <div class="col-sm-4">

                  <h4>
                    RG
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).rg}" />
                    </small>
                  </h4>

                </div>

                <div class="col-sm-4">

                  <h4>
                    CPF
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).cpf}" />
                    </small>
                  </h4>

                </div>

                <div class="col-sm-4">

                  <h4>
                    Nascimento
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).dataNascimento}" />
                    </small>
                  </h4>

                </div>

                <div class="col-sm-4">

                  <h4>
                    Telefone
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).telefone}" />
                    </small>
                  </h4>

                </div>

                <div class="col-sm-4">

                  <h4>
                    Celular
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).celular}" />
                    </small>
                  </h4>

                </div>

                <div class="col-xs-8">

                  <h4>
                    E-mail
                    <br />
                    <small>
                      <c:out value="${pessoa.get(0).email}" />
                    </small>
                  </h4>

                </div>

                <div class="col-xs-4">

                  <h4>
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
                  </h4>

                </div>

              </div>

            </div>

            <div class="col-sm-6">

              <div class="row">

                <div class="col-xs-8">

                  <h4>
                    Logradouro
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.logradouro}" />--%>
                    </small>
                  </h4>

                </div>

                <div class="col-xs-4">

                  <h4>
                    Número
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.numero}" />--%>
                    </small>
                  </h4>

                </div>

                <div class="col-xs-6 col-sm-4">

                  <h4>
                    Complemento
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.Complemento}" />--%>
                    </small>
                  </h4>

                </div>

                <div class="col-xs-6 col-sm-4">

                  <h4>
                    Bairro
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.bairro}" />--%>
                    </small>
                  </h4>

                </div>

                <div class="col-xs-5 col-sm-4">

                  <h4>
                    Cidade
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.cidade:}" />--%>
                    </small>
                  </h4>

                </div>

                <div class="col-xs-3">

                  <h4>
                    Cidade
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.estado}" />--%>
                    </small>
                  </h4>

                </div>

                <div class="col-sm-4">

                  <h4>
                    País
                    <br />
                    <small>
                      <%--<c:out value="${pessoa.get(0).end.pais}" />--%>
                    </small>
                  </h4>

                </div>

              </div>

            </div>

          </div>

          <hr />

          <c:if test="${pessoa.get(0).tipo eq 'Hospede'}">

            <h2>
              Adicionais sobre o Hospede
            </h2>

            <h4>
              Número do Cartão
              <br />
              <small>
                <%--<c:out value="${pessoa.get(0).nCartao}" />--%>
              </small>
            </h4>

            <br />

            <h4>
              Histórico de Reservas
            </h4>

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

                <h4>
                  Unidade
                  <br />
                  <small>
                    <%--<c:out value="${pessoa.get(0).unidade}" />--%>
                  </small>
                </h4>

              </div>

              <div class="col-sm-3">

                <h4>
                  Departamento
                  <br />
                  <small>
                    <%--<c:out value="${pessoa.get(0).departamento}" />--%>
                  </small>
                </h4>

              </div>

              <div class="col-sm-3">

                <h4>
                  Cargo
                  <br />
                  <small>
                    <%--<c:out value="${pessoa.get(0).cargo}" />--%>
                  </small>
                </h4>

              </div>

              <div class="col-sm-3">

                <h4>
                  Salário
                  <br />
                  <small>
                    <%--<c:out value="${pessoa.get(0).salario}" />--%>
                  </small>
                </h4>

              </div>

            </div>

            <br />

            <h4>
              Histórico de Operações no Sistema
            </h4>

            <table class="table table-condensed table-hover table-responsive">
              <thead>
                <tr>
                  <th>
                    <i class="fa fa-fw fa-calendar"></i>
                    Data
                  </th>
                  <th>
                    <i class="fa fa-fw fa-file-o"></i>
                    Descrição da Operação
                  </th>
                </tr>
              </thead>
              <tbody>
                <!-- Rodar o loop -->
              </tbody>
            </table>

          </c:if>

        </div>

      </c:when>


      <c:otherwise>
        <!-- AQUI É QUANDO FOR O USUÁRIO DA SESSÃO -->
        Nome:
        ${sessionScope.usuario.nome}
        <!-- AQUI É QUANDO FOR O USUÁRIO DA SESSÃO -->
      </c:otherwise>

    </c:choose>

    <div style="padding: 15px 0px;"></div>

  </jsp:body>

</t:defaultTemplate>