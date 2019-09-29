package com.vrddd.introduction;

import com.vrddd.introduction.excercise.Collection;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestCollection
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCollection()
    {
        Collection collection = new Collection();
        Assert.assertEquals(collection.isEmpty(),true);
        collection.insert(123);
        Assert.assertEquals(collection.isEmpty(),false);
        collection.insert(789);
        Assert.assertEquals(collection.isPresent(123),true);
        collection.remove(0);
        Assert.assertEquals(collection.isPresent(123),false);
        collection.makeEmpty();
        Assert.assertEquals(collection.isEmpty(),true);
        for (int i = 0; i < 11; i++) {
            collection.insert(i + 120);
        }
        Assert.assertEquals(collection.isPresent(130),true);
    }
}
