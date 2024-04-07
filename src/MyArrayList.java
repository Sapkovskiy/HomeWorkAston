
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MyArrayList <T>{ //создаем класс под неизвестный тип
    private Object[] array = new Object[INITIAL_SIZE]; // создаем массив
    private static final int INITIAL_SIZE = 10; // задаем начальный размер массива
    public int index = 0; // задаем начальное количество вещественных элементов массива

    private static final Object[] EMPTY = {};
    public Object[] elementData;
    private static final int DECREASE = 2; // порог уменьшения массива
    private static final int INCREASE =2; // во сколько раз изменить размер массива при заполнении или уменьшении

    public MyArrayList() {
        this.elementData = EMPTY;
    }
    public MyArrayList(Collection<? extends T> col) {
        Object[] a = col.toArray();
        if ((index = a.length) != 0) {
            if (col.getClass() == ArrayList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, index, Object[].class);
            }
        } else {
            elementData = EMPTY;
        }
    }


    public Object[] toArray() {
        return Arrays.copyOf(elementData, index);
    }


    public void add(T value) {
        if (index == array.length-1){
            newSize((array.length*INCREASE));
        }
            array[index]= value;
                index++;

    }
    public boolean add(int ind,T value){
        if (ind<0){
            return false;
        }
        if (index == array.length-1){
            newSize((array.length*INCREASE));
        }
        if (ind>index){
            ind=index;
        }
        for (int i = index; i >=ind ; i--) {
            array[i+1]= array[i];

        }
        array[ind]= value;
        index++;
        return true;
    }
    public void newSize(int newSize){ // меняем размер массива
        Object[] newArray = new Object[newSize];
//         for (int i = 0; i <= index ; i++) { //первый вариант поверхностного копирования массива
//            newArray[i] = array[i];
//        }
            System.arraycopy(array,0,newArray,0,index); // второй вариант копирования

            array = newArray;
    }
    public int length(){
        return array.length;
    }
    public T get(int index){
        if (index<this.index && index>=0)
            return (T) array[index];
        return null;
    }  // получаем элемент массива
    public void remove(int deleteIndex){
        for (int i = deleteIndex; i < index; i++) {
            array[i] = array[i + 1];
        }
        array[index--]=null;

        if (index <array.length/DECREASE){
            newSize(array.length/INCREASE);
        }
    }
    public int size(){
        return index;
    }
    public boolean addAll(Collection c){
        if (c==null){
            return false;
        }
        if (c.isEmpty()){
            return false;
        }
        for (Object value:c) {
            add((T) value);
        }
        return true;
    }
    public boolean addAll(int index,Collection c){
        if (c==null){
            return false;
        }
        if (c.isEmpty()|| index<0){
            return false;
        }
        if (index>this.index){
            index=this.index;
        }
        for (Object value:c) {
            add(index++,(T)value);
        }
        return true;
    }
    public void bubbleSortInteger(){
        boolean flag=true;
        while (flag){
            flag = false;
            for (int i = index-1; i >=1; i--) {
                for (int j = 0; j < i; j++) {
                    if ((int)array[j] > (int)array[j+1]){
                        toSwap(j,j+1);
                        flag = true;
                    }
                }

            }
        }
    }
    private void toSwap(int first,int second){
        int temp = (int)array[first];
        array[first]=array[second];
        array[second]=temp;
    }
}