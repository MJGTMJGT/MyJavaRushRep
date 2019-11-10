package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    public static final int WIDTH = 64, HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2, ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;
    private int score;
    private boolean isGameStopped;
    private RoadMarking roadMarking;
    private RoadManager roadManager;
    private PlayerCar player;
    private FinishLine finishLine;
    private ProgressBar progressBar;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x < 0 || x >= WIDTH || y < 0 || y >=HEIGHT) return;
        super.setCellColor(x, y, color);
    }

    @Override
    public void onTurn(int step) {
        score -= 5;
        setScore(score);
        if (roadManager.checkCrush(player)) {
            gameOver();
            drawScene();
            return;
        }
        if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) finishLine.show();
        if (finishLine.isCrossed(player)) {
            win();
            drawScene();
            return;
        }
        moveAll();
        roadManager.generateNewRoadObjects(this);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case RIGHT:
                player.setDirection(Direction.RIGHT);
                break;
            case LEFT:
                player.setDirection(Direction.LEFT);
                break;
            case SPACE:
                if (isGameStopped) createGame();
                break;
            case UP:
                player.speed = 2;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        switch (key) {
            case RIGHT:
                if (player.getDirection() == Direction.RIGHT) player.setDirection(Direction.NONE);
                break;
            case LEFT:
                if (player.getDirection() == Direction.LEFT) player.setDirection(Direction.NONE);
                break;
            case UP:
                player.speed = 1;
        }
    }

    private void createGame() {
        setTurnTimer(40);
        score = 3500;
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        isGameStopped = false;
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        drawScene();
    }

    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
        finishLine.draw(this);
        progressBar.draw(this);
    }

    private void drawField() {
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < HEIGHT; x++) {
                if (x == CENTER_X) setCellColor(CENTER_X, y, Color.WHITE);
                else if (x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH) setCellColor(x, y, Color.DIMGRAY);
                else setCellColor(x, y, Color.GREEN);
            }
        }
    }

    private void moveAll() {
        roadMarking.move(player.speed);
        player.move();
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "GAME OVER", Color.BLACK, 40);
        stopTurnTimer();
        player.stop();
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "YOU WIN!!!", Color.BLACK, 40);
        stopTurnTimer();
    }
}
