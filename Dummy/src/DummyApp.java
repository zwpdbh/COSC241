/**
 * Created by zw on 5/21/16.
 */
public class DummyApp {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            for (int j=1; j<=10; j++) {
                if (j%2==0) {
                    break;
                }
                System.out.format("%d : %d\n", i, j);
            }
        }
    }
}
