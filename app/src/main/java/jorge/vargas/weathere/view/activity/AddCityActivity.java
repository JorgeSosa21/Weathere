package jorge.vargas.weathere.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jorge.vargas.weathere.R;

public class AddCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
    }

    @Override
    public void onBackPressed(){
        finish();
        overridePendingTransition(R.anim.anim_state_activity, R.anim.anim_down_activity);
    }
}
