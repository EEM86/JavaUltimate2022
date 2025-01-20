package yym.svydovets.algorithm.task.csosvita.dymanic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class PlayGameTaskTest {

    @Test
    void getMaxWin1() {
        int[] player = new int[]{1,5,15,100,5};
        int[] computer = new int[]{1, 5, 15, 100, 5};

        final int res = PlayGameTask.getMaxVinDp(player, computer);
        assertEquals(120, res);
    }

    @Test
    void getMaxWin2() {
        int[] player = new int[]{1,1,1,1};
        int[] computer = new int[]{1,1,1,1};

        final int res = PlayGameTask.getMaxVinDp(player, computer);
        assertEquals(0, res);
    }

    @Test
    void getMaxWin3() {
        int[] player = new int[]{2,3,4,5,6,7,8,9,10,11};
        int[] computer = new int[]{10,9,8,7,6,5,4,3,2,1};

        final int res = PlayGameTask.getMaxVinDp(player, computer);
        assertEquals(65, res);
    }

    @Test
    void getMaxWin4() {
        int[] player = new int[]{651,321,106,503,227,290,915,549,660,115,491,378,495,789,507,381,685,530,603,394,7,704,101,620,859,490,744,495,379,781,550,356,950,628,177,373,132,740,946,609,29,329,57,636,132,843,860,594,718,849};
        int[] computer = new int[]{16,127,704,614,218,67,169,621,340,319,366,658,798,803,524,608,794,896,145,627,401,253,137,851,67,426,571,302,546,225,311,111,804,135,284,784,890,786,740,612,360,852,228,859,229,249,540,979,55,82};

        final int res = PlayGameTask.getMaxVinDp(player, computer);
        assertEquals(25084, res);
    }

    public static void main(String[] args) {
        stressTest();
    }

    private static void stressTest() {
        int i = 0;
        while (true) {
            if (i % 10 == 0) {
                System.out.println("Test #: " + i);
                i++;
            }
            test();
        }
    }

    private static void test() {
        Random r = new Random();

        final int n = r.nextInt(10);
        int[] player = new int[n];
        for (int i = 0; i < n; i++) {
            player[i] = r.nextInt(15);
        }

        int[] comp = new int[n];
        for (int i = 0; i < n; i++) {
            comp[i] = r.nextInt(15);
        }

        if (PlayGameTask.getMaxWin(player, comp) != PlayGameTask.getMaxVinDp(player, comp)) {
            System.out.println(Arrays.toString(player) + " vs comp: " + Arrays.toString(comp)
                + " 2p res: " + PlayGameTask.getMaxWin(player, comp)
                + " DP res: " + PlayGameTask.getMaxVinDp(player, comp));
            System.out.println();
            throw new RuntimeException();
        }
    }
}