package proiectmaster.proiectmaster.model;

public class Transaction {
    private int value;
    private String description;
    private String unit;

    public Transaction() {
    }

    public Transaction(int value, String description, String unit) {
        this.value = value;
        this.description = description;
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "value=" + value +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
