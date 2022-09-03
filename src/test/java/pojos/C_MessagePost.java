package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class C_MessagePost {

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
    private String message;
    private String name;
    private String subject;

    public C_MessagePost() {
    }

    public C_MessagePost(String email, String message, String name, String subject) {
        this.email = email;
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
        return "C_MessagePost{" +
                "email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
