package com.arbor.note.concurrent;

/**
 * com.arbor.note.concurrent.IThreadPool
 *
 * @author Joem
 * @date 2020-10-14
 * @since v2.0.0
 */
public interface IThreadPool {

    void execute(Runnable runnable);
}
