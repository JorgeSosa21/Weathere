package jorge.vargas.weathere.data.network;

import androidx.annotation.NonNull;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static jorge.vargas.weathere.data.network.RetrofitBuilder.buildRetrofit;

public class ApiRequest {
    private ApiCallback apiCallback;

    public ApiRequest(ApiCallback apiCallback){
        this.apiCallback = apiCallback;
    }

    public void getWeatherById(String id){
        Retrofit retrofit = buildRetrofit();
        final ApiWeather apiWeather = retrofit.create(ApiWeather.class);
        Call<JsonElement> call = apiWeather.getById(id, Urls.API_KEY, "metric", "es");

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(@NonNull Call<JsonElement> call, @NonNull Response<JsonElement> response) {
                switch (response.code()){
                    case 200:
                        apiCallback.onSuccess(response.body());
                        break;
                    case 401:
                        apiCallback.onAccessDenied();
                        break;
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonElement> call, @NonNull Throwable t) {
                apiCallback.onError(t.getMessage());
            }
        });
    }

    public void getWeatherByGroup(String id){
        Retrofit retrofit = buildRetrofit();
        final ApiWeather apiWeather = retrofit.create(ApiWeather.class);
        Call<JsonElement> call = apiWeather.getByGroupId(id, Urls.API_KEY, "metric", "es");

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(@NonNull Call<JsonElement> call, @NonNull Response<JsonElement> response) {
                switch (response.code()){
                    case 200:
                        apiCallback.onSuccess(response.body());
                        break;
                    case 401:
                        apiCallback.onAccessDenied();
                        break;
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonElement> call, @NonNull Throwable t) {
                apiCallback.onError(t.getMessage());
            }
        });
    }
}
