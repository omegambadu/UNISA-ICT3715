package Reports;

public class Report_3 {
    /* Report 3
     * list of the clients whose birthday is today  */

    String supplement,supplier;
    int  min_lev,cur_stock;

    public Report_3(String supplement, String supplier, int min_lev, int cur_stock) {
        this.supplement = supplement;
        this.supplier = supplier;
        this.min_lev = min_lev;
        this.cur_stock = cur_stock;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getMin_lev() {
        return min_lev;
    }

    public void setMin_lev(int min_lev) {
        this.min_lev = min_lev;
    }

    public int getCur_stock() {
        return cur_stock;
    }

    public void setCur_stock(int cur_stock) {
        this.cur_stock = cur_stock;
    }


}
