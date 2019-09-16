package com.company.field;

import com.company.Checker;

public class Cell{

    public static final int UP_RIGHT = 0;
    public static final int DOWN_RIGHT = 1;
    public static final int DOWN_LEFT = 2;
    public static final int UP_LEFT = 3;

    private Cell downLeft;
    private Cell downRight;
    private Cell upLeft;
    private Cell upRight;

    private Checker checker;



    public Cell(Cell downLeft, Cell downRight, Cell upLeft, Cell upRight){
        this.downRight=downRight;
        this.downLeft=downLeft;
        this.upLeft=upLeft;
        this.upRight=upRight;
    }

    public Cell(){
    }

    public void setAll(Cell downLeft, Cell downRight, Cell upLeft, Cell upRight){
        this.downRight=downRight;
        this.downLeft=downLeft;
        this.upLeft=upLeft;
        this.upRight=upRight;
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




}
