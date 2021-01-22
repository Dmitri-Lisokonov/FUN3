package nl.fhict.s3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class Opdracht2Test {

    private final byte[] expectedBytes = new byte[]{0,1,0,1,0,1,0,1,0,1};
    private final boolean[] expectedBools = new boolean[]{false, true, false, true, false, true, false, true, false, true};

    /**
     * Opdracht 2.1
     */
    @Test
    public void bitVariantOne() {
        // Arrange
        byte bit = 0;
        final byte[] actual = new byte[10];

        // Act
        for (int i = 0; i < 10; i += 1) {

            bit = (byte) (i % 2);
            System.out.println(bit);
            actual[i] = bit;
        }

        // Assert
        assertArrayEquals(expectedBytes, actual);
    }

    @Test
    public void bitVariantTwo() {
        // Arrange
        byte bit = 1;
        final byte[] actual = new byte[10];

        // Act
        for (int i = 0; i < 10; i += 1) {
            switch (bit) {
                case 0:
                    bit = 1;
                    break;
                case 1:
                    bit = 0;
                    break;
            }

            actual[i] = bit;
        }

        // Assert
        assertArrayEquals(expectedBytes, actual);
    }

    /**
     * Opdracht 2.b
     */
    @Test
    public void boolVariantOne() {
        // Arrange
        boolean bool = true;
        final boolean[] actual = new boolean[10];

        // Act

        for (int i = 0; i < 10; i += 1) {

            switch (i % 2) {
                case 0:
                    bool = false;
                    break;
                case 1:
                    bool = true;
                    break;

            }
            actual[i] = bool;
    }
        // Assert
        assertArrayEquals(expectedBools, actual);
    }


    @Test
    public void boolVariantTwo() {
        // Arrange
        boolean bool = true;
        final boolean[] actual = new boolean[10];

        // Act
        for (int i = 0; i < 10; i += 1) {
            bool = !bool;
            actual[i] = bool;
        }

        // Assert
        assertArrayEquals(expectedBools, actual);
    }
}