package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.User;

@Transactional
@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public User showUser(int id) {

		return em.find(User.class, id);
	}

	@Override
	public User createNewUser(User user) {
		
		String query = "SELECT u FROM User AS u WHERE u.alias = :alias";
		
		User aliasExists = em.createQuery(query, User.class).setParameter(
				"alias", user.getAlias()).getSingleResult();
		
		if (aliasExists == null) {
			em.getTransaction().begin();
			em.persist(user);
			em.flush();
			em.getTransaction().commit();
			return user;
		}	else {
			return null;
		}
	}

	@Override
	public User getUserByAliasAndPassword(String alias, String password) {
		
		String query = "SELECT u FROM User AS u WHERE"
				+ " u.password = :password AND u.alias = :alias";
		User user = em.createQuery(query, User.class).setParameter("password", password)
				.setParameter("alias", alias).getSingleResult();
		
		return user;
	}

}
