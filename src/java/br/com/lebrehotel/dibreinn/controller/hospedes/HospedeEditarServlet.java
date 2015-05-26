package br.com.lebrehotel.dibreinn.controller.hospedes;

import br.com.lebrehotel.dibreinn.model.email.Email;
import br.com.lebrehotel.dibreinn.model.hospede.Hospede;
import br.com.lebrehotel.dibreinn.model.hospede.HospedeDAO;
import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "HospedeEditarServlet", urlPatterns = {"/erp/hospedes/editar"})
public class HospedeEditarServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    String hospedeParametroURL = request.getParameter("id");

    HospedeDAO hospedeBD = new HospedeDAO();
    Hospede hosp = hospedeBD.getHospedeById(Integer.parseInt(hospedeParametroURL));

    if (hosp != null) {
      request.setAttribute("hospede", hosp);
      RequestDispatcher rd = request.getRequestDispatcher("/erp/hospedes/editar.jsp");
      rd.forward(request, response);
    } else {
      response.sendRedirect("../erro");
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    Hospede h = null;

    try {

      h = new Hospede();
      h.setId(Integer.parseInt(request.getParameter("formId")));
      h.setStatus(1);
      h.setNome(request.getParameter("formNome"));
      h.setSobrenome(request.getParameter("formSobrenome"));
      h.setSexo(request.getParameter("formSexo"));
      h.setRg(request.getParameter("formRg"));
      h.setCpf(request.getParameter("formCpf"));
      h.setTelefone(request.getParameter("formTel"));
      h.setCelular(request.getParameter("formCel"));
      h.setEmail(request.getParameter("formEmail"));
      if (request.getParameter("formNewsletter") != null) {
	h.setNewsletter(Integer.parseInt(request.getParameter("formNewsletter")));
      } else {
	h.setNewsletter(0);
      }
      h.setnCartao(request.getParameter("formCartao"));

      try {

	String hospedeFormDataNasc = request.getParameter("formDataNasc");

	Date dataNasc;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	dataNasc = sdf.parse(hospedeFormDataNasc);

	h.setDataNascimento(dataNasc);

      } catch (ParseException ex) {

	Logger.getLogger(HospedeEditarServlet.class.getName()).log(Level.SEVERE, null, ex);
	System.err.print("[ERRO]\n" + ex);

      }

      HospedeDAO hospedeBD = new HospedeDAO();
      hospedeBD.editarHospede(h);

      response.sendRedirect("../sucesso");

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

  

}
