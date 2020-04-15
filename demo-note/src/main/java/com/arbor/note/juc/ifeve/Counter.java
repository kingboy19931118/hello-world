package com.arbor.note.juc.ifeve;

/**
 * com.arbor.note.juc.ifeve.Counter
 *
 * @author Joem
 * @date 2020-03-17
 * @since v2.0.0
 */
/**
 * 计数器
 */
public interface Counter {
    /**
     * 取出统计数据，用Saver去持久化(仅定时器会调用，无并发)
     * @param saver
     */
    void save(Saver saver);

    /**
     * 计数(有并发)
     * @param key 业务ID
     * @param like 点赞
     * @param comment 评论
     */
    void add(String key, int like, int comment);

    /**
     * 持久化器，将数量持久化到数据库等
     */
    @FunctionalInterface
    interface Saver{
        void save(String key, int like, int comment);
    }
}