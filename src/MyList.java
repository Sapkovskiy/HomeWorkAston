import java.util.Collection;

public interface MyList<T> {

     Object[] toArray();
      <T> T[] toArray(T[] a);
     T get(int index);
     int length();
     boolean add(int ind,T value);
    void add(T value);
    void remove(int deleteIndex);
    public int size();
    boolean addAll(Collection<? extends T> c);
    boolean addAll(int index,Collection<? extends T> c);
    void bubbleSortInteger();

}
