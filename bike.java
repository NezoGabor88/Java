public class Bike {
    private String brand;
    private int gear;
    private double price;

    // Constructor
    public Bike(String brand, int gear, double price) {
        this.brand = brand;
        this.gear = gear;
        this.price = price;
    }

    // Getters and setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to display bike information
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Number of gears: " + gear);
        System.out.println("Price: $" + price);
    }
}
