package com.example.aboutjava.designpattern.strategypattern;

import java.util.Random;

class RandomMovingStrategy implements MovingStrategy {

    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_RESTRICT = 4;
    private static final Random RANDOM = new Random();

    @Override
    public boolean movable() {
        return getGenerateRandomNumber() >= MOVE_RESTRICT;
    }

    private int getGenerateRandomNumber() {
        return RANDOM.nextInt(RANDOM_RANGE);
    }
}
