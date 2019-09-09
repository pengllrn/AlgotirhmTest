package com.example.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Pengllrn
 * @since <pre>2019/7/31 16:55</pre>
 */
public class MutexLock implements Lock {
    private final AQS aqs = new AQS();
    @Override
    public void lock() {
        aqs.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        aqs.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return aqs.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return aqs.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        aqs.release(1);
    }

    @Override
    public Condition newCondition() {
        return aqs.newCondition();
    }

    //同步器是否被占有
    public boolean isLocked(){
        return aqs.isHeldExclusively();
    }

    //同步队列中是否有线程
    public boolean hasQueuedThreads(){
        return aqs.hasQueuedThreads();
    }

    private static class AQS extends AbstractQueuedSynchronizer {
        //是否处于占有状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        //当状态为0的时候获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //释放锁，将状态设置为0
        @Override
        protected boolean tryRelease(int arg) {
            if(getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //返回一个Condition，每个condition都包含了一个condition队列
        protected Condition newCondition(){
            return new ConditionObject();
        }
    }

}
