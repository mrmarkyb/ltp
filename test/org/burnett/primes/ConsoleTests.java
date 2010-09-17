package org.burnett.primes;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

public class ConsoleTests {
    public ByteArrayOutputStream outputStream;

    @Before
    public void before() {
        outputStream = new ByteArrayOutputStream(1000);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void writesUsageToOutputWhenNoArguments() {
        Console.main();
        assertEquals(programOutput(), String.format(Console.USAGE + "%n"));
    }

    @Test
    public void writesUsageToOutputWhenNonIntegerArgument() {
        Console.main("foo");
        assertEquals(programOutput(), String.format(Console.USAGE + "%n"));
    }

    @Test
    public void writesUsageToOutputWhenNegativeIntegerArgument() {
        Console.main("-1");
        assertEquals(programOutput(), String.format(Console.USAGE + "%n"));
    }

    @Test
    public void writesUsageToOutputWhenZeroIntegerArgument() {
        Console.main("-1");
        assertEquals(programOutput(), String.format(Console.USAGE + "%n"));
    }

    @Test
    public void writesUsageToOutputWhenIntegerArgumentGreaterThanMax() {
        Console.main(String.format("%d", Console.MAX_INDEX + 1));
        assertEquals(programOutput(), String.format(Console.USAGE + "%n"));
    }

    @Test
    public void writes5167For100thLTP() {
        Console.main("100");
        assertEquals(programOutput(), String.format("5167%n"));
    }

    @Test
    public void writes47For10thLTP() {
        Console.main("10");
        assertEquals(programOutput(), String.format("47%n"));
    }    

    private String programOutput() {
        return outputStream.toString();
    }

}
