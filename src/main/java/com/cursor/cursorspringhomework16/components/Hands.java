package com.cursor.cursorspringhomework16.components;

import com.cursor.cursorspringhomework16.annotation.RandomInt;
import org.springframework.stereotype.Component;

@Component
public class Hands {

    @RandomInt(min = 5, max = 8)
    private int length;

    public Hands() {
        System.out.println("Hands created");
    }

    public void push() {
        System.out.println("Robot are pushing on " + length);
    }
}
