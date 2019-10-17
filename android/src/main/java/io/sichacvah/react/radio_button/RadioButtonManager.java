package io.sichacvah.react.radio_button;

import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import android.content.res.ColorStateList;
import android.support.v4.widget.CompoundButtonCompat;
import android.widget.CompoundButton;
import android.content.ContextWrapper;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.UIManagerModule;


public class RadioButtonManager extends SimpleViewManager<ReactCheckBox> {
    private final static String REACT_CLASS = "RCTRadioButtonAndroid";


    private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER =
            (CompoundButton buttonView, boolean isChecked) -> {
                ReactContext reactContext = (ReactContext) ((ContextWrapper) buttonView.getContext()).getBaseContext();
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                        new RadioButtonEvent(
                                buttonView.getId(),
                                SystemClock.nanoTime(),
                                isChecked));
            };


    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected ReactCheckBox createViewInstance(ThemedReactContext context) {
        ReactCheckBox view = new ReactCheckBox(context);
        view.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
        return view;
    }

    @Override
    protected void addEventEmitters(final ThemedReactContext reactContext, final ReactCheckBox view) {
        view.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @ReactProp(name = "on", defaultBoolean = false)
    public void setOn(ReactCheckBox view, boolean on) {
        view.setOnCheckedChangeListener(null);
        view.setCheckedSave(on);
        view.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @ReactProp(name = "disabled", defaultBoolean = false)
    public void setEnabled(ReactCheckBox checkbox, boolean disabled) {
        checkbox.setEnabled(!disabled);
    }

    @ReactProp(name = "color", customType = "Color")
    public void setColor(ReactCheckBox checkbox, Integer color) {
        CompoundButtonCompat.setButtonTintList(checkbox, ColorStateList.valueOf(color));
    }
}
