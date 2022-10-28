package ui;
import java.util.Scanner;
import model.*;


public class Main{

    private Scanner scan;
    private Controller controller;

    public Main(){
        scan = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[] args){

        Main main = new Main();
        int option = -1;

        do{
            option = main.showMenu();
            main.executeOption(option);
        }while(option != 0);
    }

    public int validateInteger(){
        int option = -1;

        if(scan.hasNextInt()){
            option = scan.nextInt();
        }
        else{
            scan.next();
            option = -1;
        }
        
        return option;
    }

    public double validateDouble(){
        double option = -1;

        if(scan.hasNextDouble()){
            option = scan.nextDouble();
        }
        else{
            scan.next();
            option = -1;
        }
        
        return option;
    }

    public int showMenu(){
        int option = -1;

        System.out.println();
        System.out.println("Welcome to the menu of the Real State Company, please choose an option");
        System.out.println("1. Register a new building. \n" +
        "2. Register a new apartment in a building. \n" +
        "3. Register an owner. \n" +
        "4. Register a new tenant. \n" +
        "5. Consult the free apartments in a building. \n" +
        "6. Consult the amount expected from a building. \n" +
        "7. Consult if an apartment is free. \n" +
        "8. Consult the number of apartments an owner has rented. \n" +
        "9. Consult the payment expected to an owner. \n" +
        "0. Exit.");
        System.out.println();

        option = validateInteger();

        return option;
    }

    /**
     * @param option
     */
    public void executeOption(int option){

        switch(option){

            case 0:
                System.out.println("Good bye.");
                break;

            case 1:
                System.out.println();
                System.out.println("Please type the name of the building: ");
                String nameBuilding = scan.next();

                System.out.println("Please type the number of apartments the building has: ");
                int numberApartments = validateInteger();

                System.out.println("Please type the adress of the building without spaces (example: kr.24B#32-15): ");
                String adressBuilding = scan.next();

                String messageOne = controller.createNewBuilding(nameBuilding, numberApartments, adressBuilding);

                System.out.println(messageOne);
                System.out.println();

                break;

            case 2:
            System.out.println();

            System.out.println("Please type the name of the building to add a new Apartment: ");
            String nameBuildingSearched = scan.next();
            System.out.println("Please type the number of the apartment: ");
            int numberApartment = validateInteger();
            System.out.println("Please type the number of rooms: ");
            int numberRooms = validateInteger();
            System.out.println("Please type the number of bathRooms: ");
            int numberBathRooms = validateInteger();
            System.out.println("¿Does the apartment has balcony?: \n" +
            "1. Yes. \n" +
            "2. No. \n");
            int hasBalcony = validateInteger();
            System.out.println("Please type the cost of the apartment: ");
            double costApartment = validateDouble();

            
            System.out.println("Now we are going to add the information of the apartment's owner: \n" +
            "Please type the id type: ");
            String idTypeOwner = scan.next();
            System.out.println("Please type the id number whitout periods: ");
            String idNumberOwner = scan.next();
            System.out.println("Please type the name of the owner without spaces: ");
            String namingOwner = scan.next();
            System.out.println("Please type the number of contact: ");
            String numberOfContactOwner = scan.next();
            System.out.println("Please select the type of number it is: \n" +
            "1. HOME. \n" +
            "2. OFFICE. \n" +
            "3. MOVILE. \n" +
            "4. FAMILY. \n" +
            "5. OTHER. ");
            int numberContactTypeOwner = validateInteger();

            System.out.println("Please type the number of the bank count without periods or spaces: ");
            String countNumberOwner = scan.next();
            System.out.println("Please type the name of the bank: ");
            String nameBankOwner = scan.next();


            String messageTwo = controller.createNewApartment(nameBuildingSearched, numberApartment, numberRooms, numberBathRooms, hasBalcony, costApartment, idTypeOwner, idNumberOwner, namingOwner, numberOfContactOwner, numberContactTypeOwner, countNumberOwner, nameBankOwner);
            System.out.println(messageTwo);

            System.out.println();
            
                break;

            case 3:
            System.out.println();

            System.out.println("Please type the id type: ");
            String idType = scan.next();
            System.out.println("Please type the id number: ");
            String idNumber = scan.next();
            System.out.println("Please type the name of the owner: ");
            String nameOwner = scan.next();
            System.out.println("Please type the number of contact: ");
            String numberOfContact = scan.next();
            System.out.println("Please select the type of number it is: \n" +
            "1. HOME. \n" +
            "2. OFFICE. \n" +
            "3. MOVILE. \n" +
            "4. FAMILY. \n" +
            "5. OTHER. ");
            int numberContactType = validateInteger();
        
            System.out.println("Please type the number of the bank count: ");
            String countNumber = scan.next();
            System.out.println("Please type the name of the bank: ");
            String nameBank = scan.next();

            String messageThree = controller.createNewOwner(idType, idNumber, nameOwner, numberOfContact, numberContactType, countNumber, nameBank);
            System.out.println(messageThree);

            System.out.println();

                break;

            case 4:
            System.out.println();
            
            
            System.out.println("Please type the name of the building where is the apartment to rent: ");
            String buildingToTenant = scan.next();
            System.out.println("Please type the number of the apartment to rent: ");
            int apartmentToRent = validateInteger();
            System.out.println("Please type the id type of the tenant: ");
            String idTypeTenant = scan.next();
            System.out.println("Please type the id number of the tenant: ");
            String idNumberTenant = scan.next();
            System.out.println("Please type the name of the tenant: ");
            String nameTenant = scan.next();
            System.out.println("Please type the number of contact: ");
            String numberOfContactTenant = scan.next();
            System.out.println("Please select the type of number it is: \n" +
            "1. HOME. \n" +
            "2. OFFICE. \n" +
            "3. MOVILE. \n" +
            "4. FAMILY. \n" +
            "5. OTHER. ");
            int numberContactTypeTenant = validateInteger();

            String messageFour = controller.createNewTenant(buildingToTenant, apartmentToRent, idTypeTenant, idNumberTenant, nameTenant, numberOfContactTenant, numberContactTypeTenant);

            System.out.println(messageFour);
            System.out.println();

                break;

            case 5:
            System.out.println();
            System.out.println("Please type the name of the building to consult: ");
            String buildingSearched = scan.next();

            String messageFive = controller.consultAvailableApartments(buildingSearched);
            System.out.println(messageFive);
            System.out.println();

            break;

            case 6:
            System.out.println();
            System.out.println("Please type the name of the building to consult: ");
            String buildingSearchedTwo = scan.next();

            String messageSix = controller.consultAmountApartments(buildingSearchedTwo);
            System.out.println(messageSix);
            System.out.println();
            
                break;

            case 7:
            System.out.println();
            System.out.println("Please type the name of the building where is the apartment to consult: ");
            String buildingToConsult = scan.next();
            System.out.println("Please type the number of the apartment: ");
            int apartmentConsulted = validateInteger();

            String messageSeven = controller.consultSpecificApartmentFree(buildingToConsult, apartmentConsulted);
            System.out.println(messageSeven);
            System.out.println();

                break;

            case 8: 
            System.out.println();
            System.out.println("Please type the name of the owner: ");
            String ownerToConsult = scan.next();

            String messageEight = controller.consultApartmentsRentedByOwner(ownerToConsult);
            System.out.println(messageEight);
            System.out.println();

                break;

            case 9:
            System.out.println();
            System.out.println("Please type the name of the owner to consult: ");
            String ownerSearched = scan.next();


            String messageNine = controller.calculateAmountToOwner(ownerSearched);
            System.out.println(messageNine);
            System.out.println();

                break;

            default:
                System.out.println("Invalid option, try again.");
                break;
        
        }

    }

}