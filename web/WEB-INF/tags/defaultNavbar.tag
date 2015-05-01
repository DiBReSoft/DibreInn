<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header">

  <div class="sidebar-toggle-box">
    <div class="fa fa-bars tooltips" 
         data-placement="bottom" 
         data-original-title="ocultar/exibir menu lateral">
    </div>
  </div>
  <!--logo start-->
  <a href="<c:url value="/erp/inicio" />" class="logo"
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
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
          <span class="hidden-xs">
            Gerald Richie
          </span>
          <img class="img-responsive img-circle"
               src="//pbs.twimg.com/profile_images/2934946269/d069c7c3ebf55fdecc7fb1c552804026_400x400.jpeg" />
          <span class="caret"></span>
        </a>
        <ul class="dropdown-menu dropdown-menu-right" role="menu">
          <li>
            <a href="<c:url value="/erp/pessoas/perfil" />">
              <i class="fa fa-fw fa-lg fa-user"></i>
              Dados Cadastrais
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="<c:url value="/logout" />">
              <i class="fa fa-fw fa-lg fa-power-off"></i>
              Fazer Logoff
            </a>
          </li>
        </ul>
      </li>
    </ul>
  </div>

</header>