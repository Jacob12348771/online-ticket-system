import java.util.Scanner;

/**
 * A class that allows the agent to access methods to obtain details
 * specific to the client the agent is acting on behalf of.
 *
 * @author (Jacob Smith)
 * @version (04/05/2023)
 */
public class Agent extends Customer
{
    // Instance variables.
    private String clientName;
    private String clientAddress;
    
    /**
     * Constructor for objects of class Agent.
     */
    public Agent() {
        clientName = this.clientName;
        clientAddress = this.clientAddress;
    }

    /**
     * Method that allows the agent to enter the client name and address.
     *
     * @return    void
     */
    protected void getClientInfo() {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Please enter client name:");
        clientName = reader.next();
        
        System.out.println("Please enter client address:");
        clientAddress = reader.next();
    }
    
    /**
     * Polymorphic method giving an override of displayLoginSuccess specific
     * to an agent, highlighting the client info.
     *
     * @return    void
     */
    protected String displayLoginSuccess() {
        String successMessage = "";
        successMessage += "Welcome Agent(" + getEmail() + "), client details below:" + '\n';
        successMessage += "Client name: " + clientName + '\n';
        successMessage += "Client address: " + clientAddress;
        
        return successMessage;
    }
}
