import java.io.*;
import java.util.Scanner;

class CreateInpFile {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter(new File("input.txt"));// Writing an Input File Sensor( prob | width );
        Scanner sc = new Scanner(System.in); // Creacting scanner object to take input from console
        System.out.println("want to continue with default input(y/N)"); // default is width(0-20)
        String inp = sc.next(); // reading input
        float minp = 0, maxp = 1;// default values for probability ranging from 0 to 1
        int minw = 1, maxw = 20;// default values for width ranging from 0 to 20
        if (inp.equalsIgnoreCase("N")) {// checking input
            System.out.println("Import range (min-width(>=1) and max-width(<10000))");// getting custom input
            minw = sc.nextInt();
            maxw = sc.nextInt();
            minw = minw >= 1 ? minw : 1;
            maxw = maxw >= minw ? maxw : 20;// min with <max width
        }

        String flw = minw + " " + maxw + "\n"; // string containing range
        for (float i = minp; i <= maxp; i += 0.01) {
            for (int j = minw; j <= maxw; j += 1) {
                flw += i + " " + j + "\n";// all posibilities corresponding to with are added to string

            }
        }
        sc.close();// scanner object is closed
        fw.write(flw);// string is written to file
        fw.close();// fileclosed
    }
}