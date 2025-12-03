
package View;

import Controller.Controllable;
import Model.Catalog;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
// View package
public class GameFrame extends JFrame implements Controllable {
    
    private Catalog catalog;

    public GameFrame(Catalog catalog) {
        this.catalog = catalog;
      
    }

    @Override
    public Catalog getCatalog() {
        return catalog;
    }

    @Override
    public int[][] getGame(char level) throws NotFoundException {
     
        return null;
     
    }

    @Override
    public void driveGames(int[][] source) throws SolutionInvalidException {
      
    }

    @Override
    public boolean[][] verifyGame(int[][] game) {
        
        return null;
    
    }

    @Override
    public int[][] solveGame(int[][] game) throws InvalidGame {
       
        return null;
      
    }

    @Override
    public void logUserAction(UserAction userAction) throws IOException {
      
    }
}
