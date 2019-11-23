package br.edu.fema.soap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.edu.fema.soap.model.Produto;
import br.edu.fema.soap.service.IProdutoService;

public class MainClient {

	public static void main(String args[]) throws Exception {
	    URL url = new URL("http://127.0.0.1:9876/prod?wsdl");
	    QName qname = new QName("http://service.soap.fema.edu.br/","ProdutoServiceService");
	    Service ws = Service.create(url, qname);
	    IProdutoService prod = ws.getPort(IProdutoService.class);
	 
//	    Produto produto = new Produto();
//	    produto.setId(3L);
//	    produto.setDescricao("Bolacha da boa");
//	    produto.setQuantidade(2);
//	    produto.setPeso("700g");
//	    produto.setUnidadeMedida("G");
//	    
//	    prod.update(produto, 3L);
	    
//	    Produtos produtos = prod.findAll();
//	    produtos.getProdutos().forEach(produto -> {
//	    	System.out.println(produto.getDescricao());
//	    });
	    
//	    Produto produto = prod.findById(3L);
//	    System.out.println(produto.getDescricao());
	    
	    prod.delete(3L);
	 
	  }
}
