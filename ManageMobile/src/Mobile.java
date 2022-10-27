
public class Mobile {
    public String ID, BandName;
    public int UnitPrice, QoH;

    public Mobile() {
    }

    public Mobile(String ID, String BandName, int UnitPrice, int QoH) {
        this.ID = ID;
        this.BandName = BandName;
        this.UnitPrice = UnitPrice;
        this.QoH = QoH;
    }
     @Override
    public String toString() {
        return "Mobile ["
                + " Id: " + ID
                + ", Brand Name: " + BandName
                + ", Unit Price: " + UnitPrice
                + ", QoH: " + QoH
                + ", Total: " + (UnitPrice * QoH)
                + "]";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBandName() {
        return BandName;
    }

    public void setBandName(String BandName) {
        this.BandName = BandName;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQoH() {
        return QoH;
    }

    public void setQoH(int QoH) {
        this.QoH = QoH;
    }
}
