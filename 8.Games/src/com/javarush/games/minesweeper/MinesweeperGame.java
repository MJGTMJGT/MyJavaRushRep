package com.javarush.games.minesweeper;

//Игра сапер (6/16)

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    @Override
    public void initialize() {
        //super.initialize();
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
        countMinesOnField = countMinesTemp;
    }
}
