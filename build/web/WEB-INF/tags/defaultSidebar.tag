<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside>
  <div id="sidebar" class="nav-collapse darkblue-bg">
    <!-- sidebar menu start-->
    <ul class="sidebar-menu" id="nav-accordion">
      <li class="item-menu centered">
        <a href="<c:url value="/perfil.jsp" />">
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
        <a href="<c:url value="/index.jsp" />">
          <i class="fa fa-home"></i>
          <span>Início</span>
        </a>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-users"></i>
          <span>Clientes</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a  href="<c:url value="/hotel/clientes/cadastrar-novo.jsp" />">
              Cadastrar Novo
            </a>
          </li>
          <li class="item-menu">
            <a  href="<c:url value="/hotel/clientes/buscar.jsp" />">
              Buscar &amp; Editar
            </a>
          </li>
        </ul>
      </li>

      <li class="item-menu">
        <a href="<c:url value="/hotel/reservas.jsp" />" >
          <i class="fa fa-th"></i>
          <span>
            Reservas
          </span>
        </a>
      </li>

      <li class="item-menu">
        <a href="<c:url value="/hotel/servicos.jsp" />" >
          <i class="fa fa-book"></i>
          <span>Serviços de Quarto</span>
        </a>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-bar-chart-o"></i>
          <span>Relatórios</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a  href="<c:url value="/adm/relatorios/vendas.jsp" />">
              Vendas
            </a>
          </li>
          <li class="item-menu">
            <a  href="<c:url value="/adm/relatorios/cadastros.jsp" />">
              Cadastros
            </a>
          </li>
        </ul>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-briefcase"></i>
          <span>Administração</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a href="<c:url value="/adm/produtos.jsp" />">
              Produtos
            </a>
          </li>
          <li class="item-menu">
            <a href="<c:url value="/adm/serviços.jsp" />">
              Serviços
            </a>
          </li>
          <li class="item-menu">
            <a href="<c:url value="/adm/usarios.jsp" />">
              Usuários do Sistema
            </a>
          </li>
        </ul>
      </li>

      <li class="item-menu">
        <a href="<c:url value="/configuracoes.jsp" />" >
          <i class="fa fa-cogs"></i>
          <span>Configurações</span>
        </a>
      </li>

    </ul>
    <!-- sidebar menu end-->
  </div>
</aside>