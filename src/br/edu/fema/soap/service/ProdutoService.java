package br.edu.fema.soap.service;

import javax.jws.WebService;

import br.edu.fema.soap.model.Produto;
import br.edu.fema.soap.model.Produtos;
import br.edu.fema.soap.repository.IProdutoRepository;
import br.edu.fema.soap.repository.ProdutoRepository;

@WebService(endpointInterface = "br.edu.fema.soap.service.IProdutoService")
public class ProdutoService implements IProdutoService{

	private IProdutoRepository repository = new ProdutoRepository();

	@Override
	public void save(Produto produto) {
		
		this.repository.save(produto);
		
	}

	@Override
	public void update(Produto produto, Long id) {
		
		this.repository.update(produto, id);
		
	}

	@Override
	public void delete(Long id) {
		
		this.repository.delete(id);
	}

	@Override
	public Produtos findAll() {
		
		return this.repository.listAll();
	}

	@Override
	public Produto findById(Long id) {
		
		return this.repository.findById(id);
	}

}
