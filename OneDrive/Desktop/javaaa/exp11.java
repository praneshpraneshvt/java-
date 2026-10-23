import java.util.Scanner;

class ScamWord {
    static String message;
    static int score = 0;

    static String[] scamWords = {
        "otp", "winner", "lottery", "free", "click"
    };

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    static void checkScam() {
        String[] words = message.toLowerCase().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < scamWords.length; j++) {
                if (words[i].equals(scamWords[j])) {
                    score += 20;
                }
            }
        }

        System.out.println("Risk Score: " + score);

        if (score >= 60)
            System.out.println("HIGH RISK");
        else if (score >= 20)
            System.out.println("MEDIUM RISK");
        else
            System.out.println("LOW RISK");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        message = sc.nextLine();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 locked lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                synchronized (lock2) {
                    System.out.println("Thread 1 locked lock2");
                    checkScam();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 locked lock2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                synchronized (lock1) {
                    System.out.println("Thread 2 locked lock1");
                    checkScam();
                }
            }
        });

        t1.start();
        t2.start();

        sc.close();
    }
}