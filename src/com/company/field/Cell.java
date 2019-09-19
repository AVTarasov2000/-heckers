package com.company.field;

import com.company.checkers.Checker;

public class Cell{

    private Cell downLeft;
    private Cell downRight;
    private Cell upLeft;
    private Cell upRight;

    private Checker checker = null;

    public void setAll(Cell downLeft, Cell downRight, Cell upLeft, Cell upRight) {
        this.downLeft = downLeft;
        this.downRight = downRight;
        this.upLeft = upLeft;
        this.upRight = upRight;
    }

    public Checker getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public Cell getDownLeft() {
        return downLeft;
    }

    public void setDownLeft(Cell downLeft) {
        this.downLeft = downLeft;
    }

    public Cell getDownRight() {
        return downRight;
    }

    public void setDownRight(Cell downRight) {
        this.downRight = downRight;
    }

    public Cell getUpLeft() {
        return upLeft;
    }

    public void setUpLeft(Cell upLeft) {
        this.upLeft = upLeft;
    }

    public Cell getUpRight() {
        return upRight;
    }

    public void setUpRight(Cell upRight) {
        this.upRight = upRight;
    }

    public boolean isFree(){return checker == null;}



}
