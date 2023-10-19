package ifg.urutai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ifg.urutai.connection.ConnectionFactory;
import ifg.urutai.model.Pedido;
import ifg.urutai.model.Pessoa;
import ifg.urutai.model.Produto;

public class PedidoDAO {
	Connection connection;
	public PedidoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Pedido pedido) {
		String sql = "INSERT INTO Pedido (data,id_pessoa) VALUES (?,?)";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setDate(1, pedido.getDataPedido());
			statement.setInt(2, pedido.getPessoa().getId());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public Pedido findbyIdPedido(int id) {

		String sql = "SELECT * FROM Pedido WHERE id_pedido = ?";
		Pedido pedido = new Pedido();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			pedido = new Pedido();
			pedido.setId(rs.getInt("id_pedido"));
			pedido.setDataPedido(rs.getDate("data"));
			
			int id_pessoa = rs.getInt("id_pessoa");
			Pessoa pessoa = pessoaDAO.findbyId(id_pessoa);
			pedido.setPessoa(pessoa);
			
		} catch (SQLException e) {
			Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		
		return pedido;
	}
	
	public void updateDataById(Pedido pedido) {
		String sql = "UPDATE Pedido SET data = ? WHERE id_pedido = ? ";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setDate(1, pedido.getDataPedido());
			statement.setInt(2, pedido.getId());
			statement.execute();
		} catch (SQLException e) {
			Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public void deleteById(Pedido pedido)  {
		String sql = "DELETE FROM Pedido WHERE id_pedido = ? ";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, pedido.getId());
			statement.execute();
		}
	 catch (SQLException e) {
		Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
	}
	}

	public List<Pedido> findByAll() {
		String sql = "SELECT * FROM Pedido";
		
		List<Pedido> list = new ArrayList<>();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Pedido pedido = null;
			
			while (rs.next()) {
				pedido = new Pedido();
				pedido.setId(rs.getInt("id_pedido"));
				pedido.setDataPedido(rs.getDate("data"));
				int id_pedido = rs.getInt("id_pessoa");
				
				Pessoa pessoa = pessoaDAO.findbyId(id_pedido);
				
				pedido.setPessoa(pessoa);
				list.add(pedido);
			}
			
		} catch (Exception e) {
			Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		return list;
		
	}
}
