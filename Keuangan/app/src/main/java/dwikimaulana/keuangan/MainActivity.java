package dwikimaulana.keuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String strshow="";
    TextView txtshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtshow = (TextView) findViewById(R.id.result);

        TransaksiHelper dbHelper=new TransaksiHelper(this);
        List<Transaksi> listTrans=dbHelper.getTransaksi();

        for(int i =0;i<listTrans.size();i++)
        {
            Transaksi trans=listTrans.get(i);
            strshow+="--------------------------------\n";
            strshow+=trans.nama+" ["+trans.getJenis()+"] : "+trans.jumlah
                    +"\n"+trans.keterangan+"\n";
        }
        txtshow.setText(strshow);
    }

    public void tambah(View view)
    {
        Intent intent=new Intent(this, Terserah.class);
        startActivity(intent);
    }
}
