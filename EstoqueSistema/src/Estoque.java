
import java.util.ArrayList;
import java.util.List;


public class Estoque {
	List<Transacao> listTransacao = new ArrayList<Transacao>();
	List<Produto> listProduto = new ArrayList<Produto>();
	int idProduto;
	int idTransacao;

	public void setProduto(Produto novoProduto) {
		this.listProduto.add(novoProduto);
	}
	
	public String listarProdutos() {
		String listaAux = "";
		for (int i=0; i<listProduto.size(); i++) {
			listaAux = listaAux+listProduto.get(i).getIdProduto() + " - " + listProduto.get(i).getNomeProduto() + " - " + listProduto.get(i).getQtdProduto() + "\n";
			System.out.println("");
		}
		System.out.println("");
		System.out.println("-------------------------------QTD. ESTOQUE-------------------------------");
		System.out.println(listaAux);
		return listaAux;
	}
	
	public String fluxoEstoque() {
		String fluxo = "";
		for(int i=0; i<listTransacao.size(); i++) {
			fluxo = fluxo + listTransacao.get(i).getIdTransacao( )+ " - " + listTransacao.get(i).getTipoTransacao() + " - " +  listTransacao.get(i).getQtdTransacao() + " QUANTIDADES DO PRODUTO: " + listTransacao.get(i).getNomeProduto() + "\n";
		}
		System.out.println("");
		System.out.println("-----------------------------FLUXO DE ESTOQUE-----------------------------");
		System.out.println(fluxo);
		return fluxo;
	}
	
	public String historicoProduto(String fluxoProduto) {
		String historico = "";
		Produto produtoFluxo = buscarProduto(fluxoProduto);
		if (produtoFluxo !=null) {
		for(Transacao transacao:listTransacao) {
			  if (transacao.getNomeProduto().equals(fluxoProduto)) {
				  historico = historico + transacao.getIdTransacao() + " - " + transacao.getTipoTransacao() + " - " + transacao.getQtdTransacao()+" QUANTIDADES DE " + transacao.getNomeProduto() + "\n";
			  }
		}
		System.out.println("");
		System.out.println("-------------------HISTÒRICO - " + fluxoProduto + "-------------------");
		System.out.println(historico);
		}
		else {
			System.out.println("");
			System.out.println("Ops! O produto " + fluxoProduto + " não encontra-se cadastrado.");
		}
		return historico;
	}
	
	public Produto buscarProduto(String buscarProduto) {
		Produto produtoBuscado;
		for (int i=0; i<listProduto.size(); i++) {
			if (listProduto.get(i).getNomeProduto().equals(buscarProduto)) {
				produtoBuscado = listProduto.get(i);
				return produtoBuscado;
			}
		}
		return null;
	}
	
	public int existirProduto (String nomeProduto) {
		int indexProduto = 0;
		for (Produto produto:listProduto) {
			if (produto.getNomeProduto().toLowerCase().equals(nomeProduto.toLowerCase())) {
				indexProduto = listProduto.indexOf(produto);
			}
		}
		return indexProduto;
	}

	public void cadastrarProduto(String nomeProduto, int qtdProduto) {
		Produto produtoBuscado = buscarProduto(nomeProduto);	
		
		if (produtoBuscado == null) {
			Produto novoProduto = new Produto();
			idProduto++;
			novoProduto.setQtdProduto(qtdProduto);
			novoProduto.setIdProduto(idProduto);
			setProduto(novoProduto);
			System.out.println("");
			System.out.println("Produto cadastrado com sucesso!");	
		}
		else {
			System.out.println("");
			System.out.println("Ops! o produto " + nomeProduto + " já encontra-se disponível.");
		}
	} 

	public void alterarProduto (String antigoProduto, String novoProduto) {
		Produto produtoAltera = buscarProduto(antigoProduto);
		 if (produtoAltera != null) {
		     Produto produtoAlterado = buscarProduto(novoProduto);
		     if (produtoAlterado == null) {
		    	 int n = existirProduto(antigoProduto);
		    	 listProduto.get(n).setNomeProduto(novoProduto);
		    	 System.out.println("");
		    	 System.out.println("Produto alterado com sucesso!");
		     }
		     else {
		    	 System.out.println("");
		    	 System.out.println("Ops! O produto " + novoProduto + " já encontra-se disponível.");
			 }
			 }
		 else {
		  	 System.out.println("");
			 System.out.println("Ops! O produto " + antigoProduto + " não encontra-se cadastrado.");
		}
	}
	
	public void excluirProduto(String excluiProduto) {
		Produto produtoExclui = buscarProduto(excluiProduto);
		if (produtoExclui != null) {
			int nExc = existirProduto(excluiProduto); 
			listProduto.remove(nExc);
			System.out.println("");
			System.out.println("Produto " + excluiProduto + " removido com sucesso!");
		}
		else {
			System.out.println("");
	    	System.out.println("Ops! O produto " + excluiProduto + " não encontra-se cadastrado.");
		}
	}	
	
	public void aumentarEstoque (String aumentaProduto, int qtdAddProduto) {
		Produto produtoAumenta = buscarProduto(aumentaProduto);
		if (produtoAumenta !=null) {
			int nAdd = existirProduto(aumentaProduto);
			int qtdNovaProduto = listProduto.get(nAdd).getQtdProduto() + qtdAddProduto;
			listProduto.get(nAdd).setQtdProduto(qtdNovaProduto);
			System.out.println("");
			System.out.println("Quantidade adicionada com sucesso!");
			adicionarTransacao("ENTRADA", aumentaProduto, qtdAddProduto);
		}	
		else {
			System.out.println("");
			System.out.println("Ops! O produto " + aumentaProduto + " não encontra-se cadastrado.");
		}
		
	}
	
	public void diminuirEstoque (String diminuiProduto, int qtdRemProduto) {
		Produto produtoReduz = buscarProduto(diminuiProduto);
		if (produtoReduz != null) {
				int nRem = existirProduto(diminuiProduto);
				int qtdNovaProduto;
				qtdNovaProduto = listProduto.get(nRem).getQtdProduto() - qtdRemProduto;
				if (qtdNovaProduto<0) {
					System.out.println("");
					System.out.println("Ops! O estoque não possui quantidade suficiente do produto " + diminuiProduto + ".");
					}
				else {
					listProduto.get(existirProduto(diminuiProduto)).setQtdProduto(qtdNovaProduto);
					System.out.println("");
					System.out.println("Quantidade removida com sucesso!");
					adicionarTransacao("SAÍDA", diminuiProduto, qtdRemProduto);
				}
		}
		else {
			System.out.println("");
			System.out.println("Ops! O produto " + diminuiProduto + " não encontra-se cadastrado.");
		}
		
	}
	
	public void adicionarTransacao(String tipoT, String nomeProduto, int qtdProduto) {
		Transacao transacao = new Transacao();
		idTransacao++;
		transacao.setNomeProduto(nomeProduto);
		transacao.setIdTransacao(idTransacao);
		transacao.setQtdTransacao(qtdProduto);
		transacao.setTipoTransacao(tipoT);
		listTransacao.add(transacao);
	}	
	
	public List<Transacao> getListTransacao() {
		return listTransacao;
	}
	
	public void setListTransacao(List<Transacao> listTransacao) {
		this.listTransacao = listTransacao;
	}
	
	public List<Produto> getListProduto() {
		return listProduto;
	}
	
	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public int getIdTransacao() {
		return idTransacao;
	}
	
	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}
		
}