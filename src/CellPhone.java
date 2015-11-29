import java.util.Scanner;

public class CellPhone implements Cloneable {

    private long serialNumber;
    private double price;
    private int year;
    private String brand;

    //Constructors for CellPhone
    public CellPhone(long serialNumber, double price, int year, String brand) {
        this.price = price;
        this.year = year;
        this.brand = brand;
        this.serialNumber = serialNumber;
    }
    public CellPhone(CellPhone object, long serialNumber) {
        //Calls parameterized constructor,
        //Creates new object with same parameters, except serialNumber
        this(serialNumber, object.price, object.year, object.brand);
    }

    //Accessor and Mutator methods for CellPhone
    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNUmber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    //overriden clone() method copies called object,
    //prompts user for new unique serialNumber,
    //sets serialNumer to cloned object
    @Override public CellPhone clone() {
        long sn;
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter a serial number to be used for the new Cellphone: ");
        sn = kb.nextLong();
        return new CellPhone(this, sn);
    }
    //Equals method returns true if all attributes except
    //serialNumber are the same, false otherwise
    @Override public boolean equals(Object object) {
        if (object.getClass() != this.getClass()) {
            return false;
        }
        CellPhone cellPhone = (CellPhone)object;
        return (cellPhone.brand.equalsIgnoreCase(this.brand) && cellPhone.price == this.price && cellPhone.year == this.year);
    }

    @Override public String toString() {
        return (this.serialNumber + " " + this.brand  + " " + this.price + " " + this.year);
    }
}