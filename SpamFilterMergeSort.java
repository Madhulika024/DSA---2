import java.util.Arrays;

public class SpamFilterMergeSort {

    public static int[] mergeSort(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] trainingSamples = {7, 3, 11, 5, 14, 2, 9, 6, 12, 1, 8, 4};

        System.out.println("Original Training Samples:");
        System.out.println(Arrays.toString(trainingSamples));

        int[] sortedSamples = mergeSort(trainingSamples);

        System.out.println("\nSorted Training Samples:");
        System.out.println(Arrays.toString(sortedSamples));
    }
}