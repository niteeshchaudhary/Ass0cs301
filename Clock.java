
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