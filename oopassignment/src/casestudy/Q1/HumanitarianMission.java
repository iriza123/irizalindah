package casestudy.Q1;

import java.util.Scanner;

public class HumanitarianMission extends Mission {
    private boolean foodSuppliesAvailable;
    private boolean medicalKitsAvailable;
    private boolean transportationAvailable;
    Scanner input = new Scanner(System.in);

    public HumanitarianMission() {
        super();
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning tasks for the humanitarian mission...");
        System.out.println("1. Logistics");
        System.out.println("2. Distribution");
        System.out.println("3. Medical Aid");
        System.out.println("Tasks have been successfully assigned.");
    }

    @Override
    public void allocateResources() {
        System.out.println("Allocating resources for the humanitarian mission...");
        System.out.print("Are food supplies available? (yes/no): ");
        foodSuppliesAvailable = input.nextLine().equalsIgnoreCase("yes");
        System.out.print("Are medical kits available? (yes/no): ");
        medicalKitsAvailable = input.nextLine().equalsIgnoreCase("yes");
        System.out.print("Is transportation available? (yes/no): ");
        transportationAvailable = input.nextLine().equalsIgnoreCase("yes");

        if (foodSuppliesAvailable && medicalKitsAvailable && transportationAvailable) {
            System.out.println("All essential resources have been allocated.");
        } else {
            System.out.println("Warning: Some essential resources are missing. Please ensure all resources are available before starting the mission.");
        }
    }

    @Override
    public void trackMissionProgress() {
        System.out.print("Enter the current progress percentage (0-100): ");
        int progress = input.nextInt();
        input.nextLine(); // Consume newline
        if (progress < 0 || progress > 100) {
            System.out.println("Invalid progress percentage. Please enter a value between 0 and 100.");
            return;
        }
        if (progress == 100) {
            status = "Complete";
        } else if (progress > 0) {
            status = "In Progress";
        } else {
            status = "Planned";
        }
        System.out.println("Mission progress updated. Current status: " + status);
    }

    @Override
    public void generateMissionReport() {
        System.out.println("\n------- Humanitarian Mission Report -------");
        System.out.println("Mission Name: " + missionName);
        System.out.println("Mission ID: " + missionId);
        System.out.println("Start Date: " + missionStartDate);
        System.out.println("End Date: " + missionEndDate);
        System.out.println("Status: " + status);
        System.out.println("Resources:");
        System.out.println("  Food Supplies: " + (foodSuppliesAvailable ? "Available" : "Not Available"));
        System.out.println("  Medical Kits: " + (medicalKitsAvailable ? "Available" : "Not Available"));
        System.out.println("  Transportation: " + (transportationAvailable ? "Available" : "Not Available"));
    }
}