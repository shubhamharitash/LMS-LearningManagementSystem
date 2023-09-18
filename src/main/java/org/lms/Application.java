package org.lms;
import org.lms.service.Starter;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File(args[0]));
        while (sc.hasNextLine()) {
            Starter.startMethod(sc);
        }
    }
}