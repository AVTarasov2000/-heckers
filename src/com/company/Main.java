package com.company;

import com.company.field.Field;

public class Main{



    public static void main(String[] args) {
	// write your code her

//        Сheckers sh = new Сheckers();
        Field field = new Field();
        field.getChecker(1,2).goRight();
        System.out.println();
        field.print();
    }
}
