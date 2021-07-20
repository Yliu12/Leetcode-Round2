package OOP;

public class Pair<T1, T2> {
    T1 v1;
    T2 v2;

    public Pair(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    T1 getv1() {
        return v1;
    }

    T2 getv2() {
        return v2;
    }
}
