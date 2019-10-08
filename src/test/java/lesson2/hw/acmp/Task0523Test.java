package lesson2.hw.acmp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Task0523Test {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
//                /*01*/{new Integer[]{1}, 1, 1},
//                /*02*/{new Integer[]{1, 1}, 1, 2},
//                /*03*/{new Integer[]{1, 1}, 2, 1},
//                /*04*/{new Integer[]{1, 2}, 2, 2},
//                /*05*/{new Integer[]{2, 1}, 2, 2},
//                /*06*/{new Integer[]{2, 2}, 2, 2},
//                /*07*/{new Integer[]{1, 1, 1}, 1, 3},
//                /*08*/{new Integer[]{1, 1, 1}, 2, 2},
//                /*09*/{new Integer[]{1, 1, 1}, 3, 1},
//                /*10*/{new Integer[]{1, 1, 2}, 2, 2},
//                /*11*/{new Integer[]{1, 2, 1}, 2, 3},
//                /*12*/{new Integer[]{2, 1, 1}, 2, 2},
//                /*13*/{new Integer[]{2, 1, 2}, 2, 3},
//                /*14*/{new Integer[]{2, 2, 1}, 2, 3},
//                /*15*/{new Integer[]{2, 2, 2}, 2, 4},
                /*16*/{new Integer[]{1, 1, 2, 5}, 1, 4},/*9*/
                /*17*/{new Integer[]{1, 1, 2, 5}, 2, 4},/*5*/
                /*18*/{new Integer[]{1, 1, 2, 5}, 3, 4},/*5*/
//                /*19*/{new Integer[]{1, 1, 2, 5}, 4, 4},
//                /*20*/{new Integer[]{1, 2, 1, 1}, 3, 2},
//                /*21*/{new Integer[]{2, 1, 1, 2}, 2, 3},
//                /*22*/{new Integer[]{1, 2, 3, 4}, 4, 4},
//                /*23*/{new Integer[]{9, 5, 2, 4, 10}, 3, 11},


        });
    }
    private Integer[] a;
    private Integer b, c;

    public Task0523Test(Integer[] a, Integer b, Integer c) {
        this.a = a;//массив - количества страниц в главах
        this.b = b;//Количество томов
        this.c = c;//expected value
    }
    private Integer task0523;

    @Before
    public void init() {
        task0523 = new Task0523(a, b).runTest();
    }

    @Test
    public void massTestIsCondition() {
        Assert.assertEquals(c, task0523);
    }
}