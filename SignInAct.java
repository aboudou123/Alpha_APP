package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import koffi.simplifiedcodingalpha.com.jonadanapaul.R;
import koffi.simplifiedcodingalpha.com.jonadanapaul.utils.Utility;

public class SignInAct extends AppCompatActivity {

    @BindView(R.id.edt_user_name)
    EditText edtUserName;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.lin_submit)
    LinearLayout linSubmit;
    @BindView(R.id.spin_role)
    Spinner spRolle;
    @BindView(R.id.spin_projekt)
    Spinner spProjekt;
    Utility utility;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initViews();

    }

    public void initViews(){
        utility = new Utility(SignInAct.this);

        ButterKnife.bind(this);
        setOnClickListener();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinner_role, R.layout.spinner_row);
         spRolle.setAdapter(adapter);

        ArrayAdapter adapte1 = ArrayAdapter.createFromResource(this, R.array.spinner_projekt, R.layout.spinner_row);
        spProjekt.setAdapter(adapte1);
    }

    public void setOnClickListener(){
            linSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String username = edtUserName.getText().toString();
                    String password = edtPassword.getText().toString();
                    if (username.equals("Koffi")&& password.equals("123")){
                        Intent intent = new Intent(SignInAct.this,MainActivity.class);
                        startActivity(intent);
                        ActivityCompat.finishAffinity(SignInAct.this);
                    }else {
                      ///  Toast.makeText(SignInAct.this,"Your User name Or password not Valid",Toast.LENGTH_LONG).show();

                        utility.showDialog("Login !","Your User name Or password not Valid");


                    }



                }
            });
    }




}
