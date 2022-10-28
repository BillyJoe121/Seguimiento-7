package model;

public class Apartment {
    private int number;
    private int rooms;
    private int bathrooms;
    private boolean balcony;
    private double cost;
    private boolean isRented;

    public Apartment(int number, int rooms, int bathrooms, int balcony, double cost){
        this.number = number;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        if(balcony == 1){
            this.balcony = true;
        }
        else if(balcony == 2){
            this.balcony = false;
        }
        this.cost = cost;
        this.isRented = false;
    }

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getRooms(){
        return this.rooms;
    }

    public void setRooms(int rooms){
        this.rooms = rooms;
    }

    public int getBathRooms(){
        return this.bathrooms;
    }

    public void setBathRooms(int bathrooms){
        this.bathrooms = bathrooms;
    }

    public boolean getIsRented(){
        return this.isRented;
    }

    public void setIsRented(){
        this.isRented = !isRented; 
    }

    public double getCost(){
        return this.cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }


}
