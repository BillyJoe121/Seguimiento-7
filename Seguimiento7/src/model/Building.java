package model;

public class Building {

    private String name;
    private int numberOfApartments;
    private String adress;
    protected Apartment[] apartments;


    public Building(String name, int numberOfApartments, String adress){
        this.name = name;
        this.numberOfApartments = numberOfApartments;
        this.adress = adress;
        apartments = new Apartment[numberOfApartments];
        
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNumberOfApartments(){
        return this.numberOfApartments;
    }

    public void setNumberOfApartments(int numberOfApartments){
        this.numberOfApartments = numberOfApartments;
    }

    public String getAdress(){
        return this.adress;
    }

    public void setAdress(String adress){
        this.adress = adress;
    }
    

    
}
