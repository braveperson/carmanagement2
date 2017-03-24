package cn.scxh.carmangger.serverimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cn.scxh.carmangger.dao.CarDao;
import cn.scxh.carmangger.daoimpl.CarDaoImpl;
import cn.scxh.carmangger.model.Car;
import cn.scxh.carmangger.server.CarServer;
@Repository("carServer")
@Scope("singleton")
public class CarServerImpl implements CarServer {
//	private CarDao carDao = CarDaoImpl.getInstance();
	@Autowired
	private CarDao carDao;

	/**
	 * 单例模式
	 
	private CarServerImpl(){}
	private static CarServerImpl carServerImpl = null;
	public static CarServerImpl getInstance(){
		if(carServerImpl == null)
			carServerImpl = new CarServerImpl();
		return carServerImpl;
	}*/
	@Override
	public void addCar(Car car) {
		carDao.addCar(car);

	}
	@Override
	public ArrayList<Car> showCar() {
		ArrayList lists = carDao.showCar();
		return lists;
	}
	@Override
	public void deleteCarById(int id) {
		carDao.deleteCarById(id);
		
	}
	@Override
	public void updateUser(Car car, int id) {
		carDao.updateUser(car, id);
		
	}
	@Override
	public Car findCarByCarNum(String carNum) {
		Car car = carDao.findCarByCarNum(carNum);
		return car;
	}
	@Override
	public List<Car> findCar(String type,String keyword) {
		ArrayList<Car> list = (ArrayList<Car>) carDao.findCar(type,keyword);
		return list;
	}

}
