package com.arbor.note.proxy;

import java.lang.reflect.Method;

/**
 * @author qiaomu.wang
 * @date 2018-12-18
 */
public interface InvocationHandler {
    void invoke(Object proxy, Method method, Object[] args);
}
