package com.songmho.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by songm on 2016-12-26.
 */
public class MainClass {
    static List<String> dummy = new ArrayList<>();
    static List<WholeList> lists = new ArrayList<>();
    static List<TooList> tooLists = new ArrayList<>();
    static List<String> result = new ArrayList<>();
    static List<String> candidate = new ArrayList<>();

    //데이터 입력
        ////////////////////////////////////////////////////////////////
    public static void main(String[] args)  {
        try {

            BufferedReader in = new BufferedReader(new FileReader("F:\\Projects\\Java\\Algorithm2\\src\\com\\songmho\\java\\sample.txt"));

        String s;

            while ((s = in.readLine()) != null) {
                String a[] = s.split(" ");
                for(String str : a){
                    dummy.add(str);
                }

            }

            in.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        ////////////////////////////////////////////////////////////////
        int dum =0;
        for(String s1 : dummy){
            boolean isContained = false;
            if(!lists.isEmpty()) {
                for (int i = 0; i < lists.size(); i++) {
                    if (lists.get(i).getContents().equals(s1)) {
                        dum++;
                        lists.get(i).addCurSum();
                        isContained=true;
                        break;
                    }
                }
                if (!isContained)
                    lists.add(new WholeList(s1));
            }
            else
                lists.add(new WholeList(s1));
        }


        int sum = 0;
        for (int i=0;i<lists.size();i++){
            sum +=(lists.get(i).getCurSum());
        }
        double n = (double) sum / (double)WholeList.getSumClick();
        double x = n/(double)WholeList.getCategorySum();

        double dispersion = Math.sqrt(x);

        System.out.println("dispersion : "+ dispersion);

        try {
            ////////////////////////////////////////////////////////////////
            BufferedReader in = new BufferedReader(new FileReader("F:\\Projects\\Java\\ItProjAlgorithm\\src\\com\\songmho\\java\\sample2.txt"));
            String s;

            while ((s = in.readLine()) != null) {
                String a[] = s.split(" ");
                for(String str : a){
                    dummy.add(str);
                }

            }
            in.close();
            ////////////////////////////////////////////////////////////////
        } catch (IOException e) {
            System.err.println(e); // 에러가 있다면 메시지 출력
            System.exit(1);
        }

        for(String s : dummy){
            if(!tooLists.isEmpty()) {
                boolean isContained = false;
                for (int i = 0; i < tooLists.size(); i++) {
                    if (tooLists.get(i).getContents().equals(s)) {
                        tooLists.get(i).addCurSum();
                        isContained=true;
                        break;
                    }

                }
                if(!isContained)
                    tooLists.add(new TooList(s));
            }
            else
                tooLists.add(new TooList(s));


            for(int i =0; i<lists.size();i++){
                if(lists.get(i).getContents().equals(s))
                    lists.get(i).addCurSum();
            }
        }



        int sum1 = 0;
        for (int i=0;i<lists.size();i++){
            sum1 +=(lists.get(i).getCurSum());
        }
        double n1 = (double) sum1 / (double)WholeList.getSumClick();
        double x1 = n1/(double)WholeList.getCategorySum();

        double dispersion1 = Math.sqrt(x1);

        System.out.print("today's dispersion : "+dispersion1);
        //// 1번 끝
        QuickSort quickSort = new QuickSort();
        quickSort.sort(tooLists,0,tooLists.size()-1);

        for(TooList t : tooLists){

            if(t.getD()>=1.0*dispersion){
                result.add(t.getContents());
            }
            else if(t.getD()>=0.5*dispersion){
                candidate.add(t.getContents());
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();




        System.out.println("--------------------------------------");
        for(int i  =0 ;i<result.size() ; i++)
            System.out.println((i+1)+" : "+result.get(i));

        System.out.println("--------------------------------------");
        for(int i  =0 ;i<candidate.size() ; i++)
            System.out.println((i+1)+" : "+candidate.get(i));

         Collections.reverse(result);
         Collections.reverse(candidate);
         result.addAll(candidate);
        for(String r : result ) {
            for(int i=0;i<tooLists.size();i++){
                if(tooLists.get(i).getContents().equals(r)){
                    tooLists.remove(i);
                    break;
                }
            }
        }
        System.out.println("--------------------------------------");

        Collections.reverse(tooLists);
        for(int i=0;i<(10-result.size());i++){
            System.out.println((i+1)+" : "+tooLists.get(i).getContents());
        }
    }

}