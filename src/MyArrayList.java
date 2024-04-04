import java.util.ArrayList;

public class MyArrayList <T>{
    private Object[] array = new Object[INITIAL_SIZE];
    private static final int INITIAL_SIZE = 10;
    private static final int DEFAULT_VALUE = 0;
    public int index = 0;

    public static void main(String[] args) {

    }
    public void add(T value) {
        if (index == array.length-1){
            newSize((array.length*2));
        }
            array[index]= value;
                index++;

    }
    public void newSize(int newSize){
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
    }
    public void remove(int deleteIndex){
        for (int i = deleteIndex; i < index; i++) {
            array[i]=array[i+1];
            array[index]=null;
            index--;
        }
        if (index <array.length/4){
            newSize((int)(array.length/2));
        }
    }

}