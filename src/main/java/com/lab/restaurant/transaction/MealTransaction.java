package main.java.com.lab.restaurant.transaction;

import main.java.com.lab.restaurant.model.Meal;

import java.util.List;

/**
 * Created by daniel on 5/14/16.
 */
public class MealTransaction {
    private static List<Meal> lista;

    public static int create(Meal meal){
        int result = 0;
        try{
            lista.add(meal);
            result = 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static Meal read(int id){
        Meal registro = null;
        for(Meal meal : lista){
            if(meal.getId()==id){
                registro = meal;
            }
        }
        return registro;
    }

    public static int update(Meal registro){
        int result = 0;
        try{
            for(Meal meal : lista){
                if(meal.getId()==registro.getId()){
                    lista.set(lista.indexOf(meal), registro);
                }
            }
            result = 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static int delete(int id){
        int result = 0;
        try{
            for(Meal meal : lista){
                if(meal.getId() == id){
                    lista.remove(meal);
                    result = 1;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
