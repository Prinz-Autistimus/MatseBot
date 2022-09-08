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
    COMPAGNIE_DE_SAINTGOBAIN ("", "Compagnie de Saint-Gobain"),
    COMPLINGUA ("", "Complingua GmbH"),
    CONSENSE ("", "ConSense GmbH"),
    CONTINUE_SOFTWARE ("", "Continue Software GmbH"),
    CORNELSEN_ECADEMY ("", "Cornelsen eCademy & inside GmbH"),
    CYCOS ("", "cycos AG"),
    DATABAY ("", "DATAbay AG"),
    DECADIA ("", "Decadia GmbH"),
    DEVOLO ("", "devolo AG"),
    DOCMORRIS ("", "DocMorris N.V."),
    DSA ("", "DSA Daten- und Systemtechnik GmbH"),
    DTV ("", "DTV-Verkehrsconsult GmbH"),
    E_DYNAMICS ("", "e-dynamics GmbH"),
    ENERKO ("", "Enerko Informatik GmbH"),
    ENERVISION ("", "enervision GmbH"),
    EQUENSWORLDLINE ("", "equensWorldline"),
    ERICSSON ("", "Ericsson GmbH"),
    ESCO ("", "esco GmbH"),
    EUTECH ("", "EUtech Scientific Engineering GmbH"),
    FKA ("", "fka GmbH"),
    FRAUENHOFER_PRODUKTIONSTECHNOLOGIE ("", "Fraunhofer-Institut für Produktionstechnologie"),
    GENERALI_DEUTSCHLAND ("", "Generali Deutschland AG"),
    GENERALI_OPERATIONS_SERVICE ("", "Generali Operations Service Platform"),
    GITG ("", "GITG AG"),
    GRUEN ("", "GRÜN Software AG"),
    GTS ("", "GTS Systems & Consulting GmbH"),
    HEAD_ACOUSTICS ("", "HEAD acoustics GmbH"),
    INDURAD ("", "indurad GmbH"),
    INFORM ("", "INFORM GmbH"),
    INTERACTIVE_PIONEERS ("", "Interactive Pioneers GmbH"),
    ISE ("", "ISE Gmb"),
    IVU ("", "IVU"),
    KISTERS ("", "KISTERS AG"),
    KLAFKA_HINZ ("", "Klafka & Hinz Energie-Informations-Systeme GmbH"),
    LINEAR ("", "liNear GmbH"),
    M3CONNECT ("", "m3connect GmbH"),
    MACD ("", "MACD GmbH"),
    MAGMA ("", "MAGMA Gießereitechnologie GmbH"),
    MAT_TRAFFIC ("", "MAT.TRAFFIC GmbH"),
    MEASX ("", "measx GmbH & Co. KG"),
    MIT ("", "MIT GmbH"),
    MODELL_AACHEN ("", "Modell Aachen GmbH"),
    MODULE_WORKS ("", "ModuleWorks GmbH"),
    MOSER ("", "MOSER GmbH & Co. KG"),
    NATIONAL_INSTRUMENTS ("", "National Instruments Engineering GmbH & Co. KG"),
    NEA_X_DIGITAL ("", "NEA X Digital Business"),
    NEXT_AUDIT ("", "nextAudit UG"),
    OCULAVIS ("", "oculavis GmbH"),
    ONOFFICE ("", "onOffice GmbH"),
    PICAVI ("", "Picavi GmbH"),
    PROCOM ("", "ProCom GmbH"),
    PSI ("", "PSI GmbH"),
    QOSMOTEC ("", "Qosmotec Software Solutions GmbH"),
    REGIO_IT ("", "regio iT"),
    RWTH_AACHEN_INSTITUTE ("", "RWTH Aachen (Institute)"),
    SAURER_SPINNING ("", "Saurer Spinning Solution GmbH & Co. KG"),
    SCHOELLER_WERK ("", "Schoeller Werk GmbH & Co. KG"),
    SCT ("", "SCT GmbH"),
    SOPTIM ("", "SOPTIM AG"),
    TEAM4 ("", "Team4 GmbH"),
    TOPSYSTEME ("", "topsystem Systemhaus GmbH"),
    TRUETZSCHLER ("", "Trützschler GmbH"),
    USU_TECHNOLOGIES ("", "USU Technologies GmbH"),
    UTILITAS ("", "utilitas GmbH"),
    VAN_DER_BERG ("", "van den Berg AG"),
    VEDA ("", "VEDA GmbH"),
    VIA_CONSULTING ("", "VIA Consulting & Development GmbH"),
    WORLDLINE ("", "Worldline Germany Gm");


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
