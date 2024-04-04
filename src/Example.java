public class Example {
    public static void main(String[] args) {
        MyArrayList<Object> a = new MyArrayList<>(); // создали обьект класса для проверки работоспособности
        a.add("Start");  //добавили строку

        for (int i = 1; i <= 13; i++) {
            a.add(i); // добавили числа
        }
        a.add("end");
//        for (int i = 0; i < a.length(); i++) {
//            System.out.println(a.get(i)); // выводим все элементы
//        }
        System.out.println("Длинна массива = "+a.length()); // проверка длинны

        a.remove(5); //удаляем элемент под индексом 5

        for (int i = 0; i < a.length(); i++) {
            System.out.println(a.get(i)); // выводим все элементы после удаления
        }
        for (int i = 2; i < a.length()-2; i++) {
            a.remove(i);
        }
        System.out.println("Длинна массива = "+a.length());
    }

}
