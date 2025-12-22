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
        savee = new  Saving();
        load = new Load();
    }
//    public Catalog(){
//    hasUnfinishedGame();
//    hasAllDifficulties();
//    }

    public  boolean hasUnfinishedGame() {
        if(load.loadGame('i') == null)
        {
            current = false;
        }else{
        current = true;}
        return current;
    }

    public  boolean hasAllDifficulties() {
      
        if(load.checkGame('e') == false || load.checkGame('m') == false ||  load.checkGame('h') == false )
        {
            allModesExist = false;
            
        }
        else{
        allModesExist = true;}
        
return allModesExist;
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
