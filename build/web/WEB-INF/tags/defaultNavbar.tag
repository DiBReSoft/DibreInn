<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header">

  <div class="sidebar-toggle-box">
    <div class="fa fa-bars tooltips" 
         data-placement="bottom" 
         data-original-title="ocultar/exibir menu lateral">
    </div>
  </div>
  <!--logo start-->
  <a href="<c:url value="/inicio" />" class="logo"
     title="Hotel System Management">
    <strong>
      Lebre Hotel
    </strong>
    <small class="hidden-xs">
      DiBRe Inn
    </small>
  </a>
  <!--logo end-->

  <div class="top-menu pull-right">
    <ul class="nav top-menu">
      <li>
        <a class="logout" href="<c:url value="/bloquear" />">
          <i class="fa fa-fw fa-lock"></i>
          <span class="hidden-xs">
            Bloquear Sessão
          </span>
        </a>
      </li>
      <li>
        <a class="logout" href="<c:url value="/logout" />">
          <i class="fa fa-fw fa-power-off"></i>
          <span class="hidden-xs">
            Sair
          </span>                
        </a>
      </li>
    </ul>
  </div>

</header>