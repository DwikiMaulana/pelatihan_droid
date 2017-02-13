package dwikimaulana.keuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Terserah extends AppCompatActivity {

    private  String [] jenisStr = {"Pemasukan", "Pengeluaran"};
    private EditText edtNama, edtJumlah, edtKeterangan;
    private Spinner spnJenis;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terserah);

        spnJenis = (Spinner) findViewById(R.id.input2);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnJenis.setAdapter(adapter);

        edtNama = (EditText) findViewById(R.id.input1);
        edtJumlah = (EditText) findViewById(R.id.input3);
        edtKeterangan = (EditText) findViewById(R.id.input4);
    }

    public void calculate(View view){
        TransaksiHelper dbHelper = new TransaksiHelper(this);
        String nama = edtNama.getText().toString();
        int jenis = spnJenis.getSelectedItemPosition()+1;
        int jumlah = Integer.parseInt(edtJumlah.getText().toString());
        String keterangan = edtKeterangan.getText().toString();

        dbHelper.insertTransaksi(nama, jenis, jumlah, keterangan);

        Log.d("form.transaksi", nama+" - "+Integer.toString(jenis)+" - "+Integer.toString(jumlah)+" - "+keterangan);
        Toast.makeText(this, "Transaksi"+nama+"berhasil disimpan", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, MainActivity.class));
    }
}
