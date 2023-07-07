package com.retail.ui;

import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Scanner.class })
public class ConsoleInteractionImplTest {

    @Before
    public void Setup() {

    }

    @Test
    public void testReadStringPositive() throws Exception {
        // given
        Scanner scannerMock = Mockito.mock(Scanner.class);
        when(scannerMock.next()).thenReturn("some string");
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl();
        PowerMockito.whenNew(Scanner.class).withNoArguments().thenReturn(scannerMock);

        // when
        String readString = consoleInteractionImpl.readString("Some text");
        // then
        Assert.assertTrue(readString == notNull());
    }

    /**
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void readStringNegative() throws Exception {
        // given
        Scanner scannerMock = Mockito.mock(Scanner.class);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl();
        PowerMockito.whenNew(Scanner.class).withNoArguments().thenReturn(scannerMock);

        // when
        String readString = consoleInteractionImpl.readString("Some text");
        // then
    }

    @Test
    public void readNumberPositive() throws Exception {
        // given
        Scanner scannerMock = Mockito.mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(23);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl();
        PowerMockito.whenNew(Scanner.class).withNoArguments().thenReturn(scannerMock);

        // when
        int readNumber = consoleInteractionImpl.readNumber("Some text");
        // then
        Assert.assertNotEquals(readNumber, 0);
    }

    /**
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void readNumberNegative() throws Exception {
        // given
        Scanner scannerMock = Mockito.mock(Scanner.class);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl();
        PowerMockito.whenNew(Scanner.class).withNoArguments().thenReturn(scannerMock);

        // when
        String readString = consoleInteractionImpl.readString("Some text");
    }

    @Test
    public void readFloatPositive() throws Exception {
        // given
        Scanner scannerMock = Mockito.mock(Scanner.class);
        when(scannerMock.nextFloat()).thenReturn(2.5f);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl();
        PowerMockito.whenNew(Scanner.class).withNoArguments().thenReturn(scannerMock);

        // when
        float readFloat = consoleInteractionImpl.readFloatNumber("Some text");
        // then
        Assert.assertNotEquals(readFloat, 0);
    }

    /**
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void readFloatNegative() throws Exception {
        // given
        Scanner scannerMock = Mockito.mock(Scanner.class);
        ConsoleInteractionImpl consoleInteractionImpl = new ConsoleInteractionImpl();
        PowerMockito.whenNew(Scanner.class).withNoArguments().thenReturn(scannerMock);

        // when
        String readString = consoleInteractionImpl.readString("Some text");
        // then
    }

}
