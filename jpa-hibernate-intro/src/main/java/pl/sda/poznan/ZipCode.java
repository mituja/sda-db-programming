package pl.sda.poznan;

import javax.persistence.Embeddable;

@Embeddable //zagnieżdżenie
public class ZipCode {

    private String city;
    private String code;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
