import java.util.Scanner;

class ScamChecker {

    String message;
    int score = 0;

    synchronized void checkMessage() {

        String[] scamWords = {
            "otp", "winner", "lottery", "free", "click"
        };

        String[] words = message.toLowerCase().split(" ");

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < scamWords.length; j++) {

                if (words[i].equals(scamWords[j])) {
                    score += 20;
                }
            }
        }

        System.out.println("\nMessage: " + message);
        System.out.println("Risk Score: " + score);

        if (score >= 60)
            System.out.println("Status: HIGH RISK");
        else if (score >= 20)
            System.out.println("Status: MEDIUM RISK");
        else
            System.out.println("Status: LOW RISK");
    }
}

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message 1: ");
        String message1 = sc.nextLine();

        ScamChecker s1 = new ScamChecker();
        s1.message = message1;

        new Thread() {
            public void run() {
                s1.checkMessage();
            }
        }.start();

        try {
            Thread.sleep(100);
        }
        catch (Exception e) {
        }

        System.out.print("\nEnter message 2: ");
        String message2 = sc.nextLine();

        ScamChecker s2 = new ScamChecker();
        s2.message = message2;

        new Thread() {
            public void run() {
                s2.checkMessage();
            }
        }.start();

        sc.close();
    }
}