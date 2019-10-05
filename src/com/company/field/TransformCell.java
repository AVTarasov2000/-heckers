package com.company.field;

import com.company.checkers.Checker;
import com.company.checkers.Queen;

public class TransformCell extends Cell{

    private boolean transformForWhitePlayer;

    TransformCell(boolean transformForWhitePlayer) {
        super();
        this.transformForWhitePlayer = transformForWhitePlayer;
    }

    @Override
    public void setChecker(Checker checker){
        if (checker instanceof Queen){
            super.setChecker(checker);
        }
        if (checker!=null&&checker.isWhite()&&transformForWhitePlayer){
            super.setChecker(checker.transformToQueen());
        }else if (checker!=null&&!checker.isWhite()&&!transformForWhitePlayer){
            super.setChecker(checker.transformToQueen());
        }else {
            super.setChecker(checker);
        }
    }
}