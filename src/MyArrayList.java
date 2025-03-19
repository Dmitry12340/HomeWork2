import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private Object[] elements;
    private static final int CAPACITY = 16;
    private int size = 0;

    public MyArrayList(){
        elements = new Object[CAPACITY];
    }

    public boolean add(T element){
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    public boolean remove(T element){
        for(int i = 0; i < size; i++){
            if(elements[i].equals(element)){
                for (int j = i; j < size - 1; j++){
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    public T get(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }else {
            return (T) elements[index];
        }
    }

    public boolean addAll(MyArrayList<T> myArrayList){
        if(myArrayList.size() == 0){
            return false;
        }
        for(T t : myArrayList){
            add(t);
        }
        return true;
    }

    public boolean addAll(ArrayList<T> arrayList){
        if(arrayList.isEmpty()){
            return false;
        }
        for(T t : arrayList){
            add(t);
        }
        return true;
    }

    public boolean addAll(T[] array){
        if(array.length == 0){
            return false;
        }
        for(T t : array){
            add(t);
        }
        return true;
    }


    public boolean contains(T element){
        for(int i = 0; i < size; i++){
            if(elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    //Если количество добавленных элементов достигло размера массива, создаем копию этого массива вдвое больше
    private void ensureCapacity(){
        if(size == elements.length){
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    public int size(){
        return size;
    }

    //Переопределил метод toString для удобного вывода содержимого
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append(elements[i]).append(", ");
        }
        return sb.toString();
    }

    //Имплементировал метод iterator для того что бы по моей коллекции
    // можно было пройтись циклом for-each
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            //Метод возвращает true если текущий элемент в коллекции не последний
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            //Метод возвращает следующий элемент
            @Override
            public T next() {
                return get(currentIndex++);
            }
        };
    }
}