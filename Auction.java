import java.util.ArrayList;

public class Auction {
    private ArrayList<Lot> lots;
    private int nextLotNumber;
    private boolean isOpen;

    public Auction() {
        lots = new ArrayList<>();
        nextLotNumber = 1;
        isOpen = true;
    }

    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    public void showLots() {
        for (Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    public void makeABid(int lotNumber, Person bidder, long value) {
        if (!isOpen) {
            System.out.println("Lelang ditutup. Tawaran tidak diterima.");
            return;
        }
        Lot selectedLot = getLot(lotNumber);
        if (selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if (successful) {
                System.out.println("Tawaran untuk lot nomor " + lotNumber + " berhasil.");
            } else {
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Tawaran gagal. Tawaran tertinggi saat ini untuk Lot " + lotNumber + " adalah " + highestBid.getValue());
            }
        } else {
            System.out.println("Lot tidak ditemukan.");
        }
    }

    public Lot getLot(int lotNumber) {
        if ((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            return lots.get(lotNumber - 1);
        } else {
            return null;
        }
    }

    public void closeAuction() {
        isOpen = false;
        System.out.println("Lelang telah ditutup.");
    }
}
