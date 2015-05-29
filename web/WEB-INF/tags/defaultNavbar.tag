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
          <span class="avatar-nome hidden-xs">
              ${sessionScope.usuario.nome}
            <small>
                <c:choose>
                    <c:when test="${sessionScope.usuario.unidadeId == '1'}">
                        Matriz
                    </c:when>
                    <c:otherwise>
                        Filial
                    </c:otherwise>
                </c:choose>
                ${sessionScope.usuario.unidadeNome.toLowerCase()}
            </small>
          </span>
          <span class="avatar-img">            
            <img class="img-responsive"
                 src="<c:url value="/assets/img/avatar-generic.svg" />" />
            <span class="caret"></span>
          </span>
        </a>
        <ul class="dropdown-menu dropdown-menu-right" role="menu">
          <li class="dropdown-header visible-xs">
            ${sessionScope.usuario.nome}
            <small>
                <c:choose>
                    <c:when test="${sessionScope.usuario.unidadeId == '1'}">
                        MATRIZ
                    </c:when>
                    <c:otherwise>
                        FILIAL
                    </c:otherwise>
                </c:choose>
                ${sessionScope.usuario.unidadeNome}
            </small>
          </li>
          <li class="divider visible-xs"></li>
          <li>
            <a href="<c:url value="/erp/funcionarios/perfil?id=${sessionScope.usuario.id}" />">
              <i class="fa fa-fw fa-lg fa-user"></i>
              Dados Cadastrais
              <i class="fa"></i>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="<c:url value="/logout" />">
              <i class="fa fa-fw fa-lg fa-power-off"></i>
              Sair
              <i class="fa"></i>
            </a>
          </li>
        </ul>
      </li>
    </ul>
  </div>

</header>