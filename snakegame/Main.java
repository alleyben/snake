package snakegame;
import snakegame.gui.UserInterface;
import snakegame.game.SnakeGame;
import java.util.*; /// added
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		SnakeGame game = new SnakeGame(20, 20);
        UserInterface ui = new UserInterface(game, 20);
        SwingUtilities.invokeLater(ui);
        
        while (ui.getUpdatable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("The drawing board hasn't been created yet.");
            }
        }
        
        game.setUpdatable(ui.getUpdatable());
        game.start();
        
        /*
        to add:
        cannot turn backwards
        intro
        outro
        refactor names**
        score
        ??difficulty level?
        desktop/folder icon?
        install guide?
        */
	}

}
