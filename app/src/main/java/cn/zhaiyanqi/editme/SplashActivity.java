package cn.zhaiyanqi.editme;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

public class SplashActivity extends AppCompatActivity {

    private CardView cvLogo, cvLogo2;
    private TextView tvEdit, tvMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        cvLogo = findViewById(R.id.cv_logo);
        cvLogo = findViewById(R.id.cv_logo2);
        tvEdit = findViewById(R.id.tv_edit);
        tvMe = findViewById(R.id.tv_me);
        new Handler().postDelayed(this::startTransition, 500);
    }

    private void startTransition() {
        Intent intent = new Intent(this, MainActivity.class);
        Pair pair = new Pair<>(cvLogo, "cv_logo");
        Pair pair1 = new Pair<>(cvLogo, "cv_logo2");
        Pair pair2 = new Pair<>(tvEdit, "tv_edit");
        Pair pair3 = new Pair<>(tvMe, "tv_me");
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this, pair, pair1, pair2, pair3);
        ActivityCompat.startActivity(this, intent, options.toBundle());
        new Handler().postDelayed(() -> ActivityCompat.finishAfterTransition(this), 1000);
    }
}
