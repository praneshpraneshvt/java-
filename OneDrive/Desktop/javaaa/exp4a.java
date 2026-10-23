import java.util.Scanner;

class Message {
    String message;
}

class CheckScam extends Message {
    int score = 0;

    void check() {
        String[] scamWords = {
            "otp", "winner", "lottery", "free", "click"
        };

        String[] words = message.toLowerCase().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < scamWords.length; j++) {
                if (words[i].equals(scamWords[j])) {
                    score = score + 20;
                }
            }
        }
    }
}

class Result extends CheckScam {
    void display() {
        System.out.println("Message : " + message);

        if (score >= 60) {
            System.out.println("Risk Level : High Risk");
        } else if (score >= 20) {
            System.out.println("Risk Level : Medium Risk");
        } else {
            System.out.println("Risk Level : Low Risk");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Result obj = new Result();

        System.out.print("Enter Message: ");
        obj.message = sc.nextLine();

        obj.check();
        obj.display();

        sc.close();
    }
}