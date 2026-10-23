import java.util.Scanner;

interface Message {
    void check();
}

class CheckScam implements Message {
    String message;
    int score = 0;

    CheckScam(String message) {
        this.message = message;
    }

    public void check() {
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

        System.out.println("Risk Score: " + score);

        if (score >= 60)
            System.out.println("HIGH RISK");
        else if (score >= 20)
            System.out.println("MEDIUM RISK");
        else
            System.out.println("LOW RISK");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Message: ");
        String message = sc.nextLine();

        Message obj = new CheckScam(message);
        obj.check();

        sc.close();
    }
}
