/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab09;

import java.util.LinkedList;

/**
 *
 * @author muham
 */
public class ArrayHashTableChain<K, V> {

    public final int MAX_SIZE = 20;
    private LinkedList<Pair<K, V>>[] entries = new LinkedList[MAX_SIZE];

    public boolean isEmpty() {
        return getArraySize() == 0;
    }

    public boolean isFull() {
        return getArraySize() == MAX_SIZE;
    }

    public int getArraySize() {
        int count = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (entries[i] != null) {
                count++;
            }
        }
        return count;
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            LinkedList<Pair<K, V>> pairLinkedList = entries[i];
            if (pairLinkedList != null) {
                count += pairLinkedList.size();
            }
        }
        return count;
    }

    public void clear() {
        for (int i = 0; i < MAX_SIZE; i++) {
            entries[i] = null;
        }
    }

    public void showHashTable() {
        for (int i = 0; i < MAX_SIZE; i++) {
            LinkedList<Pair<K, V>> pairLinkedList = entries[i];
            if (pairLinkedList != null) {
                for (int j = 0; j < pairLinkedList.size(); j++) {
                    System.out.println(pairLinkedList.get(j).toString().replace(" |", ""));
                }
            }
        }
    }

    public boolean containsKey(Comparable<K> key) {
        int keyHash = getKeyHash((Integer) key);
        LinkedList<Pair<K, V>> pairLinkedList = entries[keyHash];
        if (pairLinkedList != null) {
            for (int i = 0; i < pairLinkedList.size(); i++) {
                Pair<K, V> pair = pairLinkedList.get(i);
                if (key.compareTo(pair.getKey()) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(Comparable<V> value) {
        for (int i = 0; i < entries.length; i++) {
            LinkedList<Pair<K, V>> pairLinkedList = entries[i];
            if (pairLinkedList != null) {
                for (int j = 0; j < pairLinkedList.size(); j++) {
                    Pair<K, V> pair = pairLinkedList.get(j);
                    if (value.compareTo(pair.getValue()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public V get(Comparable<K> key) {
        int keyHash = getKeyHash((Integer) key);
        LinkedList<Pair<K, V>> pairLinkedList = entries[keyHash];
        if (pairLinkedList != null) {
            for (int i = 0; i < pairLinkedList.size(); i++) {
                Pair<K, V> pair = pairLinkedList.get(i);
                if (key.compareTo(pair.getKey()) == 0) {
                    V value = pair.getValue();
                    return value;
                }
            }
        }
        return null;
    }

    public void printLocation(Comparable<K> key) {
        int keyHash = getKeyHash((Integer) key);
        LinkedList<Pair<K, V>> pairLinkedList = entries[keyHash];
        if (pairLinkedList != null) {
            for (int i = 0; i < pairLinkedList.size(); i++) {
                Pair<K, V> pair = pairLinkedList.get(i);
                System.out.print(pair.toString().replace("|", "-->"));
            }
            System.out.println();
        }
    }

    public V put(Comparable<K> key, V value) {
        if (isFull()) {
            System.out.println("The Hash Table is full");
            return null;
        } else {
            int keyHash = getKeyHash((Integer) key);
            if (entries[keyHash] == null) {
                entries[keyHash] = new LinkedList<>();
                entries[keyHash].add(new Pair(key, value));
            } else {
                LinkedList<Pair<K, V>> linkedList = entries[keyHash];
                for (int i = 0; i < linkedList.size(); i++) {
                    Pair<K, V> pair = linkedList.get(i);
                    if (key.compareTo(pair.getKey()) == 0) {
                        V val = pair.getValue();
                        pair.setValue(value);
                        return val;
                    }
                }
                linkedList.add(new Pair(key, value));
            }
        }
        return null;
    }

    public V remove(Comparable<K> key) {
        if (isEmpty()) {
            return null;
        } else {
            int keyHash = getKeyHash((Integer) key);
            LinkedList<Pair<K, V>> pairLinkedList = entries[keyHash];
            if (pairLinkedList != null) {
                for (int i = 0; i < pairLinkedList.size(); i++) {
                    Pair<K, V> pair = pairLinkedList.get(i);
                    if (key.compareTo(pair.getKey()) == 0) {
                        V value = pair.getValue();
                        pairLinkedList.remove(i);
                        return value;
                    }
                }
            }
            return null;
        }
    }

    public int getKeyHash(int value) {
        return value % MAX_SIZE;
    }
}
