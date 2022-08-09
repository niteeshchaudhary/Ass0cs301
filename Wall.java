
public class Wall {
    Boolean w1 = false;// sensor1
    Boolean w2 = false;// sensor2
    Boolean w3 = false;// sensor3
    Boolean current = false;// sensor on which infiltrator is standing

    // situation faced by infiltrator
    // | |#cr| |
    // |#s1|#s2|#s3|

    void wallRender(float prob) {
        w1 = prob > Math.random();// weighted probability
        w2 = prob > Math.random();// weighted probability
        w3 = prob > Math.random();// weighted probability
        current = prob > Math.random();// weighted probability
    }
}