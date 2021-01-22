package nl.fhict.s3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Opdracht1Test {

    /**
     * Opdracht 1.a
     */
    @Test
    public void outOfMemoryErrorHeapTest() throws Exception {
        // Arrange
        int iteratorValue = 20;
        // Act
        try {
            System.out.println("\n=================> OOM test started..\n");
            for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
                System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
                int loop1 = 2;
                long[] memoryFillIntVar = new long[iteratorValue];
                // feel memoryFillIntVar array in loop..
                do {
                    memoryFillIntVar[loop1] = 0;
                    loop1--;
                } while (loop1 > 0);
                iteratorValue = iteratorValue * 5;
                System.out.println("\nRequired Memory for next loop: " + iteratorValue);

            }
        }
            // Assert
            catch(OutOfMemoryError e){
                assertEquals("java.lang.OutOfMemoryError: Java heap space", e.toString());
            }

    }

    /**
     * Opdracht 1.b
     */
    @Test
     public void stackOverflowTest() {
        try{
            ErrorMethods error = new ErrorMethods();
            error.iets();
        }
        catch(StackOverflowError e){
            assertEquals("java.lang.StackOverflowError", e.toString());
        }

    }

    /**
     * Opdracht 1.c - Verklaring: Bij de eerste komt het net over 1 heen maar omdat het een float is wordt die naar beneden afgerond.
     * Dus 1. Waardoor de test slaagt. Geen van beiden komen precies op 1 uit maar dit heeft dus te maken met dat hier een float wordt gebruikt.
     */
    @Test
    public void fourtyTwo() {
        // Arrange
        int i = 42;
        float f = 1f / i;

        // Act
        float actual = i * f;

        // Assert
        assertEquals(1f, actual);
    }

    @Test
    public void fourtyOne() {
        // Arrange
        double i = 41;
        double f = 1f / i;

        // Act
        double actual = i * f;

        // Assert
        assertEquals(1f, actual);
    }

    /**
     * Opdracht 1.d
     */
    @Test
    public void throwAnotherOne() {
        try{
            int[] list = new int[3];
            int number = 5;
            list[4] = number;


        }
        catch(ArrayIndexOutOfBoundsException e){
            assertEquals("java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3", e.toString());
        }



    }
}