package org.lanqiao.JavaPractice;

/**
 * Hello world!
 *
 */
public class Calc {  
    public static void main(String args[]){  
        int count = 0;  
        for (int i = 0; i <770; i++){  
            String s = String.valueOf(i);  
            char[] chars = s.toCharArray();  
            for (char aChar : chars) {  
                if (aChar == '7'){  
                    count++;  
                }  
            }  
        }  
        System.out.println(count);  
    }  
}  