public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaOne = (C - A) * (D - B);
        int areaTwo = (G - E) * (H - F);
        int intersectArea = intersect(A, C, E, G) * intersect(B, D, F, H);
        return areaOne + areaTwo - intersectArea;
    }

    private int intersect(int A, int C, int E, int G) {
        if (G <= A || E >= C) {
            return 0;
        } else if (E <= A && G >= A && G <= C) {
            return G - A;
        } else if (E <= A && G >= C) {
            return C - A;
        } else if (A <= E && C >= G) {
            return G - E;
        } else {
            return C - E;
        }
    }
}