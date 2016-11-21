package com.android.beginner.belajarintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//create by dimdimasdim
//date 21 Nov 2016
// android upnvj

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bReset, bSubmit;
    private EditText etNama, etJurusan, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAllId();

        bSubmit.setOnClickListener(this);
        bReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View ambil) {
        switch (ambil.getId()){
            case R.id.b_submit:
                Intent intent = new Intent(getApplicationContext(), ViewActivity.class);

                Bundle b = new Bundle();

                    b.putString("nama", etNama.getText().toString());
                    b.putString("jurusan", etJurusan.getText().toString());
                    b.putString("email", etEmail.getText().toString());

                    intent.putExtras(b);

                    startActivity(intent);

                break;

            case  R.id.b_reset:
                etNama.setText("");
                etJurusan.setText("");
                etEmail.setText("");
                break;
        }
    }

    public void findAllId(){
        bReset = (Button) findViewById(R.id.b_reset);
        bSubmit =(Button) findViewById(R.id.b_submit);
        etNama =(EditText) findViewById(R.id.et_nAnda);
        etJurusan = (EditText) findViewById(R.id.et_jAnda);
        etEmail = (EditText) findViewById(R.id.et_eAnda);
    }
}
