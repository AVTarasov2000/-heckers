package com.company.checkers;
import com.company.field.Cell;

import java.util.ArrayList;

public class Queen extends Checker {

    Queen(boolean isWhite, Cell cell) {
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
        int dir = getCell().getDirection(cell);
        ArrayList <Cell> list = getCell().getAllByDirection(dir);

        for (Cell aList : list) {
            if (!aList.isFree()) {
                return false;
            }
            if (aList == cell) {
                return true;
            }
        }
        return false;
    }



    private Cell getNearestCellWithCheckerByDirection(int direction){
        ArrayList <Cell> list = getCell().getAllByDirection(direction);

        for (Cell aList : list) {
            if (!aList.isFree()) {
                return aList;
            }
        }
        return null;
    }

    @Override
    public boolean canGoAnywhere(){
        for (Cell cell :
                getCell().getCells()) {
            if (cell!= null && cell.isFree()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canBitAnything(){
        for (int i = 0; i < getCell().getCells().size(); i++) {
            Cell cell = getNearestCellWithCheckerByDirection(i);
            if(cell!=null && cell.getCellFromDirection(i).isFree() && !player.contains(cell.getChecker())){
                return true;
            }
        }
        return false;
    }

    @Override
    protected int directionToBit(Cell cell){
        int dir = this.getCell().getDirection(cell);

        Cell cellTo = getNearestCellWithCheckerByDirection(dir);
        if (cellTo!=null && cell == cellTo.getCellFromDirection(dir)){
            return dir;
        }
        return -1;
    }

    @Override
    public boolean canBit(Cell cell){
        return directionToBit(cell)>=0;
    }


    @Override
    public void bit(Cell cell){
        int direction = directionToBit(cell);

        if (direction==-1){
            return;
        }

        Checker prev = cell.getCellFromDirection(Cell.reversDigection(direction)).getChecker();
        cell.setChecker(this);

        prev.remove();

        getCell().setChecker(null);
        setCell(cell);
    }

}
