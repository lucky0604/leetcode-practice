package com.fastdata.algorithm.easy.heap;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author: Lucky
 * @Description:
 * 使用Java简单实现一个Heap
 * @Date: create in 1/19/21 - 12:54 PM
 */
public class Heap<E extends Comparable<E>> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    transient Object[] elementData;

    public Heap() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 插入操作
     * @param element
     * @return
     */
    public boolean add(E element) {
        if (null == element)
            return false;
        ensureCapacityInternal(size + 1);
        minHeapify();
        return true;
    }

    private void minHeapify() {
        int i = size - 1;
        while (i > 0 && compare(elementData[i], elementData[(i - 1) / 2]) < 0) {
            swap(elementData, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public boolean remove(Object element) {
        int index = indexOf(element);
        if (index == -1) return false;
        removeInternal(index);
        return true;
    }

    public E remove(int index) {
        rangeCheck(index);
        E oldVal = elementData(index);
        removeInternal(index);
        return oldVal;
    }

    public E getParent(int index) {
        return elementData(getParentIndex(index));
    }

    public E getParent(Object child) {
        return getParent(indexOf(child));
    }

    public int getParentIndex(int index) {
        positionCheck(index);
        return (index - 1) / 2;
    }

    public E getLeftChild(int index) {
        int leftIndex = getLeftChildIndex(index);
        return (leftIndex == -1) ? null: elementData(leftIndex);
    }

    public E getLeftChild(Object o) {
        return getLeftChild(indexOf(o));
    }

    public int getLeftChildIndex(int index) {
        rangeCheck(index);
        int leftIndex = 2 * index + 1;
        return (leftIndex >= size) ? -1: leftIndex;
    }

    public E getRightChild(int index) {
        int rightIndex = getRightChildIndex(index);
        return (rightIndex == -1) ? null : elementData(rightIndex);
    }

    public E getRightChild(Object o) {
        return getRightChild(indexOf(o));
    }

    public int getRightChildIndex(int index) {
        rangeCheck(index);
        int rightIndex = 2 * index + 2;
        return (rightIndex >= size) ? -1: rightIndex;
    }

    private void removeInternal(int index) {
        elementData[index] = elementData[--size];
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size && (compare(elementData[index], elementData[left]) > 0 || compare(elementData[index], elementData[right]) > 0)) {
            if (compare(elementData[left], elementData[right]) < 0) {
                swap(elementData, index, left);
                index = left;
            } else {
                swap(elementData, index, right);
                index = right;
            }
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }


    public void traverse(Collection<E> container) {
        for (int i = 0; i < size; i ++) {
            container.add(elementData(i));
        }
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void positionCheck(int index) {
        if (index <= 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    @SuppressWarnings("unchecked")
    private int compare(Object a, Object b) {
        return ((E) a).compareTo((E) b);
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * breadth first traversal
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        int start = 0;
        int node = 1;
        while (start < size) {
            start = node - 1;
            int end = start + node;
            int count = 0;
            while (start < size && start < end) {
                if (start == 0) {
                    if (compare(o, elementData[start]) == 0) {
                        return start;
                    } else {
                        return -1;
                    }
                } else {
                    if (compare(o, elementData[start]) == 0) {
                        return start;
                    } else if (compare(o, elementData[start]) < 0 && compare(o, getParent(start)) > 0) {
                        count ++;
                    }
                }
                start ++;
            }
            if (count == node) {
                return -1;
            } else {
                node = node * 2;
            }
        }
        return -1;
    }

    public void swap(Object[] o, int a, int b) {
        Object t = o[a];
        o[a] = o[b];
        o[b] = t;
    }

    public Heap(int intialCapacity) {
        if (intialCapacity > 0) {
            this.elementData = new Object[intialCapacity];
        } else if (intialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + intialCapacity);
        }
    }

    public void ensureCapacity(int minCapacity) {
        int minExpend = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;
        if (minCapacity > minExpend)
            ensureExplicitCapacity(minCapacity);
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    public void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
