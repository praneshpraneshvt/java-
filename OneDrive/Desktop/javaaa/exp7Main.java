import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CheckScam s = new CheckScam();
        System.out.println("====== SCAM MESSAGE CHECKER ======");
        s.input();
        s.checkMessage();
        CheckScam s2 = new CheckScam();
        s2.input();
        s2.checkMessage();
        sc.close();
    }
}