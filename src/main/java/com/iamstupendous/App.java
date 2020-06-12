package com.iamstupendous;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static int k = 0;
    static int n = 0;
    static int totalMoves = 0;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main( String[] args ) throws IOException {
        //62

        var bufferedWriter = new BufferedWriter(new FileWriter("input-1.txt"));
        var nk = scanner.nextLine().split(" ");
        var n = Integer.parseInt(nk[0]);
        var k = Integer.parseInt(nk[1]);
        var r_qC_q = scanner.nextLine().split(" ");
        var r_q = Integer.parseInt(r_qC_q[0]);
        var c_q = Integer.parseInt(r_qC_q[1]);
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
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }


}
