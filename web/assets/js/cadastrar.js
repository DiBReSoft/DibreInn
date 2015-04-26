/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
function consultacep(cep){
8
      cep = cep.replace(/\D/g,"");
9
      url="http://cep.correiocontrol.com.br/"+cep+".js";
10
      s=document.createElement('script');
11
      s.setAttribute('charset','utf-8');
12
      s.src=url;
13
      document.querySelector('head').appendChild(s);
14
    }
15
 
16
    function correiocontrolcep(valor){
17
        var rua =document.querySelector("#formLogradouro");
        var bairro =document.querySelector("#formBairro");
        var cidade =document.querySelector("#formCidade");
        var estado=document.querySelector("#formEstado");
      if (valor.erro) {
18
        alert('Cep não encontrado');       
19      
        cep.value = "";
        rua.value="";
22
       bairro.value="";
23
     cidade.value="";
24
      estado.value="";
        return;
20
      };
       rua.value=valor.logradouro;
22
       bairro.value=valor.bairro;
23
     cidade.value=valor.localidade;
24
      estado.value=valor.uf;

      
    }