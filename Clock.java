
class Clock {
    private int t = 0; // recording time

    int next() {
        t += 10;// increse time by 10sec
        return t;
    }

    int nextinf() {
        t += t * 100;// increse time by its 100 times say infinity when infiltrator stucks
        return t;
    }

    void reset() {
        t = 0;// resetting clock
    }

    int getTime() {
        return t;// sending time
    }
}