import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class contains the attributes for a show
 * and also relevant methods.
 *
 * @author (Jacob Smith)
 * @version (04/05/2023)
 */
public class Show
{
    // Instance variables.
    private String showName;
    private String showDate;
    private String showTime;

    /**
     * Constructor for objects of class Show
     */
    public Show(String showName, String showDate, String showTime) {
        this.showName = showName;
        this.showDate = showDate;
        this.showTime = showTime;
    }

    /**
     * A method to get the show name.
     *
     * @return    The show's name.
     */
    public String getShowName() {
        return this.showName;
    }

    /**
     * A method to get the show time.
     *
     * @return    The show's time.
     */
    public String getShowTime() {
        return this.showTime;
    }

    /**
     * A method to get the show date.
     *
     * @return    The show's date.
     */
    public String getShowDate() {
        return this.showDate;
    }

    /**
     * A method that displays a message to the user,
     * informing them of the show they selected.
     *
     * @return    void
     */
    protected void showOrderComplete() {
        System.out.println("You are going to " + showName + " on " + showDate + " at " + showTime + ".");
        System.out.println("Enjoy the show!");
    }
}
