package casestudy.Q1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {


        Scanner input=new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n-------MISSION SELECTION--------\n");
            System.out.print("1.Recon Mission\n2.Rescue Mission\n3.Combat mission \n4.Humanitarian Mission\n5.Exit\nEnter choice:");
            choice=input.nextInt();input.nextLine();

            switch (choice){
                case 1:
                    ReconMission n0=new ReconMission();
                    n0.setFirstName(n0.getFirstName());
                    n0.setFirstId(n0.getFirstId());
                    n0.setSecondName(n0.getSecondName());
                    n0.setSecondId(n0.getSecondId());
                    n0.assignTask();
                    n0.allocateResources();
                    n0.trackMissionProgress();
                    n0.generateMissionReport();
                    break;

                case 2:
                    RescueMission n1=new RescueMission();
                    n1.setFirstName(n1.getFirstName());
                    n1.setFirstId(n1.getFirstId());
                    n1.setSecondName(n1.getSecondName());
                    n1.setSecondId(n1.getSecondId());
                    n1.setMed(n1.getMed());
                    n1.setMedId(n1.getMedId());
                    n1.assignTask();
                    n1.allocateResources();
                    n1.trackMissionProgress();
                    n1.generateMissionReport();
                    break;
                case 3:
                    CombatMission n2=new CombatMission();
                    n2.setFirstName(n2.getFirstName());
                    n2.setFirstId(n2.getFirstId());
                    n2.setSecondName(n2.getSecondName());
                    n2.setSecondId(n2.getSecondId());
                    n2.setThirdName(n2.getThirdName());
                    n2.setThirdId(n2.getThirdId());
                    n2.assignTask();
                    n2.allocateResources();
                    n2.trackMissionProgress();
                    n2.generateMissionReport();
                    break;
                case 4:
                    HumanitarianMission n3=new HumanitarianMission();
                    n3.assignTask();
                    n3.allocateResources();
                    n3.trackMissionProgress();
                    n3.generateMissionReport();
                    break;
                case 5:
                    System.out.println("exitiitnng ");
                    break;
                default:
                    System.out.println("invalid input ,please enter (1-5): ");
                    break;
            }



        }while (choice<5);


    }

}
