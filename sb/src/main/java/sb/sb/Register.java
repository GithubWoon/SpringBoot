package sb.sb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "REGISTER")
public class Register {

    @Id
    private String id;
    private String name;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
   public String getPassword() {
       return password;
   }
   
   public void setPassword(String password) {
       this.password = password; 
   }
}
