import java.util.Scanner;

class CheckScam implements Runnable {

    String message;
    int score = 0;

    CheckScam(String message) {
        this.message = message;
    }

    public void run() {

        String[] scamWords = {"otp", "winner", "lottery", "free", "click"};
        String[] words = message.toLowerCase().split(" ");

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < scamWords.length; j++) {

                if (words[i].equals(scamWords[j])) {
                    score += 20;
                }
            }
        }

        System.out.println("Message: " + message);
        System.out.println("Risk Score: " + score);

        if (score >= 60)
            System.out.println("HIGH RISK");
        else if (score >= 20)
            System.out.println("MEDIUM RISK");
        else
            System.out.println("LOW RISK");
    }
}

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        CheckScam obj1 = new CheckScam(
            "winner lottery free click"
        );

        Thread t1 = new Thread(obj1);
        t1.start();

        
        System.out.print("\nEnter your message: ");
        String userMessage = sc.nextLine();

        CheckScam obj2 = new CheckScam(userMessage);

        Thread t2 = new Thread(obj2);
        t2.start();

        sc.close();
    }
}