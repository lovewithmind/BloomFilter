package com.bloomfilter.hasher;


public class Function2 implements HashFunction {
    @Override
    public int hash(int number) {
        return (number * number + number) % 100;
    }
}
