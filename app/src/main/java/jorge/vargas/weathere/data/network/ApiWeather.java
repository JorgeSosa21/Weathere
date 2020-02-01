package jorge.vargas.weathere.data.network;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiWeather {
    @Headers("Content-Type: application/json")
    @GET(Urls.GET_BY_ID)
    Call<JsonElement> getById(@Query("id") String id, @Query("appid") String apiKey, @Query("units") String units, @Query("lang") String language);

    @Headers("Content-Type: application/json")
    @GET(Urls.GET_BY_GROUP)
    Call<JsonElement> getByGroupId(@Query("id") String id, @Query("appid") String apiKey, @Query("units") String units, @Query("lang") String language);
}
