package pojos.PatientPojos;

public class PatientPojosCstate {

    private int id;
    private String name;

    public PatientPojosCstate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PatientPojosCstate() {
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
        return "PatientPojosCstate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
