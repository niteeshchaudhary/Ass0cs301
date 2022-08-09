
import java.util.*;
import java.io.*;

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