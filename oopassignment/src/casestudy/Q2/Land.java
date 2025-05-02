package casestudy.Q2;

import java.util.Date;


    public abstract class Land {
        private  String landId;
        private String ownerName;
        private String location;
        private Date registrationDate;
        private double sizeInAcres;
        private  String landUseStatus;
        public abstract void validateOwnership();
        public abstract void checkZoningCompliance();
        public  abstract double calculateTax();
        public abstract void generateLandReport();

        public String getOwnerName() {
            return "";
        }


        public Object getLandId() {
            return null;
        }

        public String getLocation() {
            return "";
        }
    }
