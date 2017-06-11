package main.java.area;

import java.util.*;

/**
 * Created by gudnam on 2017. 6. 7..
 */
public class GettingArea {

    public static final int EMPTY = 0;
    public static final int FILL = 1;
    public static final int PASSED = 2;

    private int cnt = 0;
    private List<Integer> rectSizeList;

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

        int[] start = new int[2];
        while (start != null) {
            cnt = 0;
            start = getEmptyPosition(area, 0, 0);
            if (start != null) {
                next(area, start[0], start[1]);

                showGraph(area);
                rectSizeList.add(cnt);

                System.out.println("rect count : " + cnt + ", rect size : " + rectSizeList.size());
            }
        }

        return rectSizeList;
    }

    private void next(int[][] area, int x, int y) {
        System.out.println("(" + x + ", " + y + ")");
        cnt++;
        area[x][y] = PASSED;
        if (x+1 < area.length && area[x+1][y] <= area.length && area[x+1][y] == EMPTY) {
            System.out.println("right");
            next(area, x+1, y);
        }
        if (x-1 >= 0 && area[x-1][y] >= 0 && area[x-1][y] == EMPTY) {
            System.out.println("left");
            next(area, x-1, y);
        }
        if (y+1 < area[x].length && area[x][y+1] <= area[x].length && area[x][y+1] == EMPTY) {
            System.out.println("up");
            next(area, x, y+1);
        }
        if (y-1 >= 0 && area[x][y-1] >= 0 && area[x][y-1] == EMPTY) {
            System.out.println("down");
            next(area, x, y-1);
        }
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
