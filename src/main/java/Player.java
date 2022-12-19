public class Player {
    int x;
    int y;
    private static Player player = new Player(6, 7);

    private Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Player getInstance(){
        return player;
    }
}
