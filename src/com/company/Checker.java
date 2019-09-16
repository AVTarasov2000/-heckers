package com.company;

import javax.sound.sampled.Clip;

public class Checker {


    Cell cell;
    private int x;
    private int y;
    private boolean isQueen=false;
    private boolean isWhite;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isQueen() {
        return isQueen;
    }

    public Checker(int x, int y, boolean isWhite){
        this.x=x;
        this.y=y;
        this.isWhite = isWhite;
    }

    public void goTo(int x, int y){

        this.x=x;
        this.y=y;
        if(isWhite){
            if(y==7){
                isQueen=true;
            }
        } else {
            if (y==0){
                isQueen=true;
            }
        }
    }

    public boolean isOnCell(int x,int y){
        return (this.x==x && this.y==y);
    }

    public int getXDirection(){
        if(isWhite){
            return 1;
        }else {
            return -1;
        }
    }


    @Override
    public String toString() {
        return "Checker{" +
                "x=" + x +
                ", y=" + y +
                ", isQueen=" + isQueen +
                '}';
    }
}