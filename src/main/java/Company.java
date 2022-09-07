public enum Company {

    INFORM ("1017151906096881684", "INFORM GmbH"),
    RWTH_AACHEN_INSTITUTE ("1017151984136114226", "RWTH Aachen (Institute)"),
    DSA ("1017152035172384859", "DSA Daten- und Systemtechnik GmbH");

    private final String roleID;
    private final String dispalyName;

    Company(String roleID, String displayName){
        this.roleID = roleID;
        this.dispalyName = displayName;
    }

}
