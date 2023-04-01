public class Expense {
    private Date date;
    private float amount;

    private String currency;
    private String notes;



    public Expense(String dateString, double amount, String currency, String notes) {
    }


    // constructor and getters/setters here
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency(){
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
