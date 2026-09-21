abstract public class Rental implements Chargeable {
    private String id;
    private int days;
    private int units;

    public Rental(String id, int days) {
        this.id = id;
        this.days = days;
    }

    public String getId() {
        return this.id;
    }

    public int getDays() {
        return this.days;
    }

    abstract public int calculateCharge();

    public int calculateCharge(int units) {
        int charge;
        if(units <= 0) {
            throw new IllegalArgumentException("Units tidak boleh negatif");
        }
        return units * calculateCharge(); 
    }

    public String label() {
        return "Rental";
    }

    public String summary() {
        return id + " | " + label();
    }
}
