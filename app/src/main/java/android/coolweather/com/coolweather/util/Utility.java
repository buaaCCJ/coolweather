package android.coolweather.com.coolweather.util;

import android.coolweather.com.coolweather.db.City;
import android.coolweather.com.coolweather.db.Couty;
import android.coolweather.com.coolweather.db.Province;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by buaa-ccj on 2017/3/18.
 */
//工具包类
public class Utility {

    //解析和处理服务器返回的省级数据
    public  static  boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response))
            try{
                JSONArray allProvinces=new JSONArray(response);
                for (int i=0;i<allProvinces.length();i++)
                {
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return  true;

            }catch (JSONException e)
            {
                e.printStackTrace();
            }
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response))
            try{
                JSONArray allCities=new JSONArray(response);
                for (int i=0;i<allCities.length();i++)
                {
                    City city=new City();
                    JSONObject cityObject=allCities.getJSONObject(i);
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceID(provinceId);
                    city.save();

                }
                return  true;

            }catch (JSONException e)
            {e.printStackTrace();}
        return false;
    }

    public static  boolean handleCountyResponse(String response,int cityId)
    {
        if(!TextUtils.isEmpty(response))
            try{
                JSONArray allCounties=new JSONArray(response);
                for (int i=0;i<allCounties.length();i++)
                {
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    Couty county=new Couty();
                    county.setCityId(cityId);
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.save();//保存到数据库
                }
                return  true;
            }catch (JSONException e)
            {e.printStackTrace();}
        return false;
    }
}

