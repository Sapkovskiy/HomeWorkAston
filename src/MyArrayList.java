
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**Необходимо написать свою реализацию коллекции ArrayList. Должны быть основные методы add,
 * get, remove, addAll(ДругаяКоллекция параметр), остальное на ваше усмотрение
   Плюс написать реализацию сортировки пузырьком с флагом, который прекращает
   сортировку, если коллекция уже отсортирована.
   Задание с *: На тему дженериков. Для этих коллекций сделать конструктор который
   будет принимать другую коллекцию в качестве параметров и инициализироваться с
   элементами из этой коллекции. Вторая часть - сделать метод сортировки статическим,
   этот метод также будет принимать какую-то коллекцию и сортировать ее.
   (Аналогия Collections.sort()). Т.е подумать на тему какое ключевое слово(extends или super)
   будет лучше применить для этих двух задач.
 */
public class MyArrayList <T> { //создаем класс под неизвестный тип
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

    /**Для этой коллекции сделать конструктор который
     * будет принимать другую коллекцию в качестве
     * параметров и инициализироваться с элементами
     * из этой коллекции.
     */

    public MyArrayList(Collection<? extends T> col) {
        if (col.isEmpty()){
            System.out.println("Коллекция пуста");
        }else {
            for (Object value : col) {
                add((T)value);
            }
        }
    }

    /**Добавление элемента
     */
    public void add(T value) {
        if (index == array.length-1){
            newSize((array.length*INCREASE));
        }
            array[index]= value;
                index++;

    }
    /**Добавление элемента в середину списка
     */
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
    /**Изменение размера коллекции
     */
    public void newSize(int newSize){ // меняем размер массива
        Object[] newArray = new Object[newSize];
//         for (int i = 0; i <= index ; i++) { //первый вариант поверхностного копирования массива
//            newArray[i] = array[i];
//        }
            System.arraycopy(array,0,newArray,0,index); // второй вариант копирования

            array = newArray;
    }
    /**Длинна массива
     */
    public int length(){
        return array.length;
    }
    /**Получение элемента по индексу
     */
    public T get(int index){
        if (index<this.index && index>=0)
            return (T) array[index];
        return null;
    }  // получаем элемент массива
    /**Удаление элементов
     */
    public void remove(int deleteIndex){
        for (int i = deleteIndex; i < index; i++) {
            array[i] = array[i + 1];
        }
        array[index--]=null;

        if (index <array.length/DECREASE){
            newSize(array.length/INCREASE);
        }
    }
    /**Получение количества заполненных элементов массива
     */
    public int size(){
        return index;
    }
    /**Добавление коллекции в нашу коллекцию
     */
    public boolean addAll(Collection<? extends T> c){
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

    /**Добавление коллекции в нашу коллекцию по индексу
     */
    public boolean addAll(int index,Collection<? extends T> c){
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
    /**Реализация сортировки пузырьком для int значений
     */
    public void bubbleSortInteger() {
        try {
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int i = index - 1; i >= 1; i--) {
                    for (int j = 0; j < i; j++) {
                        if ((int) array[j] > (int) array[j + 1]) {
                            toSwap(j, j + 1);
                            flag = true;
                        }
                    }

                }
            }
        }catch (Exception e){
            System.out.println("Коллекция не из целых чисел");
        }
    }
    private void toSwap(int first,int second){
        int temp = (int)array[first];
        array[first]=array[second];
        array[second]=temp;
    }
}