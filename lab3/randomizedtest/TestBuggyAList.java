package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
    public void testThreeAddThreeRemove() {
      /*
       */
      AListNoResizing<Integer> listNoResizing = new AListNoResizing<>();
      BuggyAList<Integer> listBuggy = new BuggyAList<>();

      //Insert
      listNoResizing.addLast(4);
      listBuggy.addLast(4);
      listNoResizing.addLast(5);
      listBuggy.addLast(5);
      listNoResizing.addLast(6);
      listBuggy.addLast(6);

      //Compare removeLast() result
      assertEquals(listNoResizing.removeLast(), listBuggy.removeLast());
      assertEquals(listNoResizing.removeLast(), listBuggy.removeLast());
      assertEquals(listNoResizing.removeLast(), listBuggy.removeLast());
  }

    @Test
    public void randomTest(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = correct.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2 && correct.size() > 0) {
                int removedCorrect = correct.removeLast();
                int removedBroken = broken.removeLast();
                System.out.println("correct: removeLast(" + removedCorrect + ")");
                System.out.println("broken: removeLast(" + removedBroken + ")");
                assertEquals(removedCorrect, removedBroken);
            }
        }
    }
}
