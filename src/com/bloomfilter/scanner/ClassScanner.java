package com.bloomfilter.scanner;

import org.reflections.Reflections;

import java.util.Set;

public class ClassScanner {
    public static <T> Set<Class<? extends T>> loadAllHashers(String packageName, Class<T> hashClass) {
        Reflections reflections = new Reflections(packageName);
        return reflections.getSubTypesOf(hashClass);
    }
}
