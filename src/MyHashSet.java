import java.util.ArrayList;

public class MyHashSet<T> {
    private ArrayList<T>[] buckets;
    private int size = 0;
    private int capacity = 5;

    public MyHashSet(int initialCapacity) {
        this.capacity = initialCapacity;

        //Создаем массив бакетов и заполняем пустыми ArrayList
        this.buckets = new ArrayList[initialCapacity];
        for(int i = 0; i < initialCapacity; i++){
            buckets[i] = new ArrayList<>();
        }
    }

    public MyHashSet() {
        this.buckets = new ArrayList[capacity];
        for(int i = 0; i < capacity; i++){
            buckets[i] = new ArrayList<>();
        }
    }

    public boolean add(T value){
        if (size == capacity){
            resize();
        }
        boolean contains = contains(value);
        if (!contains) {
            boolean add = buckets[getBacket(value)].add(value);
            if (add) {
                size++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(T value){
        boolean contains = contains(value);
        if(contains){
            int indexBacket = getBacket(value);
            int indexElement = buckets[indexBacket].indexOf(value);
            buckets[indexBacket].remove(indexElement);
            size--;

            return true;
        }
        return false;
    }

    public boolean contains(T value){
        int indexBacket = getBacket(value);

        for(int i = 0; i < buckets[indexBacket].size(); i++){
            if(buckets[indexBacket].get(i).equals(value)){
                return true;
            }
        }

        return false;
    }

    //Расширение массива бакетов
    public void resize(){
        ArrayList<T>[] oldBuckets = buckets;
        capacity *= 2;
        size = 0;
        buckets = new ArrayList[capacity];
        for(int i = 0; i < capacity; i++){
            buckets[i] = new ArrayList<>();
        }

        for(int i = 0; i < oldBuckets.length; i++){
            for(int j = 0; j < oldBuckets[i].size(); j++){
                add(oldBuckets[i].get(j));
            }
        }
    }

    //Так как хэш код объекта может быть отрицательным, здесь я возвращаю модуль числа
    private int getBacket(T value){
        return Math.abs(value.hashCode() % capacity);
    }

    public int size(){
        return size;
    }
}