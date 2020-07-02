package obj;

public class Client {
   String id,nme,snme, adrss,code,tel_h,tel_w,tel_c,email,ref_id;

    public Client(String id, String nme, String snme, String adrss, String code, String tel_h, String tel_w, String tel_c, String email, String ref_id) {
        this.id = id;
        this.nme = nme;
        this.snme = snme;
        this.adrss = adrss;
        this.code = code;
        this.tel_h = tel_h;
        this.tel_w = tel_w;
        this.tel_c = tel_c;
        this.email = email;
        this.ref_id = ref_id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNme() {
        return nme;
    }

    public void setNme(String nme) {
        this.nme = nme;
    }

    public String getSnme() {
        return snme;
    }

    public void setSnme(String snme) {
        this.snme = snme;
    }

    public String getAdrss() {
        return adrss;
    }

    public void setAdrss(String adrss) {
        this.adrss = adrss;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTel_h() {
        return tel_h;
    }

    public void setTel_h(String tel_h) {
        this.tel_h = tel_h;
    }

    public String getTel_w() {
        return tel_w;
    }

    public void setTel_w(String tel_w) {
        this.tel_w = tel_w;
    }

    public String getTel_c() {
        return tel_c;
    }

    public void setTel_c(String tel_c) {
        this.tel_c = tel_c;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }
}
