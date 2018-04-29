package modeling.gameoflife;

import processing.core.PApplet;

/**
 * Created by Wienio on 2018-04-26.
 */
public class Main extends PApplet {

    private int renderInterval = 300;

    private Game game = new Game();
    private boolean gameStarted = false;

    public void setup() {
        size(1000, 700);
        background(220, 220, 220);
        noFill();
        stroke(105, 105, 105);
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 35; j++) {
                rect(20 * i, 20 * j, 20, 20);
            }
        }
        System.out.println("Click on cell to add status ALIVE, ENTER will start the game!");
    }

    public void draw() {
        if (gameStarted) {
            game.checkNeighbours();
            game.update();
            updateView();
            try {
                Thread.sleep(renderInterval);
            } catch (InterruptedException e) {
                System.out.println("Some error with main thread occured " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            if (mousePressed) {
                int x = mouseX;
                int y = mouseY;

                game.getCells()[y / 20][x / 20].setState(1);

                fill(255, 255, 0);
                noStroke();
                rect(x - x % 20 + 1, y - y % 20 + 1, 19, 19);
            }

            if (key == ENTER) {
                gameStarted = true;
            }
        }
    }

    private void updateView() {
        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 50; j++) {
                if (game.getCells()[i][j].getState() == 1) {
                    fill(255, 255, 0);
                    rect(j * 20 + 1, i * 20 + 1, 19, 19);
                } else {
                    fill(220, 220, 220);
                    rect(j * 20 + 1, i * 20 + 1, 19, 19);
                }
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("modeling.gameoflife.Main");
    }

}
