package telecomProvider;

public class Phone {

    private PhoneType type;

    private String areaCode;

    private String uniqueNumber;

    private String customerId;

    private boolean active;

    public Phone(PhoneType type,String id,String area,String num){
        this.type = type;
        this.customerId = id;
        this.areaCode = area;
        this.uniqueNumber = num;
        this.active = Boolean.FALSE;

    }

    public void setActive(){
        this.active = Boolean.TRUE;
    }

    public Boolean getActive(){
        return this.active;
    }
    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
