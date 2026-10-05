// intip.in/ULW03A

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Enrollment Checks =====");

        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> enrollment = new LinkedHashMap<>();
        int rejectedOperations = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String operation = parts[0];
            String course = parts[1];

            if (operation.equals("REGISTER")) {
                String[] courseData = course.split(" ", 2);
                String courseCode = courseData[0];
                int count = Integer.parseInt(courseData[1]);
                if (count <= 0) {
                    rejectedOperations++;
                } else {
                    if (enrollment.containsKey(courseCode)) {
                        int currentCount = enrollment.get(courseCode);
                        enrollment.put(courseCode, currentCount + count);
                    } else {
                        enrollment.put(courseCode, count);
                    }
                }
            } else if (operation.equals("WITHDRAW")) {
                String[] courseData = course.split(" ", 2);
                String courseCode = courseData[0];
                int count = Integer.parseInt(courseData[1]);
                if (count <= 0) {
                    rejectedOperations++;
                } else {
                    if (enrollment.containsKey(courseCode) && enrollment.get(courseCode) >= count) {
                        int currentCount = enrollment.get(courseCode);
                        enrollment.put(courseCode, currentCount - count);
                    } else {
                        rejectedOperations++;
                    }
                }
            } else if (operation.equals("CHECK")) {
                String courseCode = course;
                if (enrollment.containsKey(courseCode)) {
                    int currentCount = enrollment.get(courseCode);
                    System.out.println(courseCode + ": " + currentCount + " students");
                } else {
                    System.out.println(courseCode + ": Not found");
                }
            }
        }
        sc.close();

        System.out.println();

        System.out.println("===== Final Enrollment =====");
        for (String course : enrollment.keySet()) {
            System.out.println(course + ": " + enrollment.get(course) + " students");
        }
        System.out.println();

        System.out.println("Rejected operations: " + rejectedOperations);
    }
}
