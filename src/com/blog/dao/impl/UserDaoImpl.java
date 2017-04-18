package com.blog.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.blog.dao.UserDao;
import com.blog.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	private HibernateTemplate hibernateTemplate;

	public void add(User user) {
		hibernateTemplate.save(user);
	}

	public void delete(User user) {
		hibernateTemplate.delete(user);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public boolean check(String userName) {
		List<User> users=hibernateTemplate.find("from User u where u.userName='"+userName+"'");
		if(users!=null&&users.size()>0){
			return true;
		}
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> getUsers(int currentPage, final int pageSize) {
		int maxPage=(int)Math.ceil(getTotalPage()*1.0/pageSize);
		final int offset=currentPage<=maxPage?(currentPage-1)*pageSize:(maxPage-1)*pageSize;
		final String hql="from User";
		List list = hibernateTemplate.executeFind(new HibernateCallback() {     
		    public Object doInHibernate(Session session)     
		      throws HibernateException, SQLException {     
		     Query query = session.createQuery(hql);     
		     query.setFirstResult(offset);     
		     query.setMaxResults(pageSize);     
		     List list = query.list();     
		     return list;     
		    }     
		   });     
		return list;
	}
	/**
	 * 获取所有记录行数
	 * @return
	 */
	public int getTotalPage(){
		final String hql = "select count(*) from User su";     
        Long result = null;     
        result = (Long)getHibernateTemplate().execute(new HibernateCallback() {     
    
            public Object doInHibernate(Session arg0)     
                    throws HibernateException, SQLException {     
                Query query = arg0.createQuery(hql);     
                return query.uniqueResult();     
            }     
    
        });     
        return result.intValue();  
	}

	public boolean modifyPasswordByUserName(String userName, String password) {
		User user=getUser(userName);
		if(user!=null){
			user.setPassword(password);
			hibernateTemplate.update(user);
			return true;
		}
		return false;
	}

	public boolean modifyLevelByUserName(String userName, int level) {
		User user=getUser(userName);
		if(user!=null){
			user.setLevel(level);
			hibernateTemplate.update(user);
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public User getUser(String userName) {
		List<User> users=hibernateTemplate.find("from User u where u.userName='"+userName+"'");
		if(users!=null&&users.size()==1){
			
			return users.get(0);
		}
		return null;
	}

	public String getPasswordByUserName(String userName) {
		User user=getUser(userName);
		if(user!=null){
			
			return user.getPassword();
		}
		return null;
	}

	public String[] getOrder(String userName) {
		User user=getUser(userName);
		if(user!=null){
			String order= user.getOrderWeibo();
			if(order!=null&&!"".equals(order)){
				return order.split(" ");
			}
		}
		return null;
	}

	public boolean addOrder(String userName,String blogId) {
		User user=getUser(userName);
		if(user!=null){
			String order= user.getOrderWeibo();
			if(order!=null&&!"".equals(order)){
				if(order.contains(blogId)){
					return true;
				}
				order+=" "+blogId;
				user.setOrderWeibo(order);	
			}else{
				user.setOrderWeibo(blogId);
			}
			hibernateTemplate.update(user);
			return true;
		}
		return false;
	}

	public boolean deleteOrder(String userName,String blogId) {
		User user=getUser(userName);
		if(user!=null){
			String order= user.getOrderWeibo();
			if(order!=null&&!"".equals(order)){
				if(order.contains(blogId)){
					if(order.startsWith(blogId)){
						user.setOrderWeibo(order.replaceAll(blogId+" ", ""));
					}else {
						user.setOrderWeibo(order.replaceAll(" "+blogId, ""));
					}
					hibernateTemplate.update(user);
					return true;
				}else{
					return true;
				}
			}
		}
		return false;
	}

	public boolean insertRecommend(String userName, String recommend) {
		User user=getUser(userName);
		if(user!=null){
			user.setRecommend(recommend);
			hibernateTemplate.update(user);
			return true;
		}
		return false;
	}

	public String[] getRecommend(String userName) {
		User user=getUser(userName);
		if(user!=null){
			String recommend= user.getRecommend();
			if(recommend!=null&&!"".equals(recommend)){
				return recommend.split(" ");
			}
		}
		return null;
	}

	public int getLevelByUserName(String userName) {
		User user=getUser(userName);
		if(user!=null){
			return user.getLevel();
		}
		return 0;
	}

	public boolean updateRecommend(String userName, String recommend) {
		if(recommend==null||"".equals(recommend)){
			return false;
		}
		User user = getUser(userName);
		if(user!=null){
			user.setRecommend(recommend);
			
			try{
				hibernateTemplate.update(recommend);
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}

}