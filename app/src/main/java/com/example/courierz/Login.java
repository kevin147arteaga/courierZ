package com.example.courierz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {
    private Button ingresar;
    private EditText id,password;
    private String User_password;
    private FirebaseFirestore firebaseFirestore ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ingresar= findViewById(R.id.ingresar);
        id = findViewById(R.id.Dni_et);
        password = findViewById(R.id.Password_et);
        ingresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                firebaseFirestore.collection("User").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot documentos : task.getResult()) {
                                        String nombres = documentos.getData().get("Nombres").toString();
                                        String apellidos = documentos.getData().get("Apellidos").toString();
                                        String pass = documentos.getData().get("Password").toString();
                                        String DNI = documentos.getData().get("DNI").toString();
                                        String tipo = documentos.getData().get("Tipo").toString();

                                        if (DNI.equals(id.getText().toString())) {
                                            User_password = pass;
                                            String verification = Verificacion(User_password, password.getText().toString());
                                            if (verification.equals("OK")) {
                                                Intent intent = new Intent(Login.this, menu.class);
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                Toast.makeText(Login.this, "Password Incorrecto", Toast.LENGTH_SHORT).show();
                                            }
                                            break;
                                        } else {
                                            Toast.makeText(Login.this, "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                                        }


                                    }} else {
                                    Log.e("proyecto", "Error", task.getException());
                                }
                            }
                        });
            }
    });
}

    public void redirect(View v) {
        Intent intent = new Intent(Login.this, menu.class);
        Bundle DNI = new Bundle();
        startActivity(intent);
        finish();
    }
    public String Verificacion(String password, String attemp_password){
        String result;
        if(attemp_password.equals(password)){
            return result="OK";
        }else{
            return result="Incorrect";
        }
    }
}



