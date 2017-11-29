package com.chatapp.dao;




import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatapp.model.Users;
@Transactional
@Repository("usersDao")
public class UsersDaoImpl implements UsersDao{
@Autowired
SessionFactory sessionFactory;
	public boolean registerUser(Users user) {
		try{
		  user.setRole("ROLE_USER");
		  sessionFactory.getCurrentSession().save(user);
		  return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	

	public List<Users> listUsers() {
		Session session=sessionFactory.getCurrentSession();
		
		  List<Users> list=session.createCriteria(Users.class).list();
		
		return list;
	}
	public int validateUser(String name, String password) {
		int res=0;
		Session session=sessionFactory.getCurrentSession();
		Query result=session.createQuery("from Users u where u.name='"+name+"'");
		 
		List<Users> users=result.list();
		
		System.out.println("users:"+users);
	if(users.size()==0)
	{
		res=0;
	}
	else
	{
		for(int i=0;i<users.size();i++)
		{
			System.out.println("inside for loop");
			String dbname=users.get(i).getName();
			String dbpassword=users.get(i).getPassword();
			String dbrole=users.get(i).getRole();
			if(dbname.equals(name)&&dbpassword.equals(password)&&dbrole.equals("ROLE_USER"))
			{
				
				
				
			String query1 = "UPDATE friend SET IsOnline = '"+ "online" +"' WHERE friendname = '"+ name + "'";

			SQLQuery sqlquery= 	 session.createSQLQuery(query1);
			sqlquery.executeUpdate();
				 res=1;
				System.out.println("the result is:"+res);
			}
			else
				if(dbname.equals(name)&&dbpassword.equals(password)&&dbrole.equals("ROLE_ADMIN"))
			{
				res=2;
				System.out.println("the result  is:"+res);
			}
			}
	}	
	return res;
	}
	public List<Users> findFriends(String name) {
		Session session=sessionFactory.getCurrentSession();
		
		  Criteria ct=session.createCriteria(Users.class);
		 
    ct.add(Restrictions.ne("name",name));
	ct.add(Restrictions.eq("role","ROLE_USER"));
	
	List list=ct.list();
		return list;
	}



	public void updateUsers(Users users) {
		sessionFactory.getCurrentSession().update(users);
		
	}



	



	public void logout(String name) {
		Session session=sessionFactory.getCurrentSession();
		
		String query1 = "UPDATE friend SET IsOnline = '"+ "offline" +"' WHERE friendname = '"+ name + "'";

		SQLQuery sqlquery= 	 session.createSQLQuery(query1);
		sqlquery.executeUpdate();
	}
}
