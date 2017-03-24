package cn.scxh.carmangger.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.scxh.carmangger.model.Car;
import cn.scxh.carmangger.server.CarServer;
import cn.scxh.carmangger.serverimpl.CarServerImpl;


@Controller
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarServer carServer;
	
	@RequestMapping("/form")
	public String add(){
		return "/car/add_car";
	}
	
	@RequestMapping("/add")
	public String add(Car car,Model model){
		carServer.addCar(car);
		
		return "redirect:/car/show.do";
	}
	
	@RequestMapping("/show")
	public String show(Model model){
		ArrayList<Car> lists = carServer.showCar();
		model.addAttribute("lists", lists);
		return "/car/car_lists";		
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id){
		carServer.deleteCarById(id);
		return "redirect:/car/show.do";
	}
	
	/**
	 * 
	 * @param type
	 * @param keyword
	 * @param number
	 * @param model
	 * @return
	 */
	@RequestMapping("/find")
	public String find(String type,String keyword,String number,Model model){
		System.out.println("keyword:"+keyword+"type:"+type+"carNums:"+number);
		if (type == null && keyword==null) {
			Car car = null;
			type = "carNums";
			keyword = number;
			System.out.println("keyword:"+keyword);
			ArrayList<Car> lists = (ArrayList<Car>) carServer.findCar(type,keyword);
			
			if(lists != null && lists.size()>0){
				car = lists.get(0);//得到唯一值
				
			}
			
			model.addAttribute("car", car);
			return "/car/update_car";
		} else {
			ArrayList<Car> lists = (ArrayList<Car>) carServer.findCar(type,keyword);
			for(Car car : lists){
				System.out.println("car:"+car);
			}
			model.addAttribute("lists", lists);
			return "/car/car_lists";
		}
	}
	
	@RequestMapping("/update")
	public String update(Car car,Integer id,Model model){
		System.out.println("111111111car:"+car+"\tid:"+id);
		carServer.updateUser(car, id);
		System.out.println(".>>>>>"+car);
		return "redirect:/car/show.do";
		
	}
}
