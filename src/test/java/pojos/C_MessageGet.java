package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class C_MessageGet {
    /*
            [
               {
                "email": "string",
                "id": 0,
                "message": "string",
                "name": "string",
                "subject": "string"
              }
            ]

    */
    private String email;
    private Integer id;
    private String message;
    private String name;
    private String subject;

    public C_MessageGet() {
    }

    public C_MessageGet(String email, Integer id, String message, String name, String subject) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "C_MessageGet{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
