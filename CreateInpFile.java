import java.io.*;
import java.util.Scanner;

class CreateInpFile {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter(new File("input.txt"));
        Scanner sc = new Scanner(System.in);
        System.out.println("want to continue with default input(y/N)");
        String inp = sc.next();
        float minp = 0, maxp = 1;
        int minw = 1, maxw = 20;
        if (inp.equalsIgnoreCase("N")) {
            System.out.println("Import range (min-width(>=1) and max-width(<10000))");
            minw = sc.nextInt();
            maxw = sc.nextInt();
            minw = minw >= 1 ? minw : 1;
            maxw = maxw >= minw ? maxw : 20;
        }

        String flw = minw + " " + maxw + "\n";
        for (float i = minp; i <= maxp; i += 0.01) {
            for (int j = minw; j <= maxw; j += 1) {
                flw += i + " " + j + "\n";

            }
        }
        sc.close();
        fw.write(flw);
        fw.close();
    }
}