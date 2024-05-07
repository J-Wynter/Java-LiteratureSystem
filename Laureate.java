
import java.util.ArrayList;

/**
 * Class represents a Laureate
 */
public class Laureate {

    /**
     * The name of the Laureate
     */
    private String name;

    /**
     * The birth year and death year of the Laureate
     */
    private String birth_death;

    /**
     * The nations the Laureate belongs to
     */
    private ArrayList<String> nations;

    /**
     * The language the Laureate speaks
     */
    private ArrayList<String> languages;

    /**
     * The genres the Laureate works in
     */
    private ArrayList<String> genres;

    /**
     * The citation for the Laureate
     */
    private String citation;

    /**
     * Constructor creates a Laureate object
     */
    public Laureate() {
        nations = new ArrayList<String>();
        languages = new ArrayList<String>();
        genres = new ArrayList<String>();
    }

    /**
     * Gets the Laureate name
     *
     * @return the Laureate name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Laureate name
     *
     * @param name the Laureate name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Laureate birth and death year
     *
     * @return the Laureate birth and death year
     */
    public String getBirth_death() {
        return birth_death;
    }

    /**
     * Sets the Laureate birth and death year
     *
     * @param birth_death the Laureate birth and death year
     */
    public void setBirth_death(String birth_death) {
        this.birth_death = birth_death;
    }

    /**
     * Gets the nations for the Laureate
     *
     * @return the nations for the Laureate
     */
    public ArrayList<String> getNations() {
        return nations;
    }

    /**
     * Adds the nations for the Laureate
     *
     * @param nation the nation for the Laureate
     */
    public void addNation(String nation) {
        nations.add(nation);
    }

    /**
     * Gets the languages for the Laureate
     *
     * @return the languages for the Laureate
     */
    public ArrayList<String> getLanguages() {
        return languages;
    }

    /**
     * Adds the language for the Laureate
     *
     * @param language the language for the Laureate
     */
    public void addLanguage(String language) {
        languages.add(language);
    }

    /**
     * Gets the genres for the Laureate
     *
     * @return the genres for the Laureate
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * Adds a genre for the Laureate
     *
     * @param genre genre for the Laureate
     */
    public void addGenre(String genre) {
        genres.add(genre);
    }

    /**
     * Gets the citation for the Laureate
     */
    public String getCitation() {
        return citation;
    }

    /**
     * Sets the citation for the Laureate
     *
     * @param citation the citation for the Laureate
     */
    public void setCitation(String citation) {
        this.citation = citation;
    }

    /**
     * Returns a String containing the Laureate information
     */
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("Name: %s\nBirth Death: %s\nNations: %s\nLanguages: %s\nCitation: %s\nGenres: %s", name, birth_death, nations.toString(), languages.toString(), citation, genres.toString()));
        return info.toString();
    }

}
