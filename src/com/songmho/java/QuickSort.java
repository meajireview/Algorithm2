package com.songmho.java;

import java.util.List;

/**
 * Created by songm on 2016-12-16.
 */
public class QuickSort {
    public void sort(List<TooList> data, int l, int r){
        int left = l;
        int right = r;
        double pivot = (double)(data.get(l).getCurSum() + data.get(r).getCurSum())/2;

        do{
            while(data.get(left).getCurSum() < pivot) left++;
            while(data.get(right).getCurSum() > pivot) right--;
            if(left <= right){
                TooList temp = data.get(left);
                data.set(left,data.get(right));
                data.set(right,temp);
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }
}
