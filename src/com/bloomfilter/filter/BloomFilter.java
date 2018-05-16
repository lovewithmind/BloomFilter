package com.bloomfilter.filter;

import com.bloomfilter.hasher.HashFunction;
import com.bloomfilter.scanner.ClassScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class BloomFilter {
    private final Set<Integer> inputSet;
    private int[] toggles;

    public BloomFilter(Set<Integer> inputSet) {
        this.inputSet = inputSet;
        toggles = new int[1000];
    }

    public void populate(Set<Integer> inputSet) {
        Set<Class<? extends HashFunction>> function = ClassScanner.loadAllHashers("com.bloomfilter.hasher", HashFunction.class);
        for (Class<? extends HashFunction> clazz : function) {
            Integer position = (Integer) Arrays.stream(clazz.getDeclaredMethods()).findFirst().map(method -> {
                try {
                    return method.invoke(clazz.newInstance(), 12);
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    throw new RuntimeException("Method not Found");
                }
            }).get();

            toggle(position, 1);
        }
    }

    private void toggle(Integer position, int value) {
        toggles[position] = value;
    }
}
