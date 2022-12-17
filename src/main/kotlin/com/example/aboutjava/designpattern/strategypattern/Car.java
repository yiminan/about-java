package com.example.aboutjava.designpattern.strategypattern;

class Car {

    private static final int FIRST_POSITION = 0;
    private static final int POSITION_UNIT = 1;

    private int position;

    public Car() {
        this(FIRST_POSITION);
    }

    private Car(int position) {
        this.position = position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            System.out.println("Car is moving");
            movePosition();
        } else {
            System.out.println("Car is not moving");
        }
    }

    private void movePosition() {
        position = position + POSITION_UNIT;
    }

    public int getPosition() {
        return position;
    }
}
