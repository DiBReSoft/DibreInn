var cep = document.querySelector("#formCep");

//var tipoCadastro = document.querySelector("#formEscolhaTipoCadastro");
//tipoCadastro.addEventListener('onclick',mostraTipoCadastro(tipoCadastro));
//cep.addEventListener('onblur',consultacep(this.value);


//function mostraTipoCadastro(tipoCadastro.value){

//var funcionario = document.querySelector("#formFuncionario");

//var hospede = document.querySelector("#formHospede");
//  if(tipoCadastro.value == 1){
//    hospede.style.display = block;
//  funcionario.style.display = none;
//} else{
//      hospede.style.display = none;
//      funcionario.style.display = block;
//    }

//}

function consultacep(cep) {
  cep = cep.replace(/\D/g, "");
  url = "http://cep.correiocontrol.com.br/" + cep + ".js";
  s = document.createElement('script');
  s.setAttribute('charset', 'utf-8');
  s.src = url;
  document.querySelector('head').appendChild(s);
}

function correiocontrolcep(valor) {
  var rua = document.querySelector("#formLogradouro");
  var bairro = document.querySelector("#formBairro");
  var cidade = document.querySelector("#formCidade");
  var estado = document.querySelector("#formEstado");
  var pais = document.querySelector("#formPais");
  if (valor.erro) {
    alert('CEP não encontrado');
    cep.value = "";
    rua.value = "";
    bairro.value = "";
    cidade.value = "";
    estado.value = "";
    return;
  }
  rua.value = valor.logradouro;
  bairro.value = valor.bairro;
  cidade.value = valor.localidade;
  estado.value = valor.uf;
}