package koffi.simplifiedcodingalpha.com.jonadanapaul.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import koffi.simplifiedcodingalpha.com.jonadanapaul.R;
import koffi.simplifiedcodingalpha.com.jonadanapaul.adapter.RelevanteFehlerbilderAdapter;
import koffi.simplifiedcodingalpha.com.jonadanapaul.model.RelevanteFehlebilderModel;

import static koffi.simplifiedcodingalpha.com.jonadanapaul.utils.SaveLocalStorage.getValueFromSharedPreferences;


public class ProjektInit3von4Act extends AppCompatActivity {

    ArrayList<RelevanteFehlebilderModel> rFehlerList;
    RelevanteFehlebilderModel relevanteFehlebilderModel;
    @BindView(R.id.lv_rel_fehler)
    ListView lvRelFehler;
    RelevanteFehlerbilderAdapter relevanteFehlerbilderAdapter;
    boolean isFirstSKratzer;
    boolean isFirstLunker;
    boolean isFirstEinchurung;
    @BindView(R.id.txv_projk_item)
    TextView txvProjekItem;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.rl_next)
    RelativeLayout rlNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projekt_init3von4);
        initViews();
    }

    public void initViews(){
        ButterKnife.bind(this);
        setOnClickListener();
        String getProjektItem = getValueFromSharedPreferences("projekt_exist", ProjektInit3von4Act.this);
        if (getProjektItem!=null){
            txvProjekItem.setText(getProjektItem);
        }

        rFehlerList = new ArrayList<>();
        rFehlerList.add(new RelevanteFehlebilderModel("Einschnurung"));
        rFehlerList.add(new RelevanteFehlebilderModel("Lunker"));
        rFehlerList.add(new RelevanteFehlebilderModel("Kratzer"));

        relevanteFehlerbilderAdapter = new RelevanteFehlerbilderAdapter(rFehlerList,ProjektInit3von4Act.this);
        lvRelFehler.setAdapter(relevanteFehlerbilderAdapter);

        lvRelFehler.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adpterView, View view, int position,
                                    long id) {

                    if(position==0){
                        if(!isFirstEinchurung){
                            lvRelFehler.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                            isFirstEinchurung =true;
                        }else {
                            lvRelFehler.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.white));
                            isFirstEinchurung=false;
                        }


                    }else if(position==1){
                        if(!isFirstLunker){
                            lvRelFehler.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                            isFirstLunker= true;
                        }else {
                            lvRelFehler.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.white));
                            isFirstLunker= false;
                        }

                    }else if(position==2){

                        if(!isFirstSKratzer){
                            lvRelFehler.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                            isFirstSKratzer=true;
                        }else {
                            lvRelFehler.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.white));
                            isFirstSKratzer=false;
                        }

                    }

            }
        });

    }

 public void setOnClickListener(){
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjektInit3von4Act.this,ProjektInit2von4Act.class);
                startActivity(intent);
            }
        });

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjektInit3von4Act.this,ProjektInit4von4Act.class);
                startActivity(intent);
            }
        });
    }
}
