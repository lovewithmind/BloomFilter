package com.bloomfilter.filter;

import org.junit.Test;

import java.util.Collections;

public class BloomFilterTest {

    @Test
    public void shouldLoadAllClassInFunction() {
        BloomFilter bloomFilter = new BloomFilter(Collections.emptySet());
        bloomFilter.populate(Collections.emptySet());
    }
}
