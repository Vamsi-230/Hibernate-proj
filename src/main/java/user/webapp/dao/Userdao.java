package user.webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import user.webapp.dto.User;

public class Userdao 
{
	EntityManagerFactory em=Persistence.createEntityManagerFactory("dev");
	EntityManager m=em.createEntityManager();
	
	public User saveUser(User user)
	{
		EntityTransaction et=m.getTransaction();
		m.persist(user);
		et.begin();
		et.commit();
		return user;	
	}
	public User updateUser(User user)
	{
		EntityTransaction et=m.getTransaction();
		m.merge(user);
		et.begin();
		et.commit();
		return user;
	}
	public User getUserById(int id)
	{
		return m.find(User.class, id);
	}
	public boolean deleteUserById(int id)
	{
		User u=getUserById(id);
		if(u!=null)
		{
			EntityTransaction et=m.getTransaction();
			m.remove(u);
			et.begin();
			et.commit();
			return true;
		}
		return false;
	}
	public User verifyUser(long phone,String password)
	{
		String hql="select u from User u where u.phone=?1 and u.password=?2";
		Query q=m.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		List<User> users=q.getResultList();
		if(users.size()>0)
		{
			return users.get(0);
		}
		return null;
	}
	

}
