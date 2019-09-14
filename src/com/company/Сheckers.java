package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Сheckers {

    private static final int BLACK_PLAYER = 1;
    private static final int WHITE_PLAYER = 2;
    private static final int NO_PLAYER = 0;

    private java.util.List<Checker> player_W = new ArrayList<>();
    private java.util.List<Checker> player_B = new ArrayList<>();
    private int[][] field = new int[8][8];
    private int turne = 2;


    /*2,1,3,0
     *5,2,4,1
     * 1,2,2,1
     *
     *
     */

    public Сheckers(){
        addPlayer(0,3, player_W,WHITE_PLAYER);
        addPlayer(5,8, player_B,BLACK_PLAYER);

        Scanner scanner = new Scanner(System.in);

        while (player_W.size()!=0 && player_B.size()!=0){ //реализация в консоли
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(field[i][j]+" ");
                }
                System.out.print("\n");
            }
            String str = scanner.nextLine();
            ArrayList<Integer> list = new ArrayList <>();
            for (String s:
                    str.split("[-(,)+_>]+")) {
                list.add(Integer.parseInt(s));
            }
            doStep(list.get(0),list.get(1),list.get(2),list.get(3));

        }


    }

    public void doStep(int xFrom, int yFrom, int xTo,int yTo){
        if(turne==field[xFrom][yFrom]) {
            java.util.List<Checker> player = getPlayer(turne);
            Checker checker = getClip(player,xFrom,yFrom);
            if (canMove(checker, xTo, yTo)) {
                move(checker, xTo, yTo);
                for (Checker c:
                     getAllWhoCanEat(turne)) { //если была возможность съесть фишку противника какой либо своей, то эти фишки выйдут из игры
                    System.out.println(c.toString());
                    field[c.getX()][c.getY()]=NO_PLAYER;
                    player.remove(c);
                }
                turne=3-turne;
            } else if (canEat(checker, xTo, yTo)) {
                eat(checker, xTo, yTo);
                turne=3-turne;
            }
        }
    }



    private void move(Checker checker, int xTo, int yTo){
        int color = field[checker.getX()][checker.getY()];
        if (field[xTo][yTo]==0 && (xTo+yTo)%2==1){
            field[checker.getX()][checker.getY()]=NO_PLAYER;
            checker.goTo(xTo,yTo);
            field[xTo][yTo]=color;
        }
    }



    private boolean canMove(Checker checker, int xTo, int yTo){
        if (xTo>7||xTo<0||yTo>7||yTo<0){
            return false;
        }
        int xDir = getDirection(checker.getX(),xTo);
        int yDir = getDirection(checker.getY(),yTo);


        if ((xTo- checker.getX())*xDir!=(yTo- checker.getY())*yDir || field[checker.getX()][checker.getY()]==NO_PLAYER){//проверка на занятость клетки и корректность хода
            return false;
        }
        if(!checker.isQueen() && (xTo- checker.getX())*xDir>1){//проверка на длинну хода, если не королева
            return false;
        }
        if (!checker.isQueen() && checker.getXDirection()!=xDir){//проверка на направление хода, если не королева
            return false;
        }

        for (int i = 0; i < xTo - checker.getX(); i++) {
            if (field[checker.getX()+(i+1)*xDir][checker.getY()+(i+1)*yDir]!=NO_PLAYER)return false;
        }
        return true;
    }


    private boolean canEat(Checker checker, int xTo, int yTo){
        if (xTo>7||xTo<0||yTo>7||yTo<0){
            return false;
        }
        int xDir = getDirection(checker.getX(),xTo);
        int yDir = getDirection(checker.getY(),yTo);

        if (checker.isQueen()) {
            return (canMove(checker, xTo - xDir * 2, yTo - yDir * 2)                           //проверяем, может ли королева пройти расстояние до убиваемой фишкиб есть ли она и есть ли свободная клетка после
                    && field[xTo - xDir][yTo - yDir] == 3-turne && field[xTo][yTo] == NO_PLAYER);
        }else {
            return ((xTo- checker.getX())*xDir==2&& (yTo- checker.getY())*yDir==2 &&
                    field[xTo - xDir][yTo - yDir] == 3-turne && field[xTo][yTo] == NO_PLAYER);
        }
    }

    private boolean canEat(Checker checker){
        if (checker.isQueen()){
            for (int i = 1; i < 8; i++) {
                if(canEat(checker, checker.getX()+i, checker.getY()+i)||canEat(checker, checker.getX()+i, checker.getY()-i)||
                        canEat(checker, checker.getX()-i, checker.getY()+i)||canEat(checker, checker.getX()-i, checker.getY()-i)){ //проверка на возможность съедения в 4 стороны
                    return true;
                }
            }
            return false;
        }
        else {
            return canEat(checker, checker.getX()+2, checker.getY()+2)||
                    canEat(checker, checker.getX()-2, checker.getY()+2)||
                    canEat(checker, checker.getX()+2, checker.getY()-2)||
                    canEat(checker, checker.getX()-2, checker.getY()-2);
        }
    }



    private void eat(Checker checker, int xTo, int yTo){
        int xFrom = checker.getX();
        int yFrom = checker.getY();
        int xWho = (xFrom+xTo)/2;
        int yWho = (yFrom+yTo)/2;

        int color_1 = field[xFrom][yFrom];
        int color_2 = field[xWho][yWho];
        if (color_1==color_2) return;
        java.util.List<Checker> player2 = getPlayer(color_2);

        if (field[xTo][yTo]==0 ){
            move(checker,xTo,yTo);
            player2.remove(getClip(player2,xWho,yWho));
            field[xWho][yWho]=0;

        }
    }



    private int getDirection(int from,int to){
        if(from>to){
            return -1;
        } else if (from<to){
            return 1;
        }else return 0;
    }



    private void addPlayer(int from, int to, java.util.List<Checker> player, int color){
        for (int i = from; i < to; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if((i+j)%2!=0){
                    field[i][j]=color;
                    player.add(new Checker(i,j,color==WHITE_PLAYER));
                }

            }
        }
    }


    private List<Checker> getAllWhoCanEat(int color){
        return getPlayer(color).stream().filter(checker -> canEat(checker)).collect(Collectors.toList());
    }


    private Checker getClip(java.util.List<Checker> player, int x, int y){
        for (Checker checker :
                player) {
            if (checker.isOnCell(x, y)){
                return checker;
            }
        }
        return null;
    }



    private java.util.List<Checker> getPlayer(int color){
        if (color == BLACK_PLAYER){
            return player_B;
        } else if (color == WHITE_PLAYER){
            return player_W;
        }
        else {
            throw new NullPointerException();
        }
    }
}



