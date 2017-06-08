package test.java.area;

import main.java.area.GettingArea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static main.java.area.GettingArea.EMPTY;
import static main.java.area.GettingArea.FILL;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by gudnam on 2017. 6. 7..
 */
public class GettingAreaTest {

    GettingArea ga;

    @BeforeEach
    void setUp() {
        ga = new GettingArea();
    }

    private int[][] createTestFilledArea(int x, int y, int rectX1, int rectY1, int rectX2, int rectY2) {

        List<Integer[][]> rectAreaList = new ArrayList<>();
        Integer rect1[][] = {{rectX1, rectY1}, {rectX2, rectY2}};
        rectAreaList.add(rect1);

        return ga.fillArea(ga.initializeArea(x, y), rectAreaList);
    }

    @Test
    public void testToInitializeArea() {
        int x=2, y=3;
        int[][] area = ga.initializeArea(x,y);

        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                assertTrue(area[i][j] == EMPTY);
            }
        }
    }

    @Test
    public void testToFillArea() {

        int x=5, y=7;
        int rectX1 = 0, rectY1 = 2, rectX2 = 4, rectY2 = 4;

        int[][] filledArea = createTestFilledArea(x, y, rectX1, rectY1, rectX2, rectY2);

        int areaCount = x*y;
        int filledCount = 0;
        for (int i=rectX1; i<=rectX2; i++) {
            for (int j=rectY1; j<=rectY2; j++) {
                assertTrue(filledArea[i][j] == FILL);
                filledCount++;
            }
        }

        assertTrue(areaCount-filledCount == 20);
    }

    @Test
    public void testToGetEmptyArea() {
        int x=5, y=7;
        int rectX1 = 0, rectY1 = 2, rectX2 = 4, rectY2 = 4;

        int[][] filledArea = createTestFilledArea(x, y, rectX1, rectY1, rectX2, rectY2);

        List<Integer> emptyAreaLengthList = ga.getEmptyAreaList(filledArea);

        assertTrue(emptyAreaLengthList.size() == 3);
        assertTrue(emptyAreaLengthList.get(0) == 1);
        assertTrue(emptyAreaLengthList.get(1) == 7);
        assertTrue(emptyAreaLengthList.get(2) == 13);
    }
}
