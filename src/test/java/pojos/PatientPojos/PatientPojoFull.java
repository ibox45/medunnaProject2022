package pojos.PatientPojos;

public class PatientPojoFull {


    private String createdBy;

    private String createdDate;

    private String firstName;

    private String lastName;

    private String birthDate;

    private String phone;

    private String gender;

    private String bloodGroup;

    private String adress;

    private String email;

    private String description;

    private PatientPojoUser user;

    private Object appointments;

    private Object inPatients;

    private PatientPojosCountry country;

    private PatientPojosCstate cstate;

    public PatientPojoFull(String createdBy, String createdDate, String firstName, String lastName, String birthDate, String phone, String gender, String bloodGroup, String adress, String email, String description, PatientPojoUser user, Object appointments, Object inPatients, PatientPojosCountry country, PatientPojosCstate cstate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.adress = adress;
        this.email = email;
        this.description = description;
        this.user = user;
        this.appointments = appointments;
        this.inPatients = inPatients;
        this.country = country;
        this.cstate = cstate;
    }

    public PatientPojoFull() {
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatientPojoUser getUser() {
        return user;
    }

    public void setUser(PatientPojoUser user) {
        this.user = user;
    }

    public Object getAppointments() {
        return appointments;
    }

    public void setAppointments(Object appointments) {
        this.appointments = appointments;
    }

    public Object getInPatients() {
        return inPatients;
    }

    public void setInPatients(Object inPatients) {
        this.inPatients = inPatients;
    }

    public PatientPojosCountry getCountry() {
        return country;
    }

    public void setCountry(PatientPojosCountry country) {
        this.country = country;
    }

    public PatientPojosCstate getCstate() {
        return cstate;
    }

    public void setCstate(PatientPojosCstate cstate) {
        this.cstate = cstate;
    }

    @Override
    public String toString() {
        return "PatientPojoFull{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", appointments=" + appointments +
                ", inPatients=" + inPatients +
                ", country=" + country +
                ", cstate=" + cstate +
                '}';
    }
}
