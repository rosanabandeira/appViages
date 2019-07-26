package ui.activity;

import android.os.Bundle;
import android.studio.viagens.R;
import android.studio.viagens.dao.PacoteDAO;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import model.Pacote;
import ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle("Pacotes");

        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listView);

        List<Pacote> pacotes = new PacoteDAO().lista();

        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

    }
}
