package practica1.CircularQ;

import java.util.Arrays;

public class TestCQ {

  public static void main(String[] args) {
    CircularQueue<Integer> q = new CircularQueue<>(5);
    q.put(3);
    q.toString();
    q.put(4);
    q.toString();
    q.get();
    q.toString();
    q.put(5);
    q.toString();
    q.put(8);
    q.toString();
    q.put(9);
    q.toString();
    q.put(1);
    q.toString();
    q.get();
    q.toString();
    q.get();
    q.toString();
    q.get();
    q.toString();
    q.get();
    q.toString();
    q.get();
    q.toString();
    q.get();
    q.toString();
  }
}
