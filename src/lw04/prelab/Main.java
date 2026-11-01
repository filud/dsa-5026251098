import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = sc.nextInt();
        int[] branches = new int[n];
        for(int i = 0; i < n; i++) {
            branches[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] target = new int[m];
        for(int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }

        insertionSort(branches, 3);

        for(int num : branches) {
            System.out.print(num + " ");
        }

        System.out.println();

        for(int i = 0; i < m; i++) {
            int index = linearSearch(branches, target[i]);
            if(index != -1) {
                System.out.println(target[i] + ": FOUND at index " + index);
            } else {
                System.out.println(target[i] + ": NOT FOUND");
            }
        }
    }

    public static void insertionSort(int[] array, int passes) {
        for(int i = 1; i <= passes; i++) {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
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