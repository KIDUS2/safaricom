package org.safari.et.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.safari.et.model.Values;

/**
 * DAO for Values
 */
@Stateless
public class ValuesDao {
	@PersistenceContext(unitName = "Safaricomtest-persistence-unit")
	private EntityManager em;

	public void create(Values entity) {
		em.persist(entity);
	}

	public void deleteById(long id) {
		Values entity = em.find(Values.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Values findById(long id) {
		return em.find(Values.class, id);
	}

	public Values update(Values entity) {
		return em.merge(entity);
	}

	public List<Values> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Values> findAllQuery = em.createQuery(
				"SELECT DISTINCT v FROM Values v ORDER BY v.id", Values.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
