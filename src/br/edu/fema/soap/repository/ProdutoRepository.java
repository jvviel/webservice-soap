package br.edu.fema.soap.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.edu.fema.soap.model.Produto;
import br.edu.fema.soap.model.Produtos;
import br.edu.fema.soap.util.JPAUtil;

public class ProdutoRepository implements IProdutoRepository {

	@Override
	public void save(Produto produto) {
		EntityManager em = new JPAUtil().getEntityManager();

		try {

			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();

		} catch (RuntimeException e) {
			throw new RuntimeException("Erro ao salvar Produto.");

		} finally {
			em.close();
		}

	}

	@Override
	public void update(Produto produto, Long id) {

		EntityManager em = new JPAUtil().getEntityManager();

		try {

			em.getTransaction().begin();
			em.find(Produto.class, id);
			em.merge(produto);
			em.getTransaction().commit();

		} catch (RuntimeException e) {
			throw new RuntimeException("Erro ao Atualizar Produto.");

		} finally {
			em.close();
		}

	}

	@Override
	public Produtos listAll() {

		EntityManager em = new JPAUtil().getEntityManager();

		try {

			CriteriaQuery<Produto> query = em.getCriteriaBuilder().createQuery(Produto.class);
			query.select(query.from(Produto.class));

			List<Produto> lista = em.createQuery(query).getResultList();
			Produtos produto = new Produtos();
			produto.setProdutos(lista);
			return produto;

		} catch (RuntimeException e) {
			throw new RuntimeException("Erro ao listar Produto.");

		} finally {
			em.close();
		}
	}

	@Override
	public Produto findById(Long id) {

		EntityManager em = new JPAUtil().getEntityManager();

		try {

			Produto produto = em.find(Produto.class, id);
			return produto;

		} catch (RuntimeException e) {
			throw new RuntimeException("Erro ao buscar o Id do Produto.");

		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();

		try {

			em.getTransaction().begin();
			Produto produto = em.find(Produto.class, id);
			em.remove(produto);
			em.getTransaction().commit();

		} catch (RuntimeException e) {
			throw new RuntimeException("Erro ao remover Produto.");

		} finally {
			em.close();
		}

	}

}
