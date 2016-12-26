package com.songmho.java;

/**
 * Created by songm on 2016-12-26.
 */
public class TooList {
    String contents;
    static int sumClick = 0 ;       //전체 누적 빈도 수
    int curSum = 0;     //현재 클래스 빈도 수

    public TooList(String contents){
        this.contents = contents;
        addSumClick();
        addCurSum();
    }

    public String getContents() {
        return contents;
    }

    private void addSumClick(){
        sumClick++;
    }

    public void addCurSum(){
        addSumClick();
        curSum++;
    }

    public double getD(){
        return (double)getCurSum()/(double)getSumClick();
    }

    public int getCurSum() {
        return curSum;
    }

    public static int getSumClick() {
        return sumClick;
    }
}
