package com.cursor.cursorspringhomework16.components;

import com.cursor.cursorspringhomework16.annotation.RandomInt;
import org.springframework.stereotype.Component;

@Component
public class Legs {

    @RandomInt(min = 10, max = 15)
    private int length;

    public Legs() {
        System.out.println("Legs created");
    }

    public void move() {
        System.out.println("Robot are moving on " + length);
    }
}
