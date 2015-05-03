package br.com.lebrehotel.dibreinn.model;

/**
 *
 * @author Fabio Ernanni data: 05/04/15 essa classe tem como finalidade definir
 * os atributos de Reserva
 */
import br.com.lebrehotel.dibreinn.model.pessoa.Hospede;
import br.com.lebrehotel.dibreinn.model.pessoa.Funcionario;
import java.util.Date;

public class Reserva {
    private int id;
    private int idUnidade;
    private int idFuncionario;
    private int idHospede;
    private int idQuarto;
    private int idPedido;
    private Date checkIn;
    private Date checkOut;
    
    public Reserva(){
        
    }
    
    public boolean abrirReserva(Reserva reserva, Quarto quarto, Hospede hospede, Funcionario funcionario){
        this.idFuncionario = funcionario.getId();
        this.idHospede = hospede.getId();
        this.idQuarto = quarto.getId();
        this.checkIn = reserva.checkIn;
        return true;
    }
    public boolean fecharReserva(Reserva reserva, Pedido pedido){
        if (!pedido.isPago()){
            return false;
        }else{
        this.checkOut = reserva.checkOut;
        return true;
        }
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdUnidade() {
        return idUnidade;
    }
    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdHospede() {
        return idHospede;
    }
    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }

    public int getIdQuarto() {
        return idQuarto;
    }
    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
