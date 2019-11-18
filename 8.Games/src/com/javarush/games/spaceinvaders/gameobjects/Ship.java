package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject {
    public boolean isAlive = true;
    private boolean loopAnimation = false;
    private int frameIndex;
    private List<int[][]> frames;

    public Ship(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }

    public void setStaticView(int[][] viewFrame) {
        setMatrix(viewFrame);
        frames = new ArrayList<>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public void kill() {
        isAlive = false;
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        super.setMatrix(viewFrames[0]);
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
        loopAnimation = isLoopAnimation;
    }

    public void nextFrame() {
        frameIndex++;
        if (frameIndex >= frames.size()) {
            if (!loopAnimation) return;
            else frameIndex = 0;
        }
        matrix = frames.get(frameIndex);
    }

    public Bullet fire() {
        return null;
    }

    public boolean isVisible() {
        return !(!isAlive && frameIndex >= frames.size());
    }
}
