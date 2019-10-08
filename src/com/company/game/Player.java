package com.company.game;


import com.company.checkers.Checker;
import com.company.field.Cell;
import com.company.field.Field;

import java.util.ArrayList;
import java.util.Arrays;

public class Player{

    private String name;
    private ArrayList<Checker> checkers;
    private Player next;

    private ArrayList<Integer> directionsToGo = new ArrayList <>();

    Player(String name, ArrayList <Checker> checkers, Integer... directions){
        checkers.forEach(checker -> checker.setPlayer(this));
        this.name=name;
        this.checkers=checkers;
        directionsToGo.addAll(Arrays.asList(directions));
    }



    public ArrayList <Integer> getDirectionsToGo() {
        return directionsToGo;
    }

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }

    String getName(){
        return name;
    }

    public void addChecker(Checker checker){
        checkers.add(checker);
    }

    public boolean contains(Checker checker){
        return checkers.contains(checker);
    }

    public void remove(Checker checker){
        checkers.remove(checker);
    }

    public boolean canGo(int i){
        return directionsToGo.contains(i);
    }



    ArrayList<Checker> cantMove(){
        int count = 0;
        ArrayList<Checker> result = new ArrayList <>();

        for (Checker c :
                checkers) {
            if (!c.canBitAnything()){
                result.add(c);
                count++;
            }
        }
        if (count==checkers.size()){
            result = new ArrayList <>();
        }
        return result;
    }

    ArrayList<Checker> canOnlyBit(){
        ArrayList<Checker> result = new ArrayList <>();

        for (Checker c :
                checkers) {
            if (c.canBitAnything()){
                result.add(c);
            }
        }
        return result;
    }



    static ArrayList<Checker> setPlayer(boolean isPlayerWhite, Field field){
        int size = field.getSize();
        ArrayList <Checker> arr = new ArrayList <>();

        Cell cell;
        int from,to;
        if (isPlayerWhite){
            from=0;
            to=3;
        }else {
            from=size-3;
            to=size;
        }
        for (int i = 0; i < size; i++) {
            for (int j = from; j < to; j++) {
                if ((i + j) % 2 != 0) {
                    cell = field.getField().get(Field.stringKey(i, j));
                    Checker checker = new Checker(cell, isPlayerWhite);
                    cell.setChecker(checker);
                    arr.add(checker);
                }
            }
        }
        return arr;
    }

    static ArrayList<Checker> setPlayerWithOneChecker(boolean isPlayerWhite, Field field){
        ArrayList <Checker> arr = new ArrayList <>();

        Checker checker;
        if (isPlayerWhite) {
            checker = new Checker(field.getField().get(Field.stringKey(4, 1)), true);
        }
        else {
            checker = new Checker(field.getField().get(Field.stringKey(2, 1)), false);
        }
        arr.add(checker);
        return arr;
    }

    boolean isLose(){
        if (checkers.size()==0){
            return true;
        }

        for (Checker checker:
             checkers) {
            if (checker.canGoAnywhere() || checker.canBitAnything()){
                return false;
            }
        }
        return true;
    }

    public boolean isTransformCellForThisPlayer(Cell cell){
        for (int dir :
                directionsToGo) {
            if (cell.getCellFromDirection(dir) != null) {
                return false;
            }
        }
        return true;
    }





}