package lr6;

public class Example5 {

    public static void main(String[] args) throws InterruptedException {

        int[] array = {12, 45, 7, 89, 34, 99, 123, 5, 67, 200, 15, 1};

        int max = findMax(array);

        System.out.println("Максимальный элемент: " + max);
    }

    public static int findMax(int[] array) throws InterruptedException {

        int cores = Runtime.getRuntime().availableProcessors();

        Thread[] threads = new Thread[cores];

        int[] localMax = new int[cores];

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

                int max = array[start];

                for (int j = start; j < end; j++) {

                    if (array[j] > max) {
                        max = array[j];
                    }
                }

                localMax[index] = max;
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int globalMax = localMax[0];

        for (int value : localMax) {

            if (value > globalMax) {
                globalMax = value;
            }
        }

        return globalMax;
    }
}
