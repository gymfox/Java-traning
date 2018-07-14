package com.gymfox.bcwc5.base.List;

public class ArrList<T>{
    private int array[];

    private int capacity;
    private double multiplier;
    private int current;

    public ArrList(int capacity, double multiplier) throws OutOfMemoryException {
        this.multiplier = multiplier;
        this.current = 0;
        this.capacity = capacity;

        array = new int[capacity];

        if (array == null) {
            throw new OutOfMemoryException();
        }
    }

    public void erase(int index) throws ZeroLenException {
        if (current == 0) {
            throw new ZeroLenException();
        }

        if (current > index && index > 0) {
            current -= 1;

            for (int i = index, j = index + 1; i < current; i++, j++) {
                array[i] = array[j];
            }
        }
    }

    public void insert(int value, int index) throws OutOfMemoryException {
        if (current >= index && index >= 0) {
            push_back(value);
        }

        for (int i = current - 1, j = current - 2; i > index; i--, j--) {
            array[i] = array[j];
        }
        array[index] = value;
    }

    public int find(int value) {
        for (int i = 0; i < current; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void push_back(int value) throws OutOfMemoryException {
        int newCurrent = current + 1;

        if (newCurrent > capacity) {
            int newCapacity = (int) multiplier * capacity;
            double[] newArray = new double[newCapacity];

            if (newArray == null) {
                throw new OutOfMemoryException();
            }
        }
        array[current] = value;
        current = newCurrent;
    }

    public int pop_back() throws ZeroLenException {
        if (current == 0) {
            throw new ZeroLenException();
        }
        current -= 1;

        return (int) array[current];
    }

    public void sort() {
        int last = this.current - 1;

        for (int i = 0; i < last; i++) {
            for (int j = i; j < current; j++) {
                if (array[j] < array[i]) {
                    int temp = (int) array[i];

                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public boolean equals(ArrList other) {
        if (current != other.getSize()) {
            return false;
        }

        for (int i = 0; i < current; i++) {
            if (this.getIndex(i) != other.getIndex(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean notEquals(ArrList other) {
        return !equals(other);
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        int last = getMaxSize() - 1;

        for ( int i = 0; i < last; i++ ) {
            out.append(array[i] + " ");
        }
        out.append(array[last]);

        return out.toString();
    }

    public int getSize() {
        return current;
    }

    public int getMaxSize() {
        return capacity;
    }

    public int getIndex(int index) {
        return array[index] ;
    }

}
