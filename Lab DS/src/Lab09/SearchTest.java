/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab09;

/**
 *
 * @author muham
 */
public class SearchTest<T extends Comparable<T>> {

    private T[] value;
    private int orderType, size;
    

    public SearchTest(int sortType, T b, int size) {
        orderType = sortType;
        this.size = size;
        value = (T[]) new Comparable[size];
    }

    public void showValue() {
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    public T getElement(int index) {
        return value[index];
    }

    //Linear Search
    public int linearSearchCount(T t) {
        int count = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t) == 0) {
                count++;
            }
        }
        return count;
    }

    //Binary Search
    public int binarySearchCount(T t) {
        int count = 0;
        int index = binarySearchCount(0, value.length, t);
        if (index != -1) {
            for (int i = index; i >= 0 && t.compareTo(value[i]) == 0; i--) {
                count++;
            }
            for (int i = index + 1; i < value.length && t.compareTo(value[i]) == 0; i++) {
                count++;
            }
        }
        return count;
    }

    public int ASCENDING = 1;
    public int DESCENDING = 2;

    public int binarySearchCount(int start, int end, T t) {
        int middle = (start + end) / 2;
        if (end < start) {
            return -1;
        }
        if (value[middle].compareTo(t) == 0) {
            return middle;
        } else if ((value[middle].compareTo(t) > 0 && orderType == ASCENDING)
                || (value[middle].compareTo(t) < 0 && orderType == DESCENDING)) {
            return binarySearchCount(start, middle - 1, t);
        } else {
            return binarySearchCount(middle + 1, end, t);
        }
    }

    public void swap(int index1, int index2) {
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }

    public int getMinIndex(int start) {
        T temp = value[start];
        int index = start;
        for (int i = start + 1; i < value.length; i++) {
            if (temp.compareTo(value[i]) > 0 && orderType == ASCENDING) {
                index = i;
                temp = value[i];
            } else if (temp.compareTo(value[i]) < 0 && orderType == DESCENDING) {
                index = i;
                temp = value[i];
            }
        }
        return index;
    }

    public void selectionSort(int b) {
        for (int i = 0; i < value.length - 1; i++) {
            swap(i, getMinIndex(i));
        }
    }
}
