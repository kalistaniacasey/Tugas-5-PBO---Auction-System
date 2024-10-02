public class Lot {
    private int number;
    private String description;
    private Bid highestBid;

    public Lot(int number, String description) {
        this.number = number;
        this.description = description;
        highestBid = null;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        String highestBidValue = (highestBid != null) ? String.valueOf(highestBid.getValue()) : "Belum ada tawaran";
        return "Lot " + number + ": " + description + " (Tawaran Tertinggi: " + highestBidValue + ")";
    }

    public boolean bidFor(Bid bid) {
        if (highestBid == null || bid.getValue() > highestBid.getValue()) {
            highestBid = bid;
            return true;
        }
        return false;
    }

    public Bid getHighestBid() {
        return highestBid;
    }
}
