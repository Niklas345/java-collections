import java.util.Collection;
import java.util.Iterator;

public class MyListImplementation<T> implements MyList<T> {

    private Object[] elements;
    private int length = 0;

    public MyListImplementation() {
        this.elements = new Object[0];
    }

    public int size() {
        return this.elements.length;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean contains(Object o) {

        for (int i = 0; i < this.length; i++) {
            if (this.elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(T t) {
        Object[] newElements = new Object[++this.length];
        for (int i = 0; i < this.length - 1; i++) {
            newElements[i] = this.elements[i];
        }
        newElements[this.length - 1] = t;
        this.elements = newElements;
        return true;
    }

    public boolean remove(Object o) {

        if (this.contains(o)) {
            Object[] newElements = new Object[--this.length];
            for (int i = 0, j = 0; i <= this.length; i++) {
                if (!this.elements[i].equals(o)) {
                    newElements[j] = this.elements[i];
                    j++;
                }
            }
            this.elements = newElements;
            return true;
        } else {
            return false;
        }
    }

    public boolean containsAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        for (int i = 0; i < c.size(); i++) {
            if (this.contains(iterator.next())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        Iterator<?> iterator = c.iterator();
        for (int i = 0; i < c.size(); i++) {
            this.add((T) iterator.next());
        }
        return true;
    }

    public boolean addAll(int index, Collection<? extends T> c) {

        Iterator<?> iterator = c.iterator();
        for (int i = index; i < index + c.size(); i++) {
            this.add(i, (T) iterator.next());
        }
        return false;
    }

    public boolean removeAll(Collection<?> c) {

        Iterator<?> iterator = c.iterator();
        boolean[] returnValues = new boolean[c.size()];
        for (int i = 0; i < c.size(); i++) {
            returnValues[i] = this.remove(iterator.next());
        }
        for (int i = 0; i < c.size(); i++) {
            if (returnValues[i] == false) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        this.elements = new Object[0];
    }

    public T get(int index) {
        return (T) this.elements[index];
    }

    public T set(int index, T element) {
        Object oldValue = this.elements[index];
        this.elements[index] = element;
        return (T) oldValue;
    }

    public void add(int index, T element) {
        Object[] newElements = new Object[++this.length];
        for (int i = 0; i < index; i++) {
            newElements[i] = this.get(i);
        }
        newElements[index] = element;
        for (int i = index + 1; i < this.size() + 1; i++) {
            newElements[i] = this.get(i - 1);
        }
        this.elements = newElements;

    }

    public T remove(int index) {
        T removedValue = this.get(index);
        this.remove(removedValue);
        return removedValue;
    }

    public int indexOf(Object o) {

        for (int i = 0; i < elements.length; i++) {
            if (this.elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
}

