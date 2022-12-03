package com.example.algorithms_hw_1;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private final String[] stringList;

    private final int size;

    public StringListImpl(int size) {
        this.size = size;
        this.stringList = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] == null) {
                stringList[i] = item;
                return item;
            }
        }
        return null;
    }

    @Override
    public String add(int index, String item) {
        if (index > stringList.length - 1) {
            throw new ArrayIndexOutOfBoundsException("элемент выходит за рамки массива");
        }
        if (item == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (i > index) {
                stringList[i] = stringList[i - 1];
            }
        }
        stringList[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= stringList.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Такого индекса в массиве нет");
        }
        if (item == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        stringList[index] = item;
        return null;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        for (int i = 0; i < stringList.length; i++) {
            if (!stringList[i].equals(item)) {
                throw new IllegalArgumentException("нет такой строки в массиве");
            } else {
                return stringList[i] = null;
            }
        }
        return null;
    }

    @Override
    public String remove(int index) {
        return stringList[index] = null;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null && stringList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null && stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (stringList[i] != null && stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null || otherList.get(i) != null) {
                if (!stringList[i].equals(otherList.get(i))) {
                    return false;
                }
            }

        }
        return true;
    }

    @Override
    public int size() {
        int factSize = 0;
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null) {
                factSize++;
            }
        }
        return factSize;
    }

    @Override
    public boolean isEmpty() {
        int factSize = 0;
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null) {
                factSize++;
            }
        }
        if (factSize == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(stringList, null);
    }

    @Override
    public String[] toArray() {
        String[] strings = new String[stringList.length];
        for (int i = 0; i < stringList.length; i++) {
            strings[i] = stringList[i];
        }
        return strings;


    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "stringList=" + Arrays.toString(stringList) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringListImpl that = (StringListImpl) o;
        return size == that.size && Arrays.equals(stringList, that.stringList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(stringList);
        return result;
    }

}
