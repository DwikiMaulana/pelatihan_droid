package alif.iman.tipscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hitung(View view) {
        EditText tagihan = (EditText) findViewById(R.id.tagihan);
        EditText persen = (EditText) findViewById(R.id.persen);
        EditText jumlah = (EditText) findViewById(R.id.jumlah);
        TextView result = (TextView) findViewById(R.id.result);

        double t, p, j;
        String hasil;
        t = Double.parseDouble(tagihan.getText().toString());
        p = Double.parseDouble(persen.getText().toString());
        j = Double.parseDouble(jumlah.getText().toString());

        hasil="Tips"+((t*p)/100)+"\n";
        hasil+="Total"+(t+((t*p)/100));
        hasil+="\n Per Orang"+((t+((t*p)/100))/j);

        result.setText(hasil);

    }
}
