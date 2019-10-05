package com.company.checkers;


import com.company.field.Cell;
import com.company.game.Player;

public class Checker {


    private Cell cell;
    private boolean isWhite;
    private Player player;


    public Checker(Cell cell, boolean isWhite){
        this.isWhite=isWhite;
        this.cell=cell;
        cell.setChecker(this);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public void goTo(Cell cell){
        this.cell.setChecker(null);
        this.cell = cell;
        cell.setChecker(this);
    }

    public boolean isWhite() {
        return isWhite;
    }


    Cell getCell() {
        return cell;
    }

    void setCell(Cell cell) {
        this.cell = cell;
    }

    public boolean canGoTo(Cell cell){
        int dir = this.cell.getDirection(cell);
        if(dir >= 0 && cell.isFree()){
            return isWhite == (dir <= 1);
        }
        return false;
    }


    public boolean canGoAnywhere(){
        for (int i = 0; i < 4; i++) {
            if (cell.getCellFromDirection(i)!=null
                    && cell.getCellFromDirection(i).isFree()){
                return true;
            }
        }
        return false;
    }



    public boolean canBitAnything(){
        for (int i = 0; i < 4; i++) {
            if(cell.getCellFromDirection(i)!=null
                    && cell.getCellFromDirection(i).getCellFromDirection(i)!=null) {
                if (cell.getCellFromDirection(i).getCellFromDirection(i).isFree()
                        && !cell.getCellFromDirection(i).isFree()
                        && player.getTurn()!=cell.getCellFromDirection(i).getChecker().player.getTurn()) {
                    return true;
                }
            }
        }
        return false;
    }




    protected int directionToBit(Checker checker){
        return cell.getDirection(checker.getCell());
    }

    public boolean canBit(Checker checker){
        return directionToBit(checker) >= 0;
    }

    public void bit(Checker checker){

        int dir = cell.getDirection(checker.getCell());

        if (checker.getCell().getCellFromDirection(dir).isFree() && cell.getCellFromDirection(dir).getChecker()==checker){
            Cell cell = checker.getCell().getCellFromDirection(dir);
            cell.setChecker(this);
            this.cell.setChecker(null);
            this.cell=cell;
            checker.remove();
        }
    }



    void remove(){
        player.remove(this);
        cell.setChecker(null);
        cell=null;

    }




    public Queen transformToQueen(){
        Queen queen = new Queen(isWhite, cell);
        player.remove(this);
        player.addChecker(queen);
        queen.setPlayer(player);
        return queen;

    }
}
