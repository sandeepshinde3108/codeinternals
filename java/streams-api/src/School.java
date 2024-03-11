public final class School {
    private String name;
    private String city;
    private SyllabusPattern syllabusPattern;
    private int studentCapacity;
    private String[] staff;

    public School(String name, String city, SyllabusPattern syllabusPattern, int studentCapacity, String[] staff) {
        this.name = name;
        this.city = city;
        this.syllabusPattern = syllabusPattern;
        this.studentCapacity = studentCapacity;
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public SyllabusPattern getSyllabusPattern() {
        return syllabusPattern;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public String[] getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", syllabusPattern=" + syllabusPattern +
                ", studentCapacity=" + studentCapacity +
                '}';
    }
}
