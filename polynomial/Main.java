package week3.polynomial;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void genCoef(int size, Map<Integer, Integer> poly){
        int digitLen = new Random().nextInt(4)+1;
        for(int i = 1;i < size;i++){
            int digit = 0;
            for(int j = 0;j < digitLen;j++){
                digit = digit * 10 + new Random().nextInt(9);
            }
            poly.put(i, digit);
        }
    }
    static void polynomsAddition(Map<Integer, Integer> op1, Map<Integer, Integer> op2){
        for(Map.Entry<Integer, Integer> item:op2.entrySet()){
            if(op1.containsKey(item.getKey())){
                op1.put(item.getKey(), op1.get(item.getKey()) + item.getValue());
            }else{
                op1.put(item.getKey(), item.getValue());
            }
        }
    }
    static void print(String string,Map<Integer, Integer> poly){
        StringBuilder out = new StringBuilder();
        for(Map.Entry<Integer, Integer> item:poly.entrySet()){
            out.append(item.getValue()+"X^"+item.getKey()+" + ");
        }
        System.out.println(string+out.deleteCharAt(out.length()-2));
    }
    public static void main(String[] args) {
        Map<Integer, Integer> polynom1 = new HashMap<>();
        Map<Integer, Integer> polynom2 = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter degree of first polynom");
        int size = scan.nextInt();
        genCoef(size, polynom1);
        System.out.println("Enter degree of second polynom");
        size = scan.nextInt();
        genCoef(size, polynom2);
        print("Polinom1: ", polynom1);
        print("Polinom2: ",polynom2);
        polynomsAddition(polynom1, polynom2);
        System.out.println("\n----------------------------------------------");
        print("Polinom1: ",polynom1);
        print("Polinom2: ",polynom2);

    }
}
