package com.company.checkers;


import com.company.field.Cell;


public class Checker {


    private Cell cell;
    private boolean isWhite;



    public Checker(Cell cell, boolean isWhite){
        this.isWhite=isWhite;
        this.cell=cell;
        cell.setChecker(this);
    }

    public void goRight(){
        if (isWhite){
            if(cell.getUpRight().isFree()) {
                goUpRight();
            }
        }else {
            if (cell.getDownRight().isFree()) {
                goDownRight();
            }
        }
    }

    public void goLeft(){
       if (isWhite){
           if (cell.getUpLeft().isFree()) {
               goUpLeft();
           }
       }else {
           if (cell.getDownLeft().isFree()) {
               goDownLeft();
           }
       }
    }

    protected void goUpRight(){
        cell.setChecker(null);
        cell = cell.getUpRight();
        cell.setChecker(this);
    }

    protected void goUpLeft(){
        cell.setChecker(null);
        cell = cell.getUpLeft();
        cell.setChecker(this);
    }

    protected void goDownRight(){
        cell.setChecker(null);
        cell = cell.getDownRight();
        cell.setChecker(this);
    }

    protected void goDownLeft(){
        cell.setChecker(null);
        cell = cell.getDownLeft();
        cell.setChecker(this);
    }

    public Cell getCell() {
        return cell;
    }

    public String getColor(){
        if(isWhite){
            return "W";
        }
        else{
            return "B";
        }
    }


    public void setCell(Cell cell) {
        this.cell = cell;
    }
}