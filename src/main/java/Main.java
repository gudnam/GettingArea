package main.java;

import main.java.area.GettingArea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input : ");
        int arrayY = scanner.nextInt();
        int arrayX = scanner.nextInt();
        int rectCount = scanner.nextInt();

        scanner.nextLine();

        List<Integer[][]> rectAreaList = new ArrayList<>();
        for (int cnt=0; cnt<rectCount; cnt++) {
            Integer rect[][] = new Integer[2][2];
            for (int i=0; i<rect.length; i++) {
                for (int j=0; j<rect.length; j++) {
                    rect[i][j] = scanner.nextInt();
                }
            }
            rectAreaList.add(rect);
        }

        System.out.println();

        GettingArea ga = new GettingArea();

        System.out.println("Graph : ");
        int[][] filledArea = ga.fillArea(ga.initializeArea(arrayX, arrayY), rectAreaList);

        System.out.println("Output : ");
        ga.showEmptyAreaList(filledArea);
    }
}
