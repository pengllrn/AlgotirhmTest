package com.example.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Pengllrn
 * @since <pre>2019/7/31 14:17</pre>
 */
public class AQS extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        int state = getState();
        acquire(1);
        return super.tryAcquire(arg);
    }


}
