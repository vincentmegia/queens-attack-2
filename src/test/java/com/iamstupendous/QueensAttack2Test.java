package com.iamstupendous;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.Scanner;

public class QueensAttack2Test {
    private static final Scanner scanner = new Scanner(System.in);

    @Test
    public void test1() throws IOException {
        var n = 4;
        var k = 0;
        var r_q = 4;
        var c_q = 4;
        var obstacles = new int[k][2];
        for (var i = 0; i < k; i++) {
            var obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (var j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        var queensMoveProcessor = new QueensMoveProcessor();
        var result = queensMoveProcessor.queensAttack(n, k, r_q, c_q, obstacles);
        assertEquals(result, 9);
    }

    @Test
    public void test2() throws IOException {
        var n = 5;
        var k = 3;
        var r_q = 4;
        var c_q = 3;
        var obstacles = new int[][]
        {
            new int[] {5, 5},
            new int[] {4, 2},
            new int[] {2, 3}
        };

        var queensMoveProcessor = new QueensMoveProcessor();
        var result = queensMoveProcessor.queensAttack(n, k, r_q, c_q, obstacles);
        assertEquals(result, 10);
    }

    @Test
    public void test21() throws IOException {
        var n = 1;
        var k = 0;
        var r_q = 1;
        var c_q = 1;
        var obstacles = new int[][]{};
        var queensMoveProcessor = new QueensMoveProcessor();
        var result = queensMoveProcessor.queensAttack(n, k, r_q, c_q, obstacles);
        assertEquals(result, 0);
    }

    @Test
    public void test3() throws IOException {
        var n = 100000;
        var k = 0;
        var r_q = 4187;
        var c_q = 5068;
        var obstacles = new int[][]{};
        var queensMoveProcessor = new QueensMoveProcessor();
        var result = queensMoveProcessor.queensAttack(n, k, r_q, c_q, obstacles);
        assertEquals(result, 0);
    }
}
