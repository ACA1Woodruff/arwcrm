package arwcrm.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author awood
 */
public class User implements Serializable {

    private String Username;
    private String Password;
    private String Name;
    private String Enabled;
    private List<String> roles;
    private Map<String, String> rolemap;

    public User() {
        this.rolemap = new LinkedHashMap<String, String>();
        this.rolemap.put("ROLE_USER", "User");
        this.rolemap.put("ROLE_ADMIN", "Administrator");
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = Password;
    }

    public Map<String, String> getRolemap() {
        return this.rolemap;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getEnabled() {
        return Enabled;
    }

    public void setEnabled(String Enabled) {
        this.Enabled = Enabled;
    }

//    public String toString() {
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("Username: " + this.Username + ";");
//        buffer.append("Password: " + this.Password + ";");
//        buffer.append("Enabled: " + this.Enabled);
//        return buffer.toString();
//
//    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
