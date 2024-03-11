import java.util.Objects;
import java.util.Optional;

public class OptionalExample {

    private static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
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
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student student = null;
        if(student != null){
            //your code goes here
        }

        //throw NullPointerException
        Student student1 = null;
//        Optional<Student> optionalStudent = Optional.of(student);
//        System.out.println(optionalStudent);

        //return optional object
        student1 = new Student(1, "John");
        System.out.println(Optional.of(student1));

        //return empty optional object
        Student student2 = null;
        Optional<Student> optionalStudent2 = Optional.ofNullable(student2);
        System.out.println(optionalStudent2);

        //return optional object
        student2 = new Student(2, "Richard");
        System.out.println(Optional.ofNullable(student2));

        Optional optional = Optional.empty();
        System.out.println(optional);

        //Accessor methods
        Optional<Student> optionalStudent3 = Optional.of(new Student(3, "Rick"));

        //get()
        System.out.println("-----------------get()------------------");
        System.out.println(optionalStudent3.get());

        //isPresent() -> not null check
        System.out.println("-----------------isPresent()------------------");
        System.out.println("Is Object not null in Optional? - " + optionalStudent3.isPresent());

        //Action if object present
        System.out.println("-----------------ifPresent()------------------");
        optionalStudent3.ifPresent(System.out::println);

        //orElse()
        System.out.println("-----------------orElse()------------------");
        Student nullStudent = null;
        System.out.println(Optional.ofNullable(nullStudent).orElse(new Student(5, "Nick")));

        //orElse()
        System.out.println("-----------------orElseGet()------------------");
        System.out.println(Optional.ofNullable(nullStudent).orElseGet(() -> {
            return new Student(5, "Nick");
        }));

        //orElseThrow()
        System.out.println("-----------------orElseThrow()------------------");
        //System.out.println(Optional.ofNullable(nullStudent).orElseThrow(() -> new RuntimeException("Received NULL object")));

        //filter()
        System.out.println("-----------------filter()------------------");
        System.out.println(optionalStudent3.filter(s -> s.getId() == 1));

        //map()
        System.out.println("-----------------map()------------------");
        System.out.println(optionalStudent3.map(s -> s.getName()));

        //flatMap()
        System.out.println("-----------------flatMap()------------------");
        Optional<Optional<Student>> optionalStudent4 = Optional.of(optionalStudent3);
        System.out.println(optionalStudent4.flatMap(s -> s.map(Student::getName)));
    }
}
