package ifg.urutai.model;

public class ItemPedido {
	
	private int idItemPedido;
	private int quantidade;
	private Pedido pedido;
	private Produto produto;
	
	public int getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
