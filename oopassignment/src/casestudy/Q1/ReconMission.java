package casestudy.Q1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReconMission extends Mission {
    private String SecondName;
    private String SecondId;
    private String FirstId;
    private String FirstName;
    protected List<Person> AssignedPersonneL =new ArrayList<>();
    Scanner input=new Scanner(System.in);

    public ReconMission() {
        super();
    }


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
        name.addFirst(firstName);

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
        id.addFirst(firstId);

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



    @Override
    public void assignTask() {
        if (name == null || name.size() < 2) {
            System.out.println("At least 2 personnel are required to assign tasks.");
            return;
        }
        for (String person : name) {
            System.out.println("Assigning reconnaissance task to: " + person);
        }
        System.out.println("Reconnaissance tasks have been assigned.");

    }

    @Override

    public void allocateResources() {
        System.out.print("Enter Resource provided : ");
        String resource=input.nextLine();
        while(resource.matches("\\d+(\\.\\d+)?") || resource.isEmpty() ||(!resource.equalsIgnoreCase("drones")&&!resource.equalsIgnoreCase("communication tools"))){
            if (resource.matches("\\d+(\\.\\d+)?") || resource.isEmpty() ){
                System.out.print(" invalid input please,Enter words: ");
                resource=input.nextLine();
            }
            else if((!resource.equalsIgnoreCase("drones")&&!resource.equalsIgnoreCase("communication tools"))){
                System.out.print("invalid input,valid(Drones and communication tools) retry: ");
                resource=input.nextLine();
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
        System.out.println("*******\t ReconMission \t*********");
        System.out.println("\n Assigned Personnel:");
        System.out.println("1.Soldier name "+getFirstName()+"     2.Soldier name: "+getSecondName()+"\n 1.ID:"+getFirstId()+"     3.ID: "+getSecondId());
        System.out.println("Mission name: \t"+missionName);
        System.out.println("Mission Id:  \t"+missionId);
        System.out.println("Start mission date: "+missionStartDate);
        System.out.println("End mission date: "+missionEndDate);
        System.out.println("Mission status: "+status);


    }



}
