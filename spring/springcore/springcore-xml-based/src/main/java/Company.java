public class Company {
    private static Company ourInstance;
    private int id;
    private String name;

    public static Company getInstance(int id, String name) {
        if(ourInstance == null)
            ourInstance = new Company(id, name);
        return ourInstance;
    }

    private Company(int id, String name) {
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
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
