package com.example.courierz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Detalles extends AppCompatActivity {
    TextView Ubicacion, Receptor, Precio, Contenido;
    EditText Registro;
    Button Enviar;
    FirebaseFirestore firebaseFirestore;
    ArrayList<ordedetalle> Order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);
        Order = new ArrayList<>();
        Ubicacion = findViewById(R.id.Tv_Destiny);
        Receptor = findViewById(R.id.Tv_Receptor);
        Contenido = findViewById(R.id.Tv_Content);
        Enviar = findViewById(R.id.btn_Enviar);
        Precio = findViewById(R.id.Tv_Precio);
        Registro = findViewById(R.id.eT_Detalle);
        Bundle pack = getIntent().getExtras();
        String id = pack.getString("id");
        Toast.makeText(getApplicationContext(),pack.getString("id"),Toast.LENGTH_SHORT).show();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Order_Detail").document(id).
                get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    String ubicacion = documentSnapshot.getString("LugarEntrega");
                    String content = documentSnapshot.getString("Contenido");
                    String precio = documentSnapshot.getLong("Precio").toString();
                    String receptor = documentSnapshot.getString("Receptor");
                    Ubicacion.setText(String.format("Ubicacion: %s", ubicacion));
                    Contenido.setText(String.format("Contenido: %s", content));
                    Precio.setText(String.format("Precio: %s", precio,"$"));
                    Receptor.setText(String.format("Contacto: %s", receptor));
                }
            }

        });
        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dato = Registro.getText().toString();
                firebaseFirestore.collection("Order_Detail").document(id).update("Resultado","Atendido").
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                            }
                        });
                firebaseFirestore.collection("Order_Detail").document(id).update("Detalle",dato).
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

}
