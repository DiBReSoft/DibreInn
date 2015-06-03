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
          <span>Hospedes</span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a  href="<c:url value="/erp/hospedes/cadastrar" />">
              Cadastrar
            </a>
          </li>
          <li class="item-menu">
            <a  href="<c:url value="/erp/hospedes/buscar" />">
              Buscar &amp; Editar
            </a>
          </li>
        </ul>
      </li>

      <c:if test="${sessionScope.usuario.privilegioId == 2 || sessionScope.usuario.privilegioId == 3}">
        <li class="sub-menu">
          <a href="javascript:;" >
            <i class="fa fa-fw fa-lg fa-users"></i>
            <span>Funcionários</span>
          </a>
          <ul class="sub">
            <li class="item-menu">
              <a  href="<c:url value="/erp/funcionarios/cadastrar" />">
                Cadastrar
              </a>
            </li>
            <li class="item-menu">
              <a  href="<c:url value="/erp/funcionarios/buscar" />">
                Buscar &amp; Editar
              </a>
            </li>
          </ul>
        </li>
      </c:if>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-fw fa-lg fa-check-square"></i>
          <span>
            Reservas
          </span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a href="<c:url value="/erp/reservas/nova" />">
              Agendar Nova
            </a>
          </li>
          <li class="item-menu">
            <a href="<c:url value="/erp/reservas/buscar" />">
              Buscar &amp; Cancelar
            </a>
          </li>
        </ul>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" >
          <i class="fa fa-fw fa-lg fa-bed"></i>
          <span>
            Estadias
          </span>
        </a>
        <ul class="sub">
          <li class="item-menu">
            <a href="<c:url value="/erp/estadias/checkin" />">
              Efetuar Check-In
            </a>
          </li>
          <li class="item-menu">
            <a href="<c:url value="/erp/estadias/checkout" />">
              Efetuar Check-Out
            </a>
          </li>
        </ul>
      </li>

      <c:if test="${sessionScope.usuario.privilegioId == 2 || sessionScope.usuario.privilegioId == 3}">
        <li class="sub-menu">
          <a href="javascript:;" >
            <i class="fa fa-fw fa-lg fa-bar-chart-o"></i>
            <span>
              Relatórios
            </span>
          </a>
          <ul class="sub">
            <li class="item-menu">
              <a href="<c:url value="/erp/relatorios/estadias-encerradas" />">
                Estadias Encerradas (Vendas)
              </a>
            </li>
            <li class="item-menu">
              <a href="<c:url value="/erp/relatorios/estadias-em-progresso" />">
                Estadias em Progresso
              </a>
            </li>
            <li class="item-menu">
              <a href="<c:url value="/erp/relatorios/estadias-agendadas" />">
                Reservas Agendadas
              </a>
            </li>
            <li class="item-menu">
              <a href="<c:url value="/erp/relatorios/estadias-canceladas" />">
                Reservas Canceladas
              </a>
            </li>
          </ul>
        </li>
      </c:if>

      <c:if test="${sessionScope.usuario.privilegioId == 3}">
        <li class="sub-menu">
          <a href="javascript:;" >
            <i class="fa fa-fw fa-lg fa-building"></i>
            <span>
              Unidades
            </span>
          </a>
          <ul class="sub">
            <li class="item-menu">
              <a href="<c:url value="/erp/unidades/adicionar" />">
                Adicionar
              </a>
            </li>
            <li class="item-menu">
              <a href="<c:url value="/erp/unidades/listar" />">
                Listar &amp; Editar
              </a>
            </li>
          </ul>
        </li>
      </c:if>

      <c:if test="${sessionScope.usuario.privilegioId == 2 || sessionScope.usuario.privilegioId == 3}">
        <li class="sub-menu">
          <a href="javascript:;" >
            <i class="fa fa-fw fa-lg fa-tags"></i>
            <span>Quartos</span>
          </a>
          <ul class="sub">
            <li class="item-menu">
              <a href="<c:url value="/erp/quartos/adicionar" />">
                Adicionar
              </a>
            </li>
            <li class="item-menu">
              <a href="<c:url value="/erp/quartos/listar" />">
                Listar &amp; Editar
              </a>
            </li>
          </ul>
        </li>
      </c:if>

      <c:if test="${sessionScope.usuario.privilegioId == 3}">
        <li class="sub-menu">
          <a href="javascript:;" >
            <i class="fa fa-fw fa-lg fa-briefcase"></i>
            <span>Administração</span>
          </a>
          <ul class="sub">
            <li class="item-menu">
              <a href="<c:url value="/erp/usuarios" />">
                Usuários do Sistema
              </a>
            </li>
          </ul>
        </li>
      </c:if>

    </ul>
    <!-- sidebar menu end-->
  </div>
</aside>