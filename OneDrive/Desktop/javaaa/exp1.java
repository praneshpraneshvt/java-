class ScamShieldSystem {
    String senderNumber;
    String message;
    int riskScore;
    boolean isScam;

    public ScamShieldSystem(String sender, String msg, int score) {
        senderNumber = sender;
        message = msg;
        riskScore = score;
        isScam = (riskScore >= 60);
    }

    public void displayResult() {
        System.out.println("------------------------------");
        System.out.println("Sender     : " + senderNumber);
        System.out.println("Message    : " + message);
        System.out.println("Risk Score : " + riskScore);
        System.out.println("Status     : " + (isScam ? "Scam" : "Safe"));
        System.out.println("------------------------------");
    }
}

public class ScamShieldDemo {
    public static void main(String[] args) {
        ScamShieldSystem msg1 = new ScamShieldSystem(
            "+91-9876543210",
            "Congratulations! You WON a free gift, click here to claim your prize!",
            80
        );

        msg1.displayResult();
    }
}