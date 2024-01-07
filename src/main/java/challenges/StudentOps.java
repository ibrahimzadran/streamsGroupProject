package challenges;

import domain.Student;

import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentOps {
    //  Question 1: Filter Students by Gender: Write a method to filter a list of students by their gender.

    public static List<Student> filterStudentsByGender(List<Student> students) {
        return students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase(student.getGender()))
                .limit(5)
                .collect(Collectors.toList());
    }

    // Question 2: Sort Students by Age: Sort the list of students by their age (based on date of birth).
    public static List<Student> sortStudentsByAge(List<Student> students) {
        LocalDate currentDate = LocalDate.now();
        students.forEach(student -> {
            LocalDate dob = student.getDob();
            Period period = Period.between(dob, currentDate);
            student.setAge(period.getYears());
        });
        return students.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .limit(5)
                .toList();
    }

    // Question 3: Calculate Average Age: Calculate the average age of all students.
    public static double averageAge(List<Student> students) {
        return students
                .stream()
                .map(Student::getDob)
                .mapToDouble(LocalDate::getYear)
                .average()
                .orElse(0);
    }

    // 4 Question Print Student Names: Print the full names of all students.
    public static void printNamesOfStudent(List<Student> students) {
        students
                .stream()
                .map(p -> p.getFirst_name() + " " + p.getLast_name())
                .limit(5)
                .forEach(System.out::println);
    }

    // Question 5: Group Students by Gender: Group the students by gender.

    public static Map<String,List<Student>> groupByGender(List<Student> students) {
        return students
                .stream()
                .limit(5)
                .collect(Collectors.groupingBy(Student::getGender));

    }

    // Question 6: Find Maximum Age: Find the maximum age among all students.
    public static int maximumAge(List<Student> students) {
        return students.stream()
                .mapToInt(Student::getAge)
                .max()
                .orElse(0);
    }

    // Question 7: Transform to Map: Convert the list of students into a map where the key is the student ID and the value is the student object.
    public static Map<Integer, Student> convertTomap(List<Student> students) {
        return students
                .stream()
                .limit(5)
                .collect(Collectors.toMap(Student::getId, student -> student));
    }

    // Question 8: Get Student Emails: Retrieve a list of student emails.
    public static List<String> studentEmail(List<Student> students) {
        return students
                .stream()
                .map(Student::getEmail)
                .limit(10)
                .collect(Collectors.toList());
    }

    // Question 9: Check if Any Student is Adult: Check if any student is an adult (age 18 or older).
    public static boolean ifAnyStudentIsAdult(List<Student> students) {
        return students
                .stream()
                .anyMatch(student -> student.getAge() >= 18);
    }

    // Question 10: Count Students by Gender: Count the number of students for each gender.
    public static Map<String, Long> countStudentsByGender(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
    }

    // Question 11: Find Youngest Female Student: Find the youngest female student.
    public static Student youngestFemaleStudent(List<Student> students) {
        return students
                .stream()
                .filter(student -> "Female".equals(student.getGender()))
                .min(Comparator.comparing(Student::getAge))
                .orElse(null);
    }

    // Question 12: Join Student Names: Join the first names of all students into a single string.
    public static String joinStudentNames(List<Student> students) {
        return students
                .stream()
                .map(Student::getFirst_name)
                .limit(10)
                .collect(Collectors.joining(", "));
    }

    // Question 13:Calculate Age Sum: Calculate the sum of ages for all students.
    public static int sumOfAge(List<Student> students) {
        return students
                .stream()
                .mapToInt(Student::getAge)
                .sum();
    }

    //Question 14: Check if All Students are Adults: Check if all students are adults (age 18 or older).
    public static boolean ifAllStudentAreAdult(List<Student> students) {
        return students
                .stream()
                .allMatch(student -> student.getAge() >= 18);
    }

    //Question 15: Find Oldest Student: Find the oldest student.
    public static Student oldestStudent(List<Student> students) {
        return students
                .stream()
                .max(Comparator.comparing(Student::getAge))
                .orElse(null);
    }

    //Question 16:Convert to Uppercase: Convert all student first names to uppercase.
    public static List<String> firstNameToUpperCase(List<Student> students) {
        return students
                .stream()
                .map(student -> student.getFirst_name().toUpperCase())
                .limit(5)
                .collect(Collectors.toList());
    }

    //Question 17: Find Student by ID: Find a student by their ID.
    public static int findStudentByID(List<Student> students) {
        return students
                .stream()
                .mapToInt(Student::getId)
                .limit(5)
                .findFirst()
                .orElse(0);
    }

    //Question 18: Compute Age Distribution: Compute the distribution of ages (e.g., count of students for each age).
    public static Map<Integer, Long> countOfNumberForEachAge(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
    }

    //Question 19:Group Students by Age: Group the students by their age.
    public static Map<Integer, List<Student>> groupByAge(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.groupingBy(Student::getAge));
    }

    //Question 20: Calculate Age Standard Deviation: Calculate the standard deviation of ages for all students.
    public static double calculateAgeStandardDeviation(List<Student> students) {
        int n = students.size();
        if (n <= 1) {
            return 0.0;
        }

        double mean =
                students
                        .stream()
                        .mapToInt(Student::getAge)
                        .average()
                        .orElse(0.0);

        double sumSquaredDiff =
                students
                        .stream()
                        .mapToDouble(student -> Math.pow(student.getAge()- mean,2))
                        .sum();

        double variance = sumSquaredDiff / n;

        return Math.sqrt(variance);
    }
}



