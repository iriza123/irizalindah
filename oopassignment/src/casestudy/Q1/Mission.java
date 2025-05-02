package casestudy.Q1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract   class Mission extends Person {

    protected ArrayList<String> missionId = new ArrayList<>();
    protected ArrayList<String> missionName = new ArrayList<>();
    //protected List<String> name = new ArrayList<>(Arrays.asList(null, null, null, null));
    protected Date missionStartDate;
    protected Date missionEndDate;
    protected String status ;
    protected List<Person> assignedPersonneI =new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public Mission() {
        super();
        System.out.print("Enter the mission id: ");
        String id = input.nextLine();
        while (id.isEmpty() || !id.matches("\\d+")) {
            System.out.print("Invalid input,Enter numbers: ");
            id = input.nextLine();
        }
        missionId.add(id);
        System.out.print("Enter the mission name: ");
        String name = input.nextLine();
        while (name.matches("\\d+(\\.\\d+)?") || name.isEmpty()) {
            System.out.println("Invalid input,please Enter words : ");
            name = input.nextLine();
        }
        missionName.add(name);

        Date missionStartDate;
        boolean valid=false;
        while(!valid) {
            System.out.print("Enter the Starting date (dd/MM/yyyy): ");
            try {
                String inputDate = input.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                this.missionStartDate = dateFormat.parse(inputDate);
                valid=true;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                this.missionStartDate = null;
            }
        }
        Date missionEndDate;
        boolean valid1=false;
        System.out.print("Enter the Ending Date : ");
        try{
            String date= input.nextLine();
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            this.missionEndDate=dateFormat.parse(date);
            valid1=true;
        } catch (Exception e) {
            System.out.println("Invalid date format.please enter dd/MM/yyyy");
            this.missionEndDate=null;
        }


        String status;
        System.out.print("Enter the Mission Status: ");
        status=input.nextLine();
        while(status.isEmpty() || status.matches("\\d+(\\.\\d+)?") || (!status.equalsIgnoreCase("planned")&&!status.equalsIgnoreCase("in progress")&&!status.equalsIgnoreCase("Complete")&&!status.equalsIgnoreCase("rescues complete")&& !status.equalsIgnoreCase("injured treated"))){
            if ((!status.equalsIgnoreCase("planned")&&!status.equalsIgnoreCase("in progress")&&!status.equalsIgnoreCase("Complete")&&!status.equalsIgnoreCase("rescues complete")&& !status.equalsIgnoreCase("injured treated"))) {
                System.out.print("invalid Entry.valid words(planned,in progress,complete,rescues complete,injured treated) ");
                status=input.nextLine();
            }
            else if (status.isEmpty() || status.matches("\\d+(\\.\\d+)?") ){
                System.out.print("invalid input .please enter words: ");
                status=input.nextLine();

            }

        }
        this.status = status;
    }
    //    public void addAssignedPersonnel(Person personnel) {
//        if (personnel != null) {
//            assignedPersonneI.add(personnel);
//        } else {
//            System.out.println("Invalid personnel. Cannot add to the list.");
//        }
//    }
    public void Display(){
        System.out.println("ID: "+missionId);
        System.out.println("Name: "+missionName);
        System.out.println("Start date: "+missionStartDate);
        System.out.println("End date: "+missionEndDate);
    }

    public abstract void assignTask();

    public abstract void allocateResources();

    public abstract void trackMissionProgress();

    public abstract void generateMissionReport();
}