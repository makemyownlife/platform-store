package com.courage.platform.store.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MappedFileQueueUnitTest {

    @Test
    public void testGetLastMappedFile() {
        final String fixedMsg = "0123456789abcdef";

        MappedFileQueue mappedFileQueue = new MappedFileQueue("target/unit_test_store/a/", 1024, null);

        for (int i = 0; i < 3; i++) {
            MappedFile mappedFile = mappedFileQueue.getLastMappedFile(0);
            assertThat(mappedFile).isNotNull();
            assertThat(mappedFile.appendMessage(fixedMsg.getBytes())).isTrue();
        }

        mappedFileQueue.shutdown(1000);
        mappedFileQueue.destroy();
    }

}
