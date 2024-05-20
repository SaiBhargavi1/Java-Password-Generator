import java.security.SecureRandom;
import java.util.Scanner;

public class pass {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Boolean e = false;
        while (!e) {
            System.out.println("click 1 : Genarate new password");
            System.out.println("click 2: check password score");
            System.out.println("click 3: Rules");
            System.out.println("click 4:exit");
            int n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    Genaratepass(sc);
                    break;
                case 2:
                    checkscore(sc);
                    break;
                case 3:
                    rules();
                    break;
                case 4:
                    e = true;
                    break;
                default:
                    System.out.println("enter correct number:");
            }
        }
    }

    private static void Genaratepass(Scanner sc) {
        System.out.println("Do you want to use UpperCase (Yes/No)? ");
        Boolean useupper = sc.nextLine().equalsIgnoreCase("yes");
        System.out.println("Do you want to use LowerCase (Yes/No)? ");
        Boolean uselower = sc.nextLine().equalsIgnoreCase("yes");
        System.out.println("Do you want to use Digits (Yes/No)? ");
        Boolean usedigi = sc.nextLine().equalsIgnoreCase("yes");
        System.out.println("Do you want to use symbol (Yes/No)? ");
        Boolean usesym = sc.nextLine().equalsIgnoreCase("yes");
        System.out.println("enter the length of the password");
        int l = sc.nextInt();
        String pa = "";
        if (useupper)
            pa += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (uselower)
            pa += "abcdefghijklmnopqrstuvwxyz";
        if (usedigi)
            pa += "0123456789";
        if (usesym)
            pa += "<>,.?/[]{}:;()!@#$%^&*-+=|";
        String password = genpass(pa, l);
        System.out.println("New Password is :" + password);

    }

    private static String genpass(String pa, int l) {
        SecureRandom random = new SecureRandom();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < l; i++) {
            int ri = random.nextInt(pa.length());
            s.append(pa.charAt(ri));
        }
        return s.toString();
    }

    private static void checkscore(Scanner sc) {
        System.out.println("enter password to check score:");
        String password = sc.nextLine();
        boolean useUpperCase = password.matches(".*[A-Z].*");
        boolean useLowerCase = password.matches(".*[a-z].*");
        boolean useNumbers = password.matches(".*\\d.*");
        boolean useSymbols = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*");
        int length = password.length();
        int score = 0;
        if (useUpperCase)
            score++;
        if (useLowerCase)
            score++;
        if (useNumbers)
            score++;
        if (useSymbols)
            score++;
        if (length >= 8)
            score++;
        if (length >= 16)
            score++;
        if (score >= 5) {
            System.out.println("Great password!");
        } else if (score >= 4) {
            System.out.println("Good password!");
        } else if (score >= 3) {
            System.out.println("Medium password!");
        } else {
            System.out.println("Weak password!");
        }
    }

    private static void rules() {
        System.out.println("Useful information on password security:");
        System.out.println("- Avoid using the same password for multiple accounts.");
        System.out.println("- Avoid using easily guessable passwords, such as 'password', '123456', or 'qwerty'.");
        System.out.println("- Avoid character repetition (e.g., 'aaa' or '111').");
        System.out.println("- Avoid common keyboard patterns (e.g., 'asdfgh', 'qwertyuiop').");
        System.out.println("- Avoid using dictionary words or commonly known phrases.");
        System.out.println("- Avoid using letter or number sequences (e.g., 'abc123', '87654321').");
        System.out.println("- Consider using a passphrase composed of random words for increased security.");
    }
}
