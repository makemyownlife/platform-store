package com.courage.platform.store.core.config;

import com.courage.platform.store.core.domain.annotation.ImportantField;

import java.io.File;

public class MessageStoreConfig {

    //The root directory in which the log data is kept
    @ImportantField
    private String storePathRootDir = System.getProperty("user.home") + File.separator + "platform" + File.separator + "store";

    // CommitLog file size,default is 1G
    private int mappedFileSizeCommitLog = 1024 * 1024 * 1024;

    @ImportantField
    private FlushDiskType flushDiskType = FlushDiskType.ASYNC_FLUSH;

    // CommitLog flush interval
    // flush data to disk
    @ImportantField
    private int flushIntervalCommitLog = 500;

    // Only used if TransientStorePool enabled
    // flush data to FileChannel
    @ImportantField
    private int commitIntervalCommitLog = 200;

    @ImportantField
    private int fileReservedTime = 72;

    // The maximum size of message,default is 4M
    private int maxMessageSize = 1024 * 1024 * 4;

    // Whether check the CRC32 of the records consumed.
    // This ensures no on-the-wire or on-disk corruption to the messages occurred.
    // This check adds some overhead,so it may be disabled in cases seeking extreme performance.
    private boolean checkCRCOnRecover = true;

    private boolean warmMapedFileEnable = false;

    @ImportantField
    private boolean transientStorePoolEnable = false;

    private int transientStorePoolSize = 5;

    private boolean fastFailIfNoBufferInStorePool = false;

    // Flush page size when the disk in warming state
    private int flushLeastPagesWhenWarmMapedFile = 1024 / 4 * 16;

    public String getStorePathRootDir() {
        return storePathRootDir;
    }

    public void setStorePathRootDir(String storePathRootDir) {
        this.storePathRootDir = storePathRootDir;
    }

    public int getMappedFileSizeCommitLog() {
        return mappedFileSizeCommitLog;
    }

    public void setMappedFileSizeCommitLog(int mappedFileSizeCommitLog) {
        this.mappedFileSizeCommitLog = mappedFileSizeCommitLog;
    }

    public int getFlushIntervalCommitLog() {
        return flushIntervalCommitLog;
    }

    public void setFlushIntervalCommitLog(int flushIntervalCommitLog) {
        this.flushIntervalCommitLog = flushIntervalCommitLog;
    }

    public int getCommitIntervalCommitLog() {
        return commitIntervalCommitLog;
    }

    public void setCommitIntervalCommitLog(int commitIntervalCommitLog) {
        this.commitIntervalCommitLog = commitIntervalCommitLog;
    }

    public int getFileReservedTime() {
        return fileReservedTime;
    }

    public void setFileReservedTime(int fileReservedTime) {
        this.fileReservedTime = fileReservedTime;
    }

    public int getMaxMessageSize() {
        return maxMessageSize;
    }

    public void setMaxMessageSize(int maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }

    public boolean isCheckCRCOnRecover() {
        return checkCRCOnRecover;
    }

    public void setCheckCRCOnRecover(boolean checkCRCOnRecover) {
        this.checkCRCOnRecover = checkCRCOnRecover;
    }

    public boolean isTransientStorePoolEnable() {
        return transientStorePoolEnable;
    }

    public void setTransientStorePoolEnable(boolean transientStorePoolEnable) {
        this.transientStorePoolEnable = transientStorePoolEnable;
    }

    public int getTransientStorePoolSize() {
        return transientStorePoolSize;
    }

    public void setTransientStorePoolSize(int transientStorePoolSize) {
        this.transientStorePoolSize = transientStorePoolSize;
    }

    public boolean isFastFailIfNoBufferInStorePool() {
        return fastFailIfNoBufferInStorePool;
    }

    public void setFastFailIfNoBufferInStorePool(boolean fastFailIfNoBufferInStorePool) {
        this.fastFailIfNoBufferInStorePool = fastFailIfNoBufferInStorePool;
    }

    public FlushDiskType getFlushDiskType() {
        return flushDiskType;
    }

    public void setFlushDiskType(FlushDiskType flushDiskType) {
        this.flushDiskType = flushDiskType;
    }

    public void setFlushDiskType(String type) {
        this.flushDiskType = FlushDiskType.valueOf(type);
    }

    public boolean isWarmMapedFileEnable() {
        return warmMapedFileEnable;
    }

    public void setWarmMapedFileEnable(boolean warmMapedFileEnable) {
        this.warmMapedFileEnable = warmMapedFileEnable;
    }

    public int getFlushLeastPagesWhenWarmMapedFile() {
        return flushLeastPagesWhenWarmMapedFile;
    }

    public void setFlushLeastPagesWhenWarmMapedFile(int flushLeastPagesWhenWarmMapedFile) {
        this.flushLeastPagesWhenWarmMapedFile = flushLeastPagesWhenWarmMapedFile;
    }
    
}
