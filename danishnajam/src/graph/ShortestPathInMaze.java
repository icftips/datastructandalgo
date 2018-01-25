
package graph;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class MatrixCell {
    int x, y;
    public MatrixCell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ShortestPathInMaze {

    public ShortestPathInMaze(int row, int col) {
        this.rows = row;
        this.columns = col;
    }

    class QueueNode {
        MatrixCell cell;
        int distance;

        public QueueNode(MatrixCell src, int distance) {
            this.cell = src;
            this.distance = distance;
        }
    }

    int rows;
    int columns;

    // valid moves
    int rowNum[] = { 0, 0, -1, 1 };
    int colNum[] = { -1, 1, 0, 0 };

    boolean isValid(int nextRow, int nextColumn) {
        // return true if row number and column number
        // is within matrix bounds
        return  (nextRow >= 0) && (nextRow < rows) &&
                (nextColumn >= 0) && (nextColumn < columns);
    }

    public static void main(String[] args) {

        ShortestPathInMaze g = new ShortestPathInMaze(10, 10);
        int mtx[][] = new int[][] {
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };

        MatrixCell source = new MatrixCell(0, 0);
        MatrixCell dest = new MatrixCell(3, 4);

        int dist = g.BFSTemplate(mtx, source, dest);

        if (dist != -1)
            System.out.println("Shortest Path is " + dist);
        else
            System.out.println("Shortest Path does not exist");
    }

    int BFSTemplate(int mtx[][], MatrixCell src, MatrixCell dest) {
        Queue<QueueNode> q = new LinkedBlockingDeque<>();

        boolean visited[][] = new boolean[rows][columns];
        QueueNode s = new QueueNode(src, 0);
        visited[src.x][src.y] = true;
        q.offer(s);

        QueueNode current;
        while (!q.isEmpty()) {
            current = q.poll();
            if (current.cell.x == dest.x && current.cell.y == dest.y) {
                return current.distance;
            }
            // else find a valid move
            for (int i = 0; i < 4; i++) {
                int newx = current.cell.x + rowNum[i];
                int newy = current.cell.y + colNum[i];
                /*
                 * if neighboring cell is valid(means within matrix bounds), has
                 * path(means have 1) and not visited yet than enqueue it by
                 * adding 1 in current distance.
                 */
                if (isValid(newx, newy)
                    && !visited[newx][newy]
                    && mtx[newx][newy] == 1)
                {
                    q.offer(new QueueNode(new MatrixCell(newx, newy), current.distance + 1));
                    visited[newx][newy] = true;
                }
            }
        }
        // -1 means can't be reached
        return -1;
    }
}
