package practica2.P1Sync.Monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorSync {

    private final int N;
    private final ReentrantLock l;
    private final Condition turn;
    private int turnId = 0;
    
    public MonitorSync(int N) {
        this.N = N;
        l = new ReentrantLock();
        turn = l.newCondition();
    }

    public void waitForTurn(int id) {
        l.lock();
        try{
            if (turnId != id){
               turn.awaitUninterruptibly();
            }
            
        }finally{
            l.unlock();
            
        }
    }

    public void transferTurn() {
        l.lock();
        try{
            turnId = (turnId + 1)%N;
            turn.signalAll();
        }finally{
            l.unlock();
        }
    }
   
}
