package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.GameObject;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private static final int PLAYER_CAR_DISTANCE = 12;
    private int passedCarsCount = 0;
    private List<RoadObject> items = new ArrayList<>();

    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        if (type == RoadObjectType.THORN) return new Thorn(x, y);
        if (type == RoadObjectType.DRUNK_CAR) return new MovingCar(x, y);
        else return new Car(type, x, y);
    }

    public int getPassedCarsCount() {
        return passedCarsCount;
    }

    private void addRoadObject(RoadObjectType type, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject roadObject = createRoadObject(type, x, y);
        //if (roadObject != null) items.add(roadObject);
        if (isRoadSpaceFree(roadObject)) items.add(roadObject);
    }

    private void deletePassedItems() {
        for (int i = items.size() - 1; i > 0; i--)
            if (items.get(i).y >= RacerGame.HEIGHT) {
                if (!(items.get(i) instanceof Thorn)) passedCarsCount++;
                items.remove(i);
            }
    }

    private void generateThorn(Game game) {
        if (game.getRandomNumber(100) < 10 && !isThornExists()) addRoadObject(RoadObjectType.THORN, game);
    }

    private void generateRegularCar(Game game) {
        int carTypeNumber = game.getRandomNumber(4);
        if (game.getRandomNumber(100) < 30) addRoadObject(RoadObjectType.values()[carTypeNumber], game);
    }

    private void generateMovingCar(Game game) {
        if (game.getRandomNumber(100) < 10 && !isMovingCarExists()) addRoadObject(RoadObjectType.DRUNK_CAR, game);
    }

    private boolean isThornExists() {
        for (RoadObject ro : items) if (ro instanceof Thorn) return true;
        return false;
    }

    private boolean isMovingCarExists() {
        for (RoadObject ro : items) if (ro instanceof MovingCar) return true;
        return false;
    }

    public boolean checkCrush(PlayerCar playerCar) {
        for (GameObject go : items) if (go.isCollision(playerCar)) return true;
        return false;
    }

    private boolean isRoadSpaceFree(RoadObject object) {
        for (RoadObject ro : items) if (ro.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)) return false;
        return true;
    }

    public void draw(Game game) {
        for (RoadObject ro : items) ro.draw(game);
    }

    public void move(int boost) {
        for (RoadObject ro : items) ro.move(boost + ro.speed, items);
        deletePassedItems();
    }

    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
        generateMovingCar(game);
    }
}
