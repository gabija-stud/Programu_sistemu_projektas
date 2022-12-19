import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String a[]) throws IOException {

        Player player = Player.getInstance();

        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(6, 3, -1, 0));
        enemies.add(new Enemy(17, 2, -1, 0));
        enemies.add(new Enemy(40, 5, -1, 0));

        Map map = new Map();

        Renderer renderer = new Renderer(enemies, player, map);
        Rules rules = new Rules(enemies, player, map);

        ObserverMessage message = new ObserverMessage();

        while(rules.gameOver == false) {
            renderer.renderGame();
            byte userInput = readUserInput();
            rules.UserInputs(userInput);
            rules.moveEnemies();
            rules.hitEnemy();
            rules.playerHitWall();
        }
    }

    private static byte readUserInput() throws IOException {
        byte bytes[] = new byte[10];
        System.in.read(bytes);
        byte userInput = bytes[0];
        return userInput;
    }
}