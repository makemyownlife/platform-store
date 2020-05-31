package com.courage.platform.store.core;

import org.junit.Test;

public class MappedFileQueueUnitTest {

    @Test
    public void testGetLastMappedFile() {
        final String fixedMsg = "0123456789abcdef";

        MappedFileQueue mappedFileQueue = new MappedFileQueue("target/unit_test_store/a/", 1024);

    }

}
