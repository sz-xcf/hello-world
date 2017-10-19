
//this code is a modification of the example in the book "CORE JAVA". It's just a practice.
//I don't understand why it can read English correctly, but read nothing from a file 
//contains Chinese, even though the file beginging with English.

import java.util.*;
import java.io.File;


public class HelloWorld {
    public static <T> void Println(T args) {
        System.out.println(args);
    }
    //public static void printlnObj(Object obj) { System.out.println(obj); }

    public static void main(String[] args) {
        Println("main() running...");

        //Foo f1 = new Foo(1);

        Set<String> words = new HashSet<>();
        long totalTime = 0;

        File file = new File("C:\\Users\\Administrator\\IdeaProjects\\untitled\\src\\com\\xcf\\pk1\\wordSrc.txt");
        Println("main() 1...");
        //try(Scanner in = new Scanner(System.in)){
        try(Scanner in = new Scanner(file)){
            while(in.hasNextLine()){
                String word[] = in.nextLine().split(" ");
                int i = 0;
                Println("word.length="+word.length);
                while(i < word.length) {
                    long callTime = System.currentTimeMillis();
                    words.add(word[i]);
                    callTime = System.currentTimeMillis() - callTime;
                    totalTime += callTime;
                    i++;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Println("main() 2...");

        Iterator<String> iter = words.iterator();
        for(int i = 0; i<=20 && iter.hasNext(); i++){
            Println(iter.next());
        }

        Println("...");
        Println(words.size() + " disdinct words. " + totalTime + "MilliSeconds.");

    }
}

