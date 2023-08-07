package org.example;

import service.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringList array = new StringList();
        StringList otherList = new StringList();
//        otherList.add("Fiona");
//        otherList.add("Shrek");
//        otherList.add("Gus");
//        otherList.add("Donkey");
//        otherList.add("Dragon");

        System.out.println(array.add("Fiona"));
        System.out.println(array.add("Shrek"));
        System.out.println(array.add("Gus"));
        System.out.println(array.add("Donkey"));
        System.out.println(array.add("Dragon"));
        //array.clear();
        System.out.println(Arrays.toString(array.toArray()));
        //array.remove(5);
        System.out.println(Arrays.toString(array.toArray()));
//        System.out.println(array.isEmpty());
//        System.out.println(otherList.isEmpty());
        System.out.println(array.set(5, "John"));
//        System.out.println(Arrays.toString(array.show()));
//        System.out.println(array.lastIndexOf("Gus"));
//        System.out.println(array.get(5));
       // System.out.println(array.equals(otherList));
//System.out.println(Arrays.toString(array.show()));
    }
}