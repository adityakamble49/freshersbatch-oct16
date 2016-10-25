package threading;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Nqueen {

    public static boolean isSafePosition(int y1, int y2, int x1, int x2) {
        if (y1 != y2 && x1 != x2) {
            double slope = ((y2 - y1) * 1.0) / (x2 - x1);
            if (slope != 1.0 && slope != -1.0) {
                return true;
            }
        }
        return false;
    }

    static class RunLoops implements Callable<String> {

        int a = 0;
        int b = 0;
        int a2 = 0, b2 = 1, c2 = 2, d2 = 3, e2 = 4, f2 = 5, g2 = 6, h2 = 7;
        static int i = 1;

        public RunLoops(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String call() throws Exception {
            StringBuilder answer = new StringBuilder();
            for (int c = 0; c <= 7; c++) {
                for (int d = 0; d <= 7; d++) {
                    for (int e = 0; e <= 7; e++) {
                        for (int f = 0; f <= 7; f++) {
                            for (int g = 0; g <= 7; g++) {
                                for (int h = 0; h <= 7; h++) {

                                    if (isSafePosition(a, b, a2, b2) && isSafePosition(a, c, a2, c2) && isSafePosition(a, d, a2, d2) && isSafePosition(a, e, a2, e2)
                                            && isSafePosition(a, f, a2, f2) && isSafePosition(a, g, a2, g2) && isSafePosition(a, h, a2, h2) && isSafePosition(b, c, b2, c2)
                                            && isSafePosition(b, d, b2, d2) && isSafePosition(b, e, b2, e2) && isSafePosition(b, f, b2, f2) && isSafePosition(b, g, b2, g2)
                                            && isSafePosition(b, h, b2, h2) && isSafePosition(c, d, c2, d2) && isSafePosition(c, e, c2, e2) && isSafePosition(c, f, c2, f2)
                                            && isSafePosition(c, g, c2, g2) && isSafePosition(c, h, c2, h2) && isSafePosition(d, e, d2, e2) && isSafePosition(d, f, d2, f2)
                                            && isSafePosition(d, g, d2, g2) && isSafePosition(d, h, d2, h2) && isSafePosition(e, f, e2, f2) && isSafePosition(e, g, e2, g2)
                                            && isSafePosition(e, h, e2, h2) && isSafePosition(f, g, f2, g2) && isSafePosition(f, h, f2, h2) && isSafePosition(g, h, g2, h2)) {

                                        answer.append("Position " + i + ") " + a + " - " + b + " - " + c + " - " + d + " - " + e + " - " + f + " - " + g + " - " + h + "\n");

                                        // System.out.println("Position " +
                                        // i + ") " + a + " - " + b + " - "
                                        // + c + " - " + d + " - " + e + " -
                                        // " + f + " - " + g + " - " + h);
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return answer.toString();
        }

    }

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        ExecutorService es = Executors.newCachedThreadPool();
        ArrayList<Future<String>> answersList = new ArrayList<>();
        for (int a = 0; a <= 7; a++) {
            for (int b = 0; b <= 7; b++) {
                answersList.add(es.submit(new RunLoops(a,b)));
            }
        }

        for (Future<String> future : answersList) {
            System.out.println(future.get());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + " milisec");
    }

}
