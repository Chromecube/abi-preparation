package me.niklas.learning.abiturprep.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Niklas on 2020/03/31
 */
@Service
public class SortProvider {


    public int[] selectionSort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        int temp, bestIndex;

        for (int i = 0; i < result.length; i++) {
            bestIndex = 0;
            for (int j = i; j < result.length; j++) {
                if (result[j] < result[bestIndex]) bestIndex = j;
            }
            temp = result[i];
            result[i] = result[bestIndex];
            result[bestIndex] = temp;
        }
        return result;
    }

    public int[] insertionSort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        int temp;

        for (int i = 1; i < result.length; i++) {
            for (int j = i; j > 0; j--) {
                if (result[j] < result[j - 1]) {
                    temp = result[j];
                    result[j] = result[j - 1];
                    result[j - 1] = temp;
                }
            }
        }
        return result;
    }

    public int[] bubbleSort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        int temp;

        for (int i = 0; i < result.length; i++) {
            for (int j = i; j < result.length - 1; j++) {
                if (result[j] > result[j + 1]) {
                    temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }

    public int[] mergeSort(int[] array) {
        if (array.length <= 1) return array;

        int split = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, split));
        int[] right = mergeSort(Arrays.copyOfRange(array, split, array.length - 1));
        return merge(left, right);

    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (index < result.length) {
            if (leftIndex < left.length && (rightIndex >= right.length || left[leftIndex] <= right[rightIndex])) {
                result[index] = left[leftIndex];
                leftIndex++;
            } else {
                result[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }
        return result;
    }

    public int[] quickSort(int[] array) {
        List<Integer> ints = new ArrayList<>(array.length);
        for (int i : array) {
            ints.add(i);
        }
        return quickSort(ints).stream().mapToInt(i -> i).toArray();
    }

    public List<Integer> quickSort(List<Integer> array) {
        if (array.size() <= 1) return array;
        int pivot = array.get(array.size() - 1); //Wähle letztes Element als Pivot-Element
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) < pivot) {
                left.add(array.get(i));
            } else {
                right.add(array.get(i));
            }
        }
        List<Integer> result = new ArrayList<>(array.size());
        result.addAll(quickSort(left));
        result.add(pivot);
        result.addAll(quickSort(right));
        return result;
    }
}
