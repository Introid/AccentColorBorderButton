package com.uigitdev.accentcolorborder;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uigitdev.accentcolorborder.uigitdev.buttons.AccentButton;

public class MainActivity extends AppCompatActivity {
    private AccentButton accentButton, accentButton2;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton();
        buttonClearClick();
        buttonClick();

        accentButton.setSuccessColor(getString(R.color.colorSuccess));
        accentButton.setUnsuccessColor("#000000");
//        accentButton.setButtonBackground("#000000");
//        accentButton.setTextColor("#FFFFFF");
//        accentButton.setStatusTextColor("#FFFFFF");
//        accentButton.setClearIconHide();
//        accentButton.setClearIcon(R.drawable.ic_error);
        accentButton.setClearIconTint(getString(R.color.colorSuccess));
        accentButton.setStatusSuccessText("AAA");

        accentButton.apply(
                AccentButton.STATUS.SUCCESS,
                getString(R.string.button_success_text),
                R.drawable.ic_like,
                R.drawable.ic_error);

        accentButton2.apply(
                AccentButton.STATUS.UNSUCCESS,
                getString(R.string.button_unsuccess_text),
                R.drawable.ic_like,
                R.drawable.ic_error);
    }

    private void addButton() {
        accentButton = new AccentButton(findViewById(R.id.accent_button));
        accentButton2 = new AccentButton(findViewById(R.id.accent_button_2));
    }

    private void buttonClearClick() {
        accentButton.button_clear_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clear button", Toast.LENGTH_LONG).show();
//                accentButton.button_parent.setVisibility(View.GONE);
            }
        });
    }

    private void buttonClick() {
        accentButton.button_click_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button click", Toast.LENGTH_LONG).show();
            }
        });
    }
}
