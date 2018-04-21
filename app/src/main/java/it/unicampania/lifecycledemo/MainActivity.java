package it.unicampania.lifecycledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "LIFE_MAIN";

    // Codici per identificare le varie richieste alle activity figlie
    private final int REQUEST_NOME = 1;

    // Chiave per identificare il dato restituito
    private final String EXTRA_NOME = "EXTRA_NOME";


    private Button vLancioSeconda;
    private Button vLancioTerza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "onCreate");

        // Ottengo i riferimenti alle view
        vLancioSeconda = findViewById(R.id.btnSeconda);
        vLancioTerza = findViewById(R.id.btnTerza);

        // Imposto il lancio della seconda activity
        vLancioSeconda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lancio la seconda activity
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        // Imposto il lancio della terza activity da cui mi aspetto un risultato
        vLancioTerza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lancio la terza activity
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivityForResult(intent, REQUEST_NOME);
            }
        });

    }

    // Qui otterrò la risposta dalla terza activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Qui posso discriminare le risposte in base alla provenienza
        switch (requestCode) {

            case REQUEST_NOME : // Avevo chiesto solo il nome
                if (resultCode == RESULT_OK) {
                    // Premuto Ok
                    Log.v(TAG, "Premuto OK");
                    // Prendo il dato passato e lo visualizzo in un toast
                    String valore = data.getDataString();
                    Toast.makeText(this, "E' stato ricevuto " + valore, Toast.LENGTH_LONG).show();

                } else if (resultCode == RESULT_CANCELED) {
                    Log.v(TAG, "Premuto annulla");
                }
                break;

            default :   // Qui si è verificata un'anomalia
                Log.v(TAG, "da dove sto tornando??");
                break;
        }
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
