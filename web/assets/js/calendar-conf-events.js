var Script = function () {

  /* initialize the calendar
   -----------------------------------------------------------------*/

  var date = new Date();
  var d = date.getDate();
  var m = date.getMonth();
  var y = date.getFullYear();

  var dataAtual = moment(d + "-" + (m + 1) + "-" + y, "DD-MM-YYYY").format("DD-MM-YYYY");
  console.log(dataAtual);

  var eventos = [];
  for (var i = 0; i < 3; i++) {
    for (var j = 1; j < 32; j++) {
      /*
      eventos.push({
        title: 'Nova Reserva',
        start: new Date(y, m, j),
        url: 'nova?data=' + moment(j + "-" + (m + 1) + "-" + y, "DD-MM-YYYY").format("DD-MM-YYYY")
      });
      */
      eventos.push({
        title: 'Listar Reservas',
        start: new Date(y, m, j),
        url: 'listar?data=' + moment(j + "-" + (m + 1) + "-" + y, "DD-MM-YYYY").format("DD-MM-YYYY")
      });
    }
    m++;
  }

  $('#calendar').fullCalendar({
    lang: 'pt-br',
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,basicWeek,basicDay'
    },
    businessHours: true,
    events: eventos
  });

}();