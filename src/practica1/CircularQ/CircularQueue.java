package practica1.CircularQ;

import java.util.Iterator;
import util.Queue;

public class CircularQueue<E> implements Queue<E> {

    private final E[] queue;
    private final int N;
    protected int P = 0;
    protected int G = 0;
    protected int n = 0;

    public CircularQueue(int N) {
        this.N = N;
        queue = (E[]) (new Object[N]);
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public int free() {
        return N-n;
    }

    @Override
    public boolean empty() {
        return  n==0 ;
    }

    @Override
    public boolean full() {
        return n==N;
    }

    @Override
    public E peekFirst() {
        String res = new String();
        if (empty()){
            throw new IllegalStateException("la cua esta buida");
        }
        else{
            res = res + queue[G];
            System.out.println("El primer valor es: "+res);
            return queue[G]; 
        }
    }

    @Override
    public E get() {
        if (empty()){
            throw new IllegalStateException("la cua esta buida");
        }
        
        else{
            E aux = queue[G];
            queue[G] = null;
            G = (G+1)%N;
            n=n-1;
            return aux; 
        }
    }

    @Override
    public void put(E e) {
        if (full()){
            throw new IllegalStateException("la cua esta plena");
        }
        else{
            queue[P]=e;
            P = (P+1)%N;
            n=n+1;
        }
    }

    @Override
    public String toString() {
        String res = new String();
        int i;
        for (i=G; i<G+n; i++){
            if(i<G+n-1){
                res = res + queue[i%N] + ", ";
            }
            else{
            res = res + queue[i%N];
            }
        }
        System.out.println("["+res+"]");
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator {

        int i=0;
        boolean utilitzat;
        
        @Override
        public boolean hasNext() {
            return i<n;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new IllegalStateException("No hi ha mes elements per iterar");
            }
            else{
                E aux = queue[(G+i)%N];
                i=i+1;
                utilitzat=true;
                return aux;
            }
            
        }

        @Override
        public void remove() {
            if (utilitzat){
                i=i-1;
                for (int j=i; j<n; j++){
                    queue[(j+G)%N]=queue[(j+G+1)%N];
                
                }
                P=(P-1)%N;
                n=n-1;
                
            }
            else{
                throw new IllegalStateException("Abans d'un remove cal usar un next");
                
            }
        }

    }
}
