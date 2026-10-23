import java.util.Scanner;

class Message {
    String message;

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Message: ");
        message = sc.nextLine();
    }
}

class CheckScam extends Message {
    int score = 0;

    void check() {
        String[] scamWords = {"otp", "winner", "lottery", "free", "click"};
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

class Result extends Message {
    void display(int score) {
        System.out.println("Message : " + message);
        System.out.println("Risk Score: " + score);

        if (score >= 60) {
            System.out.println("Risk Level: High Risk");
        } else if (score >= 20) {
            System.out.println("Risk Level: Medium Risk");
        } else {
            System.out.println("Risk Level: Low Risk");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CheckScam obj1 = new CheckScam();
        obj1.input();
        obj1.check();

        Result obj2 = new Result();
        obj2.message = obj1.message;
        obj2.display(obj1.score);
    }
}