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
    Pessoa: Cadastrar
  </jsp:attribute>

  <jsp:attribute name="paginaHead">
    <!-- CSS e outros que vão no <head> da página -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/CadastrarPessoa.css" />" />
  </jsp:attribute>

  <jsp:attribute name="paginaBottom">
    <!-- JavaScript e outros que vão ao final da página -->
     <script type="text/javascript" src="<c:url value="/assets/js/jquery.maskedinput.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-switch.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/form-component.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/cadastrar.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.numeric.js" />"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.maskedinput.min.js" />"></script>
 <script type="text/javascript" src="<c:url value="/assets/js/validacoes.js" />"></script>
 
  </jsp:attribute>

  <jsp:body>

    <h1 class="page-title">
      Cadastrar Pessoa
    </h1>

    <!-- page start-->
    <div>

      <!-- Início do Formulário -->
      <form role="form" method="post" class="form-di"
            action="cadastrar" name="formCadastrar">

        <!-- Início da #1 linha de GRID do formulário -->
        <div class="row">

          <!-- Início da primeira coluna: lado esquerdo - DADOS -->
          <div class="col-sm-6">

            <h4>
              Dados
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
                         placeholder="Fulano"
                         required="true" />
                </div>

              </div>

              <div class="col-xs-6">

                <div class="form-group">
                  <label for="formSobrenome">
                    Sobrenome:
                  </label>
                  <input type="text" class="form-control" 
                         tabindex="2"
                         name="formSobrenome" id="formSobrenome"
                         placeholder="da Silva"
                         required="true" />
                </div>

              </div>

              <div class="col-sm-4">

                <div class="form-group">
                  <label for="formSexo">
                    Sexo:
                  </label>
                  <select class="form-control"
                          tabindex="3"
                          name="formSexo" id="formSexo"                         
                          placeholder="Sexo"
                          required="true">
                    <option value="m">
                      Masculino
                    </option>
                    <option value="f">
                      Feminino
                    </option>
                  </select>
                </div>

              </div>

              <div class="col-sm-4">

                <div class="form-group">                    
                  <label for="formRg">
                    RG:
                  </label>                  
                  <input type="text" class="form-control"
                         tabindex="4"
                         name="formRg" id="formRg" 
                         placeholder="RG" 
                         maxlength="50" />
                </div>

              </div>

              <div class="col-sm-4">

                <div class="form-group">                    
                  <label for="formCpf">
                    CPF:
                  </label>
                  <input type="text" class="form-control"
                         tabindex="5"
                         name="formCpf" id="formCpf" 
                         placeholder="CPF" 
                         maxlength="50" />
                </div>

              </div>

              <div class="col-sm-6">

                <div class="form-group">
                  <label for="formDataNasc">
                    Data de Nascimento:
                  </label>
                  <input type="text" class="form-control" 
                         tabindex="6"
                         name="formDataNasc" id="formDataNasc" 
                         placeholder="DD-MM-AAAA"
                         required="true" 
                         maxlength="10" />
                </div>

              </div>

              <div class="col-sm-6">

                <div class="form-group">
                  <label for="formTel">
                    Telefone:
                  </label>
                  <input type="tel" class="form-control" 
                         tabindex="7"
                         name="formTel" id="formTel"
                         placeholder="5555-5555" 
                         maxlength="9" />
                </div>

              </div>

              <div class="col-xs-8">

                <div class="form-group">
                  <label for="formEmail">
                    E-mail:
                  </label>
                  <input type="email" class="form-control" 
                         tabindex="8"
                         name="formEmail" id="formEmail"
                         placeholder="fulano@dasilva.com.br" />
                </div>

              </div>

              <div class="col-xs-4">

                <div class="form-group">
                  <label for="formNewsletter">
                    Newsletter:
                  </label>
                  <br style="clear: both;" />
                  <div class="switch switch-square"
                       data-on-label="<i class=' fa fa-check'></i>"
                       data-off-label="<i class='fa fa-times'></i>">
                    <input type="checkbox" checked
                           tabindex="9"
                           name="formNewsletter" id="formNewsletter"
                           required="true" 
                           />
                  </div>
                </div>

              </div>

            </div>

          </div>
          <!-- Fim da primeira coluna: lado esquerdo - DADOS -->

          <!-- Início da segunda coluna: lado direito - ENDEREÇO
          <div class="col-sm-6">

            <h4>
              Endereço
            </h4>

            <hr />

            <div class="row">

              <div class="col-sm-6">

                <div class="form-group">
                  <label for="formCep">
                    CEP: 
                    <span class="badge badge-event">
                      autocompleta
                    </span>
                  </label>
                  <input type="text" class="form-control"
                         tabindex="10"
                         name="formCep" id="formCep"                                                     
                         placeholder="04696-000"
                         onblur="consultacep(this.value)"/>
                </div>

              </div>

              <div class="col-sm-6 hidden-xs">
                <label>
                  <i class="fa fa-lg fa-question-circle"></i>
                </label>
                <div style="padding: 5px;"></div>
                <small class="text-muted">
                  <i>
                    Digite o CEP que o endereço será preenchido
                    automaticamente com os dados geográficos
                  </i>
                </small>
              </div>

              <div class="col-xs-8">

                <div class="form-group">
                  <label for="formLogradouro">
                    Logradouro:
                  </label>
                  <input type="text" class="form-control"
                         tabindex="11"
                         name="formLogradouro" id="formLogradouro" 
                         placeholder="Av. Engenheiro Eusébio Stevaux" />
                </div>

              </div>

              <div class="col-xs-4">

                <div class="form-group">
                  <label for="formNumero">
                    Número:
                  </label>
                  <input type="number" class="form-control" 
                         tabindex="12"
                         name="formNumero" id="formNumero"
                         placeholder="823" />
                </div>

              </div>

              <div class="col-xs-6">

                <div class="form-group">
                  <label for="formComplemento">
                    Complemento:
                  </label>                  
                  <input type="text" class="form-control"
                         tabindex="13"
                         name="formComplemento" id="formComplemento" 
                         placeholder="Sala C143" />
                </div>

              </div>

              <div class="col-xs-6">

                <div class="form-group">                    
                  <label for="formBairro">
                    Bairro:
                  </label>
                  <input type="text" class="form-control"
                         tabindex="14"
                         name="formBairro" id="formBairro" 
                         placeholder="Campo Grande" />
                </div>

              </div>

              <div class="col-sm-5">

                <div class="form-group">
                  <label for="formCidade">
                    Cidade:
                  </label>
                  <input type="text" class="form-control" 
                         tabindex="15"
                         name="formCidade" id="formCidade" 
                         placeholder="São Paulo" />
                </div>

              </div>

              <div class="col-sm-3">

                <div class="form-group">
                  <label for="formEstado" title="Estado">
                    UF:
                  </label>
                  <input type="text" class="form-control" 
                         tabindex="16"
                         name="formEstado" id="formEstado" 
                         placeholder="SP" />
                </div>

              </div>

              <div class="col-sm-4">

                <div class="form-group">
                  <label for="formPais" title="País">
                    País
                  </label>
                  <input type="text" class="form-control" 
                         tabindex="17"
                         name="formPais" id="formPais" 
                         placeholder="Brasil" />
                </div>

              </div>

            </div>

          </div>
          <!-- Fim da segunda coluna: lado direito - ENDEREÇO -->

        </div>
        <!-- Fim da #1 linha de GRID do formulário -->

        <div style="padding: 5px;"></div>

        <h4 style="margin-top: 8px; margin-right: 10px; float: left;">
          Tipo de Pessoa
        </h4>
        <ul class="nav nav-pills">
          <li role="presentation">
            <a role="tab" data-toggle="tab" 
               aria-controls="abaHospede"
               href="#abaHospede">
              Hospede
            </a>
            <input type="radio"
                   tabindex="0"
                   name="formTipo" id="formTipo1"
                   value="hospede" 
                   required="true" />
          </li>
          <li role="presentation">
            <a role="tab" data-toggle="tab" 
               aria-controls="abaFuncionario"
               href="#abaFuncionario">
              Funcionário
            </a>
            <input type="radio"
                   tabindex="0"
                   name="formTipo" id="formTipo2"
                   value="funcionario" 
                   required="true" />
          </li>
        </ul>

        <hr />

        <!-- Início: ABAS de Hospede e Funcionário -->
        <div class="tab-content">

          <!-- Início: Adicionais sobre o Hospede -->
          <div id="abaHospede" class="tab-pane fade">

            <h4>
              Adicionais sobre o Hospede
            </h4>

            <hr />

            <div class="row" id="formHospede">

              <div class="col-sm-4">

                <div class="form-group">
                  <label for="formCartao">
                    Número do Cartão:
                  </label>
                  <input type="text" class="form-control" 
                         tabindex="18"
                         name="formCartao" id="formCartao"
                         placeholder="9999 9999 9999 9999"
                         />
                </div>

              </div>

              <div class="col-sm-4">

                <div class="form-group">
                  <label for="formNacionalidade">
                    Nacionalidade:
                  </label>
                  <input type="text" class="form-control"
                         tabindex="19"
                         name="formNacionalidade" id="formNacionalidade" 
                         placeholder="Brasileiro" />
                </div>

              </div>

              <div class="col-sm-4">

                <div class="form-group">
                  <label for="formPassaporte">
                    Número do Passaporte:
                  </label>
                  <input type="text" class="form-control" 
                         tabindex="20"
                         name="formPassaporte" id="formPassaporte"
                         placeholder="9999 9999 9999 9999" />
                </div>

              </div>

            </div>

          </div>
          <!-- Fim: Adicionais sobre o Hospede -->

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
                         placeholder="Recepção" />
                </div>

              </div>

              <div class="col-md-3">

                <div class="form-group">
                  <label for="formCargo">
                    Cargo:
                  </label>                  
                  <input type="text" class="form-control"
                         tabindex="20"
                         name="formCargo" id="formCargo" 
                         placeholder="Recepcionista" />
                </div>

              </div>

              <div class="col-md-2 col-xs-6">

                <div class="form-group">
                  <label for="formDependentes">
                    Número Dependentes:
                  </label>
                  <input type="number" class="form-control" 
                         tabindex="21"
                         name="formDependentes" id="formDependentes"
                         placeholder="999" />
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
                Cadastrar Usuário?
              </label>
              <br style="clear: both;" />
              <div class="switch switch-square"
                   data-on-label="<i class='fa fa-check'></i>"
                   data-off-label="<i class='fa fa-times'></i>"
                   id="checkOpUsuario">
                <input type="checkbox" checked
                       name="formOpUsuario" id="formOpUsuario"
                       />
              </div>
              <!-- Radio Button de Criação de id e senha -->
            </div>
            <div class="row" id="formUsuario">
              <div class="col-md-3">
                <div class="form-group">
                  <label for="formLogin">
                    Login:
                  </label>                  
                  <input type="text" class="form-control"
                         name="formLogin" id="formLogin" 
                         placeholder="Nome de Usuário" />
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <label for="formCargo">
                    Senha:
                  </label>                  
                  <input type="password" class="form-control"
                         name="formSenha" id="formSenha" 
                         placeholder="********" />
                </div>
              </div>
            </div>
            <!-- GRID com os campos de id e senha -->

          </div>
          <!-- Fim: Adicionais sobre o Funcionário -->

        </div>
        <!-- Fim: ABAS de Hospede e Funcionário -->

        <div style="padding: 10px 0px;"></div>

        <p>
          Os campos marcados com
          <i class="fa fa-fw fa-lg fa-asterisk"></i>
          são obrigatórios.
        </p>

        <div style="padding: 10px 0px;"></div>

        <!-- Linha de botões do formulário -->
        <div class="row">

          <div class="col-sm-3 hidden-xs"></div>

          <div class="col-xs-6 col-sm-3">

            <button type="reset" class="btn btn-block btn-lg btn-primary" 
                    tabindex="24">
              <i class="fa fa-eraser"></i>
              LIMPAR
            </button>

          </div>

          <div class="col-xs-6 col-sm-3">

            <button type="submit" class="btn btn-block btn-lg btn-default" 
                    tabindex="23">
              CADASTRAR
              <i class="fa fa-check-square"></i>
            </button>

          </div>

        </div>   
        <!-- Linha de botões do formulário -->

      </form>
      <!-- Fim do Formulário -->

      <div style="padding: 15px 0px;"></div>

    </div>

  </jsp:body>

</t:defaultTemplate>