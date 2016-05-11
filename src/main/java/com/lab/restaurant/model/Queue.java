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
		
		for(int i = 0; i < queueArray.size() - 1; i++){
			queueArray.set(i, queueArray.get(i+1));
		}
		
	}
	
	public Visita peek(){
		return queueArray.get(0);
	}
	
	

}
