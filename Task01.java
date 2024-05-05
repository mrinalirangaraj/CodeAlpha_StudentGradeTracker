import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student " + (i + 1) + "'s name:");
            String name = scanner.next();
            System.out.print("Enter student " + (i + 1) + "'s score: ");
            int score = scanner.nextInt();
            students[i] = new Student(name, score);
        }
        scanner.close();

        int sum = 0;
        int highestScore = students[0].getScore();
        int lowestScore = students[0].getScore();

        for (Student student : students) {
            sum += student.getScore();
            if (student.getScore() > highestScore) {
                highestScore = student.getScore();
            }
            if (student.getScore() < lowestScore) {
                lowestScore = student.getScore();
            }
        }

        double average = (double) sum / numStudents;

        System.out.println("Average score: " + average);
        System.out.println("Highest score: " + highestScore);
        System.out.println("Lowest score: " + lowestScore);

        for (Student student : students) {
            System.out.println(student.getName() + "'s Grade: " + calculateGrade(student.getScore()));
        }
    }

    public static char calculateGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}