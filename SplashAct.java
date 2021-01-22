package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import koffi.simplifiedcodingalpha.com.jonadanapaul.R;

import static koffi.simplifiedcodingalpha.com.jonadanapaul.utils.SaveLocalStorage.getBoleanValueSharedPreferences;

public class SplashAct extends AppCompatActivity {
    static boolean isSignIn ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initViews();

    }

    public void initViews(){
        isSignIn = getBoleanValueSharedPreferences("sign_in",SplashAct.this);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

               // if(isSignIn){
                    Intent intent = new Intent(SplashAct.this,SignInAct.class);
                    startActivity(intent);
                    ActivityCompat.finishAffinity(SplashAct.this);
//                }else {
//                    Intent intent = new Intent(SplashAct.this,MainActivity.class);
//                    startActivity(intent);
//                    ActivityCompat.finishAffinity(SplashAct.this);
//                }




            }
        }, 2000);
    }

}
