package ifg.urutai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ifg.urutai.connection.ConnectionFactory;
import ifg.urutai.model.Pessoa;

public class PessoaDAO {
	
	Connection connection;
	public PessoaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Pessoa pessoa) {
		String sql = "INSERT INTO Pessoa (nome,data_nascimento) VALUES (?,?)";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1,pessoa.getNome());
			statement.setDate(2, pessoa.getDataNascimento());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public Pessoa findbyId(int id) {

		String sql = "SELECT * FROM Pessoa WHERE id_pessoa = ?";
		Pessoa pessoa = new Pessoa();
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id_pessoa"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setDataNascimento(rs.getDate("data_nascimento"));
		} catch (SQLException e) {
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		
		return pessoa;
	}

	public void updateNameById(Pessoa pessoa) {
		String sql = "UPDATE Pessoa SET nome = ? WHERE id_pessoa = ?";
		 try(PreparedStatement statement = connection.prepareStatement(sql)){
			 statement.setString(1, pessoa.getNome());
			 statement.setInt(2, pessoa.getId());
			 statement.execute();
		 }catch (SQLException e) {
			 Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		 }
	}

	public void deleteByname (Pessoa pessoa) {
		String sql = "DELETE FROM Pessoa WHERE nome = ?";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, pessoa.getNome());
			statement.execute();
		}catch (SQLException e ) {
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}

	public List<Pessoa> findAll(){
		String sql = "SELECT * FROM Pessoa";
		
		List<Pessoa> list = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Pessoa pessoa = null;
			
			while (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id_pessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setDataNascimento(rs.getDate("data_nascimento"));
				
				list.add(pessoa);
			}
			
		}catch (SQLException e) {
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		return list;
	}
}

