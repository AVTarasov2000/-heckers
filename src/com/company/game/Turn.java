package com.company.game;

public class Turn {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void switchTurn(){
       player = player.getNext();
    }

    public Turn(Player... players) {
        player = players[0];
        for (int i = 0; i < players.length; i++) {
            players[i].setNext(players[(i+1)%players.length]);
        }

    }
}
