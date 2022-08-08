import java.util.*;
import java.io.*;

class Clock {
    private int t = 0;

    int next() {
        t += 10;
        return t;
    }

    int nextinf() {
        t += t * 100;
        return t;
    }

    void reset() {
        t = 0;
    }

    int getTime() {
        return t;
    }
}

class Wall {
    Boolean w1 = false;
    Boolean w2 = false;
    Boolean w3 = false;
    Boolean current = false;

    void wallRender(float prob) {
        w1 = prob > Math.random();
        w2 = prob > Math.random();
        w3 = prob > Math.random();
        current = prob > Math.random();
    }
}

class Walker {
    Wall wall = new Wall();
    Clock clk = new Clock();

    int checkMove(float prob) {
        wall.wallRender(prob);
        clk.next();
        if (wall.current && (wall.w1 || wall.w2 || wall.w3)) {
            return 1;
        }
        return 0;
    }

    String start(float prob, int width) {
        int pc = 0;
        int i, moves = 0;
        clk.reset();
        // System.out.println("pb " + prob);
        for (i = 0; i < 4000 && moves < width; i++) {
            moves += checkMove(prob);
        }
        if (i < 4000) {
            pc++;
        } else {
            clk.nextinf();
        }
        return clk.getTime() + " " + pc;
    }
}

class Ass0 {
    public static void main(String[] args) throws Exception {
        FileWriter flo = new FileWriter("output.txt");
        Scanner sc = new Scanner(new File("input.txt"));
        int epochs = 100;
        String flow = sc.hasNext() ? sc.nextInt() + " " + sc.nextInt() + "\n" : "";
        while (sc.hasNext()) {
            float pg = sc.nextFloat();
            int steps = 0, pc = 0, width = sc.nextInt();
            Walker wk = new Walker();
            for (int epoch = 0; epoch < epochs; epoch++) {
                String[] result = wk.start((1 - pg), width).split(" ");
                steps += Integer.parseInt(result[0]);
                pc += Integer.parseInt(result[1]);
            }
            flow += pg + " " + width + " " + (steps / epochs) + " " + (pc * 1.0 / epochs) + "\n";
        }
        flo.write(flow);
        flo.close();

    }
}