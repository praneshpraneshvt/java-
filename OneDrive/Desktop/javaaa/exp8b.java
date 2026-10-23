import java.util.Scanner;

class CheckScam extends Thread {

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

        // Default message
        CheckScam defaultMessage =
            new CheckScam("winner lottery free click");

       
        defaultMessage.start();

        try {
            defaultMessage.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // User message
        System.out.print("\nEnter Message: ");
        String userMessage = sc.nextLine();

        CheckScam obj = new CheckScam(userMessage);

        Runnable r = obj;   // Runnable reference

        obj.start();        // Start the Thread

        sc.close();
    }
}