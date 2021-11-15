package com.example.nguyenquanghuy_1911505310224.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.nguyenquanghuy_1911505310224.Adapter.BaiHatAdapter;
import com.example.nguyenquanghuy_1911505310224.Model.BaiHat;
import com.example.nguyenquanghuy_1911505310224.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Activity_BaiHat extends AppCompatActivity {
    TextView tvTenCS,tvTenBH,tvTimeBegin,tvTimeEnd;
    ImageButton imgb_play,imgb_preview,imgb_next;
    ListView listViewBH;
    SeekBar seekBar;
    ArrayList<BaiHat> arrayBaiHat;

    int vitri;

    MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat);
        AnhXa();
        thoigian_hientai();
        getName();
    }

    private void getName() {
        Intent intent = getIntent();
        int vt = intent.getIntExtra("position",0);
        String namecs = intent.getStringExtra("tencasi");
        tvTenCS.setText("Casi: "+namecs);
        switch (vt) {
            case 0:
                arrayBaiHat.add(new BaiHat("Thay lòng",time(R.raw.thaylong),R.raw.thaylong));
                arrayBaiHat.add(new BaiHat("Kiếp duyên không thành",time(R.raw.kiep_duyen_kt),R.raw.kiep_duyen_kt));
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                arrayBaiHat.add(new BaiHat("Muộn rồi mà sao còn",time(R.raw.muon_ma_sao_con),R.raw.muon_ma_sao_con));
                break;
            case 4:
                break;
            case 5:
                arrayBaiHat.add(new BaiHat("Cô độc vương",time(R.raw.co_doc_vuong),R.raw.co_doc_vuong));
                break;
            case 6:
                arrayBaiHat.add(new BaiHat("Cô đơn giành cho ai",time(R.raw.co_don_danh_cho_ai),R.raw.co_don_danh_cho_ai));
                break;
            case 7:
                break;
        }
        BaiHatAdapter baiHatAdapter = new BaiHatAdapter(Activity_BaiHat.this,R.layout.list_baihat,arrayBaiHat);
        listViewBH.setAdapter(baiHatAdapter);
        listViewBH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    vitri = i;
                    imgb_play.setImageResource(R.drawable.iconpause);
                    khoitao();
                }
                else {
                    vitri = i;
                    imgb_play.setImageResource(R.drawable.iconpause);
                    khoitao();
                }
            }
        });

        imgb_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imgb_play.setImageResource(R.drawable.iconplay);
                }
                else {
                    mediaPlayer.start();
                    imgb_play.setImageResource(R.drawable.iconpause);
                }
            }
        });

        imgb_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vitri++;
                if(vitri > (arrayBaiHat.size()-1)){
                    vitri = 0;
                }
                mediaPlayer.stop();
                khoitao();
            }
        });

        imgb_preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vitri--;
                if(vitri < 0){
                    vitri = arrayBaiHat.size()-1;
                }
                mediaPlayer.stop();
                khoitao();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
    }

    void thoigian_hientai(){
        Handler handler = new Handler();
        boolean b = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                tvTimeBegin.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        vitri++;
                        if(vitri > arrayBaiHat.size()-1){
                            mediaPlayer.stop();
                            imgb_play.setImageResource(R.drawable.iconplay);
                        }
                        else {
                            mediaPlayer.stop();
                            khoitao();
                            mediaPlayer.start();
                        }
                    }
                });
                handler.postDelayed(this,500);
            }
        },100);
    }

    private void khoitao() {
        mediaPlayer = MediaPlayer.create(Activity_BaiHat.this, arrayBaiHat.get(vitri).baihat);
        tvTimeEnd.setText(time(arrayBaiHat.get(vitri).baihat));
        tvTenBH.setText("Đang phát: "+arrayBaiHat.get(vitri).tenbaihat);
        seekBar.setMax(mediaPlayer.getDuration());
        mediaPlayer.start();
    }

    private String time(int baihat){
        String t;
        MediaPlayer player = new MediaPlayer();
        player = MediaPlayer.create(Activity_BaiHat.this,baihat);
        SimpleDateFormat tg = new SimpleDateFormat("mm:ss");
        t = tg.format(player.getDuration());
        return t;
    }

    @Override
    protected void onStop() {
        mediaPlayer.stop();
        super.onStop();
    }

    private void AnhXa() {
        tvTenCS = findViewById(R.id.tvTenCSBH);
        tvTenBH = findViewById(R.id.tvdangphat);
        tvTimeBegin = findViewById(R.id.tvtimestart);
        tvTimeEnd = findViewById(R.id.tvtimeend);
        imgb_next = findViewById(R.id.btnnext);
        imgb_play = findViewById(R.id.btnplay);
        imgb_preview = findViewById(R.id.btnpreview);
        listViewBH = findViewById(R.id.listviewBaiHat);
        seekBar = findViewById(R.id.seebar);
        arrayBaiHat = new ArrayList<>();

    }
}