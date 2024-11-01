import java.util.Scanner;

public class p2 {

    public static int computeParity(String binaryString) {
        int parityValue = 0;
        for (char digit : binaryString.toCharArray()) {
            parityValue ^= (digit - '0'); 
        }
        return parityValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the binary sequence: ");
        String binaryInput = scanner.nextLine();

        int parityBit = computeParity(binaryInput);
        System.out.println("Calculated parity bit is: " + parityBit);

        scanner.close();
    }
}
