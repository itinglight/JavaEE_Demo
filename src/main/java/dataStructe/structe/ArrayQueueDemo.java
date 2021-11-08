package dataStructe.structe;

import java.util.Scanner;

public class ArrayQueueDemo{

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key =' ';//接收用户输入
        Scanner scanner =new Scanner(System.in);
        boolean loop =true;
        while (loop){
            System.out.println("s(show),显示队列");
            System.out.println("a(add),添加数据");
            System.out.println("g(get),取出数据");
            System.out.println("h(head),显示头数据");
            System.out.println("e(exit),退出程序");

            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    loop=false;
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据:");
                    int value=scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    System.out.println(arrayQueue.getQueue());
                    break;
                default:break;
            }
        }

    }

}


class ArrayQueue {

    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr = new int[maxSize];
        front=-1;//指向队列头部，分析出front是指向队列头的前一个位置。
        rear=-1;//指向队列尾，指向队列尾的数据

    }
    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满，不能加入数据～");
            return;
        }
        rear++;//让rear后移
        arr[rear] =n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列空的，没有数据～～");
            return;
        }
        for (int i =0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        if (isEmpty()){
//            System.out.println("队列空的没有数据");
            new RuntimeException("队列空的没有数据");

        }

        return arr[front+1];
    }


}
