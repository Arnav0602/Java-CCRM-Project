import java.util.*;

class Student {
    String id;
    String name;
    String email;

    Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return id + " - " + name + " (" + email + ")";
    }
}

class Course {
    String code;
    String title;
    int credits;

    Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public String toString() {
        return code + " - " + title + " [" + credits + " credits]";
    }
}

class Enrollment {
    Student student;
    Course course;

    Enrollment(Student s, Course c) {
        this.student = s;
        this.course = c;
    }

    public String toString() {
        return student.name + " enrolled in " + course.title;
    }
}


public class CCRM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {

            System.out.println("\n===== CCRM SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. View Students");
            System.out.println("5. View Courses");
            System.out.println("6. View Enrollments");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    students.add(new Student(id, name, email));
                    System.out.println("Student added!");
                    break;

                case 2:
                    System.out.print("Course Code: ");
                    String code = sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    int credits = 0;
                    while (true) {
                        System.out.print("Credits (number only): ");

                        if (sc.hasNextInt()) {
                            credits = sc.nextInt();
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                            sc.nextLine();
                        }
                    }

                    courses.add(new Course(code, title, credits));
                    System.out.println("Course added!");
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();

                    Student foundStudent = null;
                    for (Student s : students) {
                        if (s.id.equals(sid)) {
                            foundStudent = s;
                            break;
                        }
                    }

                    if (foundStudent == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    System.out.print("Enter Course Code: ");
                    String ccode = sc.nextLine();

                    Course foundCourse = null;
                    for (Course c : courses) {
                        if (c.code.equals(ccode)) {
                            foundCourse = c;
                            break;
                        }
                    }

                    if (foundCourse == null) {
                        System.out.println("Course not found!");
                        break;
                    }

                    enrollments.add(new Enrollment(foundStudent, foundCourse));
                    System.out.println("Enrollment successful!");
                    break;

                case 4:
                    System.out.println("---- Students ----");
                    for (Student s : students) System.out.println(s);
                    break;

                case 5:
                    System.out.println("---- Courses ----");
                    for (Course c : courses) System.out.println(c);
                    break;

                case 6:
                    System.out.println("---- Enrollments ----");
                    for (Enrollment e : enrollments) System.out.println(e);
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
