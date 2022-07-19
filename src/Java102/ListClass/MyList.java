package Java102.ListClass;

public class MyList<T> {
    private T[] array;

    // Boş contructor kullanılırsa dizinin başlangıç kapasitesi 10 olur.
    public MyList() {
        this.array = (T[]) new Object[10];
    }

    // Dizinin başlangıç değeri capacity parametresinden alma.
    public MyList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    // Dizideki eleman sayısını döndürme.
    public int size() {
        int size = 0;
        for (T i : array) {
            if (i != null) {
                size++;
            }
        }
        return size;
    }

    // Dizinin kapasite değerini döndürme.
    public int getCapacity() {
        return this.array.length;
    }

    // Sınıfa ait diziye eleman ekleme, Dizide yeterli yer yoksa, dizi boyutunu 2 katına çıkarma.
    public void add(T value) {
        if (this.size() == this.getCapacity()) {
            T[] newArray = (T[]) new Object[this.getCapacity() * 2];
            System.arraycopy(this.array, 0, newArray, 0, this.array.length);
            this.array = newArray;
        }
        this.array[this.size()] = value;
    }

    // İndeksteki değeri döndürme, geçersiz index girilerse null döndürme.
    public T get(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        return this.array[index];
    }

    // Parametresi verilen nesnenin listedeki indeksini bulma. Nesne listede yoksa -1 değerini döndürme.
    public T remove(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        T remove = this.array[index];

        if (this.size() - 1 - index >= 0)
            System.arraycopy(this.array, index + 1, this.array, index, this.size() - 1 - index);
        this.array[this.size() - 1] = null;
        return remove;
    }

    // İndisteki veriyi yenisi ile değiştirme işlemi, geçersiz index girilerse null döndürme.
    public T set(int index, T value) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        T old = this.array[index];
        this.array[index] = value;
        return old;
    }

    // Sınıfa ait dizideki elemanları listeleme.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T i : array) {
            if (i != null) {
                sb.append(i).append(" ");
            }
        }
        return sb.toString();
    }

    // Parametresi verilen nesnenin listedeki indeksini bulma. Nesne listede yoksa -1 değerini döndürme.
    public int indexOf(T value) {
        for (int i = 0; i < this.size(); i++) {
            if (this.array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    // Belirtilen öğenin listedeki son indeksini bulma. Nesne listede yoksa -1 değerini döndürme.
    public int lastIndexOf(T value) {
        for (int i = this.size() - 1; i >= 0; i--) {
            if (this.array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    // Listenin boş olup olmadığını kontrol etme.
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // Listedeki tüm öğeleri, aynı sıra ile yeni bir array haline getirme.
    public T[] toArray() {
        T[] newArray = (T[]) new Object[this.size()];
        if (this.size() >= 0) System.arraycopy(this.array, 0, newArray, 0, this.size());
        return newArray;
    }

    // Listedeki tüm öğeleri silme.
    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.array[i] = null;
        }
    }

    // Parametrede verilen index aralığına ait yeni bir liste döndürme.
    public MyList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= this.size() ||
                toIndex < 0 || toIndex >= this.size() || fromIndex > toIndex) {
            return null;
        }
        MyList<T> newList = new MyList<>(toIndex - fromIndex);
        for (int i = fromIndex; i <= toIndex; i++) {
            newList.add(this.array[i]);
        }
        return newList;
    }

    // Parametrede verilen değerin dizide olup olmadığını sorgulama.
    public boolean contains(T value) {
        for (int i = 0; i < this.size(); i++) {
            if (this.array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}