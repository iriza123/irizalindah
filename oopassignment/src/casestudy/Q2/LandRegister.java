package casestudy.Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class LandRegister {
        private List<Land> registeredLands;

        public LandRegister() {
            this.registeredLands = new ArrayList<>();
        }

        public void addLand(Land land) {
            registeredLands.add(land);
            System.out.println("Land added successfully.");
        }

        public void removeLand(String landId) {
            registeredLands.removeIf(land -> land.getLandId().equals(landId));
            System.out.println("Land removed successfully.");
        }

        public List<Land> getRegisteredLands() {
            return registeredLands;
        }

        public List<Land> searchByOwner(String ownerName) {
            List<Land> result = new ArrayList<>();
            for (Land land : registeredLands) {
                if (land.getOwnerName().equalsIgnoreCase(ownerName)) {
                    result.add(land);
                }
            }
            return result;
        }

        public List<Land> searchByLocation(String location) {
            List<Land> result = new ArrayList<>();
            for (Land land : registeredLands) {
                if (land.getLocation().equalsIgnoreCase(location)) {
                    result.add(land);
                }
            }
            return result;
        }

        public List<Land> searchByType(Class<? extends Land> type) {
            List<Land> result = new ArrayList<>();
            for (Land land : registeredLands) {
                if (type.isInstance(land)) {
                    result.add(land);
                }
            }
            return result;
        }

        public void interactiveMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nLand Registry Menu:");
                System.out.println("2. Remove Land");
                System.out.println("3. Search by Owner");
                System.out.println("4. Search by Location");
                System.out.println("5. Search by Type");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Add
                        break;
                    case 2:
                        System.out.print("Enter Land ID to remove: ");
                        String landId = scanner.nextLine();
                        removeLand(landId);
                        break;
                    case 3:
                        System.out.print("Enter Owner Name: ");
                        String ownerName = scanner.nextLine();
                        List<Land> landsByOwner = searchByOwner(ownerName);
                        System.out.println("Results: " + landsByOwner);
                        break;
                    case 4:
                        System.out.print("Enter Location: ");
                        String location = scanner.nextLine();
                        List<Land> landsByLocation = searchByLocation(location);
                        System.out.println("Results: " + landsByLocation);
                        break;
                    case 5:
                        System.out.println("Enter Type (e.g., ResidentialLand, Agriculture): ");
                        String type = scanner.nextLine();
                        try {
                            Class<?> clazz = Class.forName("q2.land." + type.toLowerCase() + "." + type);
                            List<Land> landsByType = searchByType((Class<? extends Land>) clazz);
                            System.out.println("Results: " + landsByType);
                        } catch (ClassNotFoundException e) {
                            System.out.println("Invalid type.");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
