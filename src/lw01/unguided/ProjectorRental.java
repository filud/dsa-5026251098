public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    public int calculateCharge() {
        int days = getDays();
        int rentalCost;
        if(days <= 3) {
            rentalCost = days * 60000;
        } else {
            rentalCost = (3 * 60000) + ((days - 3) * 45000);
        }
        return rentalCost + 20000;
    }

    public String label() {
        return "Projector";
    }
}
