package com.lqx.l7246.donttapthewhitetile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainMenu extends Activity {
    private ImageView start;
    private ImageView ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        start=(ImageView)findViewById(R.id.startbt);
        ranking=(ImageView)findViewById(R.id.rankingbt);

        WindowManager wm = this.getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        int btck = (int)(width*0.35);
        setMargins(start,(width-btck)/2,(height-btck)/2,(width-btck)/2,(height-btck)/2);

        int topck=(int)(width*0.2);
        setMargins(ranking,width-topck-topck/4,height-topck-topck/4,topck/4,topck/4);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainMenu.this,Game.class);
                startActivity(intent);
            }

        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainMenu.this,RankingList.class);
                startActivity(intent);
            }
        });

    }
    public void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
