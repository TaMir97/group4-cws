package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    @Test
    void stringToInt() {
        assertThrows(RuntimeException.class,()-> Convert.stringToInt("32769"));
    }
}