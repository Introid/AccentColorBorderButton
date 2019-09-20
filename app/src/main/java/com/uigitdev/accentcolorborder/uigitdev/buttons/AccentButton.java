package com.uigitdev.accentcolorborder.uigitdev.buttons;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.uigitdev.accentcolorborder.R;

public class AccentButton {
    private CardView button_card_parent;
    public RelativeLayout button_click_parent, button_clear_parent, button_parent;
    private ImageView button_icon, button_clear_icon;
    private FrameLayout button_accent_border;
    private TextView button_status, button_text;

    public enum STATUS {
        SUCCESS,
        UNSUCCESS
    }

    private String
            successColor = "#3EAA56",
            unsuccessColor = "#AA3E3E",
            successText = "Success",
            unsuccessText = "Unsuccess";

    private STATUS status;

    public AccentButton(View view) {
        setType(view);
    }

    private void setType(View view) {
        button_card_parent = view.findViewById(R.id.button_card_parent);
        button_click_parent = view.findViewById(R.id.button_click_parent);
        button_clear_parent = view.findViewById(R.id.button_clear_parent);
        button_parent = view.findViewById(R.id.button_parent);
        button_icon = view.findViewById(R.id.button_icon);
        button_clear_icon = view.findViewById(R.id.button_clear_icon);
        button_accent_border = view.findViewById(R.id.button_accent_border);
        button_status = view.findViewById(R.id.button_status);
        button_text = view.findViewById(R.id.button_text);
    }

    public void setButtonBackground(String backgroundColor) {
        button_card_parent.setCardBackgroundColor(Color.parseColor(backgroundColor));
    }

    public void setStatusTextColor(String statusTextColor) {
        button_status.setTextColor(Color.parseColor(statusTextColor));
    }

    public void setTextColor(String textColor) {
        button_text.setTextColor(Color.parseColor(textColor));
    }

    public void setClearIconHide() {
        button_clear_parent.setVisibility(View.GONE);
    }

    public void setClearIcon(int clearIcon) {
        button_clear_icon.setImageResource(clearIcon);
    }

    public void setClearIconTint(String clearIconTint) {
        button_clear_icon.setColorFilter(Color.parseColor(clearIconTint), android.graphics.PorterDuff.Mode.SRC_IN);
    }

    public void setStatusSuccessText(String successText){
        this.successText = successText;
    }

    public void setStatusUnsuccessText(String unsuccessText){
        this.unsuccessText = unsuccessText;
    }

    @SuppressLint("SetTextI18n")
    private void setStatusText(STATUS status) {
        if (status == STATUS.SUCCESS) {
            button_status.setText(successText + ":");
        } else {
            button_status.setText(unsuccessText + ":");
        }
    }

    private void setButtonStatusIcon(STATUS status, int successIcon, int unsuccessIcon) {
        if (status == STATUS.SUCCESS) {
            button_icon.setImageResource(successIcon);
        } else {
            button_icon.setImageResource(unsuccessIcon);
        }
    }

    private void statusStyle(STATUS status, String successColor, String unsuccessColor) {
        if (status == STATUS.SUCCESS) {
            button_accent_border.setBackgroundColor(Color.parseColor(successColor));
            button_icon.setColorFilter(Color.parseColor(successColor), android.graphics.PorterDuff.Mode.SRC_IN);
        } else {
            button_accent_border.setBackgroundColor(Color.parseColor(unsuccessColor));
            button_icon.setColorFilter(Color.parseColor(unsuccessColor), android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }

    private void setButtonText(String buttonText) {
        button_text.setText(buttonText);
    }

    public void setSuccessColor(String successColor) {
        this.successColor = successColor;
    }

    public void setUnsuccessColor(String unsuccessColor) {
        this.unsuccessColor = unsuccessColor;
    }

    public void apply(STATUS status, String buttonText, int successIcon, int unsuccessIcon) {
        statusStyle(status, successColor, unsuccessColor);
        setStatusText(status);
        setButtonText(buttonText);
        setButtonStatusIcon(status, successIcon, unsuccessIcon);
    }
}
