package com.lesson.sayitahminetmeoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtKalanHak, txtSonuc;
    private EditText editTxtSayi;
    private String gelenDeger;
    private int kalanHak = 3, randomSayi;
    private Random rndNumber;
    private boolean tahminDogrumu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKalanHak = (TextView) findViewById(R.id.txtViewKalanHak);
        txtSonuc = (TextView) findViewById(R.id.textViewSonuc);
        editTxtSayi = (EditText) findViewById(R.id.editTxtSayi);

        rndNumber = new Random();
        randomSayi = rndNumber.nextInt( );
        System.out.println("Random Sayı: " + randomSayi);
    }

    public void btnTahminEt(View v) {
        gelenDeger = editTxtSayi.getText().toString();

        if (!TextUtils.isEmpty(gelenDeger)) {
            if (kalanHak > 0 && tahminDogrumu == false) {
                if (gelenDeger.equals(String.valueOf(randomSayi))) {
                    sonucGoster("Tebrikler Doğru Tahminde bulundunuz.");
                    tahminDogrumu = true;
                } else {
                    txtSonuc.setText("Yanlış Tahminde Bulunuz.");
                    editTxtSayi.setText("");
                }

                kalanHak--;
                txtKalanHak.setText("Kalan Hak: " + kalanHak);

                if (kalanHak == 0 && tahminDogrumu == false) {
                    sonucGoster("Tahmin hakkınız bitti");
                    editTxtSayi.setText(" ");
                }
            } else
                txtSonuc.setText("Oyun Bitti");

        } else
            txtSonuc.setText("girilen deger bos olamaz");

    }

    private void sonucGoster(String mesaj) {
        editTxtSayi.setEnabled(false);
        txtSonuc.setText(mesaj);

    }
}

