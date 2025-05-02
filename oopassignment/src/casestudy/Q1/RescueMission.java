package casestudy.Q1;

import java.util.Scanner;

public class RescueMission extends Mission {

    public RescueMission() {
        super();
    }
    private String FirstName;
    private String FirstId;
    private String SecondName;
    private String SecondId;
    private String Med;
    private String MedId;

    Scanner input=new Scanner(System.in);
    public String getFirstName() {

        return FirstName;
    }

    public void setFirstName(String firstName) {
        System.out.print("Enter the first name: ");
        firstName=input.nextLine();
        while(firstName.isEmpty() || firstName.matches("\\d+(\\.\\d+)?")){
            System.out.print("Invalid input Enter words: ");
            firstName= input.nextLine();
        }
        name.add(0,firstName);

        FirstName = firstName;
    }

    public String getFirstId() {
        return FirstId;
    }
    public void setFirstId(String firstId) {
        System.out.print("Enter the fist Id: ");
        firstId=input.nextLine();
        while(firstId.isEmpty() ||!firstId.matches("\\d+")) {
            System.out.print("Invalid input Enter whole number: ");
            firstId=input.nextLine().trim();
        }
        id.add(0,firstId);

        FirstId = firstId;
    }


    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        System.out.print("Enter the Second name: ");
        secondName = input.nextLine();
        while (secondName.isEmpty() || secondName.matches("\\d+(\\.\\d+)?")) {
            System.out.print("Invalid input. Enter a valid name (letters only): ");
            secondName = input.nextLine();
        }
        name.add(1,secondName);
        this.SecondName = secondName;
    }

    public String getSecondId() {
        return SecondId;
    }

    public void setSecondId(String secondId) {
        System.out.print("Enter the SecondId : ");
        secondId = input.nextLine();
        while (secondId.isEmpty() || !secondId.matches("\\d+")) {
            System.out.print("Invalid input Enter whole number: ");
            secondId = input.nextLine();
        }
        id.add(1, secondId);
        SecondId = secondId;
    }

    public String getMed() {
        return Med;
    }

    public void setMed(String med) {
        System.out.print("Enter the medic name: ");
        med= input.nextLine();
        while (med.isEmpty() || med.matches("\\d+(\\.\\d+)?")) {
            System.out.print("Invalid input. Enter a valid name (words): ");
            med = input.nextLine();
        }
        Med = med;
    }

    public String getMedId() {
        return MedId;
    }

    public void setMedId(String medId) {
        System.out.print("Enter the id for the medic: ");
        medId=input.nextLine();

        while (medId.isEmpty() || !medId.matches("\\d+")) {
            System.out.print("Invalid input Enter whole number: ");
            medId = input.nextLine();
        }
        MedId = medId;
    }

    @Override
    public void assignTask() {
        if(name == null || getMedId()==null){
            System.out.println("atleast a resuer and a medic most be available in this mission");
        }
        else {
            System.out.println("Team full assemble");
        }
    }

    @Override
    public void allocateResources() {
        System.out.println("Enter the the resource: ");
        String resource= input.nextLine();
        while(resource.isEmpty() || resource.matches("\\d+(\\.\\d+)?") || (!resource.equals("medical kits") && !resource.equals("ambulances")&& !resource.equals("rescue equipment"))){
            if(resource.isEmpty() || resource.matches("\\d+(\\.\\d+)?") ){
                System.out.print("invalid input,please Enter words: ");
                resource= input.nextLine();
            } else if ((!resource.equals("medical kits") && !resource.equals("ambulances")&& !resource.equals("rescue equipment"))){
                System.out.println("Invalid word,valid( medical kits, ambulances, and rescue equipment.): ");
                resource= input.nextLine();

            }
        }

    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Enter the progress of the mission from 1 to 10 : ");
        int progress= input.nextInt();
        input.nextLine();// takes away the space
        if(progress < 0 || progress > 100){
            System.out.println("Invalid progress percentage. Please enter a value between 0 and 100.");
            return;
        }
        if (progress == 100) {
            status = "rescues complete";
        } else {
            status = "injured treated";
        }
        System.out.println("Mission progress updated. Current status: " + status);
    }



    @Override
    public void generateMissionReport() {
        System.out.println("\n-------Report for Rescue Mission-----------\n");
        System.out.println("\n Assigned Personnel:");
        System.out.println("1.Soldier name "+getFirstName()+"     2.Soldier name: "+getSecondName()+"      Medic name: "+getMed()+"\n1.ID: "+getFirstId()+"      2.ID: "+getSecondId()+"      Medic Id: "+getMedId());
        System.out.println("Mission name: \t"+missionName);
        System.out.println("Mission Id:  \t"+missionId);
        System.out.println("Start mission date: "+missionStartDate);
        System.out.println("End mission date: "+missionEndDate);
        System.out.println("Mission status: "+status);


    }
}
