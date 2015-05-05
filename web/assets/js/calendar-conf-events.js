var Script = function () {
  
  /* initialize the calendar
   -----------------------------------------------------------------*/

  var date = new Date();
  var d = date.getDate();
  var m = date.getMonth();
  var y = date.getFullYear();

  var eventos = [];
  for (var i = 0; i < 3; i++) {
    for (var j = 1; j < 32; j++) {
      eventos.push({
        title: 'Nova Reserva',
        start: new Date(y, m, j),
        url: 'reservas/nova?data=' + new Date(y, m, j)
      });
      eventos.push({
        title: 'Listar Reservas',
        start: new Date(y, m, j),
        url: 'reservas/listar?data=' + new Date(y, m, j)
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