package ru.ele638.android_academy.demoapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {

    EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        getSupportActionBar().setTitle(R.string.about_caption);
        emailText = findViewById(R.id.sendEmailET);
        findViewById(R.id.sendEmailBtn).setOnClickListener(this);
        findViewById(R.id.btnIG).setOnClickListener(this);
        findViewById(R.id.btnTG).setOnClickListener(this);
        findViewById(R.id.btnVK).setOnClickListener(this);
        emailText.setOnEditorActionListener(this);
        emailText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        emailText.setRawInputType(InputType.TYPE_CLASS_TEXT);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        emailText.setText(savedInstanceState.getString("message", ""));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.sendEmailET:
            case R.id.sendEmailBtn:
                String message = ((EditText) findViewById(R.id.sendEmailET)).getText().toString();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.setData(Uri.parse("mailto:" + getString(R.string.myEmail)));
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.emailSubject));
                intent.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(intent, "Send Email"));
                break;
            case R.id.btnIG:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.myIG)));
                intent.setPackage(getString(R.string.instagram_package));
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.myIG))));
                }
                break;
            case R.id.btnTG:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setPackage(getString(R.string.telegram_package));
                intent.setData(Uri.parse(getString(R.string.myTG)));
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.myTG))));
                }
                break;
            case R.id.btnVK:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.myVK)));
                startActivity(intent);
                break;
        }
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            onClick(v);
            return true;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("message", emailText.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
