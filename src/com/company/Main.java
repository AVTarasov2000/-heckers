package com.company;

import com.company.game.Сheckers;
import com.company.field.Field;

import java.util.Scanner;

public class Main{



    public static void main(String[] args) {

//        Сheckers sh = new Сheckers("mario","boris");
//        Field field = sh.getField();
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (sh.checkEnd()==null){
//            field.print();
//            sh.doStep(scanner.nextLine(),scanner.nextLine());
//            System.out.println();
//        }
//        System.out.println(sh.checkEnd());

        Сheckers sh = new Сheckers("mario","boris", true);
        Field field = sh.getField();


        int i = 0;
        System.out.println(sh.checkEnd());
        System.out.println();
        field.print();
        System.out.println();


        System.out.println(i++);//0
        System.out.println(sh.checkEnd());
        sh.doStep("4 1","5 2");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//1
        System.out.println(sh.checkEnd());
        sh.doStep("2 1","3 0");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//2
        System.out.println(sh.checkEnd());
        sh.doStep("5 2","4 3");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//3
        System.out.println(sh.checkEnd());
        sh.doStep("3 0","6 3");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//4
        System.out.println(sh.checkEnd());
        sh.doStep("4 3","3 4");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//5
        System.out.println(sh.checkEnd());
        sh.doStep("6 3","3 0");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//6
        System.out.println(sh.checkEnd());
        sh.doStep("3 4","2 5");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//7
        System.out.println(sh.checkEnd());
        sh.doStep("3 0","0 3");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//8
        System.out.println(sh.checkEnd());
        sh.doStep("2 5","3 6");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//9
        System.out.println(sh.checkEnd());
        sh.doStep("0 3","1 2");
        System.out.println();
        field.print();
        System.out.println();

        System.out.println(i++);//10
        System.out.println(sh.checkEnd());
        sh.doStep("0 3","4 7");
        System.out.println();
        field.print();
        System.out.println();

//        System.out.println(i);//11
//        System.out.println(sh.checkEnd());
//        sh.doStep("0 3","3 6");
//        System.out.println();
//        field.print();
//        System.out.println();



        System.out.println(sh.checkEnd());



    }
}