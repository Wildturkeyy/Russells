package day0429.ch17.renterCar.res;

public class ResVO {
    //필드 선언
    private String resNumber;
    private  String resCarNumber;
    private String resDate;
    private String useBeginDate;
    private String returnDate;

    //생성자 호출
    public ResVO(){}

    public ResVO(String resNumber, String resCarNumber, String resDate, String useBeginDate, String returnDate) {
        this.resNumber = resNumber;
        this.resCarNumber = resCarNumber;
        this.resDate = resDate;
        this.useBeginDate = useBeginDate;
        this.returnDate = returnDate;
    }

    // getter setter

    public String getResNumber() {
        return resNumber;
    }

    public void setResNumber(String resNumber) {
        this.resNumber = resNumber;
    }

    public String getResCarNumber() {
        return resCarNumber;
    }

    public void setResCarNumber(String resCarNumber) {
        this.resCarNumber = resCarNumber;
    }

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    public String getUseBeginDate() {
        return useBeginDate;
    }

    public void setUseBeginDate(String useBeginDate) {
        this.useBeginDate = useBeginDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
