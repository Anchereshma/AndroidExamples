package com.example.myapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class ViewModelTest {

    @Rule
    public final MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void test(){
        Assert.assertEquals(10,10);
    }

}
