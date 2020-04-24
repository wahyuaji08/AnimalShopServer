package com.example.wahyuajisantoso.animalserver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wahyuajisantoso.animalserver.Common.Common;
import com.example.wahyuajisantoso.animalserver.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class signin extends AppCompatActivity {

    EditText edtPhone,edtPassword;
    Button btnSignIn;

    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        edtPassword = (MaterialEditText)findViewById(R.id.edtpass);
        edtPhone = (MaterialEditText)findViewById(R.id.edtphone);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        //Init Firebase
        db = FirebaseDatabase.getInstance();
        users = db.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInUser (edtPhone.getText().toString(),edtPassword.getText().toString());
            }
        });

    }

    private void signInUser(String phone, String password) {
        final ProgressDialog mDialog = new ProgressDialog(signin.this);
        mDialog.setMessage("Mohon Tunggu");
        mDialog.show();

        final  String localPhone = phone;
        final String localPassword = password;
        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(localPhone).exists())
                {
                    mDialog.dismiss();
                    User user = dataSnapshot.child(localPhone).getValue(User.class);
                    user.setPhone(localPhone);
                    if (Boolean.parseBoolean(user.getIsStaff())) {

                        if (user.getPassword().equals(localPassword))
                        {
                            Intent login = new Intent(signin.this,Home.class);
                            Common.currentUser = user;
                            startActivity(login);
                            finish();
                        } else
                            Toast.makeText(signin.this, "Password Salah", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(signin.this, "Mohon Login Dengan Akun Admin", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   mDialog.dismiss();
                    Toast.makeText(signin.this, "User Tidak Terdaftar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
