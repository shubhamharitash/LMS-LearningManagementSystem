package org.lms.service;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StarterTest {

    Starter starter=new Starter();


    @Test
    void startMethod() {
        Starter.startMethod(new Scanner("Shubham"));
    }
}