<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside>
  <div id="sidebar" class="nav-collapse darkblue-bg">
    <!-- sidebar menu start-->
    <ul class="sidebar-menu" id="nav-accordion">
      <li class="item-menu centered">
        <a href="<c:url value="/perfil" />">
          <img src="https://pbs.twimg.com/profile_images/2934946269/d069c7c3ebf55fdecc7fb1c552804026_400x400.jpeg"
               alt="Gerald Richie"
               class="img-circle sidebar-avatar" />
          <h4 class="sidebar-username">
            Gerald Richie
            <br />
            <small>
              <i>
                Diretor
              </i>
            </small>
          </h4>
        </a>
        <hr style="clear: both;" />
      </li>

      <li class="item-menu">
        <a href="<c:url value="/inicio" />">
          <i class="fa fa-home"></i>
          <span>In�cio</span>
        </a>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-users"></i>
          <span>Pessoas</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a  href="<c:url value="/hotel/pessoas/cadastrar" />">
              Cadastrar Novo
            </a>
          </li>
          <li class="item-menu">
            <a  href="<c:url value="/hotel/pessoas/buscar" />">
              Buscar &amp; Editar
            </a>
          </li>
        </ul>
      </li>

      <li class="item-menu">
        <a href="<c:url value="/hotel/reservas" />" >
          <i class="fa fa-th"></i>
          <span>
            Reservas
          </span>
        </a>
      </li>

      <li class="item-menu">
        <a href="<c:url value="/hotel/servicos" />" >
          <i class="fa fa-book"></i>
          <span>Servi�os de Quarto</span>
        </a>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-bar-chart-o"></i>
          <span>Relat�rios</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a  href="<c:url value="/adm/relatorios/vendas" />">
              Vendas
            </a>
          </li>
          <li class="item-menu">
            <a  href="<c:url value="/adm/relatorios/cadastros" />">
              Cadastros
            </a>
          </li>
        </ul>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-briefcase"></i>
          <span>Administra��o</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a href="<c:url value="/adm/produtos" />">
              Produtos
            </a>
          </li>
          <li class="item-menu">
            <a href="<c:url value="/adm/servi�os" />">
              Servi�os
            </a>
          </li>
          <li class="item-menu">
            <a href="<c:url value="/adm/usarios" />">
              Usu�rios do Sistema
            </a>
          </li>
        </ul>
      </li>

      <li class="item-menu">
        <a href="<c:url value="/configuracoes" />" >
          <i class="fa fa-cogs"></i>
          <span>Configura��es</span>
        </a>
      </li>

    </ul>
    <!-- sidebar menu end-->
  </div>
</aside>