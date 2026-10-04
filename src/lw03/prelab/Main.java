import java.util.*;

public class Main {
    public static void main(String[] args) {
        playlist();
        participants();
        inventory();
    }

    public static void playlist() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        ArrayList<String> playlist = new ArrayList<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 3);
            String operation = parts[0];

            if (operation.equals("ADD")) {
                String song = parts[1];
                playlist.add(song);
            } else if (operation.equals("INSERT")) {
                int index = Integer.parseInt(parts[1]);
                String song = parts[2];
                playlist.add(index, song);
            } else if (operation.equals("REMOVE")) {
                String song = parts[1];
                playlist.remove(song);
            }
        }
        sc.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for(int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
    }
    
    public static void participants() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();
        int duplicateCount = 0;
        while(sc.hasNextLine()) {
            String name = sc.nextLine();
            if (!participants.add(name)) {
                duplicateCount++;
            }
        }
        sc.close();

        System.out.println("\n===== Problem 2 =====");

        System.out.println("Unique participants: " + participants.size());
        int number = 1;
        for(String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println("Duplicate entries: " + duplicateCount);
    }

    public static void inventory() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        LinkedHashMap<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 3);
            String type = parts[0];
            String item = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {
                if (inventory.containsKey(item)) {
                    inventory.put(item, inventory.get(item) + quantity);
                } else {
                    inventory.put(item, quantity);
                }
            } else if (type.equals("SELL")) {
                if (inventory.containsKey(item) && inventory.get(item) >= quantity) {
                    inventory.put(item, inventory.get(item) - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        sc.close();

        System.out.println("\n===== Problem 3 =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}
