package model;

import javax.sound.sampled.SourceDataLine;
import javax.swing.event.SwingPropertyChangeSupport;

public class Owner extends User {

    private String numberBankCount;
    private String nameBank;
    protected Apartment[] apartments;

    /**
     * @param idType
     * @param idNumber
     * @param fullName
     * @param numberContact
     * @param TypeNumberContact
     * @param numberBankCount
     * @param nameBank
     */
    public Owner(String idType, String idNumber, String fullName, String numberContact, int TypeNumberContact, String numberBankCount, String nameBank){
        super(idType, idNumber, fullName, numberContact, TypeNumberContact);

        this.numberBankCount = numberBankCount;
        this.nameBank = nameBank;
        this.apartments = new Apartment[20];

    }

    public String getNumberBankCount(){
        return this.numberBankCount;
    }

    public void setNumberBankCount(String numberBankCount){
        this.numberBankCount = numberBankCount;
    }

    public String getNameBank(){
        return this.nameBank;
    }

    public void setNameBank(String nameBank){
        this.nameBank = nameBank;
    }




    
}
