package com.javarush.games.minesweeper;

//Игра сапер (6/16)

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private int countMinesOnField;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        int countMinesTemp = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                boolean b = false;
                if (getRandomNumber(10) == 0) {
                    b = true;
                    countMinesTemp++;
                }
                gameField[j][i] = new GameObject(i, j, b);
                setCellColor(i, j, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countMinesOnField = countMinesTemp;
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
        if (gameField[x][y].isMine) {
            setCellValue(x, y, MINE);
            gameField[x][y].isOpen = true;
            setCellColor(x, y, Color.RED);
        } else {
            setCellNumber(x, y, gameField[x][y].countMineNeighbors);
            gameField[x][y].isOpen = true;
            setCellColor(x, y, Color.GREEN);
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }
}
