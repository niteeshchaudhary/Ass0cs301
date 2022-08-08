
public class Wall {
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