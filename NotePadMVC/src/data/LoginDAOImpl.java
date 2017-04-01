package data;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		
		try {
			
			em.createQuery(query, User.class).setParameter(
					"alias", user.getAlias()).getSingleResult();
			return null;
			
		} catch (NoResultException e) {

			em.persist(user);
			em.flush();
			return user;
			
		}
	}

	@Override
	public User getUserByAliasAndPassword(String alias, String password) {
		
		try {
			String query = "SELECT u FROM User AS u WHERE"
					+ " u.password = :password AND u.alias = :alias";
			User user = em.createQuery(query, User.class).setParameter("password", password)
					.setParameter("alias", alias).getSingleResult();
			
			return user;
		} catch (NoResultException e) {

			return null;
		}
	}

}
