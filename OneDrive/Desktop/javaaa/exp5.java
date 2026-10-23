import java.util.Scanner;

class Message {
    String message;

    Message(String message) {
        this.message = message;
    }
}

class CheckScam extends Message {
    int score = 0;

    CheckScam(String message) {
        super(message);
    }

    void check() {
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
    }

    void display() {
        System.out.println("Checking Scam...");
    }
}

class Result extends CheckScam {
    Result(String message) {
        super(message);
    }

    @Override
    void display() {
        System.out.println("Message: " + message);
        System.out.println("Risk Score: " + score);

        if (score >= 60) {
            System.out.println("HIGH RISK");
        } else if (score >= 20) {
            System.out.println("MEDIUM RISK");
        } else {
            System.out.println("LOW RISK");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Message: ");
        String msg = sc.nextLine();

        Result obj = new Result(msg);
        obj.check();
        obj.display();

        sc.close();
    }
}