import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        MyArrayList<Object> a = new MyArrayList<>(); // создали обьект класса для проверки работоспособности
        a.add("Start");  //добавили строку

        for (int i = 1; i <= 13; i++) {
            a.add(i); // добавили числа
        }
        a.add("end");

        System.out.println("Длинна коллекции после расширения= "+a.length()); // проверка длинны

        a.remove(1); //удаляем элемент под индексом 1

        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.get(i)+" "); // выводим все элементы после удаления одного
        }
        System.out.println();
        for (int i = 4; a.get(i)!=null; ) { // удаляем все элементы кроме первого
            a.remove(i);
        }
        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.get(i)+ " "); // выводим оставшийся элемент
        }
        System.out.println("\n"+"Длинна коллекции = "+a.length()); // минимальная длинна массива
        System.out.println("Количество заполненных ячеек = "+a.size());
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(999);
        a2.add(842);
        a.addAll(a2);
        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.get(i)+ " "); // выводим оставшийся элемент
        }
        System.out.println("\n"+"Длинна коллекции = "+a.length());
        a.add(2,10);
        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.get(i)+ " "); // выводим оставшийся элемент
        }
        System.out.println();
        MyArrayList<Object> a3 = new MyArrayList<>();
        for (int i = 10; i <= 12; i++) {
            a3.add(i); // добавили числа
        }
        a3.add(1,25);
        a3.add(1,35);
        for (int i = 0; i < a3.length(); i++) {
            System.out.print(a3.get(i)+" "); // выводим все элементы перед сортировкой
        }
        a3.bubbleSortInteger();
        System.out.println();
        for (int i = 0; i < a3.length(); i++) {
            System.out.print(a3.get(i)+" "); // выводим все элементы после сортировки
        }


        ArrayList<Integer> a4 = new ArrayList<>();
        a4.add(999);
        a4.add(842);
        a4.add(14);
        a4.add(43);
        MyArrayList<Integer> a5 =new MyArrayList<>(a4);
        System.out.println("\n Получаем число под индексом 2 = "+a5.get(2));
    }
}
