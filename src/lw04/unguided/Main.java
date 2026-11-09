import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * Raka menggunakan selection sort dan linear search,
         * selection sort: mencari kartu terkecil, lalu menukarnya dengan kartu yang berada di paling kiri
         * linear search: mencari satu per satu dari kiri hingga kanan hingga menemukan kartu yang diinginkan
         */

        example1();

        System.out.println();
        
        example2();
    }

    public static void example1() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int n = sc.nextInt();
        int[] cardNumbers = new int[n];
        for(int i = 0; i < n; i++) {
            cardNumbers[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] target = new int[m];
        for(int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }

        selectionSort(cardNumbers, 2);
        for(int num : cardNumbers) {
            System.out.print(num + " ");
        }

        System.out.println();

        for(int i = 0; i < target.length; i++) {
            int index = linearSearch(cardNumbers, target[i]);
            if(index != -1) {
                System.out.println(target[i] + ": FOUND at index " + index);
            } else {
                System.out.println(target[i] + ": NOT FOUND");
            }
        }
    }

    public static void example2() {
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("cards2.txt"));
        int n = sc2.nextInt();
        int[] cardNumbers = new int[n];
        for(int i = 0; i < n; i++) {
            cardNumbers[i] = sc2.nextInt();
        }

        int m = sc2.nextInt();
        int[] target = new int[m];
        for(int i = 0; i < m; i++) {
            target[i] = sc2.nextInt();
        }

        selectionSort(cardNumbers, 2);
        for(int num : cardNumbers) {
            System.out.print(num + " ");
        }

        System.out.println();

        for(int i = 0; i < target.length; i++) {
            int index = linearSearch(cardNumbers, target[i]);
            if(index != -1) {
                System.out.println(target[i] + ": FOUND at index " + index);
            } else {
                System.out.println(target[i] + ": NOT FOUND");
            }
        }

    }

    public static void selectionSort(int[] array, int passes) {
        for(int i = 0; i < passes; i++) {
            int min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static int linearSearch(int[] array, int target) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
