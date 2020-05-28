package Reports;

import java.util.Date;

public class Report_1 {

        /* Report 1
        * list of the clients (prior to 2020) that have not yet paid their invoices   */

    String client_id, client, invoice_number;
          String invoice_date;

    public Report_1(String client_id, String client, String invoice_number, String invoice_date) {
        this.client_id = client_id;
        this.client = client;
        this.invoice_number = invoice_number;
        this.invoice_date = invoice_date;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getInvoice_date() {
        return invoice_date;
    }

    public void setDate( String invoice_date) {
        this.invoice_date = invoice_date;
        }

    }


















