package helper;

import factory.DatabaseConnection;
import modal.Aluno;
import java.sql.*;

public class HelperDB {

    private static HelperDB instance = null;

    private HelperDB() {

    }

    public static HelperDB getInstance() {

        if (instance == null)
            instance = new HelperDB();
        return instance;
    }

    public void criarAluno(Aluno aluno) {
        PreparedStatement cmdSQL;

        try {
            cmdSQL = DatabaseConnection.getInstance().preparedStatement(
                    "insert into aluno values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            cmdSQL.setString(1, aluno.getNome());
            cmdSQL.setString(2, aluno.getCurso());
            cmdSQL.setString(3, aluno.getCpf());
            cmdSQL.setString(4, aluno.getMatricula());
            cmdSQL.executeUpdate();
            cmdSQL.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public String buscaAluno(String cpf) {
        String sql = "SELECT * FROM aluno WHERE cpf = '" + cpf + "';";
        Connection connection = DatabaseConnection.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("nome") + "\n" +
                        rs.getString("curso") + "\n" +
                        rs.getString("cpf") + "\n" +
                        rs.getString("matricula");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void atualizaAluno(String cpf, String nome, String curso) {
        PreparedStatement cmdSQL;

        try {
            cmdSQL = DatabaseConnection.getInstance().preparedStatement(
                    "update aluno set nome = ?, curso = ? where cpf = ?", Statement.RETURN_GENERATED_KEYS
            );
            cmdSQL.setString(1, nome);
            cmdSQL.setString(2, curso);
            cmdSQL.setString(3, cpf);
            cmdSQL.executeUpdate();
            cmdSQL.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deletarAluno(String cpf) {
        PreparedStatement cmdSQL;

        try {
            cmdSQL = DatabaseConnection.getInstance().preparedStatement(
                    "delete from aluno where cpf = ?", Statement.RETURN_GENERATED_KEYS
            );
            cmdSQL.setString(1, cpf);
            cmdSQL.execute();
            cmdSQL.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
