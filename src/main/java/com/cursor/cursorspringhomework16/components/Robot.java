package com.cursor.cursorspringhomework16.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    private final Hands hands;
    private final Legs legs;
    private final Head head;

    @Autowired
    public Robot(Hands hands, Legs legs, Head head) {
        this.hands = hands;
        this.legs = legs;
        this.head = head;
        System.out.println("Robot created");
        robotThink();
        robotPush();
        robotMove();
    }

    public void robotMove() {
        legs.move();
    }

    public void robotThink() {
        head.think();
    }

    public void robotPush() {
        hands.push();
    }
}
