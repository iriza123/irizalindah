package casestudy.Q2;

import java.util.Scanner;

    public class Main2 {
        public static void main(String[] args) {
            Agriculture n1 = new Agriculture();
            ResidentialLand n2=new ResidentialLand();
            CommercialLand n3=new CommercialLand();
            IndustrialLand n4=new IndustrialLand();
            LandRegister n5=new LandRegister();
            String choice;
            Scanner input = new Scanner(System.in);
            int choice1;
            do {
                System.out.print("choice form below:\n1.Agriculture Land\n2.Residential Land\n3.Commercial Land\n4.Industrial Land\n5.Additional_Menu\n6.Exiting\nEnter choice: ");
                choice = input.nextLine();
                while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6")) {
                    System.out.print("invalid input (from 1-6)\nEnter choice: ");
                    choice = input.nextLine();
                }
                choice1 = Integer.parseInt(choice);
                switch (choice1) {
                    case 1:
                        System.out.println("!!!!!!!Information only agriculture must be in he zone of farming only!!!!!!");
                        n1.setOwnerName(n1.getOwnerName());
                        n1.setLandUseStatus(n1.getLandUseStatus());
                        n1.setLandId(n1.getLandId());
                        n1.setSizeInAcres(n1.getSizeInAcres());
                        n1.setRegistrationDate(n1.getRegistrationDate());
                        n1.setLocation(n1.getLocation());
                        n1.generateLandReport();
                        break ;
                    case 2:
                        System.out.println("\n!!!!Intended for housing or living purposes.!!!!!!!!\n");
                        n2.checkZoningCompliance();
                        n2.setOwnerName(n2.getOwnerName());
                        n2.validateOwnership();
                        n2.setLandId(n2.getLandId());
                        n2.setLocation(n2.getLocation());
                        n2.setLandUseStatus(n2.getLandUseStatus());
                        n2.setSizeInAcres(n2.getSizeInAcres());
                        n2.setRegistrationDate(n2.getRegistrationDate());
                        n2.generateLandReport();
                        break;
                    case 3:
                        System.out.println("!!!!!! Used for business or commercial operations.!!!!!!!!!");
                        n3.setOwnerName(n3.getOwnerName());
                        n3.setLandId(n3.getLandId());
                        n3.setLocation(n3.getLocation());
                        n3.setSizeInAcres(n3.getSizeInAcres());
                        n3.setLandUseStatus(n3.getLandUseStatus());
                        n3.setRegistrationDate(n3.getRegistrationDate());
                        n3.generateLandReport();
                        break;
                    case 4:
                        System.out.println("!!!!!!Designated for factories or large-scale production.!!!!!!!!!");
                        n4.checkZoningCompliance();
                        n4.setOwnerName(n4.getOwnerName());
                        n4.validateOwnership();
                        n4.setLandId(n4.getLandId());
                        n4.setLocation(n4.getLocation());
                        n4.setRegistrationDate(n4.getRegistrationDate());
                        n4.setLandUseStatus(n4.getLandUseStatus());
                        n4.setSizeInAcres(n4.getSizeInAcres());
                        n4.generateLandReport();
                        break;

                    case 5:
                        n5.interactiveMenu();
                        break;



                    case 6:
                        System.out.println("Exitiiing ...");
                        break;

                }
            } while (choice1 < 6);

        }
    }
