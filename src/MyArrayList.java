import java.util.ArrayList;

public class MyArrayList <T>{ //создаем класс под неизвестный тип
    private Object[] array = new Object[INITIAL_SIZE]; // создаем массив
    private static final int INITIAL_SIZE = 10; // задаем начальный размер массива
    public int index = 0; // задаем начальное количество вещественных элементов массива

    private static final int DECREASE = 3; // порог уменьшения массива
    private static final int INCREASE =2; // во сколько раз увеличивать размер массива при заполнении
    public void add(T value) {
        if (index == array.length-1){
            newSize((array.length*INCREASE));
        }
            array[index]= value;
                index++;

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
        return (T)array[index];
    }  // получаем элемент массива
    public void remove(int deleteIndex){
        for (int i = deleteIndex; i < index; i++) {
            array[i] = array[i + 1];
        }
        array[index--]=null;

        if (index <array.length/DECREASE){
            newSize(array.length/2);
        }
    }
    public int size(){
        return index;
    }

}