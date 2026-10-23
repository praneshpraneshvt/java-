import java.util.Scanner;

class CheckScam {

    String message;
    int score = 0;

    CheckScam(String message) {
        this.message = message;
    }

    void checkMessage() {

        try {

            if (message.isEmpty()) {
                throw new Exception("Message cannot be empty");
            }

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
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SCAM MESSAGE CHECKER =====");

        System.out.print("\nEnter your first message: ");
        String message1 = sc.nextLine();

        CheckScam obj1 = new CheckScam(message1);
        obj1.checkMessage();

        System.out.print("\nEnter your second message: ");
        String message2 = sc.nextLine();

        CheckScam obj2 = new CheckScam(message2);
        obj2.checkMessage();

        sc.close();
    }
}