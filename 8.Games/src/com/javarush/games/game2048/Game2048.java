//Game 2048
package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private boolean isGameStopped = false;
    private int score;
    private int[][] gameField;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                drawScene();
            }
        } else if (!canUserMove()) {
            gameOver();
        } else {
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
    }

    private void moveLeft() {
        boolean flag = false;
        for (int[] lns : gameField)
            if (compressRow(lns) | mergeRow(lns)) {
                compressRow(lns);
                flag = true;
            }
        if (flag) createNewNumber();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void createGame() {
        setScore(score = 0);
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    private void rotateClockwise() {
        int[][] temp = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++)
                temp[i][j] = gameField[SIDE - 1 - j][i];
        }
        gameField = temp;
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
        if (getMaxTileValue() == 2048) win();
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[y][x] != 0);
        gameField[y][x] = getRandomNumber(10) == 9 ? 4 : 2;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        setCellValueEx(x, y, getColorByValue(value), value == 0 ? "" : String.valueOf(value));
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.NONE, "WIN!", Color.GREEN, 48);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.NONE, "GAME OVER !", Color.RED, 48);
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
                setScore(score += row[i]);
                row[i + 1] = 0;
                move = true;
                i++;
            }
        }
        return move;
    }

    private boolean canUserMove() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[j][i] == 0) return true;
                if (i < SIDE - 1 && gameField[j][i] == gameField[j][i + 1]) return true;
                if (j < SIDE - 1 && gameField[j][i] == gameField[j +1][i]) return true;
            }
        }
        return false;
    }

    private int getMaxTileValue() {
        int max = Integer.MIN_VALUE;
        for (int[] line : gameField)
            for (int value : line) if (value > max) max = value;
        return max;
    }
}
