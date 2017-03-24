package cn.scxh.carmangger.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cn.scxh.carmangger.dao.CarDao;
import cn.scxh.carmangger.model.Car;
import cn.scxh.carmangger.utils.HibernateUtils;
@Repository("carDao")
@Scope("singleton")
public class CarDaoImpl implements CarDao {
	/**
	 * 单例模式
	
	private static CarDaoImpl carDaoImpl = null;

	public static CarDaoImpl getInstance() {
		if (carDaoImpl == null)
			carDaoImpl = new CarDaoImpl();
		return carDaoImpl;
	}

	private CarDaoImpl() {
	} */
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	@Override
	public void addCar(Car car) {
		session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();//开启事物
		
		session.save(car);
		
		session.getTransaction().commit();//提交事物
	}

	@Override
	public ArrayList<Car> showCar() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();// 开启事物
		
		Query query = session.createQuery("from Car");
		ArrayList lists = (ArrayList) query.list();
		
		session.getTransaction().commit();// 提交事物
		return lists;
	}

	@Override
	public void deleteCarById(int id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Car car = (Car) session.get(Car.class, id);
		session.delete(car);
		
		session.getTransaction().commit();
		
	}

	@Override
	public void updateUser(Car car, int id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.update(car);
		
		session.getTransaction().commit();
		
	}

	@Override
	public Car findCarByCarNum(String carNum) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Car where carNum =:carNum");
		
		query.setParameter("carNum", carNum);
		
		Car car = (Car) query.uniqueResult();
		
		session.getTransaction().commit();
		
		return car;
		
	}

	@Override
	public List<Car> findCar(String type,String keyword) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = null;
		if(type.equals("carOwnner")){
			query = session.createQuery("from Car where carOwnner =:keyword");
		}else if(type.equals("telePhone")){
			query = session.createQuery("from Car where telePhone =:keyword");
		}else if(type.equals("carNums")){
			query = session.createQuery("from Car where carNums =:keyword");
		}
		
		query.setParameter("keyword", keyword);
		ArrayList lists = (ArrayList) query.list();
		
		session.getTransaction().commit();
		return lists;
		
	}

}
