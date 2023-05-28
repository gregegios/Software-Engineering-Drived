import java.util.*;

public class Insurance {
    public int insurance_id;
    public String company_name;
    public int car_id;
    public String pinakida;
    private float insurancePrice;
    private Date insuranceDate;

    public Insurance(int insurance_id, String company_name, int car_id, String pinakida, float insurancePrice, Date insuranceDate) {
        this.insurance_id = insurance_id;
        this.company_name = company_name;
        this.car_id = car_id;
        this.pinakida = pinakida;
        this.insurancePrice = insurancePrice;
        this.insuranceDate = insuranceDate;
    }

    public int getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(int insurance_id) {
        this.insurance_id = insurance_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }



    public void setCar_id(car car) {
        this.car_id = car.getCar_id();
    }

    public void setPinakida(car car) {
        this.pinakida = car.getPinakida();
    }

    public float getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(float insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }
}
