package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainTest4JUnit {

    @Test
    public void test(){
        assertEquals(4,sum(2,2));
        assertFalse(sum(1,2)==4);
        assertTrue(sum(2,2)==4);
    }

    private int sum(int n1, int n2){
        return n1+n2;
    }



}
