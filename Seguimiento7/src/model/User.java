package model;

public abstract class User {
    private final int SIZE_APARTMENTS = 500;
 
    private String idType;
    private String idNumber;
    private String fullName;
    private String numberContact;
    private TypeNumberContact typeNumberContact;

    protected Apartment[] apartments;

    public User(String idType, String idNumber, String fullName, String numberContact, int typeNumberContact){
        this.idType = idType;
        this.idNumber = idNumber;
        this.fullName = fullName;
        this.numberContact = numberContact;
        this.apartments = new Apartment[SIZE_APARTMENTS];
        switch(typeNumberContact){
            case 1:
                this.typeNumberContact = TypeNumberContact.HOME;
                break;
            
            case 2:
            this.typeNumberContact = TypeNumberContact.OFFICE;
                break;

            case 3:
            this.typeNumberContact = TypeNumberContact.MOVILE;
                break;

            case 4: 
            this.typeNumberContact = TypeNumberContact.FAMILY;
                break;

            case 5:
            this.typeNumberContact = TypeNumberContact.OTHER;
                break;     

        }

    }

    public String getIdType(){
        return this.idType;
    }

    public void setIdType(String idType){
        this.idType = idType;
    }
    
    public String getIdNumber(){
        return this.idNumber;
    }

    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    public String getFullName(){
        return this.fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getNumberContact(){
        return this.numberContact;
    }

    public void setNumberContact(String numberContact){
        this.numberContact = numberContact;
    }

    public TypeNumberContact getTypeNumberContact(){
        return this.typeNumberContact;
    }

    public void setTypeNumberContact(TypeNumberContact typeNumberContact){
        this.typeNumberContact = typeNumberContact;
    }
    

}
