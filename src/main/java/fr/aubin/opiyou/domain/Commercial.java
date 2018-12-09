package fr.aubin.opiyou.domain;

public class Commercial {

    private int idCommercial;
    private String commercialName;
    private String corporateName;
    private String commercialDescription;
    private double commercialRemuneration;
    private long minSubs;

    public Commercial(int idCommercial, String commercialName, String corporateName, String commercialDescription, double commercialRemuneration, long minSubs) {
        this.idCommercial = idCommercial;
        this.commercialName = commercialName;
        this.corporateName = corporateName;
        this.commercialDescription = commercialDescription;
        this.commercialRemuneration = commercialRemuneration;
        this.minSubs = minSubs;
    }

    public int getIdCommercial() {
        return idCommercial;
    }

    public void setIdCommercial(int idCommercial) {
        this.idCommercial = idCommercial;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getCommercialDescription() {
        return commercialDescription;
    }

    public void setCommercialDescription(String commercialDescription) {
        this.commercialDescription = commercialDescription;
    }

    public double getCommercialRemuneration() {
        return commercialRemuneration;
    }

    public void setCommercialRemuneration(double commercialRemuneration) {
        this.commercialRemuneration = commercialRemuneration;
    }

    public long getMinSubs() {
        return minSubs;
    }

    public void setMinSubs(long minSubs) {
        this.minSubs = minSubs;
    }
}
