import java.util.Scanner;

/**
 * This class provides the customer to access methods specific
 * to that of a consumer.
 *
 * @author (Jacob Smith)
 * @version (04/05/2023)
 */
public class Consumer extends Customer
{
    // Instance variables.
    private String address;

    /**
     * Constructor for objects of class Consumer.
     */
    public Consumer() {
        this.address = address;
    }

    /**
     * A method that is responsible for obtaining user input
     * for the customer's address.
     *
     * @return    void
     */
    protected void getCustomerAddress() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter your address for tickets to be sent to!: " + '\n');
        address = reader.nextLine();
    }
}
