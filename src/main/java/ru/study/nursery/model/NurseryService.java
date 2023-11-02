package ru.study.nursery.model;

import java.util.Random;

public class NurseryService {
    public static int numberInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min)+1) + min;
    }
}
