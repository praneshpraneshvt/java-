

import java.util.*;

class CheckScam {
    String message;
    int score = 0;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Message:");
        message = sc.nextLine();
    }

    public void checkMessage() {
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
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Message: " + message);
        System.out.println("Risk Score: " + score);
        if (score >= 60) {
            System.out.println("Status: HIGH RISK");
        } else if (score >= 20) {
            System.out.println("Status: MEDIUM RISK");
        } else {
            System.out.println("Status: LOW RISK");
        }
    }
}

