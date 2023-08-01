package com.hp.utlis;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    public static List filter(List list) {
      List objList= new ArrayList<>();
        objList.clear();
        int size = list.size() % 5 == 0 ? list.size() / 5 : list.size() / 5 + 1;
        List tempList = new ArrayList();
        for (int i = 0; i < size; i++) {
            for (int j = i * 5; j < (i + 1) * 5; j++) {
                if (j > list.size()-1){
                    break;
                }
                else{
                    tempList.add(list.get(j));
                }
            }
            objList.add(new ArrayList<>(tempList));
            tempList.clear();
        }
        return objList;
    }

}
