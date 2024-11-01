import java.util.Scanner;

public class p3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 16-bit binary code: ");
        String code = scanner.nextLine();

        if (code.length() != 16) {
            System.out.println("Error: Code must be 16 bits long.");
            scanner.close();
            return;
        }

        checkAndFixHammingCode(code);
        scanner.close();
    }

    private static void checkAndFixHammingCode(String code) {
        int errorPosition = 0;
        int length = code.length();

        for (int i = 0; (1 << i) <= length; i++) {
            int paritySum = 0;
            for (int j = 1; j <= length; j++) {
                if ((j & (1 << i)) != 0) {
                    paritySum ^= (code.charAt(j - 1) - '0');
                }
            }
            if (paritySum != 0) {
                errorPosition += (1 << i);
            }
        }

        if (errorPosition == 0) {
            System.out.println("No error detected in the code.");
        } else {
            System.out.println("Error detected at position: " + errorPosition);
            char[] codeArray = code.toCharArray();
            codeArray[errorPosition - 1] = (codeArray[errorPosition - 1] == '0') ? '1' : '0';
            String correctedCode = new String(codeArray);
            System.out.println("Corrected code: " + correctedCode);
        }
    }
}
