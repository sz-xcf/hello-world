// 关于输出结果：　可能的执行序列包括　＃１－－，＃写回，＃２－－，＃３－－，＃３写回，＃２写回（未改变），＃２读取，＃１读取，＃３读取

ｗｒｉｔｅ
public class HelloWorld{
    public static <T> void Println(T args) {
        System.out.println(args);
    }
    //public static void printlnObj(Object obj) { System.out.println(obj); }

    public static void main(String[] args) {
        Println("main() running...");

        MyThread mythread1 = new MyThread(1);
        MyThread mythread2 = new MyThread(2);
        MyThread mythread3 = new MyThread(3);
        mythread1.start();
        mythread2.start();
        mythread3.start();
        Println("================================");

    }
}

//////////////////////////////////////////

class MyThread extends Thread{

    private int threadId;
    private static int counter = 10;

    public MyThread(int i){
        threadId = i;
    }

    @Override
    public void run(){
        for(int i =  0; i<5; i++){
            if(counter > 0){
                counter--;
            }
            System.out.println("Thread "+ threadId +" is running... counter = "+counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

///////////////////////////////////////


OUTPUT:
main() running...
================================
Thread 1 is running... counter = 9
Thread 2 is running... counter = 8
Thread 3 is running... counter = 7
Thread 2 is running... counter = 5
Thread 1 is running... counter = 5
Thread 3 is running... counter = 5
Thread 3 is running... counter = 3
Thread 2 is running... counter = 3
Thread 1 is running... counter = 3
Thread 2 is running... counter = 2
Thread 3 is running... counter = 2
Thread 1 is running... counter = 2
Thread 2 is running... counter = 0
Thread 1 is running... counter = 0
Thread 3 is running... counter = 0

Process finished with exit code 0
