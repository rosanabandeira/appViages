package android.studio.viagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.studio.viagens.R;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Pacote;
import utils.DiasUtil;
import utils.MoedaUtil;
import utils.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle("Resumo do Pacote");

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("249.00"));

        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSaoPaulo.getLocal());

        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableDoPacote);

        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacoteSaoPaulo.getDias());
        dias.setText(diasEmTexto);

        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataMoedaParaBrasileiro(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBrasileira);

        TextView data = findViewById(R.id.resumo_pacote_data);
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, pacoteSaoPaulo.getDias());
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
        String dataFormatadaIda = formatoBrasileiro.format(dataIda.getTime());
        String dataFormatadaVolda = formatoBrasileiro.format(dataVolta.getTime());
        String dataFormatadaDaViagem = dataFormatadaIda + " - " + dataFormatadaVolda + " de " + dataVolta.get(Calendar.YEAR);
        data.setText(dataFormatadaDaViagem);


    }
}