package com.bloomfilter.scanner;

import com.bloomfilter.hasher.Function1;
import com.bloomfilter.hasher.Function2;
import com.bloomfilter.hasher.HashFunction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class ClassScannerTest {

    @Test
    public void shouldLoadAllClassesInPackageOfSubtype() {
        String packageName = "com.bloomfilter.hasher";

        Set<Class<? extends HashFunction>> classes = ClassScanner.loadAllHashers(packageName, HashFunction.class);

        Assert.assertEquals(2, classes.size());
        Assert.assertTrue(classes.contains(Function1.class));
        Assert.assertTrue(classes.contains(Function2.class));
    }

    @Test
    public void shouldNotLoadHashFunction() {
        String packageName = "com.bloomfilter.hasher";

        Set<Class<? extends HashFunction>> classes = ClassScanner.loadAllHashers(packageName, HashFunction.class);

        Assert.assertEquals(2, classes.size());
        Assert.assertFalse(classes.contains(HashFunction.class));
    }
}