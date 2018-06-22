package week3.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static <T> Set<T> difference(Set<T> op1, Set<T> op2){
        Set<T> outSet = new HashSet<>(op1);
        for (T item:op1){
            if(op2.contains(item)){
                outSet.remove(item);
            }
        }
        return outSet;
    }
    static <T> Set<T> union(Set<T> op1, Set<T> op2){
        Set<T> outSet = new HashSet<>(op1);
        outSet.addAll(op2);
        return outSet;
    }
    static <T> Set<T> intersection(Set<T> op1, Set<T> op2){
        Set<T> outSet = new HashSet<>(op1);
        for (T item:op1){
            if(!op2.contains(item)){
                outSet.remove(item);
            }
        }
        return outSet;
    }
    static <T> void print(String string,Set<T> set){
        System.out.printf("\n%s[",string);
        for(T item:set){
            System.out.print(item+",");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Set<Integer> op1 = new HashSet<>(Arrays.asList(1337,69,2007,777,420,1488,42,228));
        Set<Integer> op2 = new HashSet<>(Arrays.asList(420,1488,42,228,666));
        print("set of integer: ", op1);
        print("set of even: ", op2);
        System.out.println("\n----------------------------------------------");
        print("intersection: ",intersection(op1, op2));
        print("difference: ",difference(op1, op2));
        print("union: ",union(op1, op2));
    }
}
