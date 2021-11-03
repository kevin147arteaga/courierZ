package com.example.courierz;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore ;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<ordedetalle> Order;
    private String dni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        recyclerView = findViewById(R.id.orders_list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dni = getIntent().getStringExtra("dni");

        Order = new ArrayList<>();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Order_Detail").whereEqualTo("DNI",dni).whereEqualTo("Resultado","Pendiente")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot documentos: task.getResult()){
                                String contenido = documentos.getData().get("Contenido").toString();
                                String fechaEntrega = documentos.getData().get("FechaEntrega").toString();
                                String ID_Order = documentos.getData().get("ID_Order").toString();
                                String lugarEntrega = documentos.getData().get("LugarEntrega").toString();
                                String receptor = documentos.getData().get("Receptor").toString();
                                String precio = documentos.getData().get("Precio").toString();
                                String dni = documentos.getData().get("DNI").toString();
                                String detalle = documentos.getData().get("Detalle").toString();
                                String resultado = documentos.get("Resultado").toString();

                                Order.add(new ordedetalle (contenido, fechaEntrega, ID_Order, lugarEntrega, receptor, precio,dni,detalle,resultado));
                            }

                            adapter = new ordenlista(Order);
                            recyclerView.setAdapter(adapter);
                        }
                        else{
                            Log.e("proyecto", "Error", task.getException());
                        }
                    }
                });

    }
}
