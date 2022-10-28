package model;

public class Tenant extends User {

    private int apartmentRented;

    public Tenant(String idType, String idNumber, String fullName, String numberContact, int TypeNumberContact, int apartmentRented){
        super(idType, idNumber, fullName, numberContact, TypeNumberContact);

        this.apartmentRented = apartmentRented;

    }

    public int getApartmentRented(){
        return this.apartmentRented;
    }

    public void setApartmentRented(int apartmentRented){
        this.apartmentRented = apartmentRented;
    }
    
}
