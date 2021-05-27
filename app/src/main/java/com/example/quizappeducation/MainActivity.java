package com.example.quizappeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ModelClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add(new ModelClass("Gunung tertinggi di indonesia?", "Kilimanjaro", "Merapi", "Padang", "Klutum","Kilimanjaro"));
        list.add(new ModelClass("Apa singkatan RS?", "Rumah Santo", "Rumah Sakit", "Rumah Suami", "Rumah Serem","Rumah Sakit"));
        list.add(new ModelClass("Kopi apa yang dari kotoran hewan?", "Jawa", "Merak", "Luwak", "StarBuck","Luwak"));
        list.add(new ModelClass("Klub sepakbola asal palembang?", "PSPS pekanbaru", "Sriwijaya", "Persija", "Persib","Sriwijaya"));
        list.add(new ModelClass("Superhero asal indonesia?", "Batman", "Robinson", "IronMan", "Gundala","Gundala"));
        list.add(new ModelClass("Petinju asal indonesia?", "Chris John", "Parto", "Indro", "Ade","Chris John"));
        list.add(new ModelClass("Berapa 1 + 1 ?", "4", "2", "9", "6","2"));
        list.add(new ModelClass("Apa nama laut di lampung?", "Klara", "Selatan", "Mati", "Cahaya","Klara"));
        list.add(new ModelClass("Apa singkatan UN", "Ujian Nasional", "Ujian Nakal", "Usulan Negara", "Usia Negara","Ujian Nasional"));
        list.add(new ModelClass("1 Giga Berapa Mb?", "10 MB", "1 MB", "1000 MB", "100 MB","1000 MB"));
        list.add(new ModelClass("Jeruk warna nya apa?", "Pink", "Merah", "Kuning", "Hijau","Kuning"));
        list.add(new ModelClass("Apa rasa dari buah Belimbing Wuluh?", "Asem", "Manis", "Kecut", "Pahit","Asem"));
        list.add(new ModelClass("Siapa presiden Indonesia tahun 2021?", "Jokowi", "Sule", "Keanu", "Andre","Jokowi"));
        list.add(new ModelClass("Apa singakatan HP?", "Handphone", "Kompor", "AC", "Meja","Handphone"));
        list.add(new ModelClass("2 X 2 =?", "8", "6", "4", "10","4"));
        list.add(new ModelClass("Makanan khas padang?", "Rendang", "Bakso", "Nasi Goreng", "Tekwan","Rendang"));
        list.add(new ModelClass("Makanan  khas jepang?", "Nastar", "Cumi", "Ramen", "Sate","Ramen"));
        list.add(new ModelClass("Musik khas indonesia?", "Dangdut", "Rock", "Pop", "Metal","Dangdut"));
        list.add(new ModelClass("Makanan hewan kelinci?", "Sate", "Menyan", "Wortel", "Kambing","Wortel"));
        list.add(new ModelClass("Ibukota Indonesia?", "Jakarta", "Medan", "Padang", "Jambi","Jakarta"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        }, 5000);
    }
}
