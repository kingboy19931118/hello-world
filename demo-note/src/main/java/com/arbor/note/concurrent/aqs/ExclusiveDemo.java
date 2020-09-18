package com.arbor.note.concurrent.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * com.arbor.note.concurrent.aqs.ExclusiveDemo
 *
 * @author Joem
 * @date 2020-09-18
 * @since v2.0.0
 */
public class ExclusiveDemo implements Lock {

    // 自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {

        // 是否处于独占状态
        @Override
        protected boolean isHeldExclusively() {
            return this.getState() == 1;
        }

        // 当前状态为0时，获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 释放锁，将线程清空，状态设置为0
        @Override
        protected boolean tryRelease(int arg) {
            // 未持有锁
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 返回一个Condition， 每个Condition 都包含一个 Condition队列
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    /**
     * ExclusiveDemo 类的 Sync 对象
      */
    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(0);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
