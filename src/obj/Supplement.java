package obj;

import java.math.BigDecimal;

public class Supplement {

        String splier_id, splemnt_id, desc,nappi_cde;
        BigDecimal cost_exc,cost_inc;
        int min_lvs,cur_stck_lev;

    public Supplement(String splier_id, String splemnt_id, String desc, String nappi_cde, BigDecimal cost_exc, BigDecimal cost_inc, int min_lvs, int cur_stck_lev) {
        this.splier_id = splier_id;
        this.splemnt_id = splemnt_id;
        this.desc = desc;
        this.nappi_cde = nappi_cde;
        this.cost_exc = cost_exc;
        this.cost_inc = cost_inc;
        this.min_lvs = min_lvs;
        this.cur_stck_lev = cur_stck_lev;
    }

    public String getSplier_id() {
        return splier_id;
    }

    public void setSplier_id(String splier_id) {
        this.splier_id = splier_id;
    }

    public String getSplemnt_id() {
        return splemnt_id;
    }

    public void setSplemnt_id(String splemnt_id) {
        this.splemnt_id = splemnt_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNappi_cde() {
        return nappi_cde;
    }

    public void setNappi_cde(String nappi_cde) {
        this.nappi_cde = nappi_cde;
    }

    public BigDecimal getCost_exc() {
        return cost_exc;
    }

    public void setCost_exc(BigDecimal cost_exc) {
        this.cost_exc = cost_exc;
    }

    public BigDecimal getCost_inc() {
        return cost_inc;
    }

    public void setCost_inc(BigDecimal cost_inc) {
        this.cost_inc = cost_inc;
    }

    public int getMin_lvs() {
        return min_lvs;
    }

    public void setMin_lvs(int min_lvs) {
        this.min_lvs = min_lvs;
    }

    public int getCur_stck_lev() {
        return cur_stck_lev;
    }

    public void setCur_stck_lev(int cur_stck_lev) {
        this.cur_stck_lev = cur_stck_lev;
    }
}
