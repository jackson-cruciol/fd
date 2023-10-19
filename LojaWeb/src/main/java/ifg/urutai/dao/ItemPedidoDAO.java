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
import ifg.urutai.model.ItemPedido;
import ifg.urutai.model.Pedido;
import ifg.urutai.model.Pessoa;
import ifg.urutai.model.Produto;

public class ItemPedidoDAO {
	
	Connection connection;
	public ItemPedidoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(ItemPedido itemPedido) {
		String sql = "INSERT INTO Item_Pedido (quantidade,id_pedido,id_produto) VALUES (?,?,?)";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, itemPedido.getQuantidade());
			statement.setInt(2, itemPedido.getPedido().getId());
			statement.setInt(3, itemPedido.getProduto().getId());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public ItemPedido findbyIdItemPedido(int id) {

		String sql = "SELECT * FROM Item_Pedido WHERE id_item_pedido = ?";
		ItemPedido itemPedido = new ItemPedido();
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			itemPedido = new ItemPedido();
			itemPedido.setIdItemPedido(rs.getInt("id_item_pedido"));
			itemPedido.setQuantidade(rs.getInt("quantidade"));
			
			int id_pedido = rs.getInt("id_pedido");
			Pedido pedido = pedidoDAO.findbyIdPedido(id_pedido);
			itemPedido.setPedido(pedido);
			
			int id_produto = rs.getInt("id_produto");
			Produto produto = produtoDAO.findbyIdProduto(id_produto);
			itemPedido.setProduto(produto);
			
		} catch (SQLException e) {
			Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		
		return itemPedido;
	}
	
	public void updateAmountById(ItemPedido itemPedido) {
		String sql = "UPDATE Item_Pedido SET quantidade = ? WHERE id_item_pedido = ? ";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, itemPedido.getQuantidade());
			statement.setInt(2, itemPedido.getIdItemPedido());
			statement.execute();
		} catch (SQLException e) {
			Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public void deleteByIdItemPedido(ItemPedido itemPedido)  {
		String sql = "DELETE FROM Item_Pedido WHERE id_item_pedido = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, itemPedido.getIdItemPedido());
			statement.execute();
		}
	 catch (SQLException e) {
		Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE,null,e);
	}
	}
	
	public List<ItemPedido> findByAll() {
		String sql = "SELECT * FROM Item_Pedido";
		
		List<ItemPedido> list = new ArrayList<>();
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			ResultSet rs = statement.getResultSet();
			ItemPedido itemPedido = null;
			
			while (rs.next()) {
				itemPedido = new ItemPedido();
				itemPedido.setIdItemPedido(rs.getInt("id_item_pedido"));
				itemPedido.setQuantidade(rs.getInt("quantidade"));
				int id_item_pedido = rs.getInt("id_pedido");
				int id_item_produto = rs.getInt("id_produto");
				
				Pedido pedido = pedidoDAO.findbyIdPedido(id_item_pedido);
				Produto produto = produtoDAO.findbyIdProduto(id_item_produto);
				
				itemPedido.setPedido(pedido);
				itemPedido.setProduto(produto);
				list.add(itemPedido);
			}
			
		} catch (Exception e) {
			Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		return list;
		
	}
}
