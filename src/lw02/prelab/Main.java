import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        while(sc.hasNext()) {
            String[] transaction = new String[3];
            transaction[0] = sc.next();
            transaction[1] = sc.next();
            transaction[2] = sc.next();
            transactions.add(transaction);
        }
        sc.close();

        queue.addAll(transactions);
        while(!queue.isEmpty()) {
            String[] transaction = queue.poll();
            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            String[] customer = null;
            for(String[] data : customers) {
                if(data[0].equals(name)) {
                    customer = data;
                    break;
                }
            }

            if (customer == null) {
                customer = new String[]{name, "0"};
                customers.add(customer);
            }

            int balance = Integer.parseInt(customer[1]);
            if (type.equals("DEPOSIT")) {
                balance += amount;
                customer[1] = String.valueOf(balance);
            } else if (type.equals("WITHDRAW")) {
                if (amount <= balance) {
                    balance -= amount;
                    customer[1] = String.valueOf(balance);
                } else {
                    failed.push(transaction);
                }
            }
        }

        System.out.println("\n=== Final Balance ===");
        for(String[] customer : customers) {
            System.out.println(customer[0] + " : " + customer[1]);
        }
        System.out.println();

        System.out.println("=== Failed Transaction ===");
        while(!failed.isEmpty()) {
            String[] transaction = failed.pop();
            System.out.println(transaction[0] + " " + transaction[1] + " " + transaction[2]);
        }
    }
}