package cn.scxh.carmangger.server;

import java.util.ArrayList;
import java.util.List;

import cn.scxh.carmangger.model.Car;

public interface CarServer {
	public abstract void addCar(Car car);
	
	public abstract ArrayList<Car> showCar();
	
	void deleteCarById(int id);
	
	public abstract void updateUser(Car car, int id);// 抽象方法
	
	public abstract Car findCarByCarNum(String carNum);
	
	public abstract List<Car> findCar(String type,String keyword);
}
