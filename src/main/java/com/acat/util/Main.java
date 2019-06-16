package com.acat.util;

//import java.util.Scanner;
//
//public class Main{
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//
//        int[] x = new int[4];
//        int[] y = new int[4];
//
//        for(int i=0;i<x.length;i++){
//            x[i] = in.nextInt();
//        }
//
//        for(int i=0;i<y.length;i++){
//            y[i] = in.nextInt();
//        }
//
//        //(r1.x2  > r2.x1 &&     r2.x2 > r1.x1 &&    r1.y2 > r2.y1 &&   r2.y2 > r1.y1)
//        if(x[2]>y[0] && y[2]>x[0] && x[3]>y[1] && y[3]>x[1]){
//            //you jiao ji
//
//            /**
//             * int width=Math.min(r1.x2,r2.x2)-Math.max(r1.x1, r2.x1);
//             * int height=Math.min(r1.y2, r2.y2)-Math.max(r1.y, r2.y);
//             */
//
//            int width=Math.min(x[2],y[2])-Math.max(x[0], y[0]);
//            int height=Math.min(x[3], y[3])-Math.max(x[1], y[1]);
//
//
//        }else{
//
//        }
//    }
//}
public class Main{
    public static void main(String[] args){

        T t1 = new T();
        T t2 = new T();

        t1.start();
        System.out.println(Thread.activeCount());
        t2.start();
    }
}

class T extends Thread{
    public void run(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}