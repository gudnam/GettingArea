package main.java;

import main.java.area.GettingArea;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GettingArea ga = new GettingArea();

        int areaX = 5, areaY = 7, rectCount = 3;
        List<Integer[][]> rectAreaList = new ArrayList<>();
        Integer rect1[][] = {{0, 2}, {4, 4}};
        Integer rect2[][] = {{1, 1}, {2, 5}};
        Integer rect3[][] = {{4,0}, {6,2}};
        rectAreaList.add(rect1);
        rectAreaList.add(rect2);
        rectAreaList.add(rect3);

        int[][] area = ga.initializeArea(areaX, areaY);
        int[][] filledArea = ga.fillArea(area, rectAreaList);
    }
}
