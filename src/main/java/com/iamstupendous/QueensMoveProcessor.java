package com.iamstupendous;

import java.util.HashMap;

public class QueensMoveProcessor {
    private int n;
    private int totalMoves;

    /**
     *
     * @param n1
     * @param k
     * @param r_q
     * @param c_q
     * @param obstacles
     * @return
     */
    public int queensAttack(int n1, int k, int r_q, int c_q, int[][] obstacles) {
        n = n1;
        r_q--;
        c_q--;
        System.out.println("n = " + n);
        System.out.println("k = " + k);
        //convert obstable to simple HashMap
        var obstacleMap = new HashMap<String, String>();
        for (var obstacle: obstacles) {
            var key = String.format("%s%s", obstacle[0] - 1, obstacle[1] - 1);
            if (!obstacleMap.containsKey(key))
                obstacleMap.put(key, key);
            System.out.println();
        }

        moveUp(obstacleMap, r_q + 1, c_q);
        System.out.println("moveUp totalMoves: " + totalMoves);

        moveDown(obstacleMap, r_q - 1, c_q);
        System.out.println("moveDown totalMoves: " + totalMoves);

        moveLeft(obstacleMap, r_q, c_q - 1);
        System.out.println("moveLeft totalMoves: " + totalMoves);
        moveRight(obstacleMap, r_q, c_q + 1);
        System.out.println("moveRight totalMoves: " + totalMoves);
        moveLowerLeft(obstacleMap, r_q - 1, c_q - 1);
        System.out.println("moveLL totalMoves: " + totalMoves);
        moveUpperLeft(obstacleMap, r_q + 1, c_q - 1);
        System.out.println("moveUL totalMoves: " + totalMoves);
        moveUpperRight(obstacleMap, r_q + 1, c_q - 1);
        System.out.println("moveUR totalMoves: " + totalMoves);
        moveLowerRight(obstacleMap, r_q - 1, c_q + 1);
        System.out.println("moveLR totalMoves: " + totalMoves);
        System.out.println(totalMoves);
        return totalMoves;
    }

    public void moveUp(HashMap<String, String> obstacles, int row, int column) {
        //totalmoves = Math.abs(n - row);
        //how to check if their is obstacles, must be same column, n - colum
        //for (var i = row; i <= )
        if (row + 1 > n) return; //it means we reached the top of the board
        if (obstacles.containsKey(String.format("%s%s", row, column))) return; //check if obstacle
        totalMoves++;
        System.out.println("row: " + row + ", column: " + column);
        moveUp(obstacles, row + 1, column);
    }

    public void moveDown(HashMap<String, String> obstacles, int row, int column) {
        if (row - 1 < -1) return; //it means we reached the top of the board
        if (obstacles.containsKey(String.format("%s%s", row, column))) return; //check if obstacle
        totalMoves++;
        moveDown(obstacles, row - 1, column);
    }

    public void moveLeft(HashMap<String, String> obstacles, int row, int column) {
        if (column - 1 < -1) return; //it means we reached the top of the board
        if (obstacles.containsKey(String.format("%s%s", row, column))) return; //check if obstacle
        totalMoves++;
        moveLeft(obstacles, row, column - 1);
    }

    public void moveRight(HashMap<String, String> obstacles, int row, int column) {
        if (column + 1 > n) return; //it means we reached the top of the board
        if (obstacles.containsKey(String.format("%s%s", row, column))) return; //check if obstacle
        totalMoves++;
        moveRight(obstacles, row, column + 1);
    }

    public void moveLowerLeft(HashMap<String, String> obstacles, int row, int column) {
        if (column - 1 < -1 || row - 1 < -1) return; //it means we reached the top of the board
        if (obstacles.containsKey(String.format("%s%s", row, column))) return; //check if obstacle
        totalMoves++;
        moveLowerLeft(obstacles, row - 1, column - 1);
    }

    public void moveUpperLeft(HashMap<String, String> obstacles, int row, int column) {
        if (column - 1 < -1 || row + 1 > n) return; //it means we reached the top of the board
        if (obstacles.containsKey(String.format("%s%s", row, column))) return; //check if obstacle
        totalMoves++;
        moveUpperLeft(obstacles, row + 1, column - 1);
    }

    public void moveUpperRight(HashMap<String, String> obstacles, int row, int column) {
        if (column + 1 > n || row + 1 > n) return; //it means we reached the top of the board
        if (obstacles.containsKey(String.format("%s%s", row, column))) return; //check if obstacle
        totalMoves++;
        moveUpperRight(obstacles, row + 1, column + 1);
    }

    public void moveLowerRight(HashMap<String, String> obstacles, int row, int column) {
        if (column + 1 > n || row - 1 < -1) return; //it means we reached the top of the board
        if (obstacles.containsKey(String.format("%s%s", row, column))) return; //check if obstacle
        totalMoves++;
        moveLowerRight(obstacles, row - 1, column + 1);
    }
}
