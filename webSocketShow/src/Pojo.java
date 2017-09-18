import java.util.Date;

/**
 * Created by SuzumiyaHaruhi on 2017/9/13.
 */
public class Pojo {
    private String SIGN = "01203305465AE1EAA712E6CD04988290";
    private String TRANSTIMESTR = "2017-09-12 13:34:38";
    private String MERCHANTNO = "999093082440001";
    private String PARENTMERCHANTNO = "999093082440001";
    private String CARDNO = "6931000000000211";
    private String TRANSTYPE = "22";
    private String TERMINALNO = "PSWY0001";
    private Double AMOUNT = 10000.0;
    private String APPLICATIONNO = "Y00000005";

    public String getSIGN() {
        return SIGN;
    }

    public void setSIGN(String SIGN) {
        this.SIGN = SIGN;
    }

    public String getTRANSTIMESTR() {
        return TRANSTIMESTR;
    }

    public void setTRANSTIMESTR(String TRANSTIMESTR) {
        this.TRANSTIMESTR = TRANSTIMESTR;
    }

    public String getMERCHANTNO() {
        return MERCHANTNO;
    }

    public void setMERCHANTNO(String MERCHANTNO) {
        this.MERCHANTNO = MERCHANTNO;
    }

    public String getPARENTMERCHANTNO() {
        return PARENTMERCHANTNO;
    }

    public void setPARENTMERCHANTNO(String PARENTMERCHANTNO) {
        this.PARENTMERCHANTNO = PARENTMERCHANTNO;
    }

    public String getCARDNO() {
        return CARDNO;
    }

    public void setCARDNO(String CARDNO) {
        this.CARDNO = CARDNO;
    }

    public String getTRANSTYPE() {
        return TRANSTYPE;
    }

    public void setTRANSTYPE(String TRANSTYPE) {
        this.TRANSTYPE = TRANSTYPE;
    }

    public String getTERMINALNO() {
        return TERMINALNO;
    }

    public void setTERMINALNO(String TERMINALNO) {
        this.TERMINALNO = TERMINALNO;
    }

    public Double getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(Double AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getAPPLICATIONNO() {
        return APPLICATIONNO;
    }

    public void setAPPLICATIONNO(String APPLICATIONNO) {
        this.APPLICATIONNO = APPLICATIONNO;
    }
}
