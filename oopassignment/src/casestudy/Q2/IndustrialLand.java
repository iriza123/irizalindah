package casestudy.Q2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


    public class IndustrialLand extends Land {
        private  String landId;
        private String ownerName;
        private String location;
        private Date registrationDate;
        private double sizeInAcres;
        private  String landUseStatus;
        Scanner input=new Scanner(System.in);
        public IndustrialLand(){

        }

        public String getLandId() {
            return landId;
        }

        public void setLandId(String landId) {
            System.out.print("Enter the Id for the land: ");
            landId=input.nextLine();
            while(landId.isEmpty() || !landId.matches("\\d+")){
                System.out.print("Invalid input ,(Enter a number)\nId: ");
                landId=input.nextLine();
            }
            this.landId = landId;
        }

        public String getLandUseStatus() {
            return landUseStatus;
        }

        public void setLandUseStatus(String landUseStatus) {
            System.out.println("Enter the land Status: ");
            landUseStatus= input.nextLine();
            while (landUseStatus.matches("\\d+(\\.\\d+)?") || landUseStatus.isEmpty() || !landUseStatus.equals("in use")&&!landUseStatus.equals("under development")&&!landUseStatus.equals("vacant") ){
                System.out.print("Invalid input,please Enter words: ");
                landUseStatus= input.nextLine();
                if(!landUseStatus.equals("in use")&&!landUseStatus.equals("under development")&&!landUseStatus.equals("vacant")){
                    System.out.print("Invalid input,allowed input are (in use,under development,vacant)");
                    landUseStatus= input.nextLine();
                }
            }
            this.landUseStatus = landUseStatus;
        }

        public double getSizeInAcres() {
            return sizeInAcres;
        }

        public void setSizeInAcres(double sizeInAcres) {
            System.out.print("Enter the size of the land : ");
            String byose= input.nextLine();
            while(byose.isEmpty() || !byose.matches("\\d+")){
                System.out.print("invalid input ,Enter a number:  ");
                byose= input.nextLine();
            }
            sizeInAcres=Double.parseDouble(byose);
            this.sizeInAcres = sizeInAcres;
        }

        public Date getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(Date registrationDate) {
            this.registrationDate = new Date();
            SimpleDateFormat Date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(this.registrationDate);
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            System.out.println("Enter the owner name: ");
            ownerName=input.nextLine();
            while(ownerName.isEmpty() || ownerName.matches("\\d+|(\\.\\d+)?") ||ownerName.length()<5){
                System.out.print("invalid input ,please enter words : ");
                ownerName=input.nextLine();
                if(ownerName.length()<5){
                    System.out.print("invalid input, the length is short it must > 5:  ");
                    ownerName=input.nextLine();
                }
            }
            this.ownerName = ownerName;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            System.out.println("Enter the land location: ");
            location=input.nextLine();
            while(location.isEmpty() || location.matches("\\d+(\\.\\d+)?")){
                System.out.print("Invalid input please enter words:  ");
                location=input.nextLine();
            }
            this.location = location;
        }

        @Override
        public void validateOwnership() {
            System.out.println(ownerName == null || ownerName.isEmpty()
                    ? "Ownership validation failed: No owner name provided."
                    : "Ownership validation passed.");

        }


        @Override
        public void checkZoningCompliance() {
            System.out.println("Enter the zoning type for this land: ");
            String zoningType = input.nextLine();
            while(!zoningType.equalsIgnoreCase("industrial")){
                if (!zoningType.equalsIgnoreCase("industrial")) {
                    System.out.println("Zoning compliance failed: Industrial land must be in an industrial zone.");
                    zoningType = input.nextLine();
                } else {
                    System.out.println("Zoning compliance passed.");
                }
            }
        }



        @Override
        public double calculateTax() {

            return sizeInAcres*12000*0.03;
        }

        @Override
        public void generateLandReport() {

            System.out.println("*************report for industrial land**********            date: "+getRegistrationDate());
            System.out.println("Name: "+getOwnerName());
            System.out.println("Land Id: "+getLandId());
            System.out.println("Land Size: "+getSizeInAcres());
            System.out.println("Land Location: "+getLocation());
            System.out.println("Land Status: "+getLandUseStatus());
            System.out.println("Rate: "+calculateTax());

        }
    }


