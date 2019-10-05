package com.company.checkers;
import com.company.field.Cell;

import java.util.ArrayList;

public class Queen extends Checker {

    Queen(boolean isWhite,Cell cell) {
        super(new Cell(), isWhite);
        setCell(cell);
    }

    @Override
    public void goTo(Cell cell){
        super.getCell().setChecker(null);
        super.setCell(cell);
        cell.setChecker(this);
    }

    @Override
    public boolean canGoTo(Cell cell){
        for (int i = 0; i < 4; i++) {
            ArrayList <Cell> list = super.getCell().getAllByDirection(i);
            if(list.contains(cell)) {
                for (Cell aList : list) {
                    if (!aList.isFree()) {
                        return false;
                    }
                    if (aList == cell) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Checker getNearestCheckerByDirection(int direction){
        ArrayList <Cell> list = super.getCell().getAllByDirection(direction);

        for (Cell aList : list) {
            if (!aList.isFree()) {
                return aList.getChecker();
            }
        }
        return null;
    }

    @Override
    public boolean canBitAnything(){
        for (int i = 0; i < 4; i++) {
            Checker checker = getNearestCheckerByDirection(i);
            if(checker!=null && checker.getCell().getCellFromDirection(i).isFree()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int directionToBit(Checker checker){
        for (int i = 0; i < 4; i++) {
            if (checker==getNearestCheckerByDirection(i)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean canBit(Checker checker){
        return directionToBit(checker)>=0;
    }

    @Override
    public void bit(Checker checker){
        int direction = directionToBit(checker);

        if (direction==-1){
            return;
        }

        Cell cell = checker.getCell().getCellFromDirection(direction);
        cell.setChecker(this);

        checker.remove();

        getCell().setChecker(null);
        setCell(cell);
    }
}
