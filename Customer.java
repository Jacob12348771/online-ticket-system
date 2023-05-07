import java.util.Scanner;

/**
 * Class to register a new customer for the online ticketing system.
 *
 * @author (Jacob Smith)
 * @version (04/05/2023)
 */
public abstract class Customer
{
    // Instance variables.
    private String email;
    private String password;

    /**
     * Constructor for objects of class Customer.
     */
    public Customer() {
        this.email = email;
        this.password = password;
    }

    /**
     * A method that is responsible for obtaining user input
     * for the email and password of the user.
     *
     * @return    void
     */
    protected void registerUser() {

        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter email: ");
        email = reader.nextLine();
        verify(email, 'e');

        System.out.println("Please enter password: ");
        password = reader.nextLine();
        verify(password, 'p');
    }

    /**
     * A method that verifies the validity of information submitted by
     * the customer. Validates correct email format and basic password
     * complexity for security.
     * 
     * @param  value  the inputted value for verification.
     * @param  verificationType  identifier for the type of verification
     * to be performed.
     * @return    void
     */
    private void verify(String value, char verificationType) {
        switch(verificationType){
            case 'e':
                String emailToConfirm = "";
                Scanner readerEmail = new Scanner(System.in);

                // Ensure a valid email is inputted.
                while (!email.contains("@") || email.length() > 20) {
                    System.out.println("Invalid email");
                    email = readerEmail.nextLine();
                }

                System.out.println("Please repeat email: ");
                emailToConfirm = readerEmail.nextLine();

                // Email match check.
                while (!email.equals(emailToConfirm)) {
                    System.out.println("Email does not match please try again: ");
                    emailToConfirm = readerEmail.nextLine();
                }
                break;
            case 'p':
                String passwordToConfirm = "";
                Scanner readerPassword = new Scanner(System.in);

                // Make sure password is of a valid length for security.
                while (password.length() < 10) {
                    System.out.println("Please make sure password is more than 10 chatacters: ");
                    password = readerPassword.nextLine();
                }

                System.out.println("Please repeat password: ");
                passwordToConfirm = readerPassword.nextLine();

                // Password match check.
                while (!password.equals(passwordToConfirm)) {
                    System.out.println("Password does not match please try again: ");
                    passwordToConfirm = readerPassword.nextLine();
                }
                break;
        }
    }

    /**
     * A method that returns the inputted email.
     *
     * @return    email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * A method that displays a success message to the user once logged in.
     *
     * @return    welcome message.
     */
    protected String displayLoginSuccess() {
        return "Welcome " + email + "!";
    }
}
