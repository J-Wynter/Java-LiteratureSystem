
import java.util.ArrayList;

/**
 * Class represents a Literature Prize
 */
public class LiteraturePrize {

    /**
     * The prize year
     */
    private int year;
    
    /**
     * The list of winners
     */
    private ArrayList<Laureate> winners;

    /**
     * Creates a Literature Prize object with the year
     * @param year The prize year
     */
    public LiteraturePrize(int year) {
        this.year = year;
        winners = new ArrayList<Laureate>();
    }

    /**
     * Gets the prize year
     * @return  the prize year
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the prize winners
     * @return the prize winners
     */
    public ArrayList<Laureate> getWinners() {
        return winners;
    }
    
    /**
     * Adds a prize winner
     * @param winner the prize winner
     */
    public void addWinner(Laureate winner) {
        winners.add(winner);
    }

    /**
     * Returns a String containing information about the Literature prize
     * @return a String containing information about the Literature prize
     */
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("Year: %d\n", year));
        if (winners.size() == 0) {
            info.append("Not awarded");
        }
        for (Laureate l : winners) {
            info.append(l.toString() + "\n");
        }
        return info.toString();
    }
}
