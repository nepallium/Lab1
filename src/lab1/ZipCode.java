package lab1;

import java.util.Arrays;

/**
 *
 * @author Alex Huang 2476382
 */
public class ZipCode {

    public int Zip = -1;
    private String barCode = "";

    private static String[] digitWeights
            = {
                "11000",
                "00011",
                "00101",
                "00110",
                "01001",
                "01010",
                "01100",
                "10001",
                "10010",
                "10100"
            };

    public ZipCode(int code) {
        this.Zip = code;
    }

    public ZipCode(String barCode) {
        if ((barCode.length() - 2) % 5 != 0) {
            System.out.println("Error: bar code must be in multiples of 5-binary digits");
            return;

        } else if (barCode.charAt(0) != '1' || barCode.charAt(barCode.length() - 1) != '1') {
            System.out.println("Error: bar code missing a 1 at start or end");
            return;
        }

        this.Zip = this.parseBarCode(barCode);
    }

    public String GetBarCode() {
        if (this.Zip == -1) {
            System.out.println("The zip is invalid -1 error");
            return "";
        }

        String codeStr = String.valueOf(this.Zip);

        if (codeStr.length() > 5) {
            System.out.println(this.Zip + " zip code is more than 5 digits");
            codeStr = String.valueOf(this.Zip % 100000);
        }

        if (codeStr.length() < 5) {
            codeStr = String.format("%05d", Integer.valueOf(codeStr));
        }

        this.barCode += "1";
        for (char digit : codeStr.toCharArray()) {
            this.barCode += digitWeights[Character.getNumericValue(digit)];
        }
        this.barCode += "1";

        return barCode;
    }

    /**
     * Converts a binary string bar code into the 5 digit zip code equivalent
     * 
     * @param barCodeStr
     * @return the parsed Zip code
     */
    private int parseBarCode(String barCodeStr) {
        barCodeStr = barCodeStr.substring(1, barCodeStr.length() - 1);

        String zipStr = "";

        boolean invalidDigits = false;
        for (int i = 0; i < barCodeStr.length(); i += 5) {
            String digitChars = barCodeStr.substring(i, i + 5);

            boolean foundDigit = false;
            for (int j = 0; j < digitWeights.length; j++) {
                if (digitWeights[j].equals(digitChars)) {
                    zipStr += j;
                    foundDigit = true;
                }
            }

            for (char c : digitChars.toCharArray()) {
                if (c != '1' && c != '0') {
                    System.out.printf("bar code character: %c must be '0' or '1'\n", c);
                    invalidDigits = true;
                }
            }

            if (!foundDigit && !invalidDigits) {
                zipStr = "-1";
                System.out.println(digitChars + " has invalid sequence in the bar code");
            }
        }

        return Integer.parseInt(zipStr);
    }
}
