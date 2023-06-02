// the difference in performance is caused by the fact that ArrayList supports random access, which means that we can
// directly access a specific object within the list using its index. LinkedList does not have such feature, since it
// consists of nodes that store references for the next object (node), which leads to time complexity of an element
// search to be O(n), instead of O(1) for ArrayList

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Project_3 {
    static int dataEntryNumber = 90000;
    static ArrayList<String> Al = new ArrayList<>();
    static LinkedList<String> Ll = new LinkedList<>();
    static Random rand = new Random();
    static Project3_Which_Data_Structure_is_Better.Bar211 bar;

    public static void main(String[] args) {
        bar = new Project3_Which_Data_Structure_is_Better.Bar211("CS 211, Spring 2023", dataEntryNumber);
//        bar = new Bar211("CS 211, Spring 2023", dataEntryNumber) //did not work due to naming differences/project structure
        add();
        System.out.println();
        search();
        System.out.println();
        remove();
    }

    public static void printResults(String action, double timeAl, double timeLl) {
        double percentage = timeAl/timeLl*100.0;
        System.out.println(action + ":");
        System.out.println("ArrayList time: " + timeAl/1000.0 + "sec");
        System.out.println("LinkedList time: " + timeLl/1000.0 + "sec");
        System.out.printf("ArrayList's processing time is %.2f %% of LinkedList\n", percentage);
    }
    public static void add() {
        double timeAddArrayList = 0.0;
        double timeAddLinkedList = 0.0;
        double startTime, endTime;

        for (int i = 0; i < dataEntryNumber; i++) {
            int randIndex = rand.nextInt(Al.size() + 1);
            startTime = System.currentTimeMillis();
            Al.add(randIndex, String.valueOf(randIndex));
            endTime = System.currentTimeMillis();
            timeAddArrayList += endTime-startTime;
            bar.setTimeAddAL(timeAddArrayList);

            startTime = System.currentTimeMillis();
            Ll.add(randIndex, String.valueOf(randIndex));
            endTime = System.currentTimeMillis();
            timeAddLinkedList += endTime-startTime;
            bar.setTimeAddLL(timeAddLinkedList);
        }
        printResults("Add", timeAddArrayList, timeAddLinkedList);
    }

    public static void search() {
        double timeGetArrayList = 0.0;
        double timeGetLinkedList = 0.0;
        double startTime, endTime;

        for (int i = 0; i < Al.size(); i++) {
            int randIndex = rand.nextInt(Al.size());

            startTime = System.currentTimeMillis();
            Al.indexOf(String.valueOf(randIndex));
            endTime = System.currentTimeMillis();
            timeGetArrayList += endTime-startTime;
            bar.setTimeSearchAL(timeGetArrayList);

            startTime = System.currentTimeMillis();
            Ll.indexOf(String.valueOf(randIndex));
            endTime = System.currentTimeMillis();
            timeGetLinkedList += endTime-startTime;
            bar.setTimeSearchLL(timeGetLinkedList);
        }
        printResults("Search", timeGetArrayList, timeGetLinkedList);
    }

    public static void remove() {
        double timeRemoveArrayList = 0.0;
        double timeRemoveLinkedList = 0.0;
        double startTime, endTime;

        for (int i = 0; i < dataEntryNumber/2; i++) {
            int randIndex = rand.nextInt(Al.size());

            startTime = System.currentTimeMillis();
            Al.remove(randIndex);
            endTime = System.currentTimeMillis();
            timeRemoveArrayList += endTime-startTime;
            bar.setTimeRemoveAL(timeRemoveArrayList);

            startTime = System.currentTimeMillis();
            Ll.remove(randIndex);
            endTime = System.currentTimeMillis();
            timeRemoveLinkedList += endTime-startTime;
            bar.setTimeRemoveLL(timeRemoveLinkedList);
        }
        printResults("Remove", timeRemoveArrayList, timeRemoveLinkedList);
    }
}