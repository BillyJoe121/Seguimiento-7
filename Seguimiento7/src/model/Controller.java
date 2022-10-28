package model;
import java.util.Scanner;
import static java.lang.Math. *;

public class Controller{

    protected final int SIZE_BUILDINGS = 5;
    protected final int SIZE_APARTMENTS = 500;
    protected final int SIZE_USERS = 20;

    private User[] users;
    private Building[] buildings;
    private Apartment[] apartments;


    public Controller(){

        users = new User[SIZE_USERS];
        buildings = new Building[SIZE_BUILDINGS];
        apartments = new Apartment[SIZE_APARTMENTS];

    }

    /**
     * @param name
     * @return
     */
    public int validateNameBuilding(String name){
		int verifier = 0;
		boolean isFoundedName = false;
		for(int i = 0; i < SIZE_BUILDINGS && !isFoundedName; i++){
			if(buildings[i] != null){
				if(buildings[i].getName().equalsIgnoreCase(name)){
					verifier = -1;
					isFoundedName = true;
				}
			}
		}
		return verifier;
	}

    public int countNumberApartments(){
        int result = 0;
        
        for(int i = 0; i < SIZE_BUILDINGS; i++){
            if(buildings[i] != null){
                result += buildings[i].getNumberOfApartments();  
            }
        }
       
        return result;
    }

    /**
     * @param name
     * @param numberApartments
     * @param adress
     * @return
     */
    public String createNewBuilding(String name, int numberApartments, String adress){
        String message = "";
        boolean isCreatedBuilding = false;
        int actualCountApartments = countNumberApartments();

        int validateName = validateNameBuilding(name);
        if(numberApartments == -1){
            message = "Please type a valid number of apartments.";
        }
        else if(validateName == -1){
            message = "There is already a building with that name, please try a different one.";
        }
        else if(numberApartments > (SIZE_APARTMENTS-actualCountApartments)){
            message = ("The number of apartments can not be bigger than " + (SIZE_APARTMENTS - actualCountApartments));
        }
        else{
            for(int i= 0; i < SIZE_BUILDINGS && !isCreatedBuilding; i++ ){
                if(buildings[i] == null){ 
            
                    buildings[i] = new Building(name, numberApartments, adress);
                    message = "New building added succesfully";

                    isCreatedBuilding = true;
                }    

            }
        }

        return message;
    }

    /**
     * @param nameBuildingSearched
     * @param numberApartment
     * @param numberRooms
     * @param numberBathRooms
     * @param hasBalcony
     * @param costApartment
     * @param idTypeOwner
     * @param idNumberOwner
     * @param namingOwner
     * @param numberOfContactOwner
     * @param numberContactTypeOwner
     * @param countNumberOwner
     * @param nameBankOwner
     * @return
     */
    public String createNewApartment( String nameBuildingSearched, int numberApartment, int numberRooms, int numberBathRooms, int hasBalcony, double costApartment, String idTypeOwner, String idNumberOwner, String namingOwner, String numberOfContactOwner, int numberContactTypeOwner, String  countNumberOwner, String nameBankOwner){
        String message = "";
        boolean isCreatedApartment = false;
        boolean isCreatedOwnerApartment = false;
        boolean isCreatedCopyApartment = false;
        

        int posOwner = searchOwnerByName(namingOwner);

        int posBuilding = searchBuildingByName(nameBuildingSearched);

        if(numberApartment == -1 || numberRooms == -1 || numberBathRooms == -1 || hasBalcony == -1 || numberContactTypeOwner == -1){
            message = "Please type a valid number when is asked.";
        }
        else if(costApartment == -1){
            message = "Please type a valid cost for the apartment. Remenber to use a comma and not a period.";
        }
        else if(posBuilding == -1){
            message = "The building typed does not exist.";
        }
        else{
            for(int i = 0; i < SIZE_APARTMENTS && !isCreatedApartment; i++){
                if(buildings[posBuilding].apartments[i] == null){
                    buildings[posBuilding].apartments[i] = new Apartment(numberApartment, numberRooms, numberBathRooms, hasBalcony, costApartment);
                    if(posOwner == -1){ 
                        for(int j = 0; j < SIZE_USERS && !isCreatedOwnerApartment; j++){
                            if(users[j] == null){
                                users[j] = new Owner( idTypeOwner, idNumberOwner, namingOwner, numberOfContactOwner, numberContactTypeOwner, countNumberOwner, nameBankOwner);
                                users[j].apartments[0] = new Apartment(numberApartment, numberRooms, numberBathRooms, hasBalcony, costApartment);
                                isCreatedOwnerApartment = true;
                            }
                        }
                    }
                    else{
                        for(int k = 0; k <SIZE_APARTMENTS && isCreatedCopyApartment; k++){
                            if(users[posOwner].apartments[k] == null){
                                users[posOwner].apartments[k] = new Apartment(numberApartment, numberRooms, numberBathRooms, hasBalcony, costApartment);
                                isCreatedCopyApartment = true;
                            }
                        }
                    }   



                    message = "Apartment added successfully.";
                    isCreatedApartment = true;
                }
            }
        }

        return message;
    }

    /**
     * @param buildingSearched
     * @return
     */
    public int searchBuildingByName(String buildingSearched){

		int position = -1;	
		boolean isFoundedBuilding = false;
			for(int i = 0; i < SIZE_BUILDINGS && !isFoundedBuilding; i++){
				if(buildings[i] != null){
					if(buildings[i].getName().equalsIgnoreCase(buildingSearched)){
						position = i;
						isFoundedBuilding = true;
					}
				}
			}	
		return position;
	}

    /**
     * @param ownerSearched
     * @return
     */
    public int searchOwnerByName(String ownerSearched){

		int position = -1;	
		boolean isFoundedOwner = false;
			for(int i = 0; i < SIZE_BUILDINGS && !isFoundedOwner; i++){
				if(users[i] != null){
					if(users[i].getFullName().equalsIgnoreCase(ownerSearched)){
						position = i;
						isFoundedOwner = true;
					}
				}
			}	
		return position;
	}

    /**
     * @param idType
     * @param idNumber
     * @param nameOwner
     * @param numberOfContact
     * @param numberContactType
     * @param countNumber
     * @param nameBank
     * @return
     */
    public String createNewOwner(String idType, String idNumber, String nameOwner, String numberOfContact, int  numberContactType, String countNumber, String nameBank){
        String message = "";
        boolean isCreatedOwner = false;
        int validateName = validateNameOwner(nameOwner);

        if(numberContactType == -1){
            message = "Please type a valid number for the contact type.";
        }
        else if(validateName == -1){
            message = "The user name already exists. try a different one please.";
        }
        else{
            for(int i = 0; i < SIZE_USERS && !isCreatedOwner; i++){
                if(users[i] == null){
                    users[i] = new Owner(idType, idNumber, nameOwner, numberOfContact, numberContactType, countNumber, nameBank);
                    
                    message = "Owner added successfully";
                    isCreatedOwner = true;
                }
            }
        }

        return message;
    }

    public int validateNameOwner(String name){
		int verifier = 0;
		boolean isFoundedName = false;
		for(int i = 0; i < SIZE_USERS && !isFoundedName; i++){
			if(users[i] != null){
				if(users[i].getFullName().equalsIgnoreCase(name)){
					verifier = -1;
					isFoundedName = true;
				}
			}
		}
		return verifier;
	}


    /**
     * @param apartmentToRent
     * @param idType
     * @param idNumber
     * @param nameOwner
     * @param numberOfContact
     * @param numberContactType
     * @return
     */
    public String createNewTenant(String buildingToTenant, int apartmentToRent, String idType, String idNumber, String nameOwner, String numberOfContact, int  numberContactType){
        String message = "";
        boolean isCreatedTenant = false;
        int posBuildingToTenant = searchBuildingByName(buildingToTenant);
        if(posBuildingToTenant == -1){
            message = "The name of the building typed does not exists.";
        }
        else{
            
            int sizeBuildingApartments = buildings[posBuildingToTenant].getNumberOfApartments();
            int existApartment = validateApartmentByNumber(posBuildingToTenant, apartmentToRent, sizeBuildingApartments);
            int freeApartment = validateFreeApartmentByNumber(posBuildingToTenant, apartmentToRent, sizeBuildingApartments);

            if(numberContactType == -1){
                message = "Please type a valid number for the contact type.";
            }
            else if(freeApartment == -1){
                message = "The apartment is already rented.";
            }
            else if(existApartment == -1){
                message = "The number of apartment typed does not exists.";
            }
            else{
                for(int i = 0; i < SIZE_USERS && !isCreatedTenant; i++){
                    if(users[i] == null){
                        users[i] = new Tenant(idType, idNumber, nameOwner, numberOfContact, numberContactType, apartmentToRent);
                        buildings[posBuildingToTenant].apartments[existApartment].setIsRented();
                        message = "Tenant added successfully";
                        isCreatedTenant = true;
                    }
                }
            }

        }

        return message;

    }


    /**
     * @param numberSearched
     * @return
     */
    public int validateApartmentByNumber(int buildingSearched, int numberSearched, int sizeBuildingApartments){
        int result = -1;
        boolean exists = false;
        for(int i = 0; i < sizeBuildingApartments && !exists; i++){ 
            if(buildings[buildingSearched].apartments[i] != null){ 
                if(buildings[buildingSearched].apartments[i].getNumber() == numberSearched){ 
                    exists = true;
                    result = i;
                }
            }
        }
        return result;
    }

        /**
     * @param numberSearched
     * @return
     */
    public int validateFreeApartmentByNumber(int buildingSearched, int numberSearched, int sizeBuildingApartments){
        int result = 0;
        boolean exists = false;
        
        for(int i = 0; i < sizeBuildingApartments && !exists; i++){ 
            if(buildings[buildingSearched].apartments[i] != null){ 
                if(buildings[buildingSearched].apartments[i].getNumber() == numberSearched){ 
                    if(buildings[buildingSearched].apartments[i].getIsRented() == true){
                        result = -1;
                    }
                    exists = true;
                }
            }
        }
        return result;
    }


    /**
     * @param buildingSearched
     * @return
     */
    public String consultAvailableApartments(String buildingSearched){
        String message = "";

        int posBuildingSearched = searchBuildingByName(buildingSearched);
        int counter = 0;
        int sizeBuildingApartments = 0;
        if(posBuildingSearched != -1){
            sizeBuildingApartments = buildings[posBuildingSearched].getNumberOfApartments();
            for(int i = 0; i < sizeBuildingApartments; i++){ 
                if(buildings[posBuildingSearched].apartments[i] != null){
                    if(buildings[posBuildingSearched].apartments[i].getIsRented() == false){
                        counter++;
                    }
                }
            }

            message = ("The number of available apartments in the building " + buildingSearched + " is " + counter);
        }
        else{
            message = "The name typed does not corresponds to any building name.";
        }

        return message;

    }

    
    /**
     * @param buildingSearched
     * @return
     */
    public String consultAmountApartments(String buildingSearched){
        String message = "";

        int posBuildingSearched = searchBuildingByName(buildingSearched);
        int sizeBuildingApartments = buildings[posBuildingSearched].getNumberOfApartments();
        double counter = 0;

        if(posBuildingSearched == -1){
            message = "The name typed does not corresponds to any building name.";
        }
        else{
            for(int i = 0; i < sizeBuildingApartments; i++){ 
                if(buildings[posBuildingSearched].apartments[i] != null){
                    counter += buildings[posBuildingSearched].apartments[i].getCost();
                }
            }

            message = ("The amount expected for all the apartments in the building " + buildingSearched + " is " + counter + " USD.");
        }

        return message;
    }

    /**
     * @param building
     * @param apartment
     * @return
     */
    public String consultSpecificApartmentFree(String building, int apartment){
        String message = "";
        int posBuilding = searchBuildingByName(building);
        boolean isFounded = false;
        boolean isFree = false;
        int sizeBuildingApartments = buildings[posBuilding].getNumberOfApartments();

        if(posBuilding == -1){
            message = "The building typed does not exist.";
        }
        else{
            for(int i = 0; i < sizeBuildingApartments && !isFounded; i++){ 
                if(buildings[posBuilding].apartments[i] != null){
                    if(buildings[posBuilding].apartments[i].getNumber() == apartment){ 
                        if(buildings[posBuilding].apartments[i].getIsRented() == false){
                            isFree = true;
                            message = "The apartment is Free.";
                        }
                        else{
                            message = "The apartment is already rentend.";
                        }
                    }
                    else{
                        message = ("There is not an apartment with that number in the bulding " + building);
                    }

                }
            }
        }

        return message;

    }

    /**
     * @param owner
     * @return
     */
    public String calculateAmountToOwner(String owner){
        String message = "";
        double countAmount = 0;

        int posOwner = searchOwnerByName(owner);

        if(posOwner == -1){
            message = "Owner searched does not exists.";
        }
        else{
            for(int i = 0; i < SIZE_APARTMENTS; i++){
                if(users[posOwner].apartments[i] != null){
                    countAmount += (users[posOwner].apartments[i].getCost() * 0.9);
                }
            }

            message = ("The amount to pay to the owner for concept of all his rented apartments is: " + countAmount);
        }


        return message;
    }

    public String consultApartmentsRentedByOwner(String ownerToConsult){
        String message = "";
        int posOwner = searchOwnerByName(ownerToConsult);
        int counterRented = 0;

        if(posOwner == -1){
            message = "The owner searched does not exist.";
        }
        else{ 
            for(int i = 0; i < SIZE_APARTMENTS; i++){ 
                if(users[posOwner].apartments[i] != null){
                    if(users[posOwner].apartments[i].getIsRented() == true){
                        counterRented++;
                    }

                    message = ("The owner " + ownerToConsult + " has " + counterRented + " rented apartments.");
                }
            }
        }

        return message;
    }


}