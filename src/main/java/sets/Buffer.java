package sets;

import java.util.Iterator;

public class Buffer<T> implements Iterable<T>{
    Node first;
    Node last;
    int N;

    public Buffer (){               //конструктор (!)
        first = null;
        last = null;
        N = 0;
    }

    public void enque (T item){           //добавление элемента (!)
        N++;
        Node tmp = last;
        last = new Node();
        last.item = item;
        if (first == null) {
            first = last;
        }else{
            last.prev = tmp;
        }
    }

    public void remove(T item){           //удаление определенного элемента (!)
        if (last.item == item){
            last = last.prev;
        } else {
            boolean b = true;
            Node counter = last;
            Node tmp;
            while (b){
                if (counter != first){
                    if (counter.prev.item == item) {
                        tmp = counter;
                        counter = counter.prev;
                        tmp.prev = counter.prev;
                        b = false;
                    } else counter = counter.prev;
                } else b = false;
            }
        }

    }

    public boolean isEmpty(){                           //Пуста ли очередь (!)
        return first == null;
    }

    public int size(){                                  //количество элементов в очереди (!)
        return N;
    }

    public void setEnterFalse(T item){
    }

    public void setFree (T item){                   //установка значения (!)
        Node counter = last;
        boolean b = true;
        while (b) {
            if (counter.item == item) {
                counter.isFree = true;
                b = false;
            } else if (counter.prev != null){
                counter = counter.prev;
            }
        }
    }

    public int noFreeSize(){                         // (Количество несвободных элементов)
        boolean b = true;
        int cnt = 0;
        Node counter = last;
        while (b){
            if (!counter.isFree){
                cnt++;
                if (counter.prev != null){
                    counter = counter.prev;
                } else b = false;
            }
        }
        cnt = size() - cnt;
        return cnt;
    }

    public T dequeue (){                 //удаление самого старого элемента (!)
        N--;
        boolean b = true;
        T result = first.item;
        Node counter = last;
        if (counter != first) {
            while (counter.prev != first) {
                counter = counter.prev;
            }
        } else {
            first = null;
        }
        first = counter;
        first.prev = null;
        return result;
    }

    @Override
    public Iterator<T> iterator() {                 // (!)
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
//                return (last != first);       //Пропускає останній елемент
//                return (first != null);       //Бескінечний цикл
//                return (last != null);
                return N != 0;
            }

            @Override
            public T next() {
                return dequeue();
            }
        };
    }

    private class Node{                             // (!)
        T item;
        Node prev;
        boolean isFree;
        Node (){
            item = null;
            prev = null;
            isFree = false;
        }
    }
}

