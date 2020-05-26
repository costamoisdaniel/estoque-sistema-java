
public class Transacao {
	int idTransacao = 0;
	String tipoTransacao;
	String nomeProduto;
	int qtdTransacao;
	
	public int getIdTransacao() {
		return idTransacao;
	}
	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public int getQtdTransacao() {
		return qtdTransacao;
	}
	public void setQtdTransacao(int qtdTransacao) {
		this.qtdTransacao = qtdTransacao;
	}
	
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	

}