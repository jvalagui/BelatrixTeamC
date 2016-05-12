package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;


public class Queue {
	
	private List<Visita> queueArray;
	
	
	public Queue(){
		
		queueArray = new ArrayList<Visita>();
	}
	
	public void insert(Visita visita){
		
		queueArray.add(visita);
		
	}
	
		
	public void remove(){
		
		queueArray.remove(0);
		
	}
	
	public Visita peek(){
		return queueArray.get(0);
	}
	
	

}
