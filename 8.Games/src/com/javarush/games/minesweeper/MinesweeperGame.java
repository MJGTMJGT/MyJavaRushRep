package com.javarush.games.minesweeper;

//Игра сапер (15/16)

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countMinesOnField = 0, countFlags, score = 0, countClosedTiles = SIDE*SIDE;
    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellColor(i, j, Color.ORANGE);
                setCellValue(i, j, "");
                boolean mine = getRandomNumber(10) == 0;
                gameField[j][i] = new GameObject(i, j, mine);
                if (mine) countMinesOnField++;

            }
        }
        //isGameStopped = false;
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void countMineNeighbors() {
        for (GameObject[] line : gameField) {
            for (GameObject go : line) {
                if (!go.isMine) {
                    for (GameObject nei : getNeighbors(go)) if (nei.isMine) go.countMineNeighbors++;
                }
            }
        }
    }

    //Про необходимость создания этого метода в условии ничего не сказано! Нашел в подсказках.
    private List<GameObject> getNeighbors(GameObject go) {
        List<GameObject> neighbors = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if (go.x + i < 0 || go.x + i == SIDE) continue;
                if (go.y + j < 0 || go.y + j == SIDE) continue;
                neighbors.add(gameField[go.y + j][go.x + i]);
            }
        }
        return neighbors;
    }

    private void openTile(int x, int y) {
        if (gameField[y][x].isOpen || gameField[y][x].isFlag || isGameStopped) return;
        setCellColor(x, y, Color.GREEN);
        gameField[y][x].isOpen = true;
        countClosedTiles--;
        if (gameField[y][x].isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else {
            score += 5;
            setScore(score);
            if (countClosedTiles == countMinesOnField) {
                win();
            } else if (gameField[y][x].countMineNeighbors != 0) {
                setCellNumber(x, y, gameField[y][x].countMineNeighbors);
            } else {
                for (GameObject go : getNeighbors(gameField[y][x])) {
                    if (!go.isOpen) openTile(go.x, go.y);
                }
                setCellValue(x, y, "");
            }
        }
    }

    private void markTile(int x, int y) {
        if (isGameStopped || gameField[y][x].isOpen || (countFlags == 0 && !gameField[y][x].isFlag)) return;
        if (!gameField[y][x].isFlag) {
            gameField[y][x].isFlag = true;
            countFlags--;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        } else {
            gameField[y][x].isFlag = false;
            countFlags++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE*SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Game over", Color.BLACK, 40);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "You win", Color.BLACK, 40);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) restart();
        else openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}
