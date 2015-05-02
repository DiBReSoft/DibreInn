$(document).ready(function () {

    $("a[href=#abaHospede]").click(function () {
        console.log("Aba de hospede ativa");
        $("#formTipo1").click();
    });
    $("a[href=#abaFuncionario]").click(function () {
        console.log("Aba de funcionario ativa");
        $("#formTipo2").click();
    });

});

var cep = document.querySelector("#formCep");


function consultacep(cep) {
    if(cep != ""){
        cep = cep.replace(/\D/g, "");
    url = "http://cep.correiocontrol.com.br/" + cep + ".js";
    s = document.createElement('script');
    s.setAttribute('charset', 'utf-8');
    s.src = url;
    document.querySelector('head').appendChild(s); 
        
    }
   
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
