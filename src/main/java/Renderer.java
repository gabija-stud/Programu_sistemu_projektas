import java.util.List;

public class Renderer {
    private List<Enemy> enemies;
    private Player player;
    private Map map;

    public Renderer(List<Enemy> enemies, Player player, Map map) {
        this.enemies = enemies;
        this.player = player;
        this.map = map;
    }

    public void renderGame() {
        for (int y=0; y<map.getHeight(); y++) {
            for (int x=0; x<map.getWidth(); x++) {
                if (y == player.y && x == player.x) {
                    System.out.print("A");
                }
                else if (isEnemy(x, y)) {
                    System.out.print("O");
                }
                else if (map.isWall(x,y)) {
                    System.out.print("#");
                }
                else if (map.isBlank(x,y)) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private  boolean isEnemy(int x, int y) {
        for (Enemy enemy: enemies) {
            if (enemy.x == x && enemy.y == y) {
                return true;
            }
        }
        return false;
    }
}
