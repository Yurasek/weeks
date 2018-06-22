package week3.replacevalue;

import java.util.Random;

public class Main {
    public int[] list = new int[new Random().nextInt(10)+5];//]{34,56,67,-4,-34,-5,-45,-56};
    static void genValue(int[] list){
        for(int i = 0;i < list.length-1;i++){
            int digit = new Random().nextInt(50) * (int)Math.pow(-1, new Random().nextInt(2));
            list[i] = digit;
        }
    }
    static void replaced(int[] list){
        int j = list.length-1;
        for(int i = list.length-1;i >= 0;i--){
            if(list[i] < 0 && list[j] >= 0){
                list[i] ^= list[j];
                list[j] ^= list[i];
                list[i] ^= list[j];
                --j;
            }
        }
    }
    public static void main(String[] args) {
        Main obj = new Main();
        genValue(obj.list);
        for(int item:obj.list) {
            System.out.print(item+" ");
        }
        System.out.println();
        replaced(obj.list);
        System.out.println();
        for(int item:obj.list) {
            System.out.print(item+" ");
        }
    }
}
