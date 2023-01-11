package com.waroeng.waroenggaknoermal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class ReadDetailPembelian extends AppCompatActivity {
    private TextView dtlnama, dtlpembeli, dtltanggal, dtlharga, dtljumlah, dtlbayar;
    private String id = "";



    //    Digunakan untuk menampilkan user yang login dan untuk membuat fungsi kembali.
    private ImageView kembali;
    private TextView textName;


    //    Koneksi untuk mendapatkan user yang sedang login.
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_detail_pembelian);
        //        Untuk menampilkan nama user yang login pada id yang terdapat pada halaman.
        textName = findViewById(R.id.namaadmin);

        dtlnama = findViewById(R.id.namabarang3);
        dtltanggal = findViewById(R.id.tanggall3);
        dtlpembeli = findViewById(R.id.namapembeliku3);
        dtlbayar = findViewById(R.id.bayarku3);
        dtlharga = findViewById(R.id.hargaproduku3);
        dtljumlah = findViewById(R.id.jmlhpembelian3);



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
                Intent intent = new Intent(ReadDetailPembelian.this, HalamanReportPembelian.class);
                startActivity(intent);
            }
        });



        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("id");
            dtlnama.setText(intent.getStringExtra("Nama_Produk"));
            dtlharga.setText(intent.getStringExtra("Harga_Produk"));
            dtlpembeli.setText(intent.getStringExtra("Nama_Pembeli"));
            dtltanggal.setText(intent.getStringExtra("Tanggal_Pembelian"));
            dtljumlah.setText(intent.getStringExtra("Jumlah_Pembelian"));
            dtlbayar.setText(intent.getStringExtra("Harga_Pembelian"));
        }
    }
}