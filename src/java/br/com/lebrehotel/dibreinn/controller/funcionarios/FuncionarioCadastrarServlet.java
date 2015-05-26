package br.com.lebrehotel.dibreinn.controller.funcionarios;

import br.com.lebrehotel.dibreinn.model.email.Email;
import br.com.lebrehotel.dibreinn.model.funcionario.Funcionario;
import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import br.com.lebrehotel.dibreinn.model.funcionario.FuncionarioDAO;
import br.com.lebrehotel.dibreinn.model.privilegio.PrivilegioDAO;
import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@WebServlet(name = "FuncionarioCadastrarServlet", urlPatterns = {"/erp/funcionarios/cadastrar"})
public class FuncionarioCadastrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // buscando apenas os Unidades
        UnidadeDAO consulta = new UnidadeDAO();
        request.setAttribute("lista", consulta.listarUnidades());

        PrivilegioDAO privilegioDB = new PrivilegioDAO();
        request.setAttribute("listaPrivilegios", privilegioDB.listarPrivilegios());

        RequestDispatcher rd = request.getRequestDispatcher("/erp/funcionarios/cadastrar.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Funcionario f = null;

        try {

            f = new Funcionario();
            f.setStatus(1);
            f.setNome(request.getParameter("formNome"));
            f.setSobrenome(request.getParameter("formSobrenome"));
            f.setSexo(request.getParameter("formSexo"));
            f.setRg(request.getParameter("formRg"));
            f.setCpf(request.getParameter("formCpf"));
            f.setDataNascimento(java.sql.Date.valueOf(request.getParameter("formDataNasc")));
            f.setTelefone(request.getParameter("formTel"));
            f.setCelular(request.getParameter("formCel"));
            f.setEmail(request.getParameter("formEmail"));

            if (request.getParameter("formNewsletter") != null) {
                f.setNewsletter(Integer.parseInt(request.getParameter("formNewsletter")));
            } else {
                f.setNewsletter(0);
            }

            if (request.getParameter("formOpUsuario").equals("1")) {
                f.setLogin(request.getParameter("formEmail"));
                f.setSenha(request.getParameter("formSenha"));
            } else {
                f.setLogin(null);
                f.setSenha(null);
            }
            f.setDepartamento(request.getParameter("formPrivilegio"));
            f.setUnidade(Integer.parseInt(request.getParameter("formUnidade")));

            FuncionarioDAO pessoaBD = new FuncionarioDAO();

            f.setId(pessoaBD.cadastrarFuncionario(f));

            if (f.getId() != 0) {
                montaEmail(f);
                response.sendRedirect("../sucesso");

            } else {

                response.sendRedirect("../erro");

            }

        } catch (Exception ex) {

            System.out.println(ex);

            response.sendRedirect("../erro");

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

    private void montaEmail(Pessoa p) {
        System.out.println("[DADOS GRAVADOS COM SUCESSO] Novo cadastro: " + p.getNome() + " " + p.getSobrenome());
        Email email = new Email();
        email.setDestinatario(p.getEmail());
        email.setAssunto("Cadastro Efetuado");
        email.setMensagem(p.getNome() + ", seja bem-vindo(a) e obrigado por efetuar o cadastro no Lebre Hotel!");
        //EnviarEmail envia = new EnviarEmail();
        EnviarEmail(email);
    }

    public void EnviarEmail(Email email) {

        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("lebrehotel@gmail.com", "senac123");
                    }
                });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);

            // Remetente
            message.setFrom(new InternetAddress("lebrehotel@gmail.com"));

            // Destinatário(s)
            String destinos = "";
            for (String destinatario : email.getDestinatario()) {
                destinos += ", " + destinatario;
            }
            Address[] toUser = InternetAddress.parse("lebrehotel@gmail.com,fabioernanni@hotmail.com,elvitous@gmail.com,lucianolourencoti@gmail.com" + destinos);
            message.setRecipients(Message.RecipientType.TO, toUser);

            // Assunto
            message.setSubject(email.getAssunto());

            // Montar corpo da mensagem
            message.setText(email.getMensagem());

            // Método para enviar a mensagem criada
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
