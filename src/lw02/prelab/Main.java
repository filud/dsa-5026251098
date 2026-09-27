import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();

        try (Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] transaction = line.split("\\s+");
                String name = transaction[0];
                String type = transaction[1];
                String amount = transaction[2];

                transactions.add(new String[]{name, type, amount});

                boolean exist = false;
                for (String[] customer : customers) {
                    if (customer[0].equals(name)) {
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    customers.add(new String[]{name, "0"});
                }
            }
        } catch (Exception e) {
            System.out.println("File transactions.txt tidak ditemukan.");
            return;
        }

        Queue<String[]> transactionQueue = new LinkedList<>();
        transactionQueue.addAll(transactions);

        Stack<String[]> failedTransactions = new Stack<>();

        while (!transactionQueue.isEmpty()) {
            String[] transaction = transactionQueue.poll();
            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            String[] customer = null;
            for (String[] c : customers) {
                if (c[0].equals(name)) {
                    customer = c;
                    break;
                }
            }

            int balance = Integer.parseInt(customer[1]);

            if (type.equals("DEPOSIT")) {
                balance += amount;
                customer[1] = String.valueOf(balance);
            } else if (type.equals("WITHDRAW")) {
                if (amount > balance) {
                    failedTransactions.push(transaction);
                } else {
                    balance -= amount;
                    customer[1] = String.valueOf(balance);
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] customer : customers) {
            System.out.println(customer[0] + " : " + customer[1]);
        }
        System.out.println();

        System.out.println("=== Failed Transactions ===");
        while (!failedTransactions.isEmpty()) {
            String[] transaction = failedTransactions.pop();
            System.out.println(transaction[0] + " " + transaction[1] + " " + transaction[2]);
        }
    }
}