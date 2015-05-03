<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside>
  <div id="sidebar" class="nav-collapse">
    <!-- sidebar menu start-->
    <ul class="sidebar-menu" id="nav-accordion">

      <li class="item-menu">
        <a href="<c:url value="/erp/inicio" />">
          <i class="fa fa-fw fa-lg fa-home"></i>
          <span>Início</span>
        </a>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-fw fa-lg fa-users"></i>
          <span>Pessoas</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a  href="<c:url value="/erp/pessoas/cadastrar" />">
              Cadastrar
            </a>
          </li>
          <li class="item-menu">
            <a  href="<c:url value="/erp/pessoas/buscar" />">
              Buscar &amp; Editar
            </a>
          </li>
        </ul>
      </li>

      <li class="item-menu">
        <a href="<c:url value="/erp/reservas" />" >
          <i class="fa fa-fw fa-lg fa-th"></i>
          <span>
            Reservas
          </span>
        </a>
      </li>

      <li class="item-menu">
        <a href="<c:url value="/erp/servicos" />" >
          <i class="fa fa-fw fa-lg fa-book"></i>
          <span>Serviços de Quarto</span>
        </a>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-fw fa-lg fa-bar-chart-o"></i>
          <span>Relatórios</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a  href="<c:url value="/erp/relatorios/vendas" />">
              Vendas
            </a>
          </li>
          <li class="item-menu">
            <a  href="<c:url value="/erp/relatorios/cadastros" />">
              Cadastros
            </a>
          </li>
        </ul>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-fw fa-lg fa-briefcase"></i>
          <span>Administração</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a href="<c:url value="/erp/produtos" />">
              Produtos
            </a>
          </li>
          <li class="item-menu">
            <a href="<c:url value="/erp/serviços" />">
              Serviços
            </a>
          </li>
          <li class="item-menu">
            <a href="<c:url value="/erp/usarios" />">
              Usuários do Sistema
            </a>
          </li>
        </ul>
      </li>

      <li class="item-menu">
        <a href="<c:url value="/erp/configuracoes" />" >
          <i class="fa fa-fw fa-lg fa-cogs"></i>
          <span>Configurações</span>
        </a>
      </li>

    </ul>
    <!-- sidebar menu end-->
  </div>
</aside>