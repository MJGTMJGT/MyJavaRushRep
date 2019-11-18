package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    public double getBottomBorder() {
        double tempCount = Double.MIN_VALUE;
        for (EnemyShip enemyShip : ships) if (enemyShip.y + enemyShip.height > tempCount) tempCount = enemyShip.y + enemyShip.height;
        return tempCount;
    }

    public int getShipsCount() {
        return ships.size();
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int i = 0; i < COLUMNS_COUNT; i++) {
            for (int j = 0; j < ROWS_COUNT; j++) {
                ships.add(new EnemyShip(i * STEP, j * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    private double getLeftBorder() {
        double temp = Integer.MAX_VALUE;
        for (EnemyShip esh : ships) if (temp > esh.x) temp = esh.x;
        return temp;
    }

    private double getRightBorder() {
        double temp = Integer.MIN_VALUE;
        for (EnemyShip esh : ships) if (temp < esh.x + esh.width) temp = esh.x + esh.width;
        return temp;
    }

    private double getSpeed() {
        return Math.min(2.0, 3.0 / ships.size());
    }

    public void draw(Game game) {
        for (EnemyShip esh : ships) esh.draw(game);
    }

    public void move() {
        if (ships.size() == 0) return;
        Direction dirToChange = direction;
        switch (direction) {
            case LEFT:
                if (getLeftBorder() < 0) direction = Direction.RIGHT;
                break;
            case RIGHT:
                if (getRightBorder() > SpaceInvadersGame.WIDTH) direction = Direction.LEFT;
        }
        for (EnemyShip esh : ships) {
            esh.move(direction != dirToChange ? Direction.DOWN : direction, getSpeed());
        }
    }

    public int verifyHit(List<Bullet> bullets) {
        int totalScore = 0;
        if (bullets.size() == 0) return 0;
        for (Bullet bullet : bullets) {
            for (EnemyShip enemyShip : ships) {
                if (enemyShip.isCollision(bullet) && enemyShip.isAlive && bullet.isAlive) {
                    totalScore += enemyShip.score;
                    enemyShip.kill();
                    bullet.kill();
                }
            }
        }
        return totalScore;
    }

    public void deleteHiddenShips() {
        //for (EnemyShip enemyShip : ships) if (!enemyShip.isVisible()) ships.remove(enemyShip);
        ships.removeIf(s -> !s.isVisible());
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0) return null;
        if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0) return null;
        return ships.get(game.getRandomNumber(ships.size())).fire();
    }
}
