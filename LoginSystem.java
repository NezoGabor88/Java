import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoginSystem {
    public static void main(String[] args) {
        // Create a Hibernate SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Bike.class) // Add Bike class as an annotated class
                .buildSessionFactory();

        try {
            // Open a session
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // Hardcoded username and password (you can replace this with user input)
            String username = "user123";
            String password = "pass123";

            // Query the database for the user
            User user = session.createQuery("FROM User WHERE username=:username AND password=:password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();

            // Check if user exists
            if (user != null) {
                System.out.println("Login successful!");

                // Query the database for bike information
                System.out.println("Bike information:");
                session.createQuery("FROM Bike", Bike.class)
                        .getResultList()
                        .forEach(bike -> System.out.println(bike.getBrand() + " - " + bike.getType() + " - $" + bike.getPrice()));
            } else {
                System.out.println("Incorrect username or password. Please try again.");
            }

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the session and the factory
            factory.close();
        }
    }
}
