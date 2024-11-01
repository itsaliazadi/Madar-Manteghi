public class p1 {

    public static int calculateParityBit(String codeword, int bitPosition) {
        int parityBit = 0;
        for (int i = bitPosition - 1; i < codeword.length(); i += 2 * bitPosition) {
            for (int j = 0; j < bitPosition && (i + j) < codeword.length(); j++) {
                parityBit ^= (codeword.charAt(i + j) - '0');
            }
        }
        return parityBit;
    }

    public static int detectError(String codeword) {
        int positionWithError = 0;
        int numberOfParities = (int) Math.ceil(Math.log(codeword.length()) / Math.log(2));
        for (int i = 0; i <= numberOfParities; i++) {
            if (calculateParityBit(codeword, (1 << i)) != 0) {
                positionWithError += (1 << i);
            }
        }
        return positionWithError;
    }

    public static void validateHammingCode(String codeword) {
        int errorBitPosition = detectError(codeword);
        if (errorBitPosition == 0) {
            System.out.println("No errors found in the code.");
        } else {
            System.out.println("Error located at position: " + errorBitPosition);
            StringBuilder fixedCodeword = new StringBuilder(codeword);
            fixedCodeword.setCharAt(errorBitPosition - 1, 
                (fixedCodeword.charAt(errorBitPosition - 1) == '0') ? '1' : '0');
            System.out.println("Repaired code: " + fixedCodeword);
        }
    }

    public static void main(String[] args) {
        String[] codewords = {
            "0110011001001100", 
            "0001110111011100",  
            "0000000011110000"   
        };

        for (int i = 0; i < codewords.length; ++i) {
            System.out.println("Analyzing codeword " + (char)('a' + i) + ": " + codewords[i]);
            validateHammingCode(codewords[i]);
            System.out.println("");
        }
    }
}

