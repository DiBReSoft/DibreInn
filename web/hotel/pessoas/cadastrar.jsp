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

    <script type="text/javascript" src="<c:url value="/assets/js/cadastrar.js" />"></script>
    <!-- JavaScript e outros que vão ao final -->
  </jsp:attribute>

  <jsp:body>

    <h1>
      <i class="fa fa-angle-right"></i> 
      Cadastrar Pessoa
    </h1>
    <!-- page start-->
    <div class="row mt">

      <div class="form-panel">


        <!-- Início do Formulário -->
        <form role="form" method="post" action="cadastrado" name="formCadastrar">

          <!-- Início da linha de GRID do formulário -->
          <div class="row">

            <!-- Início da primeira coluna: lado esquerdo -->
            <div class="col-sm-6">

              <h2>Dados Cadastrais</h2>

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
                           placeholder="RG" />
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
                           placeholder="CPF" />
                  </div>

                </div>

                <div class="col-sm-4">

                  <div class="form-group">
                    <label for="formDataNasc">
                      Data de Nascimento:
                    </label>
                    <input type="date" class="form-control" 
                           tabindex="6"
                           name="formDataNasc" id="formDataNasc" 
                           placeholder="DD/MM/AAAA" />
                  </div>

                </div>

                <div class="col-sm-4">

                  <div class="form-group">
                    <label for="formTel">
                      Telefone:
                    </label>
                    <input type="tel" class="form-control" 
                           tabindex="7"
                           name="formTel" id="formTel"
                           placeholder="Telefone" />
                  </div>

                </div>

                <div class="col-sm-4">

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

              </div>

            </div>
            <!-- Fim da primeira coluna: lado esquerdo -->

            <!-- Início da segunda coluna: lado direito -->
            <div class="col-sm-6">

              <h2>Endereço</h2>

              <hr />

              <div class="row">

                <div class="col-xs-8">

                  <div class="form-group">
                    <label for="formLogradouro">
                      Logradouro:
                    </label>
                    <input type="text" class="form-control"
                           tabindex="9"
                           name="formLogradouro" id="formLogradouro" 
                           placeholder="Av. Xpto" />
                  </div>

                </div>

                <div class="col-xs-4">

                  <div class="form-group">
                    <label for="formNumero">
                      Número:
                    </label>
                    <input type="number" class="form-control" 
                           tabindex="10"
                           name="formNumero" id="formNumero"
                           placeholder="999" />
                  </div>

                </div>

                <div class="col-xs-6">

                  <div class="form-group">
                    <label for="formComplemento">
                      Complemento:
                    </label>                  
                    <input type="text" class="form-control"
                           tabindex="12"
                           name="formComplemento" id="formComplemento" 
                           placeholder="Casa 1" />
                  </div>

                </div>

                <div class="col-xs-6">

                  <div class="form-group">
                    <label for="formCep">
                      CEP: 
                      <span class="badge badge-event">
                        autocompleta
                      </span>
                    </label>
                    <input type="text" class="form-control"
                           tabindex="11"
                           name="formCep" id="formCep" onblur="consultacep(this.value)"                        
                           placeholder="000000-000" />
                  </div>

                </div>

                <div class="col-sm-4">

                  <div class="form-group">                    
                    <label for="formBairro">
                      Bairro:
                    </label>
                    <input type="text" class="form-control"
                           tabindex="13"
                           name="formBairro" id="formBairro" 
                           placeholder="Jardim das Cidades" />
                  </div>

                </div>

                <div class="col-sm-5">

                  <div class="form-group">
                    <label for="formCidade">
                      Cidade:
                    </label>
                    <input type="text" class="form-control" 
                           tabindex="14"
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
                           tabindex="14"
                           name="formEstado" id="formEstado" 
                           placeholder="SP" />
                  </div>

                </div>

              </div>

            </div>
            <!-- Fim da segunda coluna: lado direito -->
            
            <div class="col-sm-6">

              <h2>Escolha uma opção para continuar:</h2>

              <hr />

              <div class="row">

                <div class="col-xs-6">

             <div class="col-sm-6">

                  <div class="form-group">
                    <label for="formEscolhaTipoCadastro">
                      Tipo de Cadastro:
                    </label>
                    <select class="form-control"
                            tabindex="3"
                            name="formEscolhaTipoCadastro" id="formEscolhaTipoCadastro"                         
                            placeholder="Escolha uma opção"
                            required="true">
                      <option value="1">
                        Hospede
                      </option>
                      <option value="2">
                        Funcionario
                      </option>
                    </select>
                  </div>

                </div>
                    
                </div>

                </div>
             </div>

            
            
            <!-- Início da terceira coluna: lado esquerdo -->
            <div class="col-sm-6" id="formHospede">

              <h2>Dados Complementares Hospede</h2>

              <hr />

              <div class="row">

                <div class="col-xs-6">

                  <div class="form-group">
                    <label for="formNacionalidade">
                      Nacionalidade:
                    </label>
                    <input type="text" class="form-control"
                           tabindex="15"
                           name="formNacionalidade" id="formNacionalidade" 
                           placeholder="Brasil"
                           required="true" />
                  </div>

                </div>

                <div class="col-xs-6">

                  <div class="form-group">
                    <label for="formCartao">
                      Número do Cartão:
                    </label>
                    <input type="text" class="form-control" 
                           tabindex="16"
                           name="formCartao" id="formCartao"
                           placeholder="9999 9999 9999 9999"
                           required="true" />
                  </div>

                </div>

                <div class="col-sm-4">

                  <div class="form-group">
                    <label for="formPassaporte">
                      Número do Passaporte:
                    </label>
                    <input type="text" class="form-control" 
                           tabindex="17"
                           name="formPassaporte" id="formPassaporte"
                           placeholder="9999 9999 9999 9999"
                           required="true" />
                  </div>

                </div>

              </div>

            </div>
            <!-- Fim da terceira coluna: lado esquerdo -->
            
            
            <!-- Início da quarta coluna: lado direito -->
            <div class="col-sm-6" id="formFuncionario">

              <h2>Dados Complementares Fúncionarios</h2>

              <hr />

              <div class="row">

                <div class="col-xs-8">

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

                <div class="col-xs-4">

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

                <div class="col-xs-6">

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

                <div class="col-xs-6">

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

                <div class="col-sm-4">

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
            <!-- Fim da quarta coluna: lado direito -->
            
            
            
            
            
            
            
            

          </div>
          <!-- Fim da linha de GRID do formulário -->          

          <hr />
          
          
          


          <!-- Linha de botões do formulário -->
          <div class="row">

            <div class="col-sm-3 hidden-xs"></div>

            <div class="col-xs-6 col-sm-3">

              <button type="reset" class="btn btn-block btn-lg btn-primary" 
                      tabindex="16">
                <i class="fa fa-eraser"></i>
                CANCELAR
              </button>

            </div>

            <div class="col-xs-6 col-sm-3">

              <button type="submit" class="btn btn-block btn-lg btn-default" 
                      tabindex="15">
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

    </div>

  </jsp:body>

</t:defaultTemplate>