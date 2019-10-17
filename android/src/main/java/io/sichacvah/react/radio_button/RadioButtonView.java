package io.sichacvah.react.radio_button;

import android.content.Context;

import com.google.android.material.radiobutton.MaterialRadioButton;

class ReactCheckBox extends MaterialRadioButton {

    private boolean mAllowChange;

    public ReactCheckBox(Context context) {
        super(context);
        mAllowChange = true;
    }

    @Override
    public void setChecked(boolean checked) {
        if (mAllowChange) {
            mAllowChange = false;
            super.setChecked(checked);
        }
    }

    void setCheckedSave(boolean on) {
        if (isChecked() != on) {
            super.setChecked(on);
        }
        mAllowChange = true;
    }
}