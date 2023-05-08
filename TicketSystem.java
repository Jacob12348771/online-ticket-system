import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class is the main class of the Online Ticketing System for the Bucks
 * Centre of Performing Arts. This is a console application that allows
 * input from the terminal to select shows and tickets for a consumer and agent.
 * This is the application entry point.
 *
 * @author (Jacob Smith)
 * @version (04/05/202)
 */
public class TicketSystem
{
    // Instance variables.
    private Show selectedShow;
    private ArrayList<Show>eveningShows = new ArrayList<>();
    private ArrayList<Show>afternoonShows = new ArrayList<>();

    /**
     * Constructor for objects of class TicketSystem.
     */
    public TicketSystem() {
        createAndSortShows();
    }

    /**
     * Main method that is to be called to start the application.
     * Makes calls to various different methods in order to navigate
     * the user through the system.
     *
     * @return    void
     */
    protected void main() 
    {
        determineUser();

        System.out.println("Registration successful.");
        System.out.println("Please enter '1' or '2'.");
        System.out.println("1. Select tickets for upcoming shows.");
        System.out.println("2. Log out of online ticketing system.");

        Scanner reader = new Scanner(System.in);
        char userSelection = reader.next().charAt(0);

        while (userSelection != '1' && userSelection != '2') {
            System.out.println("Please try again: ");
            userSelection = reader.next().charAt(0);
        }

        if (userSelection == '1') {
            String idealTime = determineIdealTime();
            selectedShow = determineShowToSee(idealTime);
            selectedShow.showOrderComplete();
            System.exit(0);
        } else if (userSelection == '2') {
            System.out.println("Thanks for using the online ticketing system!");
            System.exit(0);
        }

    }

    /**
     * A method that creates show objects for upcoming showings,
     * storing them in seperate array lists, depending on time of
     * showing.
     *
     * @return    void
     */
    private void createAndSortShows()
    {
        Show 
        wickedEvening,
        wickedAfternoon,
        matildaEvening,
        matildaAfternoon,
        hamiltonEvening,
        hamiltonAfternoon;

        wickedEvening = new Show("1. Wicked", "(11/04/2023)", "6pm");
        wickedAfternoon = new Show("1. Wicked", "(11/04/2023)", "2pm");
        matildaEvening = new Show("2. Matilda The Musical", "(12/04/2023)", "6pm");
        matildaAfternoon = new Show("2. Matilda The Musical", "(12/04/2023)", "2pm");
        hamiltonEvening = new Show("3. Hamilton", "(23/04/2023)", "6pm");
        hamiltonAfternoon = new Show("3. Hamilton", "(23/04/2023)", "2pm");

        eveningShows.add(wickedEvening);
        eveningShows.add(matildaEvening);
        eveningShows.add(hamiltonEvening);

        afternoonShows.add(wickedAfternoon);
        afternoonShows.add(matildaAfternoon);
        afternoonShows.add(hamiltonAfternoon);        
    }

    /**
     * A method that is responsible for determining if the user
     * is a consumer or agent.
     *
     * @return    void
     */
    private void determineUser() {
        System.out.println("<----- Welcome to the Bucks Centre for Performing Arts online ticketing System. ----->" + '\n');
        System.out.println("Please select below:" + '\n' + "'1' for consumer registation." + '\n' + "'2' for agent registration.");

        Scanner reader = new Scanner(System.in);
        char userSelection = reader.next().charAt(0);

        while (userSelection != '1' && userSelection != '2') {
            System.out.println("Error, please make your selection again: ");
            userSelection = reader.next().charAt(0);
        }

        if (userSelection == '1') {
            Consumer consumer = new Consumer();
            consumer.registerUser();
            consumer.getCustomerAddress();
            System.out.println(consumer.displayLoginSuccess());
        } else {
            Agent agent = new Agent();
            agent.registerUser();
            agent.getClientInfo();
            System.out.println(agent.displayLoginSuccess());
        }
    }

    /**
     * A method that asks for user input to determine what time
     * of day the user wants to see a show at.
     *
     * @return    the time of day that a show wants to be seen at.
     */
    private String determineIdealTime() {
        System.out.println("We have two different show times to choose from below, please input '1' or '2' for you desired time");
        System.out.println("1. Afternoon at 2pm");
        System.out.println("2. Evening at 6pm");

        Scanner reader = new Scanner(System.in);
        char userSelection = reader.next().charAt(0);

        while (userSelection != '1' && userSelection != '2') {
            System.out.println("Error, please make your selection again: ");
            userSelection = reader.next().charAt(0);
        }

        String idealTime = "";

        switch(userSelection) {
            case '1': idealTime = "Afternoon";
                break;
            case '2': idealTime = "Evening";
                break;
        }

        return idealTime;
    }

    /**
     * A method that determines the show the user wants to see
     *
     * @param  idealTime    the time of day that a show wants to be seen at.
     * @return    the show that is selected to be seen.
     */
    private Show determineShowToSee(String idealTime) {
        System.out.println("Please choose a show, inputting its number:");
        if(idealTime == "Afternoon") {
            for(Show show : afternoonShows) {
                System.out.println(show.getShowName() + " - " + show.getShowDate() + " - " + show.getShowTime());
            }

            Scanner reader = new Scanner(System.in);     
            char userSelection = reader.next().charAt(0);

            while (userSelection != '1' && userSelection != '2' && userSelection != '3') {
                System.out.println("Error, please make your selection again: ");
                userSelection = reader.next().charAt(0);
            }

            int chosenShow = userSelection - '0';
            chosenShow--;

            return afternoonShows.get(chosenShow);
        } else if(idealTime == "Evening") {
            for(Show show : eveningShows) {
                System.out.println(show.getShowName() + " - " + show.getShowDate() + " - " + show.getShowTime());
            }

            Scanner reader = new Scanner(System.in);    
            char userSelection = reader.next().charAt(0);

            while (userSelection != '1' && userSelection != '2' && userSelection != '3') {
                System.out.println("Error, please make your selection again: ");
                userSelection = reader.next().charAt(0);
            }

            int chosenShow = userSelection - '0';
            chosenShow--;

            return eveningShows.get(chosenShow);
        }
        return null;
    }
}
