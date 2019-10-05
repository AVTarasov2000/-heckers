
package com.company.game;


import com.company.checkers.Checker;
import com.company.field.Cell;
import com.company.field.Field;



public class Сheckers {
    private int turn = 1;
    private Field field = new Field();

    private Player blackPlayer;
    private Player whitePlayer;


    public Field getField() {
        return field;
    }

    public Сheckers(String firstPlayer, String secondPlayer){
        whitePlayer = new Player(firstPlayer,Player.setPlayer(true, field),1);
        blackPlayer = new Player(secondPlayer,Player.setPlayer(false, field),2);
    }

    public Сheckers(String firstPlayer, String secondPlayer, boolean forOneChecker){//для проверки работы
        whitePlayer = new Player(firstPlayer,Player.setPlayerWithOneChecker(true, field),1);
        blackPlayer = new Player(secondPlayer,Player.setPlayerWithOneChecker(false, field),2);
    }
    private void switchTurn(){
        turn = 3-turn;
    }


    public void doStep(String checker, String to){
        Checker checker1 = field.getChecker(checker);
        Cell cellTo = field.getCell(to);
        Player player = getPlayer(turn);

        if (cellTo.isFree() && !player.canOnlyBit().contains(checker1)){
            if(!getPlayer(turn).contains(checker1) || player.cantMove().contains(checker1)){
                return;
            }
            if (checker1.canGoTo(cellTo)){
                checker1.goTo(cellTo);
                switchTurn();
            }
        }else if(!cellTo.isFree()){
            Checker checker2 = cellTo.getChecker();
            if (checker1 != null && checker2 != null && checker1.canBit(checker2)) {
                checker1.bit(checker2);
                switchTurn();
            }
        }
    }


    public String checkEnd(){
        if(getPlayer(turn).isLose()){
            return getPlayer(3-turn).getName();
        }
        return null;
    }

    private Player getPlayer(int turn){
        return turn==whitePlayer.getTurn()?whitePlayer:blackPlayer;
    }
}