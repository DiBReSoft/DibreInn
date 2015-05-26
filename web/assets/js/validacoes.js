
$(document).ready(function() {
 
 //aplicando mascaras
     $("#formCartao").unmask();
     $('#formCpf').unmask();
     $('#formRg').unmask();
     $('#formCep').unmask();
     $('#formTel').unmask();
     $('#formCel').unmask();
     
     $("#formCartao").mask('9999 9999 9999 9999');
     $('#formCpf').mask('999.999.999-99');
     $('#formRg').mask('**.999.999-*');
     $('#formCep').mask('99999-999');
     $('#formTel').mask('(99) 9999-9999');
     $('#formCel').mask('(99) 999-999-999');
 
 
//começa verificação de cpf
$("#formCpf").blur(function() {
    if (CPF != '') {
    

    var Expressao = /([0]{12}|[1]{12}|[2]{12}|[3]{12}|[4]{12}|[5]{12}|[6]{12}|[7]{12}|[8]{12}|[9]{12}|)/

var cpf= $("#formCpf");
    //Recebe o valor digitado no campo
    CPF = new String(cpf.val());

    //retira os '.' e o '-' do cpf
    CPF = CPF.replace(".", "");
    CPF = CPF.replace(".", "");
    CPF = CPF.replace("-", "");
  
    if (CPF.substr(Expressao) == "11111111111" ||
        CPF.substr(Expressao) == "22222222222" ||
        CPF.substr(Expressao) == "33333333333" ||
        CPF.substr(Expressao) == "44444444444" ||
        CPF.substr(Expressao) == "55555555555" ||
        CPF.substr(Expressao) == "66666666666" ||
        CPF.substr(Expressao) == "77777777777" ||
        CPF.substr(Expressao) == "88888888888" ||
        CPF.substr(Expressao) == "99999999999" ||
        CPF.substr(Expressao) == "00000000000") {

        alert("CPF inválido")
        cpf.focus();
        
        return false;
    }


    //AquicomeçaachecagemdoCPF
    var POSICAO, I, SOMA, DV, DV_INFORMADO;
    var DIGITO = new Array(10);
    DV_INFORMADO = CPF.substr(9, 2);
    //Retira os dois últimos dígitos donúmero informado

    //Desmembra o número do CPF na array DIGITO
    for (I = 0; I <= 8; I++) {
        DIGITO[I] = CPF.substr(I, 1);
    }
    //Calcula o valor do 10º dígito da verificação
    POSICAO = 10;
    SOMA = 0;
    for (I = 0; I <= 8; I++) {
        SOMA = SOMA + DIGITO[I] * POSICAO;
        POSICAO = POSICAO - 1;
    }
    DIGITO[9] = SOMA % 11;
    if (DIGITO[9] < 2) {
        DIGITO[9] = 0;
    }
    else {
        DIGITO[9] = 11 - DIGITO[9];
    }
    //Calcula o valor do 11º dígito da verificação
    POSICAO = 11;
    SOMA = 0;
    for (I = 0; I <= 9; I++) {
        SOMA = SOMA + DIGITO[I] * POSICAO;
        POSICAO = POSICAO - 1;
    }
    DIGITO[10] = SOMA % 11;
    if (DIGITO[10] < 2) {
        DIGITO[10] = 0;
    }
    else {
        DIGITO[10] = 11 - DIGITO[10];
    }
    //Verifica se os valores dos dígitos verificadores conferem
    DV = DIGITO[9] * 10 + DIGITO[10];
    if (DV != DV_INFORMADO) {
        alert('CPF inválido');
        
        cpf.focus();
        
        return false;
    }
}
});//fecha verificação de cpf


//começa verificação de email
$("#formEmail").blur(function()  {
    var email = $("#formEmail");
    if (email.val() != "") {
        if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.val()))) {
            alert("É necessário o preenchimento de um endereço de e-mail válido.");
            email.focus();
            return false;
        }
    }
});//fecha verificação de email




});



     