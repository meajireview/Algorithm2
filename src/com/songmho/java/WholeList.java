package com.songmho.java;

/**
 * Created by songm on 2016-12-26.
 */
public class WholeList {
    static int sumClick = 0 ;       //전체 누적 빈도 수
    int curSum = 0;     //현재 클래스 빈도 수
    static int categorySum =0;
    String contents;

    double dispersion;

    public WholeList(String contents){
        this.contents = contents;
        addSumClick();
        addCurSum();
        addCategorySum();
    }
    private void addCategorySum(){
        categorySum++;
    }
    private void addSumClick(){
        sumClick++;
    }

    public void addCurSum(){
        addSumClick();
        curSum++;
    }
    public String getContents() {
        return this.contents;
    }

    public int getCurSum() {
        return curSum;
    }

    public static int getSumClick() {
        return sumClick;
    }

    public static int getCategorySum() {
        return categorySum;
    }
}
