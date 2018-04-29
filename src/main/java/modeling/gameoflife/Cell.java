package modeling.gameoflife;

/**
 * Created by Wienio on 2018-04-27.
 */
public class Cell {

    private int state = 0;
    private int positionX;
    private int positionY;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

}
