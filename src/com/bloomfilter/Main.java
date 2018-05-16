package com.bloomfilter;

import com.bloomfilter.filter.BloomFilter;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Populate set!!");
        Set<Integer> inputSet = new HashSet<Integer>();
        inputSet.add(sc.nextInt());
        BloomFilter bloomFilter = new BloomFilter(inputSet);
    }
}
