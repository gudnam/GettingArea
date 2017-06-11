package test.java.area;

import main.java.area.GettingArea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static main.java.area.GettingArea.EMPTY;
import static main.java.area.GettingArea.FILL;
import static main.java.area.GettingArea.PASSED;
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

        int x=7, y=5;
        int rectX1 = 0, rectY1 = 2, rectX2 = 4, rectY2 = 4;
        Integer rect1[][] = {{rectX1, rectY1}, {rectX2, rectY2}};

        List<Integer[][]> rectAreaList = new ArrayList<>();
        rectAreaList.add(rect1);

        int[][] filledArea = ga.fillArea(ga.initializeArea(x, y), rectAreaList);

        int areaCount = x*y;
        int filledCount = 0;
        for (int i=rectX1; i<rectX2; i++) {
            for (int j=rectY1; j<rectY2; j++) {
                assertTrue(filledArea[i][j] == FILL);
                filledCount++;
            }
        }

        assertTrue(areaCount-filledCount == 27);
    }

    private int[][] getTestArea() {
        int x=7, y=5;
        Integer rect1[][] = {{0, 2}, {4, 4}};
        Integer rect2[][] = {{1, 1}, {2, 5}};
        Integer rect3[][] = {{4, 0}, {6, 2}};

        List<Integer[][]> rectAreaList = new ArrayList<>();
        rectAreaList.add(rect1);
        rectAreaList.add(rect2);
        rectAreaList.add(rect3);

        return ga.fillArea(ga.initializeArea(x, y), rectAreaList);
    }

    @Test
    public void testToGetEmptyArea() {

        int[][] filledArea = getTestArea();

        List<Integer> emptyAreaLengthList = ga.getEmptyAreaList(filledArea);

        assertTrue(emptyAreaLengthList.size() == 3);
        assertTrue(emptyAreaLengthList.get(0) == 7);
        assertTrue(emptyAreaLengthList.get(1) == 1);
        assertTrue(emptyAreaLengthList.get(2) == 13);
    }

    @Test
    public void testRectSizeListIsZeroIfAreaIsAllFilled() {
        int[][] filledArea = getTestArea();
        for (int i=0; i<filledArea.length; i++) {
            for (int j=0; j<filledArea[i].length; j++) {
                filledArea[i][j] = FILL;
            }
        }
        assertTrue(ga.getEmptyAreaList(filledArea).size() == 0);
    }

    @Test
    public void testRectSizeListIsZeroIfAreaIsAllPassed() {
        int[][] filledArea = getTestArea();
        for (int i=0; i<filledArea.length; i++) {
            for (int j=0; j<filledArea[i].length; j++) {
                filledArea[i][j] = PASSED;
            }
        }
        assertTrue(ga.getEmptyAreaList(filledArea).size() == 0);
    }
}
