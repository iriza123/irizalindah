package casestudy.Q2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

    public class CommercialLand extends Land {
        private String landId;
        private String ownerName;
        private String location;
        private Date registrationDate;
        private double sizeInAcres;
        private  String landUseStatus;

        public String getLandId() {
            return landId;
        }

        public void setLandId(String landId) {
            System.out.print("Enter the land ID: ");
            landId=input.nextLine();
            while(landId.isEmpty()||!landId.matches("\\d+")){
                System.out.print("Invalid input ,only numbers allowed Enter id:  ");
                landId=input.nextLine();
            }
            this.landId = landId;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            System.out.print("Enter owner name: ");
            ownerName = input.nextLine();
            while (ownerName.isEmpty() || ownerName.matches("\\d+(\\.\\d+)?") || ownerName.length() < 5) {
                if (ownerName.isEmpty() || ownerName.matches("\\d+(\\.\\d+)?")) {
                    System.out.print("Invalid input, Enter words not numbers: ");
                } else if (ownerName.length() < 5) {
                    System.out.print("Invalid input, Name must be at least 5 characters long: ");
                }
                ownerName = input.nextLine();
            }
            this.ownerName = ownerName;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            System.out.print("Enter the location : ");
            location=input.nextLine();
            while(location.isEmpty()||location.matches("\\d+(\\.\\d+)?")){
                System.out.println("invalid input,Enter words: ");
                location= input.nextLine();
            }
            this.location = location;
        }

        public Date getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(Date registrationDate) {
            this.registrationDate = new Date();
            SimpleDateFormat date=new SimpleDateFormat("yyyy, MM-dd-MM HH:mm:ss");
            System.out.println(date.format(this.registrationDate));
        }

        public double getSizeInAcres() {
            return sizeInAcres;
        }

        public void setSizeInAcres(double sizeInAcres) {
            System.out.print("Enter the size of the land: ");
            String byose= input.nextLine();
            while (byose.matches("\\d+")||byose.isEmpty()){
                System.out.print("Invalid input ,please entry a float number: ");
                byose= input.nextLine();
                sizeInAcres=Double.parseDouble(byose);
            }
            this.sizeInAcres = sizeInAcres;
        }

        public String getLandUseStatus() {
            return landUseStatus;
        }

        public void setLandUseStatus(String landUseStatus) {
            System.out.print("Enter the land status: ");
            landUseStatus=input.nextLine();
            while (landUseStatus.isEmpty()||landUseStatus.matches("\\d+(\\.\\d+)?")){
                System.out.print("invalid input,Enter words: ");
                landUseStatus=input.nextLine();
                if (!landUseStatus.equals("in use")&&!landUseStatus.equals("vacant")&&!landUseStatus.equals("under development")){
                    System.out.println("invalid input,enter valid words,(in use,under development,vacant)");
                    landUseStatus=input.nextLine();
                }
            }
            this.landUseStatus = landUseStatus;
        }

        Scanner input=new Scanner(System.in);
        public CommercialLand(){

        }

        @Override
        public void validateOwnership() {

        }

        @Override
        public void checkZoningCompliance() {


        }

        @Override
        public double calculateTax() {
            return sizeInAcres*10000*0.025;
        }

        @Override
        public void generateLandReport() {
            System.out.println("*******Report*************\t\t\t\t\t\t\t\t\t\tDate: "+getRegistrationDate());
            System.out.println("Name: "+getOwnerName());
            System.out.println("Owner id: "+getOwnerName());
            System.out.println("Land location: "+getLocation());
            System.out.println("acres: "+getSizeInAcres());
            System.out.println("LAnd Status: "+getLandUseStatus());
            System.out.println("Tax: "+calculateTax());

        }
    }
