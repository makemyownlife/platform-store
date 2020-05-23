package com.courage.platform.store.core;

import com.courage.platform.store.core.config.MessageStoreConfig;
import com.courage.platform.store.core.domain.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认消息存储
 * Created by zhangyong on 2020/5/10.
 */
public class DefaultMessageStore implements MessageStore {

    private final static Logger logger = LoggerFactory.getLogger(DefaultMessageStore.class);

    private MessageStoreConfig messageStoreConfig;

    private final TransientStorePool transientStorePool = null;

    public DefaultMessageStore(final MessageStoreConfig messageStoreConfig) {
        this.messageStoreConfig = messageStoreConfig;
    }

    @Override
    public boolean load() {
        return false;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public PutMessageResult putMessage(Message message) {
        return null;
    }

    //============================================================== get set method start ===========================================================

    public MessageStoreConfig getMessageStoreConfig() {
        return this.messageStoreConfig;
    }

    public TransientStorePool getTransientStorePool() {
        return transientStorePool;
    }


    //============================================================== get set method end  ===========================================================

}
