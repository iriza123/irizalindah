package casestudy.Q2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

    public class ResidentialLand extends Land {
        private String landId;
        private String ownerName;
        private String location;
        private Date registrationDate;
        private double sizeInAcres;
        private String landUseStatus;

        public ResidentialLand() {

        }

        Scanner input = new Scanner(System.in);

        public String getLandId() {
            return landId;
        }

        public void setLandId(String landId) {
            System.out.print("Enter land Id: ");
            landId = input.nextLine();
            while (!landId.matches("\\d+") || landId.isEmpty()) {
                System.out.print("Invalid input ,please try again\nEnter id: ");
                landId = input.nextLine().trim();
            }
            this.landId = landId;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            System.out.print("Enter the Owner name: ");
            ownerName = input.nextLine().trim();
            while (ownerName.isEmpty() || ownerName.matches("\\d+(\\.\\d+)?")) {
                System.out.print("invalid input please try again \n owner name: ");
                ownerName = input.nextLine().trim();
            }
            this.ownerName = ownerName;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            System.out.print("Enter the land's location: ");
            location = input.nextLine();
            while (location.matches("\\d+(\\.\\d+)?")) {
                System.out.print("Invalid input please try again\n location: ");
                location = input.nextLine().trim();
            }
            this.location = location;
        }

        public Date getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(Date registrationDate) {
            this.registrationDate = new Date();
            SimpleDateFormat date = new SimpleDateFormat("EEEE, yyyy-MM-dd HH:mm:ss");
            System.out.println(date.format(this.registrationDate));
        }

        public double getSizeInAcres() {
            return sizeInAcres;
        }

        public void setSizeInAcres(double sizeInAcres) {
            System.out.print("Enter the size of the land in acres: ");
            String byose = input.nextLine();
            while (byose.isEmpty() || !byose.matches("\\d+(\\.\\d+)?")) {
                System.out.print("invalid input p[lease try again,Enter the size of the land in ancres: ");
                byose = input.nextLine().trim();}
            sizeInAcres = Double.parseDouble(byose);
            if (sizeInAcres<0||sizeInAcres >2 ) {
                System.out.print("Cannot exceed 2 residential  or be a negative number units per acre.: ");
                sizeInAcres = input.nextInt();
            }

            this.sizeInAcres = sizeInAcres;
        }

        public String getLandUseStatus() {
            return landUseStatus;
        }

        public void setLandUseStatus(String landUseStatus) {
            System.out.print("Enter the status for the land: ");
            landUseStatus = input.nextLine();
            while (landUseStatus.isEmpty() || landUseStatus.matches("\\d+(\\.\\d+)?") || (!landUseStatus.equals("vacant") && !landUseStatus.equals("in use") && !landUseStatus.equals("under development"))) {
                System.out.println("Invalid input (allowed: in use,under development,vacant) ,Enter the Status : ");
                landUseStatus = input.nextLine();
                this.landUseStatus = landUseStatus;
            }
        }

        @Override
        public void validateOwnership () {
            System.out.println(ownerName == null || ownerName.isEmpty()
                    ?"owner validation failed"
                    :"owner validation passed"
            );

        }

        @Override
        public void checkZoningCompliance () {
            System.out.println("Enter the zone:");
            String zone = input.nextLine();
            while (zone.isEmpty() || zone.matches("\\d+(\\.\\d+)?") || (!zone.equalsIgnoreCase("housing") && !zone.equalsIgnoreCase("living"))) {
                if (zone.isEmpty() || zone.matches("\\d+(\\.\\d+)?")) {
                    System.out.println("Invalid input, please enter words:");
                    zone = input.nextLine();
                } else if (!zone.equalsIgnoreCase("housing") && !zone.equalsIgnoreCase("living")) {
                    System.out.println("Invalid input, validated words (housing, living):");
                    zone = input.nextLine();
                }
            }
            System.out.println("Validation complete and successful");

        }

        @Override
        public double calculateTax () {

            return sizeInAcres*8000*0.015;
        }

        @Override
        public void generateLandReport () {
            System.out.println("\n*********Report **************\n\t\t\t\t\t\t\t\tDate:  "    +getRegistrationDate());
            System.out.println("Owner names: "+getOwnerName());
            System.out.println("Owner Id: "+getLandId());
            System.out.println("Land Location: "+getLocation() );
            System.out.println("land Status: "+getLandUseStatus());
            System.out.println("Land acres: "+getSizeInAcres());
            System.out.println("Tax rate: "+calculateTax());

        }
    }
