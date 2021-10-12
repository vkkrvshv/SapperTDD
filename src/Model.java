public class Model {
    static final int FIELD_SIZE = 10;
    static final int mines = 7;

    Cell[][] cells;

    public void generateBoard(int FIELD_SIZE, int mines) {
        cells = new Cell[FIELD_SIZE][FIELD_SIZE];
        for (int j = 0; j < FIELD_SIZE; j++) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                cells[i][j] = new Cell(j,i);
            }
        }

    }

    private void incrementCountAroundCell(int row, int column) {
        for (int j = -1; j < 2; j++) {
            for (int i = -1; i < 2; i++) {
                if(!outOfBounds(column + i, row + j)) {
                    if((i == 0) && (j == 0)) {
                        cells[column + i][row + j].counter = 10;
                        cells[column + i][row + j].mined = true;
                    }
                    else {
                        cells[column + i][row + j].counter++;
                    }

                }
            }
        }
    }

    private boolean isWon() {
        for(int j = 0; j < cells.length; j++) {
            for(int i = 0; i < cells[0].length; i++) {
                if((cells[i][j].state == "closed") && (!cells[i][j].mined)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean outOfBounds(int column,int row) {
        try {
            Cell cell = cells[column][row];
            return false;
        }
        catch (IndexOutOfBoundsException e) {
            return true;
        }
    }
}
