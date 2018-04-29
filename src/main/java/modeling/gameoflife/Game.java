package modeling.gameoflife;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wienio on 2018-04-26.
 */
public class Game {

    private Cell[][] cells = new Cell[35][50];
    private Map<Cell, Integer> cellsToUpdate = new HashMap<>();

    public void checkNeighbours() {
        int startY, endY, startX, endX;
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[i].length; ++j) {
                startY = i == 0 ? i : i - 1;
                endY = i == cells.length - 1 ? i : i + 1;
                startX = j == 0 ? j : j - 1;
                endX = j == cells[i].length - 1 ? j : j + 1;

                int counter = 0;
                for (int k = startY; k <= endY; ++k) {
                    for (int l = startX; l <= endX; ++l) {
                        if (i == k && j == l) {
                            continue;
                        }
                        if (cells[k][l].getState() == 1) {
                            counter++;
                        }
                    }
                }
                if (counter < 2 || counter > 3) {
                    cellsToUpdate.put(cells[i][j], 0);
                } else if (counter == 3) {
                    cellsToUpdate.put(cells[i][j], 1);
                }
            }
        }
    }

    public void update() {
        for (Map.Entry<Cell, Integer> entry : cellsToUpdate.entrySet()) {
            entry.getKey().setState(entry.getValue());
        }

        cellsToUpdate.clear();
    }

    public Game() {
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[i].length; ++j) {
                cells[i][j] = new Cell(j, i);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

}
