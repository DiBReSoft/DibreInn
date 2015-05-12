package br.com.lebrehotel.dibreinn.controller.pessoas;

import br.com.lebrehotel.dibreinn.controller.emails.EnviarEmail;
import br.com.lebrehotel.dibreinn.model.Email;
import br.com.lebrehotel.dibreinn.model.pessoa.Endereco;
import br.com.lebrehotel.dibreinn.model.pessoa.Funcionario;
import br.com.lebrehotel.dibreinn.model.pessoa.Hospede;
import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import br.com.lebrehotel.dibreinn.model.pessoa.PessoaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @authors jSilverize, Thiago, Ernanni, Luciano
 */
@WebServlet(name = "PessoaCadastrarServlet", urlPatterns = {"/erp/pessoas/cadastrar"})
public class PessoaCadastrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/erp/pessoas/cadastrar.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa p = null;
        boolean resultado = false;

        try {

            //verificando qual tipo de pessoa
            if (request.getParameter("formTipo").equalsIgnoreCase("funcionario")) {

                //criando pessoa tipo funcionario
                p = new Funcionario();

            } else {

                //criando pessoa tipo hospede
                p = new Hospede();

            }
            p.setNome(request.getParameter("formNome"));
            p.setSobrenome(request.getParameter("formSobrenome"));
            p.setSexo(request.getParameter("formSexo"));
            p.setRg(request.getParameter("formRg"));
            p.setCpf(request.getParameter("formCpf"));
            p.setDataNascimento(java.sql.Date.valueOf(request.getParameter("formDataNasc")));
            p.setTelefone(request.getParameter("formTel"));
            p.setEmail(request.getParameter("formEmail"));

            Endereco endereco = new Endereco();
            endereco.setCep((request.getParameter("formCep")));
            endereco.setLogradouro(request.getParameter("formLogradouro"));
            endereco.setNumero(request.getParameter("formNumero"));
            endereco.setComplemento(request.getParameter("formComplemento"));
            endereco.setBairro(request.getParameter("formBairro"));
            endereco.setCidade(request.getParameter("formCidade"));

//      DateFormat formatadorData = new SimpleDateFormat("dd-MM-yyyy");
            // verifico se o objeto é do tipo funcionario, se não for é do tipo hospede
            if (p instanceof Funcionario) {
        // faço um cast de pessoa para funcionario para 
                // acessar os atributos especificos de funcionario
                Funcionario funcionario = (Funcionario) p;
                if (request.getParameter("formOpUsuario").equalsIgnoreCase("1")) {
                    funcionario.setLogin(request.getParameter("formUsuario"));
                    funcionario.setSenha(request.getParameter("formSenha"));
                }
                funcionario.setSalario(Double.parseDouble(request.getParameter("formSalario")));
                funcionario.setDependentes(Integer.parseInt(request.getParameter("formDependentes")));
                funcionario.setDepartamento(request.getParameter("formDepartamento"));
                funcionario.setCargo(request.getParameter("formCargo"));
                funcionario.setUnidade(request.getParameter("formUnidade"));

                //resultado = pessoaDAO.montarQuery(funcionario);
            } else {
        // faço um cast de pessoa para hospede para 
                // acessar os atributos especificos de hospede
                Hospede hospede = (Hospede) p;

                hospede.setnPassaporte(request.getParameter("formPassaporte"));
                hospede.setFoto(request.getParameter("formFoto"));
                hospede.setNacionalidade(request.getParameter("formNacionalidade"));
                hospede.setnCartao(request.getParameter("formCartao"));

            }

            PessoaDAO teste = new PessoaDAO();
            p.setId(teste.cadastrarPessoa(p));

            /* Teste se o resultado do cadastro foi positivo. Se for envia o email.
             if (p.getId() != 0) {
             enviaEmail(p);
             }
             */

            /* 
             * Esse redirecionamento acontecerá após o submit dos dados,
             * levando o usuário para uma página com os dados que acabaram de ser
             * cadastrados
             */
            response.sendRedirect("cadastro?id=" + p.getId());

        } catch (Exception ex) {
            System.out.println(ex);
            response.sendRedirect("erro.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    //Funcão para enviar e-mail a pessoa cadastrada
  private void enviaEmail(Pessoa p) {
        System.out.println("[DADOS GRAVADOS COM SUCESSO] Novo cadastro: " + p.getNome() + " " + p.getSobrenome());
        Email email = new Email();
        email.setDestinatario(p.getEmail());
        email.setAssunto("Cadastro Efetuado");
        email.setMensagem(p.getNome() + ", seja bem-vindo e obrigado por efetuar o cadastro no Lebre Hotel!");
        EnviarEmail envia = new EnviarEmail();
        envia.EnviarEmail(email);
    }


}
