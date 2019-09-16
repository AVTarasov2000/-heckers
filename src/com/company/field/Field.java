package com.company.field;

import java.util.ArrayList;

public class Field {

    Cell[][] field = new Cell[4][8];

    public Field(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j]=new Cell();
            }
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if(i%2==0){
                    field[j][i].setDownLeft(i-1>=0&&j-1>=0?field[j-1][i-1]:null);
                    field[j][i].setDownRight(j-1>=0?field[j-1][i]:null);
                    field[j][i].setUpLeft(i-1>=0&&j+1<4?field[j+1][i-1]:null);
                    field[j][i].setUpRight(j+1<4?field[j+1][i]:null);


                }else {
                    field[j][i].setDownLeft(j-1>=0?field[j-1][i]:null);
                    field[j][i].setDownRight(j-1>=0&&i+1<8?field[j-1][i+1]:null);
                    field[j][i].setUpLeft(j+1<4?field[j+1][i]:null);
                    field[j][i].setUpRight(j+1<4&&i+1<8?field[j+1][i+1]:null);
                }

            }
        }


        for (int j = 7; j >=0; j--) {
            for (int i = 0; i < 4; i++) {
                System.out.print((field[i][j].getDownLeft()!=null)+" ");
            }
            System.out.println();
        }
    }









}
