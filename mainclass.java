public class Main {
    public static void main(String[] args) {
        // Create ten instances of Bike
        Bike[] bikes = new Bike[10];
        bikes[0] = new Bike("Brand1", 6, 300.0);
        bikes[1] = new Bike("Brand2", 7, 400.0);
        bikes[2] = new Bike("Brand3", 5, 250.0);
        bikes[3] = new Bike("Brand4", 8, 500.0);
        bikes[4] = new Bike("Brand5", 6, 350.0);
        bikes[5] = new Bike("Brand6", 7, 450.0);
        bikes[6] = new Bike("Brand7", 5, 280.0);
        bikes[7] = new Bike("Brand8", 8, 550.0);
        bikes[8] = new Bike("Brand9", 6, 320.0);
        bikes[9] = new Bike("Brand10", 7, 420.0);

        // Display information for each bike
        for (int i = 0; i < bikes.length; i++) {
            System.out.println("Bike " + (i + 1) + " information:");
            bikes[i].displayInfo();
            System.out.println();
        }
    }
}
