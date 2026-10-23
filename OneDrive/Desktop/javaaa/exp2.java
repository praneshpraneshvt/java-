class ScamShieldSystem {
    String senderNumber;
    String message;
    int riskScore;
    boolean isScam;
    private String scamType;
    public static int totalMessages = 0;

    public ScamShieldSystem(String sender, String msg, int score,
                            boolean scamStatus, String type) {
        senderNumber = sender;
        message = msg;
        riskScore = score;
        isScam = scamStatus;
        scamType = type;
        totalMessages++;
    }

    private void showScamType() {
        System.out.println("Scam Type   : " + scamType);
    }

    public void displayResult() {
        System.out.println("======================================");
        System.out.println("Sender      : " + senderNumber);
        System.out.println("Message     : " + message);
        System.out.println("Risk Score  : " + riskScore);
        System.out.println("Status      : " + isScam);
        showScamType();
    }

    public static void showTotalMessages() {
        System.out.println("======================================");
        System.out.println("Total Messages Scanned : " + totalMessages);
        System.out.println("======================================");
    }
}

public class Scam {
    public static void main(String[] args) {
        ScamShieldSystem msg1 = new ScamShieldSystem(
            "+91-9876543210",
            "Congratulations! You WON a free gift, click here to claim your prize!",
            80,
            true,
            "Lottery Scam"
        );

        msg1.displayResult();
        ScamShieldSystem.showTotalMessages();
    }
}