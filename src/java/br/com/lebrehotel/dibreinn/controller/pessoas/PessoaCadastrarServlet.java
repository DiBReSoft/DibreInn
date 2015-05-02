package br.com.lebrehotel.dibreinn.controller.pessoas;

import br.com.lebrehotel.dibreinn.model.DAO;
import br.com.lebrehotel.dibreinn.model.Email;
import br.com.lebrehotel.dibreinn.model.Funcionario;
import br.com.lebrehotel.dibreinn.model.Hospede;
import br.com.lebrehotel.dibreinn.model.Pessoa;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jSilverize
 */
@WebServlet(name = "PessoaCadastrarServlet", urlPatterns = {"/Cadastrar"})
public class PessoaCadastrarServlet extends HttpServlet {

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    // EXEMPLIFICAÇÃO
    // Essa é uma instância de data que será chamada na tela inicio.jsp
    // a partir da expressão regualar ${valorData}
    Date data = new Date();
    request.setAttribute("valorData", data.toString());

    RequestDispatcher rd = request.getRequestDispatcher("/erp/pessoas/cadastrar.jsp");
    rd.forward(request, response);

  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      Pessoa Pessoa=null;
      boolean resultado=false;
       try{
    if(request.getParameter("formTipo").equalsIgnoreCase("funcionario"))//verificando qual tipo de pessoa
     Pessoa = new Funcionario();//criando pessoa tipo funcionario
    else
      Pessoa = new Hospede();//criando pessoa tipo hospede
    
      Pessoa.setNome(request.getParameter("formNome"));
      Pessoa.setSobrenome(request.getParameter("formSobrenome"));
      Pessoa.setCpf(Integer.parseInt(request.getParameter("formCpf")));
      Pessoa.setRg(request.getParameter("formRg"));
      Pessoa.setEmail(request.getParameter("formEmail"));
      Pessoa.setCep(Integer.parseInt(request.getParameter("formCep")));
      Pessoa.setBairro(request.getParameter("formBairro"));
      Pessoa.setLogradouro(request.getParameter("formLogradouro"));
      Pessoa.setCidade(request.getParameter("formCidade"));
      Pessoa.setComplemento(request.getParameter("formComplemento"));
      Pessoa.setNumero(Integer.parseInt(request.getParameter("formCidade")));
      Pessoa.setSexo(request.getParameter("formSexo"));
      
      DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
      
      Pessoa.setDataNascimento(formatadorData.parse((request.getParameter("Form"))));
      Pessoa.setTelefone(Integer.parseInt(request.getParameter("formSexo")));
      DAO cmd = new DAO();
      
          if(Pessoa instanceof Funcionario){//verifico se o objeto é do tipo funcionario, se não for é do tipo hospede
                
              Funcionario  funcionario = (Funcionario)Pessoa;//faço um cast de pessoa para funcionario para 
                //acessar os atributos especificos de funcionario
                
                funcionario.setSalario(Double.parseDouble(request.getParameter("formSalario")));
                funcionario.setDependentes(Integer.parseInt(request.getParameter("formDependentes")));
                funcionario.setDepartamento(request.getParameter("formDepartamento"));
                funcionario.setCargo(request.getParameter("formCargo"));
                funcionario.setUnidade(Integer.parseInt(request.getParameter("formUnidade")));
              //resultado = cmd.ExecutaSQL(null, null);
          }else{
                
              Hospede  hospede = (Hospede)Pessoa;//faço um cast de pessoa para hospede para 
                //acessar os atributos especificos de hospede
              
               
                hospede.setnPassaporte(Integer.parseInt(request.getParameter("formNpassaporte")));
                hospede.setFoto(request.getParameter("formFoto"));
                hospede.setNacionalidade(request.getParameter("formNacionalidade"));
                hospede.setnCartao(request.getParameter("formNcartao"));
                 //resultado = cmd.ExecutaSQL(null, null);
              
          }
           }catch(ParseException ex){
               System.out.println(ex);
           }
       
       if(resultado==true){
                System.out.println("Dados Gravados com Sucesso");
                Email email = new Email();
                email.setAssunto("Cadastro Efetuado");
                email.setMensagem(Pessoa.getNome()+" Obrigado por efetuar o cadastro no LebreHotel.");
                email.setDestinatario(Pessoa.getEmail());
       }else{
                     System.out.println("Não foi possivel Gravar as informações");
       }
       //response.sendRedirect("resultado.jsp");
 

  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
