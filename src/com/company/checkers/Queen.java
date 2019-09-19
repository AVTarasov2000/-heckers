package com.company.checkers;

import com.company.checkers.Checker;
import com.company.field.Cell;

public class Queen extends Checker {

    public Queen(Cell cell, boolean isWhite) {
        super(cell, isWhite);
    }

    public void goUpRight(int count){
        for (int i = 0; i < count; i++) {
            super.goUpRight();
        }
    }
    public void goUpLeft(int count){
        for (int i = 0; i < count; i++) {
            super.goUpLeft();
        }
    }
    public void goDownLeft(int count){
        for (int i = 0; i < count; i++) {
            super.goDownLeft();
        }
    }
    public void goDownRight(int count){
        for (int i = 0; i < count; i++) {
            super.goDownRight();
        }
    }




}
