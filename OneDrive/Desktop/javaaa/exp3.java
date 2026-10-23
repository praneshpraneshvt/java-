import java.util.Scanner;

class ScamShieldSystem2 {
    String senderNumber;
    String message;
    int riskScore = 0;

    public ScamShieldSystem2(String sender, String msg) {
        senderNumber = sender;
        message = msg;
    }

    void checkScam() {
        String[] scamWords = {
            "winner", "free", "lottery", "click", "otp"
        };

        String[] words = message.toLowerCase().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < scamWords.length; j++) {
                if (words[i].equals(scamWords[j])) {
                    riskScore += 20;
                }
            }
        }
    }

    void displayResult() {
        System.out.println("Sender : " + senderNumber);
        System.out.println("Message : " + message);
        System.out.println("Risk Score : " + riskScore);

        if (riskScore >= 60) {
            System.out.println("Risk Level : High Risk");
        } else if (riskScore >= 20) {
            System.out.println("Risk Level : Medium Risk");
        } else {
            System.out.println("Risk Level : Low Risk");
        }
    }
}

public class Scam2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Sender Number: ");
        String sender = sc.nextLine();

        System.out.print("Enter Message: ");
        String msg = sc.nextLine();

        ScamShieldSystem2 obj =
            new ScamShieldSystem2(sender, msg);

        obj.checkScam();
        obj.displayResult();

        sc.close();
    }
}