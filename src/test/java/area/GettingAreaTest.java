package test.java.area;

import main.java.area.GettingArea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testToGetEmptyArea() {
        int x=7, y=5;
        Integer rect1[][] = {{0, 2}, {4, 4}};
        Integer rect2[][] = {{1, 1}, {2, 5}};
        Integer rect3[][] = {{4, 0}, {6, 2}};

        List<Integer[][]> rectAreaList = new ArrayList<>();
        rectAreaList.add(rect1);
        rectAreaList.add(rect2);
        rectAreaList.add(rect3);

        int[][] filledArea = ga.fillArea(ga.initializeArea(x, y), rectAreaList);

        List<Integer> emptyAreaLengthList = ga.getEmptyAreaList(filledArea);

        assertTrue(emptyAreaLengthList.size() == 1);
        assertTrue(emptyAreaLengthList.get(0) == 27);
    }

    @Test
    public void test() {
        int[][] a = new int[10][5];

        System.out.println("x : " + a.length);
        System.out.println("y : " + a[0].length);
    }
}
