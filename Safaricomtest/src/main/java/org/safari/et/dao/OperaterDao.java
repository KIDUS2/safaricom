package org.safari.et.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.safari.et.model.Operater;

/**
 * DAO for Operater
 */
@Stateless
public class OperaterDao {
	@PersistenceContext(unitName = "Safaricomtest-persistence-unit")
	private EntityManager em;

	public void create(Operater entity) {
		em.persist(entity);
	}

	public void deleteById(long id) {
		Operater entity = em.find(Operater.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Operater findById(long id) {
		return em.find(Operater.class, id);
	}

	public Operater update(Operater entity) {
		return em.merge(entity);
	}

	public List<Operater> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Operater> findAllQuery = em.createQuery(
				"SELECT DISTINCT o FROM Operater o ORDER BY o.id",
				Operater.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
