package practica1.LinkedQ;

import java.util.Iterator;
import util.Queue;

public class LinkedQueue<E> implements Queue<E> {

   private Node<E> primer;
   private Node<E> ultim;
   private int numElem;
            
    
  

  @Override
  public int size() {
    return numElem;
  }

  @Override
  public int free() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean empty() {
    return numElem==0;
  }

  @Override
  public boolean full() {
    return false;
  }

  @Override
  public E peekFirst() {
      return primer.getValue();
    
  }

  @Override
  public E get() {
    if(empty()){
        throw new IllegalStateException("la cua esta buida"); 
    }
    else{
        E aux;
        aux = primer.getValue();
        primer = primer.getNext();
        numElem = numElem - 1;
        return aux;
    }
  }

  @Override
  public void put(E e) {
      Node<E> nou_node = new Node();
      nou_node.setValue(e);
      nou_node.setNext(null);
      if(empty()){
          primer = ultim = nou_node;
      }
      else{
          ultim.setNext(nou_node);
          ultim = nou_node;
      }
      numElem = numElem + 1;
      
  }


  @Override
  public String toString() {
     String res = "[";
     Node<E> aux = primer;
     if(empty()){
         System.out.println("La cua esta buida");
     }
     
     for(int i=0; i<numElem; i++){
         res = res + aux.getValue();
         aux = aux.getNext();
         if(i < numElem -1){
             res = res + ",";
         }
     }
     res = res +"]";
     return res;
  }

  @Override
  public Iterator<E> iterator() {
    return new MyIterator();
  }

  class MyIterator implements Iterator {

    Node<E> iter = primer;
    Node<E> previ = null;
    boolean utilitzat;
    
    @Override
    public boolean hasNext() {
        return iter != ultim;
    }

    @Override
    public E next() {
      if (!hasNext()){
                throw new IllegalStateException("No hi ha mes elements per iterar");
            }
      else{
        E aux = iter.getValue();
        previ = iter;
        iter = iter.getNext();
        utilitzat = true;
        return aux;          
      }
    }

    @Override
    public void remove() {
      if(utilitzat){
          
          
      }
    }

  }
}
