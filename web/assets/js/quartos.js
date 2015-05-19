$(".selecionado").click(selecionaItem);

function selecionaItem(event){
    $("#formNumero").val("");
    $("#formAndar").val("");
    $("#formRamal").val("");
    $("#formValor").val("");
    $("#formOcupado").val("");  
    
    event.preventDefault();
 
    
    var id = parseInt($("#tableId").text());
    var numero = parseInt($("#tableNumero").text());
    var andar = $("#tableAndar").text();
    var ramal = parseInt($("#tableRamal").text());
    var valor = parseFloat($("#tableValor").text());
    var ocupado = parseInt($("#tableOcupado").text());
    
      
    
    $("#formNumero").val(numero);
    $("#formAndar").val(andar);
    $("#formRamal").val(ramal);
    $("#formValor").val(valor);
    $("#formOcupado").val(ocupado);
    
}


