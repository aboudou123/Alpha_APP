package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import koffi.simplifiedcodingalpha.com.jonadanapaul.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lin_logout)
    LinearLayout linLogout;

    @BindView(R.id.lin_pro_init)
    LinearLayout linProjektInit;

    @BindView(R.id.lin_fehler)
    LinearLayout ic_fehler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        ButterKnife.bind(this);
        setOnClickListener();
    }

    public void setOnClickListener(){
        linLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignInAct.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(MainActivity.this);

            }
        });

        linProjektInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProjektInit1von4Act.class);
                startActivity(intent);
               // ActivityCompat.finishAffinity(MainActivity.this);

            }
        });


        ic_fehler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProjektInit3von4Act.class);
                startActivity(intent);
                // ActivityCompat.finishAffinity(MainActivity.this);

            }
        });


    }

}
