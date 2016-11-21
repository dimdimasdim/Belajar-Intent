package com.android.beginner.belajarintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//create by dimdimasdim
//date 21 Nov 2016
// android upnvj

public class ViewActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvNama, tvJurusan, tvEmail;
    private Button bSMail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        Bundle b = getIntent().getExtras();
        tvNama = (TextView) findViewById(R.id.tv_nama);
        tvJurusan =(TextView) findViewById(R.id.tv_jurusan);
        tvEmail = (TextView) findViewById(R.id.tv_email);

        tvNama.setText(b.getCharSequence("nama"));
        tvJurusan.setText(b.getCharSequence("jurusan"));
        tvEmail.setText(b.getCharSequence("email"));

        bSMail =(Button) findViewById(R.id.b_sMail);
        bSMail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent email_intent = new Intent(Intent.ACTION_SEND);
        Bundle b = getIntent().getExtras();

        email_intent.putExtra(Intent.EXTRA_EMAIL,new String[]{String.valueOf(b.getCharSequence("email"))});
        email_intent.setType("message/rfc822");

        startActivity(Intent.createChooser(email_intent,"Choose an Email Client :"));
    }
}
