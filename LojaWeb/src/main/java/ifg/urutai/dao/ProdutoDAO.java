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
import ifg.urutai.model.Produto;

public class ProdutoDAO {
	
	Connection connection;
	public ProdutoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addProduto(Produto produto) {
		String sql = "INSERT INTO Produto (nome) VALUES (?)";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1,produto.getNome());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,e);
		
	}}

	public Produto findbyIdProduto(int id) {

		String sql = "SELECT * FROM Produto WHERE id_produto = ?";
		Produto produto = new Produto();
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			produto = new Produto();
			produto.setId(rs.getInt("id_produto"));
			produto.setNome(rs.getString("nome"));
		} catch (SQLException e) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		
		return produto;
	}
	
	public void updateNameByIdProduto(Produto produto) {
		String sql = "UPDATE Produto SET nome = ? WHERE id_produto = ?";
		 try(PreparedStatement statement = connection.prepareStatement(sql)){
			 statement.setString(1, produto.getNome());
			 statement.setInt(2, produto.getId());
			 statement.execute();
		 }catch (SQLException e) {
			 Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,e);
		 }
	}

	public List<Produto> findAllProduto(){
		String sql = "SELECT * FROM Produto";
		
		List<Produto> list = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Produto produto = null;
			
			while (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id_produto"));
				produto.setNome(rs.getString("nome"));
				
				list.add(produto);
			}
			
		}catch (SQLException e) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		return list;
	}

	public void deleteByNameProduto (Produto produto) {
		String sql = "DELETE FROM Produto WHERE nome = ?";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, produto.getNome());
			statement.execute();
		}catch (SQLException e ) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
}
