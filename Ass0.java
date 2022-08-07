import java.util.*;
import java.io.*;

class Clock {
    int t = 0;

    int next() {
        t += 10;
        return t;
    }
}

class Ass0 {

    Boolean[] wall = new Boolean[3];

    void wallRender(float prob) {
        for (int j = 0; j < 3; j++) {
            wall[j] = prob > Math.random();
        }
    }

    boolean checkMove(float prob) {
        Boolean cur = prob > Math.random();
        if (cur && (wall[0] || wall[1] || wall[2])) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        FileWriter flo = new FileWriter("output.txt");
        Scanner sc = new Scanner(new File("input.txt"));
        Ass0 app = new Ass0();
        int epochs = 50;
        String flow = sc.hasNext() ? sc.nextInt() + " " + sc.nextInt() + "\n" : "";
        while (sc.hasNext()) {
            int steps = 0;
            float pg = sc.nextFloat();
            float prob = 1 - pg;
            int width = sc.nextInt();
            int pc = 0;
            for (int epoch = 0; epoch < epochs; epoch++) {
                app.wallRender(prob);
                boolean brk = false;
                int i, moves = 0;
                for (i = 1; i < 2001 && moves < width; i++) {
                    app.wallRender(prob);
                    brk = app.checkMove(width);
                    if (brk)
                        moves++;
                }
                if (i != 2001 && brk) {
                    pc++;
                    steps = steps + i * 10;
                } else {
                    steps += i * 100;
                }

            }
            // assignment.printWalker(width);

            flow += pg + " " + width + " " + (steps / epochs) + " " + (pc / epochs) + "\n";

            // assignment.printWall(width);
        }
        flo.write(flow);
        flo.close();

    }
}