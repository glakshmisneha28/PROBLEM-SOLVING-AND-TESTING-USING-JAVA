package PSTJ;

import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public static boolean isOlderThan(Person p, int ageLimit) {
        return p.age > ageLimit;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            persons.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();
        String sortedNames = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .collect(Collectors.joining(" "));
        System.out.println(sortedNames);
        String filteredNames = persons.stream()
                .filter(p -> Person.isOlderThan(p, ageLimit))
                .map(Person::getName)
                .collect(Collectors.joining(" "));
        System.out.println(filteredNames);
        String upperCaseNames = persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));
        System.out.println(upperCaseNames);

        sc.close();
    }
}
