package com.bloomfilter.hasher;


public class Function1 implements HashFunction {
    @Override
    public int hash(int number) {
        return number % 100;
    }
}
