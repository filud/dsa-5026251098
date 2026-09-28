//intip.in/2ALW2UG

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        while(sc.hasNext()) {
            String[] borrow = new String[3];
            borrow[0] = sc.next();
            borrow[1] = sc.next();
            borrow[2] = "2"; // max borrow
            request.add(borrow);
        }
        sc.close();

        /*String[] book = null;
        for (String[] data : books) {
            if(data[1].equals(book)) {
                book = data;
                break;
            }
        } */

        int kalkulus = 2;
        int fisika = 1;
        int statistika = 2;

        queue.addAll(request);
        while(!queue.isEmpty()) {
            String[] borrow = queue.poll();
            String name = borrow[0];
            String book = borrow[1];
            int maxBorrow = Integer.parseInt(borrow[2]);

            if(maxBorrow <= 0) {
                failed.push(borrow);
            } else {
                maxBorrow--;
            }

            if (book.equals("Kalkulus")) {
                if (kalkulus > 0) {
                    kalkulus--;
                    books.add(new String[]{name, book});
                } else {
                    failed.push(borrow);
                }
            } else if (book.equals("Fisika")) {
                if (fisika > 0) {
                    fisika--;
                    books.add(new String[]{name, book});
                } else {
                    failed.push(borrow);
                }
            } else if (book.equals("Statistika")) {
                if (statistika > 0) {
                    statistika--;
                    books.add(new String[]{name, book});
                } else {
                    failed.push(borrow);
                }
            }
        }

        System.out.println("\n=== Succesfully Processed Request ===");
        for(String[] req : books) {
            System.out.println(req[0] + " " + req[1]);
        }

        System.out.println("\n=== Remaining Book ===");
        System.out.println("Kalkulus : " + kalkulus);
        System.out.println("Fisika : " + fisika);
        System.out.println("Statistika : " + statistika);


        System.out.println("=== Failed Request ===");
        while(!failed.isEmpty()) {
            String[] borrow = failed.pop();
            System.out.println(borrow[0] + " " + borrow[1]);
        }

    }
}
