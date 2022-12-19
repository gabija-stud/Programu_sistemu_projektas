import java.util.ArrayList;
import java.util.List;

public class Rules implements Subject {
    private List<Enemy> enemies;
    private Player player;
    private Map map;

    public boolean gameOver = false;

    private List<Observer> listOfObservers = new ArrayList<Observer>();

    public Rules(List<Enemy> enemies, Player player, Map map) {
        this.enemies = enemies;
        this.player = player;
        this.map = map;
    }

    public boolean hitWall(Enemy enemy) {
        return map.isWall(enemy.x + enemy.dx, enemy.y + enemy.dy);
    }

    public void moveEnemies() {
        for (Enemy enemy: enemies) {
            if (hitWall(enemy)) {
                enemy.changeDirection();
            }
            else {
                enemy.moveForward();
            }
        }
    }

    public void hitEnemy() {
        for (Enemy enemy: enemies) {
            if (player.x == enemy.x && player.y == enemy.y) {
                gameOver = true;
                notifyObserver();
            }
        }
    }

    public void playerHitWall() {
        if (map.isWall(player.x, player.y)) {
            gameOver = true;
            notifyObserver();
        }
    }

    public void UserInputs(int userInput) {
        switch(userInput) {
            case 'q':
                gameOver = true;
                break;
            case 'a':
                player.x -= 1;
                break;
            case 'd':
                player.x += 1;
                break;
            case 'w':
                player.y -= 1;
                break;
            case 's':
                player.y += 1;
                break;
        }
    }

    public List<Observer> getListOfObservers() {
        return listOfObservers;
    }

    public void setListOfObservers(List<Observer> listOfObservers) {
        this.listOfObservers = listOfObservers;
    }

    @Override
    public void registerObserver(Observer observer) {
        listOfObservers.add(observer);
    }

    @Override
    public void removeObservers(Observer observer) {
        listOfObservers.remove(observer);
    }

    @Override
    public void notifyObserver() {
         System.out.println("Game Over");
         for(Observer observer : listOfObservers) {
             observer.update();
         }
    }
}
