package lab1;

/**
 *
 * @author 2476382
 */
public class ZipCode {

    private Integer Zip = null;
    private String barCode;

    public ZipCode(int code) {
        if (String.valueOf(code).length() > 5) {
            System.out.println("The entered integer zip code has more than 5 digits");
        } else {
            this.Zip = code;

        }
    }

    public ZipCode(String barCode) {
        this.barCode = barCode;
    }

    public String GetBarCode() {
        if (this.Zip == null) {
            System.out.println("The zip is invalid (more than 5 digits)");
        }
        
        return barCode;
    }

}
