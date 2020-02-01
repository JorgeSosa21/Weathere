package jorge.vargas.weathere.data.network;

import com.google.gson.JsonElement;

public interface ApiCallback {
    void onSuccess(JsonElement response);

    void onError(String error);

    void onEmptyData();

    void onAccessDenied();
}
