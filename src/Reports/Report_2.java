package Reports;

public class Report_2 {

    /* Report 2
     * list of the clients whose birthday is today  */

    public Report_2(String client_id, String client_name) {
        this.client_id = client_id;
        this.client_name = client_name;
    }

    String client_id, client_name;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }
}
