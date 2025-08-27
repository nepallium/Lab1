package lab1;

/**
 *
 * @author 2476382
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
        if (barCode.length() < 2) {
            return;
        } else if (barCode.charAt(0) != '1' || barCode.charAt(barCode.length() - 1) != '1') {
            System.out.println("Error: bar code missing a 1 at start or end");
            return;
        } else if ((barCode.length() - 2) % 5 != 0) {
            System.out.println("Error: bar code must be in multiples of 5-binary digits");
        }

//        for (int i = 0; i < barCode.length; i += 5) {
//            
//        }
        this.barCode = barCode;
    }

    public String GetBarCode() {
        if (this.Zip == -1) {
            System.out.println("The zip is invalid -1 error");
            return "";
        }

        String codeStr = String.valueOf(this.Zip);

        if (codeStr.length() > 5) {
            System.out.println(this.Zip + " zip code is more than 5 digits");
        }

        if (codeStr.length() < 5) {
            codeStr = String.format("%05d", codeStr);
        }

        this.barCode += "1";
        for (char digit : codeStr.toCharArray()) {
            this.barCode += digitWeights[Character.getNumericValue(digit)];
        }
        this.barCode += "1";
        
        return barCode;
    }

//    private int parseBarCode(String barCodeStr) {
//        
//    }
}
