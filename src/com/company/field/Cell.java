package com.company.field;

import com.company.checkers.Checker;

import java.util.ArrayList;

public class Cell{

    public static final int UP_RIGHT = 0;
    public static final int UP_LEFT = 1;
    public static final int DOWN_RIGHT = 2;
    public static final int DOWN_LEFT = 3;

    private ArrayList<Cell> cells = new ArrayList <>();
    {
        for (int i = 0; i < 4; i++) {
            cells.add(null);
        }
    }


    private Checker checker = null;

    void setAll(Cell downLeft, Cell downRight, Cell upLeft, Cell upRight) {
        cells.set(UP_RIGHT,upRight);
        cells.set(UP_LEFT, upLeft);
        cells.set(DOWN_LEFT, downLeft);
        cells.set(DOWN_RIGHT, downRight);
    }

    public ArrayList <Cell> getCells() {
        return cells;
    }
    public Checker getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public Cell getCellFromDirection(int direction){
        return cells.get(direction);
    }

    public boolean isFree(){return checker == null;}



    public int getDirection(Cell cell){
        if (cell==null){
            return -1;
        }
        for (int i = 0; i < cells.size(); i++) {
            if(getAllByDirection(i).contains(cell)){
                return i;
            }
        }
        return -1;
    }

    public static int reversDigection(int direction){
        return Math.abs(3-direction);
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