import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ExploreCollectors {

    private static class School {
        private int id;
        private String name;

        public School(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "School{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            School school = (School) o;
            return id == school.id &&
                    Objects.equals(name, school.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    private static class Student {
        private int id;
        private String name;
        private int age;
        private School school;
        private EnumMap<Subject, Integer> marks;

        public Student(int id, String name, int age, School school, EnumMap<Subject, Integer> marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.school = school;
            this.marks = marks;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() { return age; }

        public School getSchool() {
            return school;
        }

        public EnumMap<Subject, Integer> getMarks() {
            return marks;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", school=" + school +
                    ", marks=" + marks +
                    '}';
        }
    }

    public static void main(String[] args) {

        School stJosephSchool = new School(1, "St. Joseph School");
        School stMerrySchool = new School(2, "St. Merry School");

        List<Student> students = new ArrayList<Student>(){
            {
                add(new Student(1, "John", 12, stJosephSchool, new EnumMap<Subject, Integer>(Subject.class){
                    {
                        put(Subject.Maths, 78);
                        put(Subject.English, 80);
                        put(Subject.Science, 75);
                    }
                }));
                add(new Student(2, "Richard", 14, stMerrySchool, new EnumMap<Subject, Integer>(Subject.class){
                    {
                        put(Subject.Maths, 80);
                        put(Subject.English, 83);
                        put(Subject.Science, 90);
                    }
                }));
                add(new Student(3, "Nick", 8, stJosephSchool, new EnumMap<Subject, Integer>(Subject.class){
                    {
                        put(Subject.Maths, 55);
                        put(Subject.English, 60);
                        put(Subject.Science, 57);
                    }
                }));
                add(new Student(4, "Dereck", 10, stMerrySchool, new EnumMap<Subject, Integer>(Subject.class){
                    {
                        put(Subject.Maths, 98);
                        put(Subject.English, 89);
                        put(Subject.Science, 70);
                    }
                }));
                add(new Student(5, "Stefanni", 15, stMerrySchool, new EnumMap<Subject, Integer>(Subject.class){
                    {
                        put(Subject.Maths, 96);
                        put(Subject.English, 85);
                        put(Subject.Science, 88);
                    }
                }));
            }
        };

        //toList
        System.out.println("----------------toList------------------");
        List<School> schools = Stream.of(new School(4, "St. Steven School"),
                                         new School(5, "St. Stella School"))
                                     .collect(Collectors.toList());
        schools.forEach(System.out::println);

        //toSet
        System.out.println("----------------toSet------------------");
        Set<School> schoolSet = Stream.of(new School(4, "St. Steven School"),
                                          new School(5, "St. Stella School"))
                                       .collect(Collectors.toSet());
        schoolSet.forEach(System.out::println);

        //toMap
        System.out.println("----------------toMap------------------");
        Map<String, EnumMap<Subject, Integer>> studentMap = students.stream()
                                                                    .collect(Collectors.toMap(Student::getName, Student::getMarks));
        studentMap.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().forEach(marksEntry-> {
                System.out.println("Subject:" + marksEntry.getKey() + "Mark: " + marksEntry.getValue());
            });
        });

        //grouping
        System.out.println("----------------Grouping------------------");
        Map<School, List<Student>> groupBySchool = students.stream()
                                                           .collect(Collectors.groupingBy(Student::getSchool));
        groupBySchool.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        });

        //partitioning
        System.out.println("----------------Partitioning------------------");
        Map<Boolean, List<Student>> partitionedStudents = students.stream()
                                                                  .collect(Collectors.partitioningBy(s -> s.getMarks()
                                                                          .values()
                                                                          .stream()
                                                                          .mapToInt(Integer::intValue)
                                                                          .average()
                                                                          .getAsDouble() > 70));
        partitionedStudents.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        });

        //maxBy
        System.out.println("----------------maxBy------------------");
        Optional<Student> olderStudent = students.stream()
                                                 .collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        System.out.println(olderStudent.toString());

        //minBy
        System.out.println("----------------minBy------------------");
        Optional<Student> youngerStudent = students.stream()
                                                   .collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        System.out.println(youngerStudent.toString());

        //reducing
        System.out.println("----------------reducing------------------");
        Optional<Student> reducedMaxAgeStudent = students.stream()
                                                         .collect(Collectors.reducing((s1, s2) -> s1.getAge() > s2.getAge() ? s1 : s2));
        System.out.println(reducedMaxAgeStudent.toString());


        //joining
        System.out.println("----------------joining------------------");
        String commaSeparatedNames = students.stream()
                                             .map(Student::getName).collect(Collectors.joining(","));
        System.out.println(commaSeparatedNames);

        //counting
        System.out.println("----------------counting------------------");
        long count = students.stream().collect(Collectors.counting());
        System.out.println("No of Students: " + count);

        //summing
        System.out.println("----------------Summing------------------");
        Map<String, Integer> studentTotalMarks = students.stream()
                                                         .collect(Collectors.toMap(Student::getName,
                                                                                   s -> s.getMarks()
                                                                                           .values()
                                                                                           .stream()
                                                                                           .collect(Collectors.summingInt(Integer::intValue))));
        studentTotalMarks.entrySet().forEach(entry -> {
            System.out.println("Student: " + entry.getKey() + ", Total Marks: " + entry.getValue());
        });

        //averaging
        System.out.println("----------------Averaging------------------");
        Map<String, Double> studentAvgMarks = students.stream()
                                                        .collect(Collectors.toMap(Student::getName,
                                                                                  s -> s.getMarks()
                                                                                          .values()
                                                                                          .stream()
                                                                                          .collect(Collectors.averagingInt(Integer::intValue))));
        studentAvgMarks.entrySet().forEach(entry -> {
            System.out.println("Student: " + entry.getKey() + ", Avg Marks: " + entry.getValue());
        });

        //summarizing
        System.out.println("----------------Summarizing------------------");
        Map<String, IntSummaryStatistics> studentSummaryStats = students.stream()
                                                        .collect(Collectors.toMap(Student::getName,
                                                                                    s -> s.getMarks()
                                                                                            .values()
                                                                                            .stream()
                                                                                            .collect(Collectors.summarizingInt(Integer::intValue))));
        studentSummaryStats.entrySet().forEach(entry -> {
            System.out.println("Student: " + entry.getKey());
            System.out.println("Statistics - ");
            System.out.println(entry.getValue().toString());
        });

        //custom collector implementation
        boolean isEven = Stream.of(2,2,1).collect(new EvenOddChecker());
        System.out.println("Is sum even? - " + isEven);
    }
}
