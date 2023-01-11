package com.waroeng.waroenggaknoermal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HalamanPilihanWaroeng extends AppCompatActivity {

    private ImageView btn1, btn2;
    private FirebaseUser firebaseUser;

    //    Digunakan sebagai tempat untuk menampilkan user yang sedang login.
    private TextView textName;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_pilihan_waroeng);

        //        Memanggil Id dari tampilan UI.
        textName = findViewById(R.id.namaadmin);
        btnLogout = findViewById(R.id.logoutadmin);


        //        Melakukan koneksi untuk mengetahui user yang melakukan login dan untuk melakukan logout user.
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();



        //        Untuk mengetahui user yang melakukan login yang nanti nya username user akan di tampilkan dihalaman tampilan UI.
        if (firebaseUser != null) {
            //            Mengambil user yang melakukan login.
            textName.setText(firebaseUser.getEmail());

        } else {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
        }

        btnLogout.setOnClickListener(view ->  {
            //            Fungsi untuk user melakukan logout.
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), HalamanLoginAdminWaroeng.class));
            finish();
        });


        //        Mengambil Id yang ada pada tampilan UI.
        btn1 = findViewById(R.id.menuadmin);
        //        Membuat action listener ketika user menekan img button pada halaman  menu pilihan.
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //                Mehubungkan halaman halaman pilihan dengan halaman menu admin.
                Intent intent = new Intent(HalamanPilihanWaroeng.this, HalamanMenuAdminWaroeng.class);
                startActivity(intent);
            }
        });



        //        Mengambil Id yang ada pada tampilan UI.
        btn2 = findViewById(R.id.kasir);
        //        Membuat action listener ketika user menekan img button pada halaman  menu pilihan.
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //                Mehubungkan halaman menu pilihan dengan halaman kasir.
                Intent intent = new Intent(HalamanPilihanWaroeng.this, HalamanKasirWaroeng.class);
                startActivity(intent);
            }
        });
    }
    }
