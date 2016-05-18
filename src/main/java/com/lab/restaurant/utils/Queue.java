package main.java.com.lab.restaurant.utils;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Visita;


public class Queue {
	
	private List<Visita> queueArray;
	
	
	public Queue(){
		
		queueArray = new ArrayList<Visita>();
	}
	
	public void insert(Visita visita){
		
		queueArray.add(visita);
		
	}
	
		
	public void remove(){
		
		if(!isEmpty()){queueArray.remove(0);}
		
	}
	
	public Visita peek(){
		if(!isEmpty()){
			return queueArray.get(0);
		}
		else {return null;}
	}
	
	public boolean isEmpty(){
		return queueArray.isEmpty();
	}

	@Override
	public String toString(){
		StringBuffer stringBuffer= new StringBuffer();
		
		stringBuffer.append("SALA DE ESPERA: \n");
		
		for(Visita itemVisita : queueArray){
			stringBuffer.append(itemVisita+"\n");
		}
		
		return stringBuffer.toString();
	}
}
