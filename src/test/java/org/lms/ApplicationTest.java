package org.lms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }
    @Test
    void main()  {
        try{
        Application.main(new String[]{
                "shubham_\\input1.txt"
        });
        }
        catch (Exception e){}
        assertTrue(outContent.toString().trim().isEmpty());
    }
}