package com.example.lab8b_lttbdd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityLogin extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    Button btnLogin;
    EditText edtEmail,edtPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=findViewById(R.id.btnSingin);
        edtEmail=findViewById(R.id.editEmail);
        edtPass=findViewById(R.id.editPassConfirm);
        firebaseAuth=FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(view -> {
          if(edtEmail.getText().length()==0){
             edtEmail.setError("Please enter email!");
          }else if(edtPass.getText().length()==0){
              edtEmail.setError("Please enter pass!");
          }else singIn();
        });

    }

    private void singIn() {
        String email=edtEmail.getText().toString();
        String password= edtEmail.getText().toString();
        final Intent intentLogin=new Intent(this, ActivityLogin.class);
        final Intent intentRegister=new Intent(this,ActivityRegister.class);
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,task -> {
                   if(task.isSuccessful()){
                       final DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Users").
                               child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("role");
//                       ref.addListenerForSingleValueEvent(new ValueEventListener() {
//                           @Override
//                           public void onDataChange(@NonNull DataSnapshot snapshot) {
//                               String role=snapshot.getValue().toString();
//                           }
//
//                           @Override
//                           public void onCancelled(@NonNull DatabaseError error) {
//
//                           }
//                       });
                       startActivity(intentLogin);
                       Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
                   }
                });
    }
}
