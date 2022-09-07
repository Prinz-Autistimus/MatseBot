import java.util.Arrays;

public enum Company {

    INFORM ("", "INFORM GmbH"),
    RWTH_AACHEN_INSTITUTE ("", "RWTH Aachen (Institute)"),
    DSA ("", "DSA Daten- und Systemtechnik GmbH"),
    COMPLINGUA ("", "Complingua GmbH");

    private String roleID;
    private final String dispalyName;

    Company(String roleID, String displayName){
        this.roleID = roleID;
        this.dispalyName = displayName;
    }

    public String getRoleID(){
        return roleID;
    }

    public String getDispalyName(){
        return dispalyName;
    }

    public void setRoleID(String newRoleID){
        roleID = newRoleID;
    }

    public static Company getByName(String name){
        for(Company c : Company.values()){
            if(name.equals(c.getDispalyName())){
                return c;
            }
        }
        return null;
    }

}
