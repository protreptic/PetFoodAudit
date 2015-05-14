package org.javaprotrepticon.petproducts.widget;

import org.javaprotrepticon.android.audit.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

public class NumberPickerDialog extends AlertDialog implements OnClickListener, OnValueChangeListener {

	private static final String VALUE = "value";	
    private final NumberPicker mNumberPicker;
    private final OnNumberSetListener mCallBack;

    public interface OnNumberSetListener {
        void onNumberSet(NumberPicker view, int value);
    }
    
    public NumberPickerDialog(Context context, OnNumberSetListener callBack, int value, int minValue, int maxValue) {
        this(context, 0, callBack, value,minValue,maxValue, "Отмена", "Ok", "");
    }
    
    public NumberPickerDialog(Context context,
            int theme,
            OnNumberSetListener callBack,
            int value,
            String[] values,
            String negativeButtonText,
            String positiveButtonText,
            String dialogTitle){
    	this(context, theme,callBack,value,0,values.length-1,values,negativeButtonText,positiveButtonText,dialogTitle);
    }
    public NumberPickerDialog(Context context,
            int theme,
            OnNumberSetListener callBack,
            int value,
            int minValue,
            int maxValue,
            String negativeButtonText,
            String positiveButtonText,
            String dialogTitle){
    	this(context, theme,callBack,value,minValue,maxValue,null,negativeButtonText,positiveButtonText,dialogTitle);
    }

    public NumberPickerDialog(Context context,
            int theme,
            OnNumberSetListener callBack,
            int value,
            int minValue,
            int maxValue,
            String[] values,
            String negativeButtonText,
            String positiveButtonText,
            String dialogTitle) {
        super(context, theme);

        mCallBack = callBack;

        Context themeContext = getContext();
        setButton(BUTTON_POSITIVE, positiveButtonText, this);
        setButton(BUTTON_NEGATIVE, negativeButtonText, (OnClickListener) null);
        setIcon(0);
        setTitle(dialogTitle);

        LayoutInflater inflater = (LayoutInflater) themeContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.number_picker_dialog, null);
        setView(view);
        int color = getContext().getResources().getColor(android.R.color.transparent);
        view.setBackgroundColor(color);
      
        mNumberPicker = (NumberPicker) view.findViewById(R.id.number_picker_dialog_number_picker);
        mNumberPicker.setMinValue(minValue);
        mNumberPicker.setMaxValue(maxValue);
        mNumberPicker.setValue(value);
        mNumberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        if (values!=null) mNumberPicker.setDisplayedValues(values);
    }

    public void onClick(DialogInterface dialog, int which) {
        if (mCallBack != null) {
            //mNumberPicker.clearFocus();
            mCallBack.onNumberSet(mNumberPicker, mNumberPicker.getValue());
        }
    }
    
    @Override
    public void onValueChange(NumberPicker view, int oldVal, int newVal) {
        mNumberPicker.setValue(newVal);
    }
	
    public NumberPicker getNumberPicker() {
        return mNumberPicker;
    }

    public void setValue(int value) {
        mNumberPicker.setValue(value);
    }

    @Override
    public Bundle onSaveInstanceState() {
        Bundle state = super.onSaveInstanceState();
        state.putInt(VALUE, mNumberPicker.getValue());
       
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int value = savedInstanceState.getInt(VALUE);
        mNumberPicker.setValue(value);
    }
    
}


