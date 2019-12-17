package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case LEFT:
                moveLeft();
                drawScene();
                break;
            case RIGHT:
                moveRight();
                drawScene();
                break;
            case UP:
                moveUp();
                drawScene();
                break;
            case DOWN:
                moveDown();
                drawScene();
        }
    }

    private void moveLeft() {
        int flag = 0;
        for (int i = 0; i < SIDE; i++) if (compressRow(gameField[i])) flag++;
        for (int i = 0; i < SIDE; i++) if (mergeRow(gameField[i])) flag++;
        for (int i = 0; i < SIDE; i++) if (compressRow(gameField[i])) flag++;
        if (flag > 0) createNewNumber();
    }

    private void moveRight() {
    }

    private void moveUp() {
    }

    private void moveDown() {
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void rotateClockwise() {
    }

    private void drawScene() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                //setCellColor(i, j, Color.RED);
                setCellColoredNumber(i, j, gameField[j][i]);
            }
        }
    }

    private void createNewNumber() {
        int x, y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[y][x] != 0);
        gameField[y][x] = getRandomNumber(10) == 9 ? 4 : 2;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        setCellValueEx(x, y, getColorByValue(value), value == 0 ? "" : String.valueOf(value));
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 2:
                return Color.NAVAJOWHITE;
            case 4:
                return Color.AQUA;
            case 8:
                return Color.BEIGE;
            case 16:
                return Color.CYAN;
            case 32:
                return Color.LIGHTPINK;
            case 64:
                return Color.MEDIUMORCHID;
            case 128:
                return Color.PURPLE;
            case 256:
                return Color.OLIVE;
            case 512:
                return Color.YELLOW;
            case 1024:
                return Color.TURQUOISE;
            case 2048:
                return Color.SANDYBROWN;
            default:
                return Color.WHITE;
        }
    }

    private boolean compressRow(int[] row) {
        boolean temp = false, move = false;
        int j = 0;
        for (int i = 0; i < row.length; i++) {
            if (j == i && row[i] != 0) j++;
            else if (!temp && row[i] == 0) temp = true;
            else if (row[i] != 0) {
                if (!move) move = true;
                row[j] = row[i];
                row[i] = 0;
                j++;
            }
        }
        return move;
    }

    private boolean mergeRow(int[] row) {
        boolean move = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] *= 2;
                row[i + 1] = 0;
                move = true;
                i++;
            }
        }
        return move;
    }
}
