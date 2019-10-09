package lesson2.hw.acmp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Task0523RTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                /*0*/{new Integer[]{1}, 1, 1},
                /*1*/{new Integer[]{1, 1}, 1, 2},
                /*2*/{new Integer[]{1, 1}, 2, 1},
                /*3*/{new Integer[]{1, 2}, 2, 2},
                /*4*/{new Integer[]{2, 1}, 2, 2},
                /*5*/{new Integer[]{2, 2}, 2, 2},
                /*6*/{new Integer[]{1, 1, 1}, 1, 3},
                /*7*/{new Integer[]{1, 1, 1}, 2, 2},
                /*8*/{new Integer[]{1, 1, 1}, 3, 1},
                /*9*/{new Integer[]{1, 1, 2}, 2, 2},
                /*10*/{new Integer[]{1, 2, 1}, 2, 3},/*2*/
                /*11*/{new Integer[]{2, 1, 1}, 2, 2},
                /*12*/{new Integer[]{2, 1, 2}, 2, 3},/*2*/
                /*13*/{new Integer[]{2, 2, 1}, 2, 3},
                /*14*/{new Integer[]{2, 2, 2}, 2, 4},
                /*15*/{new Integer[]{1, 1, 2, 5}, 1, 9},
                /*16*/{new Integer[]{1, 1, 2, 5}, 2, 5},
                /*17*/{new Integer[]{1, 1, 2, 5}, 3, 5},
                /*18*/{new Integer[]{1, 1, 2, 5}, 4, 5},
                /*19*/{new Integer[]{2, 1, 1, 2}, 2, 3},
                /*20*/{new Integer[]{1, 2, 1, 1}, 3, 2},/*-1*/
                /*21*/{new Integer[]{1, 2, 3, 4}, 4, 4},
                /*22*/{new Integer[]{9, 5, 2, 4, 10}, 2, 16},/*14*/
                /*23*/{new Integer[]{9, 5, 2, 4, 10}, 3, 11},/*-1*/
                /*24*/{new Integer[]{9, 5, 2, 4, 10}, 4, 10},/*-1*/
                /*25*/{new Integer[]{9, 5, 2, 4, 10}, 5, 10},
                /*26*/{new Integer[]{9, 5, 10, 4, 1}, 2, 15},/*24*/
                /*27*/{new Integer[]{9, 5, 10, 4, 1}, 3, 14},/*-1*/
                /*28*/{new Integer[]{9, 5, 10, 4, 1}, 4, 10},/*-1*/
                /*29*/{new Integer[]{9, 5, 10, 4, 1}, 5, 10},
        });
    }
    private Integer[] a;
    private Integer b, c;

    public Task0523RTest(Integer[] a, Integer b, Integer c) {
        this.a = a;//массив - количества страниц в главах
        this.b = b;//Количество томов
        this.c = c;//expected value
    }
    private Integer task0523R;

    @Before
    public void init() {
        task0523R = new Task0523R(a, b).runTest();
    }

    @Test
    public void massTestIsCondition() {
        Assert.assertEquals(c, task0523R);
    }
}