package com.dongdong.service;

/**
 * 代理接口。处理给定名字的任务。
 */
public interface Subject {
    /**
     * 执行给定名字的任务。
     * @param taskName 任务名
     */
    void dealTask(String taskName);
}
