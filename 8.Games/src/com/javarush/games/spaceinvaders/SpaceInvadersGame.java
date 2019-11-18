package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64, HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private static final int PLAYER_BULLETS_MAX = 1;
    private int animationsCount, score;
    private boolean isGameStopped;
    private List<Bullet> playerBullets;
    private EnemyFleet enemyFleet;
    private List<Star> stars;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) enemyBullets.add(bullet);
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case SPACE:
                if (isGameStopped) {
                    createGame();
                    return;
                }
                Bullet bullet = playerShip.fire();
                if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX)
                    playerBullets.add(bullet);
                break;
            case LEFT:
                playerShip.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                playerShip.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        switch (key) {
            case LEFT:
                if (playerShip.getDirection() == Direction.LEFT) playerShip.setDirection(Direction.UP);
                break;
            case RIGHT:
                if (playerShip.getDirection() == Direction.RIGHT) playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) return;
        super.setCellValueEx(x, y, cellColor, value);
    }

    private void createGame() {
        createStars();
        enemyFleet = new EnemyFleet();
        setTurnTimer(40);
        enemyBullets = new ArrayList<>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        playerBullets = new ArrayList<>();
        score = 0;
        drawScene();
    }

    private void drawScene() {
        drawField();
        for (Bullet pfl : playerBullets) pfl.draw(this);
        for (Bullet efl : enemyBullets) efl.draw(this);
        enemyFleet.draw(this);
        playerShip.draw(this);
    }

    private void drawField() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                setCellValueEx(i, j, Color.BLACK, "");
            }
        }
        for (int i = 0; i < stars.size(); i++) {
            stars.get(i).draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(getRandomNumber(WIDTH - 1), getRandomNumber(HEIGHT - 1)));
        }
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet plBullet : playerBullets) plBullet.move();
        for (Bullet enBullet : enemyBullets) enBullet.move();
        playerShip.move();
    }

    private void removeDeadBullets() {
        for (int i = enemyBullets.size() - 1; i >= 0 ; i--) if (!enemyBullets.get(i).isAlive || enemyBullets.get(i).y >= HEIGHT - 1) enemyBullets.remove(i);
        for (int i = playerBullets.size() - 1; i >= 0 ; i--) if (!playerBullets.get(i).isAlive || playerBullets.get(i).y + playerBullets.get(i).height < 0) playerBullets.remove(i);
        /*enemyBullets.removeIf(b -> !b.isAlive || b.y >= HEIGHT - 1);
        playerBullets.removeIf(b -> !b.isAlive || b.y + b.height < 0);*/
    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if (!playerShip.isAlive) stopGameWithDelay();
        if (enemyFleet.getBottomBorder() >= playerShip.y) playerShip.kill();
        if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) showMessageDialog(Color.BLACK, "You win!!!", Color.GREEN, 40);
        else showMessageDialog(Color.BLACK, "Game over", Color.RED, 40);
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) stopGame(playerShip.isAlive);
    }
}
