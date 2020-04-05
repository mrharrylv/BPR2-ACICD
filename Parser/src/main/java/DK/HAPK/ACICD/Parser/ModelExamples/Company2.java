package DK.HAPK.ACICD.Parser.ModelExamples;

public class Company2 {

    public String IC_DPH;
    public String ICO;
    public String NAZOV_DS;
    public String OBEC;
    public String ULICA_CISLO;
    public String PSC;
    public String STAT;
    public String DRUH_REG_DPH;
    public String DATUM_REG;
    public String DATUM_ZMENY_DRUHU_REG;

    public Company2() {
    }

    public Company2(String IC_DPH, String ICO, String NAZOV_DS, String OBEC, String ULICA_CISLO, String PSC, String STAT, String DRUH_REG_DPH, String DATUM_REG, String DATUM_ZMENY_DRUHU_REG) {
        this.IC_DPH = IC_DPH;
        this.ICO = ICO;
        this.NAZOV_DS = NAZOV_DS;
        this.OBEC = OBEC;
        this.ULICA_CISLO = ULICA_CISLO;
        this.PSC = PSC;
        this.STAT = STAT;
        this.DRUH_REG_DPH = DRUH_REG_DPH;
        this.DATUM_REG = DATUM_REG;
        this.DATUM_ZMENY_DRUHU_REG = DATUM_ZMENY_DRUHU_REG;
    }

    @Override
    public String toString() {
        return "Company{" +
                "IC_DPH='" + IC_DPH + '\'' +
                ", ICO='" + ICO + '\'' +
                ", NAZOV_DS='" + NAZOV_DS + '\'' +
                ", OBEC='" + OBEC + '\'' +
                ", ULICA_CISLO='" + ULICA_CISLO + '\'' +
                ", PSC='" + PSC + '\'' +
                ", STAT='" + STAT + '\'' +
                ", DRUH_REG_DPH='" + DRUH_REG_DPH + '\'' +
                ", DATUM_REG='" + DATUM_REG + '\'' +
                ", DATUM_ZMENY_DRUHU_REG='" + DATUM_ZMENY_DRUHU_REG + '\'' +
                '}';
    }
}
