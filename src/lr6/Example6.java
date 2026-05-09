package lr6;

public class Example6 {

    public static void main(String[] args) throws InterruptedException {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sum = calculateSum(array);

        System.out.println("Сумма массива: " + sum);
    }

    public static int calculateSum(int[] array) throws InterruptedException {

        int cores = Runtime.getRuntime().availableProcessors();

        Thread[] threads = new Thread[cores];

        int[] partialSums = new int[cores];

        int chunkSize = array.length / cores;

        for (int i = 0; i < cores; i++) {

            int start = i * chunkSize;

            int end;

            if (i == cores - 1) {
                end = array.length;
            } else {
                end = start + chunkSize;
            }

            int index = i;

            threads[i] = new Thread(() -> {

                int localSum = 0;

                for (int j = start; j < end; j++) {
                    localSum += array[j];
                }

                partialSums[index] = localSum;
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int totalSum = 0;

        for (int sum : partialSums) {
            totalSum += sum;
        }

        return totalSum;
    }
}