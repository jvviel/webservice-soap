package br.edu.fema.soap.repository;

import br.edu.fema.soap.model.Produto;
import br.edu.fema.soap.model.Produtos;

public interface IProdutoRepository {

	void save(Produto produto);
	void update(Produto produto, Long id);
	Produtos listAll();
	Produto findById(Long id);
	void delete(Long id);
	
}
