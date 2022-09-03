package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class C_MessageGetId {
    /*
             {
                "email": "string",
                "id": 0,
                "message": "string",
                "name": "string",
                "subject": "string"
              }

    */
    private String email;
    private int id;
    private String message;
    private String name;
    private String subject;

    public C_MessageGetId() {
    }

    public C_MessageGetId(String email, int id, String message, String name, String subject) {
        this.email = email;
        this.id = id;
        this.message = message;
        this.name = name;
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "C_MessageGetId{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
