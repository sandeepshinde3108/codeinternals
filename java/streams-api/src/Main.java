import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {
        List<Student> students = constructStudents();

        //filter all students with age greater than 10

        System.out.println("---------------------Traditional way of filtering the data-----------------");
        //traditional way of filtering the data
        for (Student student : students) {
            if(student.getAge() >= 10)
                System.out.println(student.toString());
        }

        System.out.println("--------------------Streams API way of filtering the data-------------------");
        //Streams API way of filtering the data
        students.stream().filter(student -> student.getAge() >= 10).forEach(System.out::println);

        System.out.println("--------------------filter()-------------------");
        //filter()
        Stream<Student> filterStream = students.stream()
                                               .filter(student -> student.getAge() < 10);
        filterStream.forEach(System.out::println);

        System.out.println("--------------------map()-------------------");
        //map()
        Stream<String> studentNames = students.stream()
                                              .map(student -> student.getName());
        studentNames.forEach(System.out::println);

        System.out.println("--------------------flatmap()-------------------");
        //flatmap()

        Stream<String> staff = students.stream()
                .flatMap(student -> Arrays.stream(student.getSchool().getStaff()))
                .distinct();
        staff.forEach(System.out::println);

        System.out.println("--------------------limit()-------------------");
        //limit()
        Stream<Student> limitStudents = students.stream()
                                                .limit(3);
        limitStudents.forEach(System.out::println);

        System.out.println("--------------------sorted() - ascending-------------------");
        //sorted() - sort by one field in ascending order
        Stream<Student> sortedByAge = students.stream()
                                              .sorted(Comparator.comparing(Student::getAge));
        sortedByAge.forEach(System.out::println);

        System.out.println("--------------------sorted() - descending-------------------");
        //sorted() - sort by one field in descending order
        Stream<Student> sortedByAgeDesc = students.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed());
        sortedByAgeDesc.forEach(System.out::println);

        System.out.println("--------------------sorted() - multi field-------------------");
        //sorted() - sort by multiple fields
        Stream<Student> multiFieldSort = students.stream()
                                                 .sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName));
        multiFieldSort.forEach(System.out::println);

        System.out.println("--------------------distinct()-------------------");
        //distinct()

        Stream<String> distinctSchoolNames = students.stream()
                                                     .map(student -> student.getSchool().getName())
                                                     .distinct();
        distinctSchoolNames.forEach(System.out::println);

        System.out.println("--------------------collect()-------------------");
        //collect()
        List<Student> studentList = students.stream()
                                            .limit(3)
                                            .collect(Collectors.toList());
        studentList.forEach(System.out::println);

        System.out.println("--------------------count()-------------------");
        //count()
        System.out.println("No of Students: " + students.stream().count());

        System.out.println("--------------------anyMatch()-------------------");
        //anyMatch()
        System.out.println("Any student of age 10? :" + students.stream().anyMatch(student -> student.getAge() == 10));

        System.out.println("--------------------allMatch()-------------------");
        //allMatch()
        System.out.println("Are all students of age 10? : " + students.stream().allMatch(student -> student.getAge() == 10));

        System.out.println("--------------------noneMatch()-------------------");
        //noneMatch()
        System.out.println("None of the students are of age 10? : " + students.stream().noneMatch(student -> student.getAge() == 10));

        System.out.println("--------------------reduce()-------------------");
        //reduce()
        Optional<String> commaSeparatedStudentNames = students.stream()
                                                              .map(student -> student.getName())
                                                              .reduce((s1, s2) -> s1 + "," + s2);
        System.out.println(commaSeparatedStudentNames.get());

        System.out.println("--------------------findFirst()-------------------");
        //findFirst()
        Optional<Student> firstStudent = students.stream()
                                                 .findFirst();
        System.out.println(firstStudent.get());

        System.out.println("--------------------findAny()-------------------");
        //findAny()
        Optional<Student> anyStudent = students.stream()
                                               .filter(student -> student.getAge() > 10)
                                               .findAny();
        System.out.println(anyStudent.get());
    }

    /**
     * Construct Students data
     * @return - List of Students
     */
    private static List<Student> constructStudents(){
        final School vibgyorSchool = new School("Vibgyor School", "Mumbai", SyllabusPattern.CBSE, 50, new String[]{"Marry", "Suzzane", "Shanaya"});
        final School lexiconSchool = new School("Lexicon School", "Pune", SyllabusPattern.CBSE, 70, new String[]{"Luci", "Kristine", "Shabana"});
        final School bishopSchool = new School("Bishop School", "Pune", SyllabusPattern.ICSE, 50, new String[]{"Neelam", "Raj", "Riddhi"});
        final School ryanSchool = new School("Ryan School", "Delhi", SyllabusPattern.ICSE, 150, new String[]{"Rajeshwari", "Dipti", "Ramesh"});
        final School dpsSchool = new School("Delhi Public School", "Delhi", SyllabusPattern.CBSE, 100, new String[]{"Kriti", "Dipesh", "John"});

        List<Student> students = new ArrayList<Student>(){
            {
                //vibgyor students
                add(new Student(1, "Rishab", 10, vibgyorSchool));
                add(new Student(2, "Rahul", 8, vibgyorSchool));
                add(new Student(3, "Adit", 14, vibgyorSchool));

                //lexicon students
                add(new Student(1, "Udit", 12, lexiconSchool));
                add(new Student(2, "Ayansh", 9, lexiconSchool));
                add(new Student(3, "Ansh", 7, lexiconSchool));

                //bishop students
                add(new Student(1, "Rizwan", 7, bishopSchool));
                add(new Student(2, "Ria", 13, bishopSchool));
                add(new Student(3, "Avani", 8, bishopSchool));

                //ryan students
                add(new Student(1, "Anaya", 15, ryanSchool));
                add(new Student(2, "Nilima", 9, ryanSchool));
                add(new Student(3, "Rajveer", 4, ryanSchool));

                //dps students
                add(new Student(1, "Raghav", 12, dpsSchool));
                add(new Student(2, "Ridhima", 9, dpsSchool));
                add(new Student(3, "Raima", 5, dpsSchool));
            }
        };

        return students;
    }
}
