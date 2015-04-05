/* Estas declaracoes irao monitorar a altura e largura da tela
 * salvando estes dados nas seguintes variaveis, mesmo quando
 * houver redimensionamento da tela (usuario virar o smartphone de lado e etc) */
var telaLargura = window.innerWidth;
var telaAltura = window.innerHeight;

$(window).resize(function () {
  telaLargura = window.innerWidth;
  telaAltura = window.innerHeight;
});

/******************************************************************************/
/******************************************************************************/
/******************************************************************************/
/******************************************************************************/

/* Todos os codigos dentro desta declaracao, 
 * serao executados assim que a página for ACESSADA */
$(document).ready(function () {

  function posicionarBoxCredenciais() {
    if (telaAltura > 450) {
      $("footer").css("top", (telaAltura / 2 - 188) + "px");
    }
    if (telaAltura > 300) {
      $("section").css("margin-top", ((telaAltura / 2) - 170) + "px");
    }
  }
  posicionarBoxCredenciais();
  $(window).resize(posicionarBoxCredenciais);

});

/******************************************************************************/
/******************************************************************************/
/******************************************************************************/
/******************************************************************************/

/* Todos os codigos dentro desta declaracao, 
 * serao executados assim que a página for CARREGADA POR COMPLETO */
$(window).load(function () {

});