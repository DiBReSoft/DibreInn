package br.com.lebrehotel.dibreinn.model.funcionario;

/**
 *
 * @author jSilverize data: 02/05/2015
 */
import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {

    public int cadastrarFuncionario(Funcionario f) {

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

//    int codPessoa;
//    String sqlConsulta = "SELECT max(ID_PESSOA) as ID_PESSOA FROM TB_PESSOA";
        String sqlInsert = " INSERT INTO TB_PESSOA (NOME, STATUS, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, NEWSLETTER) VALUES (?, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?) \n ";

        sqlInsert += " DECLARE @IdCliente AS INT = @@IDENTITY \n";//pega o id_pessoa da transação

        sqlInsert += " INSERT INTO TB_FUNCIONARIO (ID_PESSOA,ID_UNIDADE,ID_PRIVILEGIO,SENHA) VALUES (@IdCliente,?,?,?) \n ";

        try {
            conexao.openConection();
            stmt = conexao.conn.prepareStatement(sqlInsert);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getSobrenome());
            stmt.setString(3, f.getSexo());
            stmt.setString(4, f.getRg());
            stmt.setString(5, f.getCpf());
            
            java.sql.Date sqlDataNasc = new java.sql.Date(f.getDataNascimento().getTime());
            stmt.setDate(6, sqlDataNasc);
            
            stmt.setString(7, f.getTelefone());
            stmt.setString(8, f.getCelular());
            stmt.setString(9, f.getEmail());
            stmt.setInt(10, f.getNewsletter());

            stmt.setInt(11, f.getUnidade());
            stmt.setInt(12, f.getPrivilegio());
            stmt.setString(13, f.getSenha());
            stmt.executeUpdate();

            System.out.println("[INFO] Funcionario " + f.getNome() + " " + f.getSobrenome() + " Cadastrado com sucesso.");

//      System.out.println("Bucando o id da pessoa cadastrada...");
//      conexao.executaSQL(sqlConsulta);
//      conexao.rs.next();
//      codPessoa = conexao.rs.getInt("ID_PESSOA");
//      System.out.println("Id encontrado!!");
//      System.out.println("Id: " + codPessoa + "\n");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao.conn != null) {
                try {
                    conexao.conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 1;
    }

    public List<Funcionario> buscarFuncionario(String pesquisa, int tipoBusca) {
        ResultSet rs = null;

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        List<Funcionario> lista = new ArrayList<>();

        String Query = "SELECT STATUS, TB_PESSOA.ID_PESSOA,NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, NEWSLETTER \n"
                + "FROM TB_PESSOA "
                + "INNER JOIN TB_FUNCIONARIO on TB_FUNCIONARIO.ID_PESSOA = TB_PESSOA.ID_PESSOA \n"
                + " WHERE ";

        switch (tipoBusca) {
            case 1:
                Query += "NOME = ?";
                break;
            case 2:
                Query += "EMAIL = ?";
                break;
            case 3:
                Query += "CPF = ?";
                break;
            case 4:
                Query += "TB_PESSOA.ID_PESSOA = ?";
                break;
        }
        try {
            conexao.openConection();

            stmt = conexao.conn.prepareStatement(Query);

            stmt.setString(1, pesquisa);

            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {

                Funcionario p = new Funcionario();

                p.setStatus(resultados.getInt("STATUS"));
                p.setId(resultados.getInt("ID_PESSOA"));
                p.setNome(resultados.getString("NOME"));
                p.setSobrenome(resultados.getString("SOBRENOME"));
                p.setSexo(resultados.getString("SEXO"));
                p.setRg(resultados.getString("RG"));
                p.setCpf(resultados.getString("CPF"));
                p.setDataNascimento(resultados.getDate("DATANASC"));
                p.setTelefone(resultados.getString("TELEFONE"));
                p.setCelular(resultados.getString("CEL"));
                p.setEmail(resultados.getString("EMAIL"));
                p.setNewsletter(resultados.getInt("NEWSLETTER"));

                lista.add(p);

            }

            return lista;
        } catch (SQLException ex) {
            // Caso haja erro retorna 0 como ID e informa no log
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao buscar dados: ", ex);

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao != null) {
                conexao.closeConection();
            }
        }
        return null;
    }

    public int editarFuncionario(Funcionario f) {

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        String sql = "UPDATE TB_PESSOA SET STATUS = ?, NOME = ?, SOBRENOME = ?, "
                + "SEXO = ?, RG = ?, CPF = ?, DATANASC = ?, TELEFONE = ?, CEL = ?, EMAIL = ?, NEWSLETTER = ? \n"
                + "WHERE ID_PESSOA = ? \n";

        sql += " UPDATE TB_FUNCIONARIO SET ID_UNIDADE = ?,ID_PRIVILEGIO = ? WHERE ID_PESSOA = ?";

        try {
            conexao.openConection();
            stmt = conexao.conn.prepareStatement(sql);

            stmt.setInt(1, f.getStatus());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getSobrenome());
            stmt.setString(4, f.getSexo());
            stmt.setString(5, f.getRg());
            stmt.setString(6, f.getCpf());

            java.sql.Date sqlDataNasc = new java.sql.Date(f.getDataNascimento().getTime());
            stmt.setDate(7, sqlDataNasc);

            stmt.setString(8, f.getTelefone());
            stmt.setString(9, f.getCelular());
            stmt.setString(10, f.getEmail());
            stmt.setInt(11, f.getNewsletter());
            stmt.setInt(12, f.getId());

            stmt.setInt(13, f.getUnidade());
            stmt.setInt(14, f.getPrivilegio());
            stmt.setInt(15, f.getId());

            stmt.executeUpdate();
            System.out.println("Dados Alterados com sucesso!!!");

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao alterar os dados");
            return 0;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao.conn != null) {
                try {
                    conexao.conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 1;
    }

    public Funcionario getFuncionarioById(int id) throws ParseException {

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;
        String query;
        Funcionario func = new Funcionario();

        query = "SELECT P.STATUS, P.ID_PESSOA, P.NOME, P.SOBRENOME, P.SEXO, P.RG, CPF, P.DATANASC, P.TELEFONE, P.CEL, P.EMAIL, P.NEWSLETTER, "
        + "F.ID_UNIDADE, F.ID_PRIVILEGIO "
        + "FROM TB_FUNCIONARIO AS F "
        + "JOIN TB_PESSOA AS P ON P.ID_PESSOA = F.ID_PESSOA "
        + "WHERE F.ID_PESSOA = ?";

        try {
            conexao.openConection();
            stmt = conexao.conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            result.next();

            func.setStatus(result.getInt("STATUS"));
            func.setId(result.getInt("ID_PESSOA"));
            func.setNome(result.getString("NOME"));
            func.setSobrenome(result.getString("SOBRENOME"));
            func.setSexo(result.getString("SEXO"));
            func.setRg(result.getString("RG"));
            func.setCpf(result.getString("CPF"));
//               Date funcionarioFormDataNasc = result.getDate("DATANASC");
///
          func.setDataNascimento(result.getDate("DATANASC"));
            func.setTelefone(result.getString("TELEFONE"));
            func.setCelular(result.getString("CEL"));
            func.setEmail(result.getString("EMAIL"));
            func.setNewsletter(result.getInt("NEWSLETTER"));
            func.setUnidade(result.getInt("ID_UNIDADE"));
            func.setPrivilegio(result.getInt("ID_PRIVILEGIO"));

            System.out.println("Dados de funcionario populados com sucesso");
            conexao.closeConection();

        } catch (SQLException ex) {
            // Caso haja erro 
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao popular os dados de funcionario: ", ex);
            conexao.closeConection();
        }

        return func;

    }

    public int consultarIdPessoa(String cpf) {
        int idPessoa;
        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;
        String consultaCpf = "SELECT ID_PESSOA FROM TB_PESSOA WHERE CPF=" + cpf;

        try {
            conexao.openConection();
            stmt = conexao.conn.prepareStatement(consultaCpf);
            ResultSet result = stmt.executeQuery();
            result.next();
            idPessoa = result.getInt("ID_PESSOA");
            System.out.println("ID encontrado com sucesso!");
            conexao.closeConection();
            return idPessoa;

        } catch (SQLException ex) {
            conexao.closeConection();
            System.out.println("Erro ao retornar o id: " + ex);
            return 0;
        }

    }

    public int deletarPessoa(int id, String tipo) {

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;
        String query = "DELETE FROM TB_PESSOA WHERE ID_PESSOA = ? \n";
        if (tipo.equalsIgnoreCase("f")) {
            query += " DELETE FROM TB_FUNCIONARIO WHERE ID_PESSOA = ?";
        } else {
            query += " DELETE FROM TB_HOSPEDE WHERE ID_PESSOA = ?";
        }

        try {
            conexao.openConection();
            stmt = conexao.conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeQuery();
            System.out.println("deletado com sucesso!");
            conexao.closeConection();
            return 1;

        } catch (SQLException ex) {
            conexao.closeConection();
            System.out.println("Erro ao retornar o id: " + ex);
            return 0;
        }
    }

}
