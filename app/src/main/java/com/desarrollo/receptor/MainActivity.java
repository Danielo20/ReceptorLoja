package com.desarrollo.receptor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receptorIntent = getIntent();
        String action = receptorIntent.getAction();
        String tipo = receptorIntent.getType();
        Button btn_map = (Button)findViewById(R.id.btn_direccion);
        final TextView txt_direccion = (TextView)findViewById(R.id.txt_direccion);

        if (Intent.ACTION_SEND_MULTIPLE.equals(action) && tipo != null){
            if("text/plain".equals(tipo)){
                ActualizarDatos(receptorIntent);
            }
        }


       /* btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = txt_direccion.getText().toString();
                Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q="+aux));
                if (locationIntent.resolveActivity(getPackageManager()) != null){
                    if (txt_direccion.getText().equals(getResources().getText(R.string.txt_direccion).toString())) {
                        Toast.makeText(getApplicationContext(),"Direccion invalidad para Maps",Toast.LENGTH_SHORT).show();
                    }
                    else {

                        startActivity(locationIntent);
                    }
                }
                else {
                    Toast.makeText(null, "Error",Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    private void ActualizarDatos(Intent intent) {
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String dni = intent.getStringExtra("dni");
        String codigo = intent.getStringExtra("codigo");
        Bitmap imagen = (Bitmap) intent.getParcelableExtra("imagen");

    }
}
