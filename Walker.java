
public class Walker {
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