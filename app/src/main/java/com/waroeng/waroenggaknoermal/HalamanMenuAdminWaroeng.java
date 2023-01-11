package com.waroeng.waroenggaknoermal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HalamanMenuAdminWaroeng extends AppCompatActivity {
    //    Mengambil koneksi ke firebase.
    private FirebaseUser firebaseUser;


    //    Digunakan sebagai tempat untuk menampilkan user yang sedang login.
    private TextView textName;
    private ImageView kembali;


    //    Untuk menghubungkan halaman menu admin dengan halaman tambah produk dan report.
    private ImageButton btn1, btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        Untuk Memanggil tampilan yang akan di gunakan.
        setContentView(R.layout.halaman_menu_admin_waroeng);



        //        Memanggil Id dari tampilan UI.
        textName = findViewById(R.id.namaadmin);



        //        Melakukan koneksi untuk mengetahui user yang melakukan login dan untuk melakukan logout user.
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();



        //        Untuk mengetahui user yang melakukan login yang nanti nya username user akan di tampilkan dihalaman tampilan UI.
        if (firebaseUser != null) {
            //            Mengambil user yang melakukan login.
            textName.setText(firebaseUser.getEmail());

        } else {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
        }

        //        Mengatur fungsi kembali ketika user menekan icon kembali.
        kembali = findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HalamanMenuAdminWaroeng.this, HalamanPilihanWaroeng.class);
                startActivity(intent);
            }
        });




        //        Mengambil Id yang ada pada tampilan UI.
        btn1 = findViewById(R.id.menuadmin);
        //        Membuat action listener ketika user menekan img button pada halaman  menu admin.
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //                Mehubungkan halaman menu admin dengan halaman tambah produk.
                Intent intent = new Intent(HalamanMenuAdminWaroeng.this, HalamanTambahProdukWaroeng.class);
                startActivity(intent);
            }
        });



        //        Mengambil Id yang ada pada tampilan UI.
        btn2 = findViewById(R.id.kasir);
        //        Membuat action listener ketika user menekan img button pada halaman  menu admin.
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //                Mehubungkan halaman menu admin dengan halaman report waroeng.
                Intent intent = new Intent(HalamanMenuAdminWaroeng.this, HalamanPilihanReportWaroeng.class);
                startActivity(intent);
            }
        });
    }
}