
package com.company.game;


import com.company.checkers.Checker;
import com.company.field.Cell;
import com.company.field.Field;

import java.util.ArrayList;


public class Сheckers {
    private Field field = new Field();

    private Player blackPlayer;
    private Player whitePlayer;
    private Turn turn;

    public Field getField() {
        return field;
    }

    public Сheckers(String firstPlayer, String secondPlayer){
        whitePlayer = new Player(firstPlayer,Player.setPlayer(true, field),Cell.UP_LEFT, Cell.UP_RIGHT);
        blackPlayer = new Player(secondPlayer,Player.setPlayer(false, field), Cell.DOWN_LEFT, Cell.DOWN_RIGHT);
        turn = new Turn(whitePlayer,blackPlayer);
    }

    public Сheckers(String firstPlayer, String secondPlayer, boolean forOneChecker){//для проверки работы
        whitePlayer = new Player(firstPlayer,Player.setPlayerWithOneChecker(true, field),Cell.UP_LEFT, Cell.UP_RIGHT);
        blackPlayer = new Player(secondPlayer,Player.setPlayerWithOneChecker(false, field), Cell.DOWN_LEFT, Cell.DOWN_RIGHT);
        turn = new Turn(whitePlayer,blackPlayer);
    }



    public void doStep(String checker, String to){
        Checker checker1 = field.getChecker(checker);
        Cell cellTo = field.getCell(to);

        if (checker1==null && cellTo==null){
            return;
        }

        if (checker1.canGoTo(cellTo) && cellTo.isFree() && !turn.getPlayer().canOnlyBit().contains(checker1)){
            if(!turn.getPlayer().contains(checker1) || turn.getPlayer().cantMove().contains(checker1)){
                return;
            }
            checker1.goTo(cellTo);
            turn.switchTurn();
        }else if(checker1.canBit(cellTo)){
                checker1.bit(cellTo);
                if(!checker1.canBitAnything()) {
                    turn.switchTurn();
                }
        }
    }


    public String checkEnd(){
        if(turn.getPlayer().isLose()){
            turn.switchTurn();
            return turn.getPlayer().getName();
        }
        return null;
    }
}