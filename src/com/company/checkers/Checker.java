package com.company.checkers;


import com.company.field.Cell;
import com.company.game.Player;

import java.util.ArrayList;

public class Checker {


    private Cell cell;
    private boolean isWhite;
    Player player;

    // TODO: 05/10/2019 rewrite method bit and canBit

    public Checker(Cell cell, boolean isWhite){
        this.isWhite=isWhite;
        this.cell=cell;
        cell.setChecker(this);
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public void goTo(Cell cell){
        this.cell.setChecker(null);
        this.cell = cell;
        cell.setChecker(this);
    }

    public boolean canGoTo(Cell cell){
        int dir = this.cell.getDirection(cell);
        return this.cell.getCellFromDirection(dir)==cell && player.canGo(dir);
    }

    public boolean canGoAnywhere(){
            for (int i :
                    player.getDirectionsToGo()) {
                if (cell.getCellFromDirection(i) != null
                        && cell.getCellFromDirection(i).isFree()) {
                    return true;
                }
            }
        return false;
    }

    public boolean canBitAnything(){
        for (int i = 0; i < cell.getCells().size(); i++) {
            ArrayList<Cell> list = cell.getAllByDirection(i);

            if (list.size()>2 && list.get(0)!=null && list.get(1)!=null){
                if(!list.get(0).isFree() && list.get(1).isFree() && !player.contains(list.get(0).getChecker())){//проверка на то, принадлежат ли они одному игроку
                    return true;
                }
            }
        }
        return false;
    }




    protected int directionToBit(Cell cell){
        return this.cell.getDirection(cell);
    }

    public boolean canBit(Cell cell){
        return directionToBit(cell) >= 0;
    }


    public void bit(Cell cell){

        int dir = this.cell.getDirection(cell);

        Checker prev = cell.getCellFromDirection(Cell.reversDirection(dir)).getChecker();

        if(cell.isFree() && prev!=null && !player.contains(prev)){
            cell.setChecker(this);
            this.cell.setChecker(null);
            this.cell=cell;
            prev.remove();
        }

    }

    public Player getPlayer() {
        return player;
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
