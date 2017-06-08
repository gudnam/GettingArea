package main.java.area;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gudnam on 2017. 6. 7..
 */
public class GettingArea {

    public static final int EMPTY = 0;
    public static final int FILL = 1;
    public static final int PASSED = 2;

    List<Integer> results;

    public GettingArea() {
        results = new ArrayList<>();
    }

    public int[][] fillArea(int[][] area, List<Integer[][]> rectAreaList) {

        int[][] filledArea = new int[area.length][area[0].length];
        for (int i=0; i<area.length; i++) {
            for (int j=0; j<area[i].length; j++) {
                for (Integer[][] rect : rectAreaList) {
                    if ((rect[0][0] <= i && i <= rect[1][0]) &&
                            (rect[0][1] <= j && j <= rect[1][1]))
                        filledArea[i][j] = FILL;
                    else
                        filledArea[i][j] = area[i][j];
                }
            }
        }

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
        List<Integer> emptyAreaLengthList = new ArrayList<>();

        next(area, 0, 0, 0);
//        emptyAreaLengthList.add(1);
//        emptyAreaLengthList.add(7);
//        emptyAreaLengthList.add(13);

        return emptyAreaLengthList;
    }

    private int[] getStart(int[][] area, int x, int y) {
        int[] start = new int[2];
        for (int i=x; i<area.length; i++) {
            for (int j=y; j<area[0].length; j++) {
                if (area[i][j] == FILL) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    List<Integer> rectSizeList = new ArrayList<>();
    private void next(final int[][] area, int x, int y, int rectSize) {
        if (area[x][y] != FILL) {
            int[] start = getStart(area, x, y);
            next(area, start[0], start[1], ++rectSize);
        }

        area[x][y] = PASSED;

        if (y < area[1].length -1 && area[y+1][x] == FILL) {
            next(area, x, y + 1, ++rectSize);
        } else if (y > 0 && area[y-1][x] == FILL) {
            next(area, x, y - 1, ++rectSize);
        } else if (x < area[0].length-1 && area[y][x + 1] == FILL) {
            next(area, x + 1, y, ++rectSize);
        } else if (x > 0 && area[y][x - 1] != 0) {
            next(area, x - 1, y, ++rectSize);
        } else {
            rectSizeList.add(rectSize);
        }
    }
}
