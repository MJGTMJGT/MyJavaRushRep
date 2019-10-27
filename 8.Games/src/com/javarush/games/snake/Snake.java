package com.javarush.games.snake;

import com.javarush.engine.cell.*;
//import com.sun.javafx.scene.traversal.Direction; //из-за этого на 7 уровне 7 попыток))

import java.util.ArrayList;
import java.util.List;

import static com.javarush.games.snake.SnakeGame.WIDTH;
import static com.javarush.games.snake.SnakeGame.HEIGHT;

public class Snake {
    int x, y;
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Direction getDirection() {
        return direction;
    }

    public int getLength() {
        return snakeParts.size();
    }

    public void setDirection(Direction d) {
        boolean xEqual = snakeParts.get(0).x == snakeParts.get(1).x;
        boolean yEqual = snakeParts.get(0).y == snakeParts.get(1).y;
        switch (d) {
            case UP:
                if (direction != Direction.DOWN && yEqual) this.direction = d;
                break;
            case DOWN:
                if (direction != Direction.UP && yEqual) this.direction = d;
                break;
            case LEFT:
                if (direction != Direction.RIGHT && xEqual) this.direction = d;
                break;
            case RIGHT:
                if (direction != Direction.LEFT && xEqual) this.direction = d;
                break;
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        isAlive = newHead.x >= 0 && newHead.x < WIDTH && newHead.y >= 0 && newHead.y < HEIGHT;
        if (checkCollision(newHead)) isAlive = false;
        apple.isAlive = newHead.x != apple.x || newHead.y != apple.y;
        if (isAlive) {
            snakeParts.add(0, newHead);
            if (apple.isAlive) removeTail();
        }
    }

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
        for (int i = 1; i < snakeParts.size(); i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
        }
    }

    public GameObject createNewHead() {
        int headX = snakeParts.get(0).x;
        int headY = snakeParts.get(0).y;
        switch (direction) {
            case UP:
                headY--;
                break;
            case DOWN:
                headY++;
                break;
            case LEFT:
                headX--;
                break;
            case RIGHT:
                headX++;
                break;
        }
        return new GameObject(headX, headY);
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject head) {
        for (GameObject go : snakeParts) {
            if (go.x == head.x && go.y == head.y) return true;
        }
        return false;
    }
}
