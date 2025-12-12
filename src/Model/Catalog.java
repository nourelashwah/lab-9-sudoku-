package Model;

import java.io.IOException;

/**
 *
 * @author DELL
 */
public class Catalog
{
  private boolean current; // True if there is a game in progress, False otherwise.
  private boolean allModesExist; // True if there is atleast one game available for eachdifficulty, False otherwise.
  private Saving savee;
  private Load load;
  
  
 
    public Catalog(boolean current, boolean allModesExist) {
        this.current = current;
        this.allModesExist = allModesExist;
        
    }

    public void hasUnfinishedGame() {
        if(load.loadGame('i') == null)
        {
            current = false;
        }
        current = true;
    }

    public void hasAllDifficulties() {
      
        if(load.loadGame('e') == null || load.loadGame('m') == null ||  load.loadGame('h') == null )
        {
            allModesExist = false;
        }
        allModesExist = true;

    }

    public boolean isCurrent() {
        return current;
    }

    public boolean isAllModesExist() {
        return allModesExist;
    }
  
    
    
    public void addNew(Game game) throws IOException    //hena bn7othm fel folders 3ala hsb el level
                                                       //bnftrd en mfish ay error in validation, bn-handlha ABL ma nnady el method de
    {
        if(game!=null)
        {
            savee.SavingToFolder(game); 
        }
        else
        {
            return;
        }
    }
  
}
