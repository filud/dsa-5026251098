//package lw01.prelab;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        List<PrintJob> jobs = new ArrayList<>();
        
        Scanner sc = new Scanner(main.class.getResourceAsStream("jobs.txt"));
        while (sc.hasNext()) {
            String type = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();
                
            if (type.equals("MONO")) {
                jobs.add(new MonoPrint(id, pages));
            } else if (type.equals("COLOUR")) {
                jobs.add(new ColourPrint(id, pages));
            }
        }
        
        for(PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}