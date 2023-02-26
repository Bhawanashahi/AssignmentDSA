package QuestionFour;


import java.util.LinkedList;

public class Steps {

    public static int stepsToSortLinkedList(LinkedList<Integer> list) {
        // Convert the linked list to an array
        int n = list.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }

        // Sort the array using selection sort and count the number of steps
        int steps = 0;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                steps++;
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        int steps = stepsToSortLinkedList(list);
        System.out.println(steps);

    }

}
