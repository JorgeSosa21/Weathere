package jorge.vargas.weathere.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import jorge.vargas.weathere.R;
import jorge.vargas.weathere.data.network.ApiCallback;
import jorge.vargas.weathere.data.network.ApiRequest;
import jorge.vargas.weathere.model.City;
import jorge.vargas.weathere.model.Weather;
import jorge.vargas.weathere.view.activity.AddCityActivity;
import jorge.vargas.weathere.view.adapter.CityAdapter;

public class MainActivityViewModel implements ApiCallback {
    private Activity activity;
    private ApiRequest apiRequest;
    private List<City> cityList = new ArrayList<>();
    private CityAdapter cityAdapter;

    public MainActivityViewModel(Activity activity){
        apiRequest = new ApiRequest(this);
        cityAdapter = new CityAdapter(R.layout.item_city, this);
        this.activity = activity;

        apiRequest.getWeatherByGroup("3530597,3521082,3514783,3995465");
    }

    public void onAddCityClick(){
        Intent intent = new Intent(activity, AddCityActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.anim_up_activity, R.anim.anim_state_activity);
    }

    public void onItemClick(int position){

    }

    public City getCityAt(Integer position){
        return cityList.get(position);
    }

    public CityAdapter getCityAdapter(){
        return cityAdapter;
    }

    @Override
    public void onSuccess(JsonElement response) {
        try{
            JSONObject jsonList = new JSONObject(response.toString());
            JSONArray array = jsonList.getJSONArray("list");

            for(int i = 0; i < array.length(); i++) {
                JSONObject json = array.getJSONObject(i);

                City city = new City();
                Weather weather = new Weather();

                city.setName(json.getString("name"));
                city.setId(json.getLong("id"));
                city.setLongitude(json.getJSONObject("coord").getLong("lon"));
                city.setLatitude(json.getJSONObject("coord").getLong("lat"));
                city.setSunrise(json.getJSONObject("sys").getLong("sunrise"));
                city.setSunset(json.getJSONObject("sys").getLong("sunset"));

                weather.setTemp(json.getJSONObject("main").getLong("temp"));
                weather.setDescription(json.getJSONArray("weather").getJSONObject(0).getString("description"));
                weather.setHumidity(json.getJSONObject("main").getInt("humidity"));
                weather.setWindSpeed(json.getJSONObject("wind").getInt("speed"));

                city.setWeather(weather);

                cityList.add(city);
                cityAdapter.setCityList(cityList);
                cityAdapter.notifyDataSetChanged();
            }
        }catch (JSONException e){
            Log.e("ERROR", e.getMessage());
        }
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onAccessDenied() {

    }
}
