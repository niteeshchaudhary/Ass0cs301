
public class Walker {// class to simulate the infiltrator
    Wall wall = new Wall();// object to simulate border
    Clock clk = new Clock();// object to simulate time

    int checkMove(float prob) {// method to check if move is possible
        wall.wallRender(prob);// changing configurations of border sensor
        clk.next();// time increment
        if (wall.current && (wall.w1 || wall.w2 || wall.w3)) {// condition for infiltrator to move
            return 1;
        }
        return 0;
    }

    String start(float prob, int width) {// starting infiltrator to cross border
        int pc = 0;
        int i, moves = 0;
        clk.reset();// resetting clock
        for (i = 0; i < 4000 && moves < width; i++) {// looping infiltrator to move
            moves += checkMove(prob);
        }
        if (i < 4000) {// if infiltrator successfully crossed the border
            pc++;
        } else {
            clk.nextinf();// if infiltrator was unable to cross border in 40_000sec(666min(11hrs)) then
                          // time of crossing is assumed infinity
        }
        return clk.getTime() + " " + pc;// returning time and success
    }
}