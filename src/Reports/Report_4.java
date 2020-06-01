package Reports;

public class Report_4 {
    /* Report 4
     * list of the clients whose birthday is today  */
    String client,frequency;

    public Report_4(String client, String frequency) {
        this.client = client;
        this.frequency = frequency;
    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
