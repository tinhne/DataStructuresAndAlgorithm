package MyTree;

public class TNode {
        int data;
        TNode ll, rr;
        TNode(int x) {
            data = x;
            ll = rr = null;
        }
        TNode(int data, TNode ll, TNode rr) {
            this.data = data;
            this.ll = ll;
            this.rr = rr;
        }
}
