package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import koffi.simplifiedcodingalpha.com.jonadanapaul.R;
import koffi.simplifiedcodingalpha.com.jonadanapaul.adapter.RelevanteFehlerbilderAdapter;
import koffi.simplifiedcodingalpha.com.jonadanapaul.database.LocalStorageDB;
import koffi.simplifiedcodingalpha.com.jonadanapaul.model.RelevanteFehlebilderModel;

import static koffi.simplifiedcodingalpha.com.jonadanapaul.utils.SaveLocalStorage.getValueFromSharedPreferences;

public class ProjektInit4von4Act extends AppCompatActivity {

    ArrayList<RelevanteFehlebilderModel> verfugbareList;
    ArrayList<RelevanteFehlebilderModel> showVerfugbareList;
    RelevanteFehlerbilderAdapter relevanteFehlerbilderAdapter;
    @BindView(R.id.lv_verfugbare_mitarbeiter)
    ListView lvVerfugbare;
    @BindView(R.id.lv_show_selected)
    ListView showLvVerfugbare;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.rl_next)
    RelativeLayout rlNext;
    @BindView(R.id.txv_projk_item)
    TextView txvProjekItem;


    boolean isMA0;
    boolean isMA1;
    boolean isMA2;
    boolean isMA3;
    boolean isMA4;
    boolean isMA5;
    boolean isMA6;
    boolean isMA7;
    boolean isMA8;
    boolean isMA9;
    boolean isMA10;
    boolean isMA11;
    boolean isMA12;

    LocalStorageDB localStorageDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projekt_init4von4);
        initViews();

    }

    public void initViews(){
        ButterKnife.bind(this);
        setOnClickListener();
        String getProjektItem = getValueFromSharedPreferences("projekt_exist", ProjektInit4von4Act.this);
        if (getProjektItem!=null){
            txvProjekItem.setText(getProjektItem);
        }

        localStorageDB = new LocalStorageDB(ProjektInit4von4Act.this);
        verfugbareList = new ArrayList<>();
        showVerfugbareList= new ArrayList<>();
        verfugbareList.add(new RelevanteFehlebilderModel("MA1"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA2"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA3"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA4"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA5"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA6"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA7"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA8"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA9"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA10"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA11"));
        verfugbareList.add(new RelevanteFehlebilderModel("MA12"));

        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(verfugbareList,ProjektInit4von4Act.this);
        lvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);

        lvVerfugbare.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adpterView, View view, int position,
                                    long id) {
               // RelevanteFehlebilderModel relevanteFehlebilderModel = relevanteFehlebilderModel.get(position);

                if(position==0){
                    if(!isMA0){
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA0 =true;

                         localStorageDB.open();
                         localStorageDB.saveItemName("MA1");

                         showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);

                    }else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA0=false;

                        localStorageDB.open();
                        localStorageDB.delete("MA1");
                        showVerfugbareList= localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    }


                }

                else if(position==1) {
                    if (!isMA1) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA1 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA2");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA1 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA2");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                }else if(position==2){

                    if (!isMA2) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA2 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA3");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA2 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA3");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }

                }else if(position==3){
                    if (!isMA3) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA3 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA4");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA3 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA4");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }

                }

                else if(position==4){
                    if (!isMA4) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA4 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA5");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA4 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA5");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }


                }else if(position==5){
                    if (!isMA5) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA5 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA6");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA5 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA6");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }


                }else if(position==6){
                    if (!isMA6) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA6 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA7");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA6 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA7");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                }else if(position==7){
                    if (!isMA7) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA7 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA8");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA7 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA8");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                }else if(position==8){
                    if (!isMA8) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA8 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA9");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA8 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA9");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                }else if(position==9){
                    if (!isMA9) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA9 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA10");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA9 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA10");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }


                }else if (position==10){
                    if (!isMA10) {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA10 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA11");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA10 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA11");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                }else if(position==11){
                    if (!isMA11) {
                         lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        isMA11 = true;

                        localStorageDB.open();
                        localStorageDB.saveItemName("MA12");

                        showVerfugbareList = localStorageDB.getAllData();
                        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                        showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                    } else {
                        lvVerfugbare.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.white));
                        isMA11 = false;

                        try{
                            localStorageDB.open();
                            localStorageDB.delete("MA12");
                            showVerfugbareList= localStorageDB.getAllData();

                            relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(showVerfugbareList,ProjektInit4von4Act.this);
                            showLvVerfugbare.setAdapter(relevanteFehlerbilderAdapter);
                        }catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                        }

                    }
                }

            }
        });

    }

    public void setOnClickListener(){
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjektInit4von4Act.this,ProjektInit3von4Act.class);
                startActivity(intent);
            }
        });

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjektInit4von4Act.this,FehlerauFnahmeAct.class);
                startActivity(intent);
            }
        });
    }
}
