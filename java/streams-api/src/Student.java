public final class Student {
    private int rollNo;
    private String name;
    private int age;
    private School school;

    public Student(int rollNo, String name, int age, School school) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public School getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
