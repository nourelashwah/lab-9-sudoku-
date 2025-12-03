package Model;

/**
 *
 * @author DELL
 */
public class Catalog
{
  boolean current; // True if there is a game in progress, False otherwise.
  boolean allModesExist; // True if there is atleast one game available for eachdifficulty, False otherwise.

    public Catalog(boolean current, boolean allModesExist) {
        this.current = current;
        this.allModesExist = allModesExist;
    }

    public boolean hasUnfinishedGame() {
        return current;
    }

    public boolean hasAllDifficulties() {
        return allModesExist;
    }
  
  
}
