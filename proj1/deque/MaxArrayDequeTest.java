package deque;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test
    public void testComparator(){
        Comparator<Integer> intComparator = Integer::compareTo;
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<Integer>(intComparator);
        for(int i = 0; i<100;i++){
            mad.addFirst(i);
        }
        mad.addFirst(1000);
        for(int i = 0; i<100;i++){
            mad.addFirst(i);
        }
        System.out.println(mad.max());

    }
}


