$(".selecionado").click(selecionaItem);

function selecionaItem(event){
    $("#formNome").val("");
    $("#formCnpj").val("");
    $("#formCategoria").val("");
    $("#formCep").val("");
    $("#formLogradouro").val("");  
    $("#formNumero").val("");  
    $("#formComplemento").val("");  
    $("#formBairro").val("");  
    $("#formCidade").val("");  
    $("#formEstado").val(""); 
    
    event.preventDefault();
 
    
    var id = parseInt($("#tableId").text());
    var nome = $("#tableNome").text();
    var cnpj = $("#tableCnpj").text();
    var categoria = parseInt($("#tableCategoria").text());
    var cep = $("#tableCep").text();
    var complemento = $("#tableComplemento").text();
    var numero = ParseInt($("#tableNumero").text());
    //var logradouro = parseInt($("#tableOcupado").text());
    
      
    
    $("#formNome").val(nome);
    $("#formCnpj").val(cnpj);
    $("#formCategoria").val(categoria);
    $("#formCep").val(cep);
    //$("#formLogradouro").val();  
    $("#formNumero").val(numero);  
    $("#formComplemento").val(complemento);  
//    $("#formBairro").val("");  
//    $("#formCidade").val("");  
//    $("#formEstado").val(""); 
    
}





