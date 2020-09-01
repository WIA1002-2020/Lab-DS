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
public class SortTest<T extends Comparable<T>> {

    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;
    private T[] value;
    private int orderType;

    public SortTest(int a, T[] b) {
        orderType = a;
        value = (T[]) new Comparable[b.length];
        for (int i = 0; i < b.length; i++) {
            value[i] = b[i];
        }
    }

    public SortTest() {
        value=null;
        orderType=0;
    }

    public boolean isSorted() {
        for (int i = 0; i < value.length - 1; i++) {
            if (value[i].compareTo(value[i + 1]) > 0 && orderType == ASCENDING) {
                return false;
            } else if (value[i].compareTo(value[i + 1]) < 0 && orderType == DESCENDING) {
                return false;
            }
        }
        return true;
    }

    public void swap(int index1, int index2) {
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }

    public void showValue() {
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    //Selection Sort
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

    public void selectionSort() {
        for (int i = 0; i < value.length - 1; i++) {
            swap(i, getMinIndex(i));
        }
    }

    //Bubble Sort
    public void bubbleSort() {
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length - 1 - i; j++) {
                if (value[j].compareTo(value[j + 1]) > 0 && orderType == ASCENDING) {
                    swap(j, j + 1);
                } else if (value[j].compareTo(value[j + 1]) < 0 && orderType == DESCENDING) {
                    swap(i, i + 1);
                }
            }
        }
    }

    //Insertion Sort
    public void insertionSort() {
        int j;
        for (int i = 1; i < value.length; i++) {
            for (j = 0; j < i; j++) {
                if (value[i].compareTo(value[j]) < 0 && orderType == ASCENDING) {
                    swap(i, j);
                    break;
                } else if (value[i].compareTo(value[j]) > 0 && orderType == DESCENDING) {
                    swap(i, j);
                    break;
                }
            }
            for (j = j + 1; j < i; j++) {
                swap(j, i);
            }
        }
    }

    //Merge Sort
    public void mergeSort() {
        mergeSort(0, value.length - 1);
    }

    public void mergeSort(int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }

    public void merge(int leftFirst, int leftLast, int rightFirst, int rightLast) {
        T[] temp = (T[]) new Comparable[value.length];
        int index = leftFirst;
        int currentIndex = leftFirst;
        while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
            if ((value[leftFirst].compareTo(value[rightFirst]) < 0) && orderType == ASCENDING
                    || (value[leftFirst].compareTo(value[rightFirst]) > 0) && orderType == DESCENDING) {
                temp[index] = value[leftFirst];
                leftFirst++;
            } else {
                temp[index] = value[rightFirst];
                rightFirst++;
            }
            index++;
        }
        while (leftFirst <= leftLast) {
            temp[index] = value[leftFirst];
            leftFirst++;
            index++;
        }
        while (rightFirst <= rightLast) {
            temp[index] = value[rightFirst];
            rightFirst++;
            index++;
        }
        for (int i = currentIndex; i <= rightLast; i++) {
            value[i] = temp[i];
        }
    }

    //Quick Sort
    public void quickSort() {
        quickSort(0, value.length - 1);
    }

    public void quickSort(int first, int last) {
        if (first < last) {
            int splitIndex = split(first, last);
            quickSort(first, splitIndex - 1);
            quickSort(splitIndex + 1, last);
        }
    }

    public int split(int first, int last) {
        boolean correctSide;
        T splitValue = value[first];
        int index = first;
        first++;
        do {
            correctSide = true;
            while (correctSide) {
                if ((splitValue.compareTo(value[first]) < 0 && orderType == ASCENDING)
                        || (splitValue.compareTo(value[first]) >= 0 && orderType == ASCENDING)) {
                    correctSide = false;
                } else {
                    first++;
                    if (first <= last) {
                        correctSide = true;
                    } else {
                        correctSide = false;
                    }
                }
            }
            if (first <= last) {
                correctSide = true;
            } else {
                correctSide = false;
            }
            while (correctSide) {
                if ((splitValue.compareTo(value[last]) >= 0 && orderType == ASCENDING)
                        || (splitValue.compareTo(value[last]) < 0 && orderType == ASCENDING)) {
                    correctSide = false;
                } else {
                    last--;
                    if (first <= last) {
                        correctSide = true;
                    } else {
                        correctSide = false;
                    }
                }
            }
            if (first <= last) {
                swap(first, last);
                first++;
                last--;
            }
        } while (first <= last);
        swap(index, last);
        return last;
    }

    public boolean findElement(T t, T[][] arrr) {
        for (T[] arr : arrr) {
            for (T ar : arr) {
                if (ar.compareTo(t) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public int findOccurence(T t, T[][] arrr) {
        int count = 0;
        for (T[] arr : arrr) {
            for (T ar : arr) {
                if (ar.compareTo(t) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public String findLocation(T value, T[][] arrr) {
        String str = "";
        for (int i = 0; i < arrr.length; i++) {
            for (int j = 0; j < arrr[i].length; j++) {
                if (value.compareTo(arrr[i][j]) == 0) {
                    str += "["+ i +","+ j +"]";
                }
            }
        }
        return str;
    }
}
