public class Example {
    public static void main(String[] args) {
        MyArrayList<Object> a = new MyArrayList<>(); // создали обьект класса для проверки работоспособности
        a.add("Start");  //добавили строку

        for (int i = 1; i <= 13; i++) {
            a.add(i); // добавили числа
        }
        a.add("end");

        System.out.println("Длинна коллекции после расширения= "+a.length()); // проверка длинны

        a.remove(1); //удаляем элемент под индексом 5

        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.get(i)+" "); // выводим все элементы после удаления одного
        }
        System.out.println();
        for (int i = 1; a.get(i)!=null; ) { // удаляем все элементы кроме первого
            a.remove(i);
        }
        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.get(i)+ " "); // выводим оставшийся элемент
        }
        System.out.println("\n"+"Длинна коллекции = "+a.length()); // минимальная длинна массива
        System.out.println("Количество заполненных ячеек = "+a.size());
    }

}
