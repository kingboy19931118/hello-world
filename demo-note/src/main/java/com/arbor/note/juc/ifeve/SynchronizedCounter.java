package com.arbor.note.juc.ifeve;

import java.util.HashMap;

/**
 * com.arbor.note.juc.ifeve.SynchronizedCounter
 *
 * /**
 *  * 直接对所有操作上锁，来保证线程安全
 *  * 简单分析可知，计数器比较简单，用AtomicInteger便能保证原子性，但考虑到计数器会被回收，则可能会出现这样的场景：某计数器已被回收了，此时继续在该计数器上计数，便会造成数据丢失，因此要处理该并发问题
 *  *
 *  *         解决方案
 *  *         方案一
 *  *         使用原生锁来解决竞争问题
 *  *
 *
 * @author Joem
 * @date 2020-03-17
 * @since v2.0.0
 */
public class SynchronizedCounter implements Counter{
    private HashMap<String, Adder> map = new HashMap<>();

    @Override
    public synchronized void save(Saver saver) {
        //因为已加锁，所以可以安全地取数据
        map.forEach((key, value) -> {
            saver.save(key, value.like, value.comment);
        });
        map = new HashMap<>();
    }

    @Override
    public synchronized void add(String key, int like, int comment) {
        //因为已加锁，所以可以安全地更新数据
        Adder adder = map.computeIfAbsent(key, x -> new Adder());
        adder.like += like;
        adder.comment += comment;
    }

    static class Adder {
        private int like;
        private int comment;
    }
}
