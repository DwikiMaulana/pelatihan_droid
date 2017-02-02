package maulanadwiki.classjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String showString;
    public TextView showText;
    public Barang [] arrBarang = new Barang[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText = (TextView) findViewById(R.id.show_text);

        showString = "Manipulasi Class Java Android";
        addSeparator();

        initBarang();
//        showString += arrBarang[5].toString();
//        addSeparator();
//        showString += arrBarang[1].toString();

        Transaksi trans1 = new Transaksi();
        trans1.addBarang(arrBarang[3]);
        trans1.addBarang(arrBarang[7]);
        trans1.addBarang(arrBarang[1]);
        showString += trans1.printTransaksi();
        showString += "rata-rata harga barang yang dibeli "+
                trans1.averageTransaksi();
        showString += "\n"+trans1.maxBarang();
        showText.setText(showString);
    }
    public void addSeparator(){
        showString += "\n--------------------------\n";
    }

    public void initBarang(){
        arrBarang[0] = new Barang("Laptop", 1, 7000000);
        arrBarang[1] = new Barang("Printer", Barang.ELEKTRONIK, 250000);
        arrBarang[2] = new Barang("Monitor", Barang.ELEKTRONIK, 150000);
        arrBarang[3] = new Barang("PE28 TDR", Barang.NON_ELEKTRONIK, 1200000);
        arrBarang[4] = new Barang("IRC FASTI2",  Barang.NON_ELEKTRONIK, 350000);
        arrBarang[5] = new Barang("PISTON SET GL PRO NEOTECH", Barang.NON_ELEKTRONIK, 300000);
        arrBarang[6] = new Barang("GEAR SET SSS 428",  Barang.NON_ELEKTRONIK, 500000);
        arrBarang[7] = new Barang("OLI",  Barang.NON_ELEKTRONIK, 50000);
        arrBarang[8] = new Barang("KOP BURING SATRIA F",  Barang.NON_ELEKTRONIK, 900000);
        arrBarang[9] = new Barang("DOP",  Barang.NON_ELEKTRONIK, 5000);
    }
}
