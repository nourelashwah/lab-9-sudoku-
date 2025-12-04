package Model;

/**
 *
 * @author DELL
 */
public class Catalog
{
  private boolean current; // True if there is a game in progress, False otherwise.
  private boolean allModesExist; // True if there is atleast one game available for eachdifficulty, False otherwise.
  
  
 
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
  
    public void addNew(Game game)    //hena bn7othm fel folders 3ala hsb el level
    {
        if(game!=null)
        {
            switch(game.getDifficulty())
            {
                case "easy":
                    savee.addGame(game);
                    break;
                case "medium":
                     savee.addGame(game);
                    break;
                case "hard":
                    savee.addGame(game);
                    break;
                default:
                    return;
            }
        }
        else
        {
            return;
        }
    }
  
}
