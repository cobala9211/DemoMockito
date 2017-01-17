package com.example.dnp.demomockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Iterator;
import java.util.List;

/**
 * Created by DNP on 1/15/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MathTestUtil {
    @Mock
    MathUtil mMathUtil;
    @Mock
    List<Integer> listNumA;
    @Mock
    List<Integer> listNumB;


    @Test
    public void testFunctionAdd() {
        // test result method
        Mockito.when(listNumA.get(0)).thenReturn(1);
        Mockito.when(listNumB.get(0)).thenReturn(2);
        Mockito.when(mMathUtil.getAddition(listNumA.get(0), listNumB.get(0))).thenReturn(3);
        Iterator listNumber = Mockito.mock(Iterator.class);
        Mockito.when(listNumber.next()).thenReturn(1).thenReturn(2);
        Assert.assertEquals(3, mMathUtil.getAddition((Integer) listNumber.next(), (Integer) listNumber.next()));
    }

    @Test
    public void testParameter() {
        // test parameter for method
        List mockList = Mockito.mock(List.class);
        mockList.add(1);
        mockList.clear();

        Mockito.verify(mockList).add(1);
        Mockito.verify(mockList).clear();

        Mockito.when(listNumA.get(0)).thenReturn(1);
        Mockito.when(listNumB.get(0)).thenReturn(2);
        MathUtil math = Mockito.mock(MathUtil.class);
        math.getAddition(listNumA.get(0), listNumB.get(0));
    }

    @Test
    public void testIsMax() {
        // test value is max
        boolean isIsMax = MathUtil.isMax(4, 3);
        Assert.assertTrue(isIsMax);

        // test value is'nt max
        boolean isMin = MathUtil.isMax(1, 2);
        Assert.assertFalse(isMin);
    }

}
