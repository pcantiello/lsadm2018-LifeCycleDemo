package it.unicampania.lifecycledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    private final String TAG = "LIFE_THIRD";

    // Chiave per identificare il dato restituito
    private final String EXTRA_NOME = "EXTRA_NOME";

    // Riferimenti alle view
    Button btnConferma;
    Button btnAnnulla;
    EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Log.v(TAG, "onCreate");

        // Ottengo i riferimenti alle view
        btnConferma = findViewById(R.id.btnConferma);
        btnAnnulla = findViewById(R.id.btnAnnulla);
        editNome = findViewById(R.id.editNome);

        // Imposto le azioni dei pulsanti
        // Pulsante Conferma
        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Leggo il valore da passare
                String nome = editNome.getText().toString();

                // Creo un intent e vi aggiungo i dati che devono essere passati all'activity precedente
                Intent intent = new Intent();
                intent.putExtra(EXTRA_NOME, nome);

                // Imposto il codice che indica che il dato è valido
                setResult(RESULT_OK, intent);

                // Termino l'esecuzione dell'activity e torno al chiamante
                finish();
            }
        });

        // Pulsante Annulla
        btnAnnulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creo un intent. Non ho bisogno di aggiungere nessun dato
                Intent intent = new Intent();

                // Imposto il codice che indica che il dato è valido
                setResult(RESULT_CANCELED, intent);

                // Termino l'esecuzione dell'activity e torno al chiamante
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.v(TAG, "onRestart");
    }
}
