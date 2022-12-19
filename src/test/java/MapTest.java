import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    Map map = new Map();
    @Test
    void isWall() {
        assertEquals(false, map.isWall(1,1));
    }

    @Test
    void isBlank() {
        assertEquals(true, map.isBlank(1,1));
    }

    @Test
    void getHeight() {
        assertEquals(11 ,map.getHeight());
    }

    @Test
    void getWidth() {
        assertEquals(47 ,map.getWidth());
    }
}