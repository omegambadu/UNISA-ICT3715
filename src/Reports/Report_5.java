package Reports;

public class Report_5 {

         /* REPORT 5
         number of purchases made per month since 2012
          */

     String n_of_purch, mnth;

    public Report_5(String n_of_purch, String mnth) {
        this.n_of_purch = n_of_purch;
        this.mnth = mnth;
    }

    public String getN_of_purch() {
        return n_of_purch;
    }

    public void setN_of_purch(String n_of_purch) {
        this.n_of_purch = n_of_purch;
    }

    public String getMnth() {
        return mnth;
    }

    public void setMnth(String mnth) {
        this.mnth = mnth;
    }
}
