public enum Company {

    INSTITUTE_NUCLEAR_TRAINING ("", "Institute for Nuclear Training GmbH"),
    ADAPTION_ENERGIESYSTEME ("", "adaption Energiesysteme AG"),
    AGINEO ("", "agineo GmbH"),
    AXIGO ("", "aixigo AG"),
    AIXITEM ("", "AIXITEM GmbH"),
    AIXTRON ("", "AIXTRON SE"),
    AMADEUS_LEISURE ("", "Amadeus Leisure IT GmbH"),
    ANDERSCORE ("", "anderScore GmbH"),
    APODIUS ("", "Apodius GmbH"),
    ATESTEO ("", "ATESTEO GmbH & Co.KG"),
    AXINO_SOLUTIONS ("", "Axino Solutions GmbH"),
    BAUER_KIRCH ("", "Bauer + Kirch GmbH"),
    BERENS ("", "Berens & Partner"),
    CAE ("", "CAE GmbH"),
    CANCOM ("", "CANCOM synaix GmbH"),
    CASERIS ("", "CASERIS GmbH"),

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

    public String getDisplayName(){
        return dispalyName;
    }

    public void setRoleID(String newRoleID){
        roleID = newRoleID;
    }

    public static Company getByName(String name){
        for(Company c : Company.values()){
            if(name.equals(c.getDisplayName())){
                return c;
            }
        }
        return null;
    }

}
