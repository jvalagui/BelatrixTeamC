package main.java.com.lab.restaurant.model;

/**
 * Created by daniel on 5/14/16.
 */
public class Meal {
    private int id;
    private String nombre;
    private double precio;
    private double costo;
    private int tipo;


    public Meal(int id, String nombre, double precio, double costo, int tipo){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
        this.tipo = tipo;
    }

    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getTipo(){
        return tipo;
    }
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    public double getCosto(){
        return costo;
    }
    public void setCosto(double costo){
        this.costo = costo;
    }
}
