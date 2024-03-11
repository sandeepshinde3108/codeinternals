
public final class Department {
    private int id;
    private String name;

    public Department() {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void init(){
        System.out.println("Initialization code post bean creation will go here.");
    }

    public void cleanUp(){
        System.out.println("Clean up code will go here");
    }
}
