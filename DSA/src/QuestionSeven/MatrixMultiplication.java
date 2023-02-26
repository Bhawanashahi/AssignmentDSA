package QuestionSeven;
//Question no seven(a)
//Ans



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int n = 5;
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] result = new int[n][n];

        // Initialize matrices a and b with random values between 0 and 4
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) (Math.random() * 5);
                b[i][j] = (int) (Math.random() * 5);
            }
        }

        // Create a fixed thread pool with a number of threads equal to the available processors
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Submit a task for each element of the result matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Each task will compute a single element of the result matrix
                Runnable task = new Task(a, b, result, i, j);
                executor.execute(task);
            }
        }

        // Shutdown the executor and wait for all tasks to complete
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the result matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    // The task class that will compute a single element of the result matrix
    static class Task implements Runnable {
        int[][] a;
        int[][] b;
        int[][] result;
        int i;
        int j;

        public Task(int[][] a, int[][] b, int[][] result, int i, int j) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.i = i;
            this.j = j;
        }

        public void run() {
            int sum = 0;
            // Compute the dot product of the ith row of matrix a and the jth column of matrix b
            for (int k = 0; k < a.length; k++) {
                sum += a[i][k] * b[k][j];
            }
            // Store the result in the result matrix
            result[i][j] = sum;
        }
    }
}
