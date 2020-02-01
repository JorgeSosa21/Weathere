package jorge.vargas.weathere.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class AnimExpandCard {
    View view;

    public AnimExpandCard(View view){
        this.view = view;
    }

    public void expand(){
        /*AnimationSet set = new AnimationSet(true);

        Animation anim = new ScaleAnimation(1f, 0f, 1f, 0f, 1f, 1f);
        Animation animT = new TranslateAnimation(0f, "", 0f, "");

        set.addAnimation(anim);
        set.addAnimation(animT);
        set.setDuration(130);

        view.startAnimation(set);*/
    }
}
