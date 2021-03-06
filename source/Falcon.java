package Falcon;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Double.parseDouble;

public class Falcon {
    /* ------- path of text file -------- */
    private static final String FILENAME = "D:\\Falcon\\Falcon\\bin\\Falcon\\falcons1.txt";

    /* ------- color of text ---------- */
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static TimerTask myTask1 = null;
    private static TimerTask myTask2 = null;
    static Thread thread1 = new Thread();
    static Thread thread2 = new Thread();
    static Thread thread3 = new Thread();
    static Thread thread4 = new Thread();
    static Thread thread5 = new Thread();
    static Thread thread6 = new Thread();
    static Thread thread7 = new Thread();
    boolean containNot = false;


    public static void main(String[] args) throws InterruptedException {
        Timer timer1 = new Timer("My Timer1", false);
        Timer timer2 = new Timer("My Timer2", false);
        int count = 60; //60 seconds
        int countTimeReadFile = 2; //30 seconds
        int i,j,k,l,m,n,o;
        Falcon readFile = new Falcon();
        String yes = "yes";
        String no = "no";
        long delay = 1000L;

        myTask1 = new MyTimerTask(count, new Runnable() {
            public void run() {
                System.exit(0);
            }
        });
        myTask2 = new MyTimerTask(count, new Runnable() {
            public void run() {
                System.exit(0);
            }
        });


        //Start
        Scanner Sc = new Scanner(System.in);

        timer1.scheduleAtFixedRate(myTask1, delay, delay);

        Thread.currentThread();
        System.out.print("Code Start : ");

        String start = Sc.nextLine();
        timer1.cancel();

        //Read File (show file 30 seconds)
        readFile.showReadFile();
        if(readFile.containNot == true){
            System.exit(0);
        }
        for (i = countTimeReadFile - 1; i > 0; i--) {
            thread1.sleep(1000);
        }
        if (i == 0) {
            System.out.print("Start (Yes or No) : ");
            timer2.scheduleAtFixedRate(myTask2, delay, delay);
            String choose = Sc.nextLine();
            while(!choose.toLowerCase().equals("yes") && !choose.toLowerCase().equals("no")){
                System.out.print("Please enter between (Yes or No) : ");
                choose = Sc.nextLine();
            }
            timer2.cancel();
            if (choose.toLowerCase().equals(yes)) {
                //Water Injection (10 seconds)
                System.out.print("Water Injection: ");
              
                for(j = 10 ; j > 0 ; j--){
                    thread2.sleep(1000);
                    if(j > 3) {
                    	System.out.print(j + " ");
                    }
                    //Engine Controller: ignition sequence (start)
                    if(j==3){
                    	System.out.println();
                    	System.out.print("Engine Controller:Tgnition sequence");
                    }
                }
                //Launch: Nine Merlin Engines (start)
                if(j==0){
                	System.out.println();
                	System.out.print("Launch:Nine merlin");
                }

                System.out.println();
                System.out.print("Pressure: ");
                //Pressure 0 - 100% in 1 minutes
                for(k = 0 ; k <= 100 ; k++){
                    thread3.sleep(600);
                    System.out.print(k+"% ");
                }
                //Maximum Dynamic Pressure (start)
                if(k==100){
                	System.out.println();
                	System.out.println("Maximum Dynamic Pressure!!");
                }
                
                //First Stage            
                System.out.println();
                System.out.println("First Stage: Main Engine Cutted off");
                for(l = 3 ; l > 0 ; l--){
                    thread4.sleep(1000);
                }

                
                System.out.println("Start Engine Second Stage");
                System.out.print("Pressure: ");
                //Pressure 0 - 100% in 1 minutes
                for(k = 0 ; k <= 100 ; k++){
                    thread3.sleep(600);
                    System.out.print(k+"% ");
                }
                
                System.out.println();
                System.out.println("Main Engine Cutted off");
                for(l = 2; l > 0 ; l--) {
                	thread4.sleep(1000);
                }
                System.out.println("Drgon Deployment");
                for(l = 3; l > 0 ; l--) {
                	thread4.sleep(1000);
                }
                System.out.println("Done!!!");
                
                //Payload Fairing
                System.out.println("Payload Fairing");
                
                System.out.println();
                //Coordinate in latitude and longtitude
                System.out.print("Coordinate (x,y) : ");
                String co = Sc.nextLine();
                co = co.replaceAll("[\\s|\\u00A0]+", "");
                int split = co.indexOf(",");

                double latitude = Double.parseDouble(co.substring(1,split));
                double longtitude = Double.parseDouble(co.substring(split+1,co.length()-1));

                if((latitude < -90 || latitude > 90) || (longtitude < -180 || longtitude > 180)) {
                    System.out.println("Invalid Coordinate");
                    System.exit(0);
                }

                //Flip: Cold Gas Thruster
                System.out.println();
                System.out.print("Flip: ");
                for(m = 3 ; m > 0 ; m--){
                    thread5.sleep(1000);
                    System.out.println("Cold Gas Thruster " + m + "s ");
                }

                //BoostBack Burn
                System.out.println();
                System.out.print("BoostBack Burn: ");
                for(n = 5 ; n > 0 ; n--){
                    thread6.sleep(1000);
                    System.out.print(n + "s ");
                }

                //Entry Burn with Expand Grid Fins
                System.out.println();
                System.out.println("Entry Burn with Expand Grid Fins");

                //Landing Burn
                System.out.print("Landing Burn: ");
                for(o = 3; o > 0; o--){
                    thread7.sleep(1000);
                    System.out.print(o + "s ");
                }

                //Done !!!
                System.out.println();
                System.out.println("Done!!!");
                System.exit(0);

            } else if (choose.toLowerCase().equals(no)) {
                System.out.print("End of program");
            }


        }
    }

    // Read File Method
    public void showReadFile(){
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            System.out.println("-------------- Prelaunch Checks --------------");
            while ((sCurrentLine = br.readLine()) != null) {
                if(sCurrentLine.contains("not")){
                    int not = sCurrentLine.lastIndexOf("n");
                    System.out.println(ANSI_RED + sCurrentLine.substring(0,not) + "not" + ANSI_RESET);
                    containNot = true;
                }
                else if(sCurrentLine.contains("ok")){
                    int ok = sCurrentLine.lastIndexOf("o");
                    System.out.println(ANSI_GREEN + sCurrentLine.substring(0,ok) + "ok" + ANSI_RESET);
                }
                else{
                    System.out.println(sCurrentLine);
                }
            }
            System.out.println("----------------------------------------------");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
class MyTimerTask extends TimerTask {
    private int count;
    private Runnable doWhenDone;

    public MyTimerTask(int count, Runnable doWhenDone) {
        this.count = count;
        this.doWhenDone = doWhenDone;
    }

    @Override
    public void run() {
        count--;

       // System.out.println(count);
        if (count == 0) {
            System.out.println("End");
            cancel();
            doWhenDone.run();

        }
    }
}