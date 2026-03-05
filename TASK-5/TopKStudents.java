import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class TopKStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int marks = sc.nextInt();
            list.add(new Student(name, marks));
        }

        int k = sc.nextInt();

        list.stream()
            .sorted(Comparator.comparingInt((Student s) -> s.marks).reversed()
            .thenComparing(s -> s.name))
            .limit(k)
            .map(s -> s.name)
            .forEach(s -> System.out.print(s + " "));
    }
}
