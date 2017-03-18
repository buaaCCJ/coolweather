package android.coolweather.com.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by buaa-ccj on 2017/3/18.
 */

public class City extends DataSupport {
    private int id;
    private String CityName;
    private int cityCode;
    private  int provinceID;

    public int getId() {
        return id;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public String getCityName() {
        return CityName;
    }
}
