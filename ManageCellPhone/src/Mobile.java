
public class Mobile {

    public String id, bandName;
    public int price, QoH;

    public Mobile() {
    }

    public Mobile(String id, String bandName, int price, int QoH) {
        this.id = id;
        this.bandName = bandName;
        this.price = price;
        this.QoH = QoH;
    }
    
     @Override
    public String toString() {
        return "Mobile ["
                + " Id: " + id
                + ", Brand Name: " + bandName
                + ", Price: " + price
                + ", QoH: " + QoH
                + ", Total: " + (price * QoH)
                + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQoH() {
        return QoH;
    }

    public void setQoH(int QoH) {
        this.QoH = QoH;
    }

}
