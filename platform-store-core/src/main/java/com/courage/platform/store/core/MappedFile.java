package com.courage.platform.store.core;

public class MappedFile extends ReferenceResource {

    public static final int OS_PAGE_SIZE = 1024 * 4;

    @Override
    public boolean cleanup(long currentRef) {
        return false;
    }

}
