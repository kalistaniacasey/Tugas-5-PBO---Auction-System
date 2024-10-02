public class Bid {
    private Person bidder;
    private long value;

    public Bid(Person bidder, long value) {
        this.bidder = bidder;
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
