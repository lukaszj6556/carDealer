package com.retail.ui;

import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
// import org.powermock.api.mockito.PowerMockito;
// import org.powermock.core.classloader.annotations.PrepareForTest;
// import org.powermock.modules.junit4.PowerMockRunner;

import com.retail.ui.ScannerWrapperInterface;

// @RunWith(PowerMockRunner.class)
// @PrepareForTest({ ScannerWrapper.class })
public class ConsoleInteractionImplTest {

    @Test
    public void testReadStringPositive() throws Exception {
        // given
        ScannerWrapperInterface scannerMock = Mockito.mock(ScannerWrapperInterface.class);
        // PowerMockito.whenNew(ScannerWrapper.class).withAnyArguments().thenReturn(scannerMock);
        when(scannerMock.readString()).thenReturn("some string");
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl(scannerMock);

        // when
        String readString = consoleInteractionImpl.readString("testReadStringPositive");
        // then
        Assert.assertNotNull(readString);
    }

    /**
     * @throws Exception
     */
    @Test
    public void readStringNegative() throws Exception {
        // given
        ScannerWrapperInterface scannerMock = Mockito.mock(ScannerWrapperInterface.class);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl(scannerMock);
        // PowerMockito.whenNew(ScannerWrapper.class).withAnyArguments().thenReturn(scannerMock);

        // when
        String readString = consoleInteractionImpl.readString("Some text");
        // then
        Assert.assertTrue(readString == null);
    }

    @Test
    public void readNumberPositive() throws Exception {
        // given
        ScannerWrapperInterface scannerMock = Mockito.mock(ScannerWrapperInterface.class);
        when(scannerMock.readInt()).thenReturn(23);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl(scannerMock);
        // PowerMockito.whenNew(ScannerWrapper.class).withNoArguments().thenReturn(scannerMock);

        // when
        int readNumber = consoleInteractionImpl.readNumber("Some text");
        // then
        Assert.assertNotEquals(readNumber, 0);
    }

    /**
     * @throws Exception
     */
    @Test
    public void readNumberNegative() throws Exception {
        // given
        ScannerWrapperInterface scannerMock = Mockito.mock(ScannerWrapperInterface.class);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl(scannerMock);
        // PowerMockito.whenNew(ScannerWrapper.class).withNoArguments().thenReturn(scannerMock);

        // when
        int readNumber = consoleInteractionImpl.readNumber("Some text");
        // then
        Assert.assertEquals(readNumber, 0);
    }

    @Test
    public void readFloatPositive() throws Exception {
        // given
        ScannerWrapperInterface scannerMock = Mockito.mock(ScannerWrapperInterface.class);
        when(scannerMock.readFloat()).thenReturn(2.5f);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl(scannerMock);
        // PowerMockito.whenNew(ScannerWrapper.class).withNoArguments().thenReturn(scannerMock);

        // when
        float readFloat = consoleInteractionImpl.readFloatNumber("Some text");
        // then
        Assert.assertEquals(readFloat, 2.5f, 0.0f);
    }

    /**
     * @throws Exception
     */
    @Test
    public void readFloatNegative() throws Exception {
        // given
        ScannerWrapperInterface scannerMock = Mockito.mock(ScannerWrapperInterface.class);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl(scannerMock);
        // PowerMockito.whenNew(ScannerWrapper.class).withNoArguments().thenReturn(scannerMock);

        // when
        float readFloat = consoleInteractionImpl.readFloatNumber("Some text");
        // then
        Assert.assertEquals(readFloat, 0.0f, 0.0f);
    }

}
