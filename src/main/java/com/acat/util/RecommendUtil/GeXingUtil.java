package com.acat.util.RecommendUtil;

import java.util.*;

public class GeXingUtil {

    public static Map<String,Integer> calcCountsOfListElements(List<String> items){
        if(items!=null && items.size() > 0){
            Map<String,Integer> map = new HashMap<>();
            for(int i=0; i<items.size(); i++){
                if(!map.containsKey(items.get(i))){
                    map.put(items.get(i), 1);
                }else {
                    map.put(items.get(i), (Integer)map.get(items.get(i)) + 1);
                }
            }
            return map;
        }else {
            return null;
        }
    }

    //根据最大value寻找key
    public static Object getKey(Map<String,Integer> map,Integer value){
        String key = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(value == entry.getValue()){
                key=entry.getKey();
            }
        }
        return key;
    }

    //遍历寻找最大value
    public static Object gerMinValue(Map<String, Integer> map) {
        if (map.size() == 0)
            return null;
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return obj[obj.length - 1];
    }

    public static void removeDup(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        System.out.println( " remove duplicate " + list);
    }


    public static String stringSplic(String str){
        String newStr = str.substring(0,2);
        return newStr;
    }

    public static void main(String[] args){
        String str = "西安市";
        System.out.println(stringSplic(str));
    }
}
