package com.courage.platform.store.core;

import com.courage.platform.store.core.config.MessageStoreConfig;
import com.courage.platform.store.core.config.StorePathConfigHelper;
import com.courage.platform.store.core.domain.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * 默认消息存储
 * Created by zhangyong on 2020/5/10.
 */
public class DefaultMessageStore implements MessageStore {

    private final static Logger logger = LoggerFactory.getLogger(DefaultMessageStore.class);

    private volatile boolean shutdown = true;

    private MessageStoreConfig messageStoreConfig;

    private final TransientStorePool transientStorePool;

    private RandomAccessFile lockFile;

    private FileLock lock;

    public DefaultMessageStore(final MessageStoreConfig messageStoreConfig) throws IOException {
        this.messageStoreConfig = messageStoreConfig;

        this.transientStorePool = new TransientStorePool(messageStoreConfig);

        File file = new File(StorePathConfigHelper.getLockFile(messageStoreConfig.getStorePathRootDir()));
        MappedFile.ensureDirOK(file.getParent());
        lockFile = new RandomAccessFile(file, "rw");
    }

    //先调用load方法
    @Override
    public boolean load() {
        return false;
    }

    //然后调用start方法
    @Override
    public void start() throws Exception {

    }

    @Override
    public void shutdown() {
        this.transientStorePool.destroy();
        if (lockFile != null && lock != null) {
            try {
                lock.release();
                lockFile.close();
            } catch (IOException e) {
            }
        }
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
