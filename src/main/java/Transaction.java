import java.sql.Date;

public class Transaction {

    private Long id;
    private TransactionType type;
    private String description;
    private Date date;
    private double amount;

    public Transaction() {
    }

    public Transaction(Long id, TransactionType type, String description, Date date, double amount) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    public Transaction(TransactionType type, String description, Date date, double amount) {
        this (null, type, description, date, amount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
