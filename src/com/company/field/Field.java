package com.company.field;

import com.company.checkers.Checker;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Field {



    private Map<String,Cell> field = new HashMap <>();
    private int size = 8;


    public Field(){

        setField();
        print();

    }


    private void setField(){


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                if((i+j)%2!=0) {
                    field.put(i + "" + j, new Cell());
                }
            }
        }

        Cell cell;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if((i+j)%2!=0) {
                    cell = field.get(i + "" + j);
                    cell.setAll(field.getOrDefault((i - 1) + "" + (j - 1), null),//downLeft
                                field.getOrDefault((i + 1) + "" + (j - 1), null),//downRight
                                field.getOrDefault((i - 1) + "" + (j + 1), null),//upLeft
                                field.getOrDefault((i + 1) + "" + (j + 1), null));//upRight
                    if(j < 3){
                        cell.setChecker(new Checker(cell,true));
                        System.out.println(i + "" + j);
                    }
                    if (j>=size-3){
                        cell.setChecker(new Checker(cell,false));
                        System.out.println(i + "" + j);
                    }

                }
            }
        }
    }







    public Checker getChecker(int x,int y) {
        return field.get(x+""+y).getChecker();

    }
    public void print(){
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if((i+j)%2!=0) {
                    if (j % 2 == 0) {
                        System.out.print(0 + " " + (field.get(i + "" + j).getChecker()!=null?1:0) + " ");

                    } else {
                        System.out.print((field.get(i + "" + j).getChecker()!=null?1:0) + " " + 0 + " ");
                    }
                }
            }
            System.out.println();
        }
    }


    private int count(Cell cell){
        int i = 0;
        if (cell.getUpLeft()!=null){
            i++;
        }
        if (cell.getUpRight()!=null){
            i++;
        }
        if (cell.getDownLeft()!=null){
            i++;
        }
        if (cell.getDownRight()!=null){
            i++;
        }
        return i;
    }



}
