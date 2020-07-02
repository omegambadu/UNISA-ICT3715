package obj;

public class Supplier {


    String supp_id,cntct_p,supp_tel,supp_mail,bank,bank_cde,bank_num,bank_acc_type;


    public Supplier(String supp_id, String cntct_p, String supp_tel, String supp_mail, String bank, String bank_cde, String bank_num, String bank_acc_type) {
        this.supp_id = supp_id;
        this.cntct_p = cntct_p;
        this.supp_tel = supp_tel;
        this.supp_mail = supp_mail;
        this.bank = bank;
        this.bank_cde = bank_cde;
        this.bank_num = bank_num;
        this.bank_acc_type = bank_acc_type;
    }

    public String getSupp_id() {
        return supp_id;
    }

    public void setSupp_id(String supp_id) {
        this.supp_id = supp_id;
    }

    public String getCntct_p() {
        return cntct_p;
    }

    public void setCntct_p(String cntct_p) {
        this.cntct_p = cntct_p;
    }

    public String getSupp_tel() {
        return supp_tel;
    }

    public void setSupp_tel(String supp_tel) {
        this.supp_tel = supp_tel;
    }

    public String getSupp_mail() {
        return supp_mail;
    }

    public void setSupp_mail(String supp_mail) {
        this.supp_mail = supp_mail;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank_cde() {
        return bank_cde;
    }

    public void setBank_cde(String bank_cde) {
        this.bank_cde = bank_cde;
    }

    public String getBank_num() {
        return bank_num;
    }

    public void setBank_num(String bank_num) {
        this.bank_num = bank_num;
    }

    public String getBank_acc_type() {
        return bank_acc_type;
    }

    public void setBank_acc_type(String bank_acc_type) {
        this.bank_acc_type = bank_acc_type;
    }
}

