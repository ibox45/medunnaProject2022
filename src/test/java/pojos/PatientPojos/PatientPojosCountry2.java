package pojos.PatientPojos;

public class PatientPojosCountry2 {

    private int id;
    private String name;

    public PatientPojosCountry2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PatientPojosCountry2() {
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
        return "PatientPojosCountry2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
