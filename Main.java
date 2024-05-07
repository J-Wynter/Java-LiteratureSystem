
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main program that contains the menu driven application
 */
public class Main {

    public static void main(String[] args) {
        //Loads the list of literature prizes and the winners from the file
        ArrayList<LiteraturePrize> prizes = loadLiteraturePrizes("literature-prizes.txt");
        
        //Scanne for user input
        Scanner in = new Scanner(System.in);
        int option = 1;
        do {
            //Prints the menu
            System.out.println("----------------------");
            System.out.println("Literature prize menu");
            System.out.println("----------------------");
            System.out.println("List ................1");
            System.out.println("Select ..............2");
            System.out.println("Search ..............3");
            System.out.println("Exit ................0");
            System.out.println("----------------------");
            System.out.print("\n\nEnter choice > ");
            option = in.nextInt();
            in.nextLine();
            
            // If user selects 1
            //Ask user for starting and ending year
            //Display all the prizes for the between starting and ending year both inclusive
            if (option == 1) {
                System.out.print("Enter starting year: ");
                int startingYear = in.nextInt();
                in.nextLine();
                System.out.print("Enter ending year: ");
                int endingYear = in.nextInt();
                in.nextLine();
                
                System.out.println("\nLiterature Prizes between " + startingYear + " and " + endingYear);
                for (LiteraturePrize p: prizes) {
                    if (p.getYear() >= startingYear && p.getYear() <= endingYear) {
                        System.out.println(p);
                    }
                }

            } 
            //If user selects 2
            //Ask user for the year
            //Display all the prizes for the selected year
            else if (option == 2) {
                System.out.print("Enter year: ");
                int year = in.nextInt();
                in.nextLine();
                
                for (LiteraturePrize p: prizes) {
                    if (p.getYear() == year) {
                        System.out.println(p);
                    }
                } 
            }  
            //If users selects 3
            //Asks the user for a genre
            //Displays all winners with the selected genre
            else if (option == 3) {
                System.out.print("Enter genre: ");
                String genre = in.nextLine();
                System.out.println("\nLaureate with genre " + genre);
                
                for (LiteraturePrize p: prizes) {
                    for (Laureate l: p.getWinners()) {
                        for (String g: l.getGenres()) {
                            if (g.equalsIgnoreCase(genre)) {
                                System.out.println("Winner of " + p.getYear());
                                System.out.println(l);
                                System.out.println("");
                            }
                        }
                    }
                }
            } 
            //If users selects 0 then exit
            else if (option == 0) {
                break;
            }
        } while (option != 0);
        in.close();

    }
    
    /**
     * Loads all the Laureates and store them in the appropriate Literature Prize year
     * @param filename The name of the filename containing the information
     * @return a list of Literature Prizes
     */
    public static ArrayList<LiteraturePrize> loadLiteraturePrizes(String filename) {
        ArrayList<LiteraturePrize> prizes = new ArrayList<LiteraturePrize>();
        try {
            Scanner in = new Scanner(new File(filename));
            String line;
            while (in.hasNext()) {
                line = in.nextLine().trim();
                if (!line.equals("-----")) {
                    int year = Integer.parseInt(line.trim());
                    LiteraturePrize prize = new LiteraturePrize(year);
                    while (in.hasNext()) {
                        Laureate laureate = new Laureate();
                        line = in.nextLine().trim();

                        if (line.equals("-----") || line.equals("Not awarded")) {
                            break;
                        }
                        String[] temp = line.trim().split("\\|");
                        String[] nameBirth = temp[0].replace("\\)", "").split("\\(");
                        String name = nameBirth[0].trim();
                        String birthDeath = nameBirth[1].trim();
                        String citation = in.nextLine().trim();
                        String[] genres = in.nextLine().trim().split(", ");

                        laureate.setName(name);
                        laureate.setBirth_death(birthDeath);
                        laureate.setCitation(citation);
                        for (String nation : temp[1].split(",")) {
                            laureate.addNation(nation);
                        }
                        for (String language : temp[2].split(",")) {
                            laureate.addLanguage(language);
                        }
                        for (String genre : genres) {
                            laureate.addGenre(genre);
                        }
                        prize.addWinner(laureate);
                    }
                    prizes.add(prize);
                }

            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prizes;
    }

}
