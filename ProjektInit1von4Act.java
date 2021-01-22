package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import koffi.simplifiedcodingalpha.com.jonadanapaul.R;

import static koffi.simplifiedcodingalpha.com.jonadanapaul.utils.SaveLocalStorage.saveToSharedPreferences;

public class ProjektInit1von4Act extends AppCompatActivity {
    @BindView(R.id.spin_exist)
    Spinner spinExist;
    @BindView(R.id.spin_obarkategorie)
    Spinner spinObarkategorie;
    @BindView(R.id.spin_untercategorie)
    Spinner spinUntercategorie;
    @BindView(R.id.spin_bildocument)
    Spinner spinBildocument;
    @BindView(R.id.spin_prüfart)
    Spinner spinprüfart;
    @BindView(R.id.spin_packeinheit)
    Spinner spinPackeinheit;
    @BindView(R.id.spin_identifikationsart)
    Spinner spinIdentifikationsart;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.rl_next)
    RelativeLayout rlNext;

    CheckBox ckbLogistik,ckbSap,ckbUmpack;


    String projectName = " ";
    String bildDocu = " ";
    String profart = " ";
    String packeInheit = " ";
    String identiFType = " ";

    String oberCateg = " ";
    String undercategori = " ";

    String logistik = " ";
    String sap = " ";
    String umpack  = " ";

 //   ArrayList<String>


    private boolean isSpinnerTouched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projekt_init1_von4);

        initViews();
    }

    public void initViews(){
        ckbLogistik = findViewById(R.id.chk_logistik);
        ckbSap = findViewById(R.id.chk_sap);
        ckbUmpack = findViewById(R.id.chk_umpacken);



        ButterKnife.bind(this);
        setOnClickListener();

        ArrayAdapter adapte1 = ArrayAdapter.createFromResource(this, R.array.spinner_projekt, R.layout.spinner_row);
        spinExist.setAdapter(adapte1);
//      detect touch spinner
        spinExist.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });

        // How to select spinner item
        spinExist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "This is " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                if (!isSpinnerTouched) {
                    return;
                }


                projectName = adapterView.getItemAtPosition(i).toString();

               // System.out.println(projectName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
               // Toast.makeText(getApplicationContext(), "You Not any Project Item", Toast.LENGTH_LONG).show();
            }
        });




        ArrayAdapter adapteBild = ArrayAdapter.createFromResource(this, R.array.spinner_bildocument, R.layout.spinner_row);
        spinBildocument.setAdapter(adapteBild);

        //      detect touch spinner
        spinBildocument.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });

        // How to select spinner item
        spinBildocument.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "This is " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                if (!isSpinnerTouched) {
                    return;
                }


                bildDocu = adapterView.getItemAtPosition(i).toString();

                // System.out.println(projectName);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(getApplicationContext(), "You Not any Project Item", Toast.LENGTH_LONG).show();
            }
        });


        ArrayAdapter adaptePrufart = ArrayAdapter.createFromResource(this, R.array.spinner_prüfart, R.layout.spinner_row);
        spinprüfart.setAdapter(adaptePrufart);

        //      detect touch spinner
        spinprüfart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });

        // How to select spinner item
        spinprüfart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "This is " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                if (!isSpinnerTouched) {
                    return;
                }

                profart = adapterView.getItemAtPosition(i).toString();

                // System.out.println(projectName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(getApplicationContext(), "You Not any Project Item", Toast.LENGTH_LONG).show();
            }
        });



        ArrayAdapter adapterPackeinheit = ArrayAdapter.createFromResource(this, R.array.spinner_packeinheit, R.layout.spinner_row);
        spinPackeinheit.setAdapter(adapterPackeinheit);

        //      detect touch spinner
        spinPackeinheit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });

        // How to select spinner item
        spinPackeinheit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "This is " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                if (!isSpinnerTouched) {
                    return;
                }


                packeInheit = adapterView.getItemAtPosition(i).toString();

                // System.out.println(projectName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(getApplicationContext(), "You Not any Project Item", Toast.LENGTH_LONG).show();
            }
        });


        ArrayAdapter adapterIdentifikation = ArrayAdapter.createFromResource(this, R.array.spinner_identifikationsart, R.layout.spinner_row);
        spinIdentifikationsart.setAdapter(adapterIdentifikation);

        //      detect touch spinner
        spinIdentifikationsart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });

        // How to select spinner item
        spinIdentifikationsart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "This is " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                if (!isSpinnerTouched) {
                    return;
                }

                identiFType = adapterView.getItemAtPosition(i).toString();

                // System.out.println(projectName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(getApplicationContext(), "You Not any Project Item", Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter adapterOberCate = ArrayAdapter.createFromResource(this, R.array.obercategori_list, R.layout.spinner_row);
        spinObarkategorie.setAdapter(adapterOberCate);

        //      detect touch spinner
        spinObarkategorie.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });

        // How to select spinner item
        spinObarkategorie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "This is " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                if (!isSpinnerTouched) {
                    return;
                }


                oberCateg = adapterView.getItemAtPosition(i).toString();

                // System.out.println(projectName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(getApplicationContext(), "You Not any Project Item", Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter adapterUterCate = ArrayAdapter.createFromResource(this, R.array.Untercategori_list, R.layout.spinner_row);
        spinUntercategorie.setAdapter(adapterUterCate);

        //      detect touch spinner
        spinUntercategorie.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });

        // How to select spinner item
        spinUntercategorie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "This is " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                if (!isSpinnerTouched) {
                    return;
                }

                undercategori = adapterView.getItemAtPosition(i).toString();

                // System.out.println(projectName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(getApplicationContext(), "You Not any Project Item", Toast.LENGTH_LONG).show();
            }
        });

        String selectedProjekt = spinExist.getSelectedItem().toString();
        saveToSharedPreferences("projekt_exist",selectedProjekt,ProjektInit1von4Act.this);


        ckbLogistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ckbLogistik.isChecked()){
                        logistik = ckbLogistik.getText().toString();
                }
            }
        });

        ckbSap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ckbSap.isChecked()){
                    sap = ckbSap.getText().toString();
                }
            }
        });


        ckbUmpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ckbUmpack.isChecked()){
                    umpack = ckbUmpack.getText().toString();
                }
            }
        });
    }

    public void setOnClickListener(){
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjektInit1von4Act.this,MainActivity.class);
                startActivity(intent);
            }
        });

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjektInit1von4Act.this,ProjektInit2von4Act.class);
                startActivity(intent);
            }
        });

    }
}
