package com.company.field;

import com.company.checkers.Checker;

import java.util.ArrayList;

public class Cell{

    public static final int UP_RIGHT = 0;
    public static final int UP_LEFT = 1;
    public static final int DOWN_RIGHT = 2;
    public static final int DOWN_LEFT = 3;

    private Cell[] cells = {null, null, null, null};

    private Checker checker = null;

    public void setAll(Cell downLeft, Cell downRight, Cell upLeft, Cell upRight) {
        cells[UP_RIGHT] = upRight;
        cells[UP_LEFT] = upLeft;
        cells[DOWN_RIGHT] = downRight;
        cells[DOWN_LEFT] = downLeft;

    }

    public Checker getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public Cell getCellFromDirection(int direction){
        return cells[direction];
    }

    public boolean isFree(){return checker == null;}



    public int getDirection(Cell cell){
        for (int i = 0; i < cells.length; i++) {
            if (cell!= null && cells[i]!=null && cell.equals(cells[i])){
                return i;
            }
        }
        return -1;
    }


    public ArrayList<Cell> getAllByDirection(int direction){
        Cell cell = getCellFromDirection(direction);
        ArrayList<Cell> cells = new ArrayList <>();
        while (cell!=null){
            cells.add(cell);
            cell = cell.getCellFromDirection(direction);
        }
        return cells;
    }






}