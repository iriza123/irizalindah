package casestudy.Q1;

import java.util.Scanner;

public class CombatMission extends Mission {
    private String FirstName;
    private String FirstId;
    private String SecondName;
    private String SecondId;
    private String ThirdName;
    private String ThirdId;
    Scanner input=new Scanner(System.in);

    public CombatMission() {
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
        id.add( 0,firstId);
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

    public String getThirdName() {
        return ThirdName;
    }

    public void setThirdName(String thirdName) {
        System.out.print("Enter the Third person name: ");
        thirdName= input.nextLine();
        while (thirdName.isEmpty() || thirdName.matches("\\d+(\\.\\d+)?")) {
            System.out.print("Invalid input. Enter a valid name (letters only): ");
            thirdName = input.nextLine();
        }
        ThirdName = thirdName;
    }

    public String getThirdId() {
        return ThirdId;
    }

    public void setThirdId(String thirdId) {
        System.out.print("Enter the  third Id: ");
        thirdId= input.nextLine();
        while (thirdId.isEmpty() || !thirdId.matches("\\d+")) {
            System.out.print("Invalid input Enter whole number: ");
            thirdId = input.nextLine();
        }
        ThirdId = thirdId;
    }

    @Override
    public void assignTask() {
        System.out.print("Enter combat-specific :");
        String combat= input.nextLine();
        while(combat.isEmpty() || combat.matches("\\d+(\\.\\d+)?") || (!combat.equals("defense")&&!combat.equals("attack")&&!combat.equals("strategy."))){
            if (combat.isEmpty() || combat.matches("\\d+(\\.\\d+)?")){
                System.out.print("Invalid input,Enter words: ");
                combat= input.nextLine();
            } else if ((!combat.equals("defense")&&!combat.equals("attack")&&!combat.equals("strategy."))) {
                System.out.print("invalid input please enter valid words(defense, attack, and strategy.): ");{

                }

            }
        }
    }

    @Override
    public void allocateResources() {
        System.out.print("Resource allocated (ammunition, vehicles, and weaponry.),choice:  ");
        String resource= input.nextLine();
        while(resource.isEmpty() || resource.matches("\\d+(\\.\\d+)?") || (!resource.equals("ammunition,") && !resource.equals("vehicles") && !resource.equals("weaponry"))){
            if (resource.isEmpty() || resource.matches("\\d+(\\.\\d+)?")){
                System.out.print("invalid input ,please enter words: ");
                resource= input.nextLine();
            } else if ((!resource.equals("ammunition,") && !resource.equals("vehicles") && !resource.equals("weaponry"))) {
                System.out.print("invalid words enter valid words(Allocates ammunition, vehicles, and weaponry.): ");
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
            status = "Mission perfect complete";
        } else {
            status = "Mission in the movement";
        }
        System.out.println("Mission progress updated. Current status: " + status);
    }



    @Override
    public void generateMissionReport() {
        System.out.println("\n-------Report for combat  Mission-----------\n");
        System.out.println("\n Assigned Personnel:");
        System.out.println("1.Soldier name "+getFirstName()+"     2.Soldier name: "+getSecondName()+"      Soldier name: "+getThirdName()+"\n1.ID: "+getFirstId()+"      2.ID: "+getSecondId()+"       3.Id: "+getThirdId());
        System.out.println("Mission name: \t"+missionName);
        System.out.println("Mission Id:  \t"+missionId);
        System.out.println("Start mission date: "+missionStartDate);
        System.out.println("End mission date: "+missionEndDate);
        System.out.println("Mission status: "+status);


    }

}
