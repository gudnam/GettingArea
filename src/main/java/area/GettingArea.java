package main.java.area;

import java.util.*;

/**
 * Created by gudnam on 2017. 6. 7..
 */
public class GettingArea {

    public static final int EMPTY = 0;
    public static final int FILL = 1;
    public static final int PASSED = 2;

    List<Integer> rectSizeList;

    public GettingArea() {
        rectSizeList = new ArrayList<>();
    }

    public int[][] fillArea(final int[][] area, List<Integer[][]> rectvisitedList) {

        int[][] filledArea = new int[area.length][area[0].length];
        for (Integer[][] rect : rectvisitedList) {
            for (int i=0; i<area.length; i++) {
                for (int j=0; j<area[i].length; j++) {
                    if ((rect[0][0] <= i && i < rect[1][0]) &&
                            (rect[0][1] <= j && j < rect[1][1]))
                        filledArea[i][j] = FILL;
                    else {
                        if (filledArea[i][j] != FILL)
                            filledArea[i][j] = area[i][j];
                    }
                }
            }
        }

        showGraph(filledArea);

        return filledArea;
    }

    public int[][] initializeArea(int x, int y) {
        int[][] area = new int[x][y];

        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                area[i][j] = EMPTY;
            }
        }

        return area;
    }

    public List<Integer> getEmptyAreaList(int[][] area) {
        next(area, 0, 0);

        return rectSizeList;
    }

    private void next(final int[][] area, int x, int y) {
        int[] start = getEmptyPosition(area, x, y);

//        if (start == null || start[0] <= area.length)
    }

    private int[] getEmptyPosition(int[][] area, int x, int y) {
        int[] start = new int[2];
        for (int i=x; i<area.length; i++) {
            for (int j=y; j<area[0].length; j++) {
                if (area[i][j] == EMPTY) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private void showGraph(int[][] area) {
        for (int j=0; j<area[0].length; j++) {
            System.out.println();
            for (int i=0; i<area.length; i++) {
                System.out.print(area[i][j]);
            }
        }
        System.out.println();
        System.out.println();
    }
}
