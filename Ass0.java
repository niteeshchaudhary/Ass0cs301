
import java.util.*;
import java.io.*;

class Ass0 {
    public static void main(String[] args) throws Exception {
        FileWriter flo = new FileWriter("output.txt");// creating outputfile and object to write in it
        Scanner sc = new Scanner(new File("input.txt"));// object to read input file
        int epochs = 100; // number of observations to take average
        String flow = sc.hasNext() ? sc.nextInt() + " " + sc.nextInt() + "\n" : "";// reading input
        while (sc.hasNext()) {// checking if data is available in file
            float pg = sc.nextFloat();// reading probability from file
            int steps = 0, pc = 0, width = sc.nextInt();// reading width from file
            Walker wk = new Walker();// creating object for infiltrator
            for (int epoch = 0; epoch < epochs; epoch++) {// simulation starts fpr 100 epochs
                String[] result = wk.start((1 - pg), width).split(" ");// spliting the strimg to get time and success
                steps += Integer.parseInt(result[0]);
                pc += Integer.parseInt(result[1]);
            }
            flow += pg + " " + width + " " + (steps / epochs) + " " + (pc * 1.0 / epochs) + "\n";
            // given probability and width -> average time taken probability of success in
            // crossing border
        }
        flo.write(flow);
        flo.close();
        sc.close();

    }
}