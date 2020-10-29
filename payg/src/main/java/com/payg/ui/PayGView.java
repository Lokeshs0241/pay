package com.payg.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.payg.R;

public class PayGView extends LinearLayout {

    private EditText etDetailsAmount;
    private EditText etOrderType;
    private EditText etAmountDiscount;
    private EditText etAmount;
    private EditText etCustomerNote;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etMobileNo;
    private EditText etEmail;
    private EditText etEmailReceipt;
    private EditText etBillingAddress;
    private EditText etBillingCity;
    private EditText etBillingState;
    private EditText etBillingCountry;
    private EditText etBillingZipCode;
    private EditText etShippingFirstName;
    private EditText etShippingLastName;
    private EditText etShippingAddress;
    private EditText etShippingCity;
    private EditText etShippingState;
    private EditText etShippingCountry;
    private EditText etShippingZipCode;
    private EditText etShippingMobileNo;
    private EditText etUserName;
    private EditText etSource;
    private EditText etIntegrationType;
    private EditText etHashData;
    private EditText etPlatformId;
    private EditText etRequestTime;
    private Context context;
    private LinearLayout container;

    public PayGView(Context context) {
        super(context);
        this.context = context;
    }

    public PayGView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.step_view_styleable);

        String title = attrArray.getString(R.styleable.step_view_styleable_title_text);
        String code = attrArray.getString(R.styleable.step_view_styleable_code_text);
        String buttonText = attrArray.getString(R.styleable.step_view_styleable_button_text);
        boolean enabled = attrArray.getBoolean(R.styleable.step_view_styleable_enabled,true);

        title = title == null ? "" : title;
        code = code == null ? "" : code;
        buttonText = buttonText == null ? "" : buttonText;

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        container = (LinearLayout) layoutInflater.inflate(R.layout.payg_view_layout,this,true);

        etDetailsAmount    = findViewById(R.id.etDetailsAmount);
        etOrderType        = findViewById(R.id.etOrderType);
        etAmountDiscount   = findViewById(R.id.etAmountDiscount);
        etAmount           = findViewById(R.id.etAmount);
        etCustomerNote     = findViewById(R.id.etCustomerNote);
        etFirstName        = findViewById(R.id.etFirstName);
        etLastName         = findViewById(R.id.etLastName);
        etMobileNo         = findViewById(R.id.etMobileNo);
        etEmail            = findViewById(R.id.etEmail);
        etEmailReceipt     = findViewById(R.id.etEmailReceipt);
        etBillingAddress   = findViewById(R.id.etBillingAddress);
        etBillingCity      = findViewById(R.id.etBillingCity);
        etBillingState     = findViewById(R.id.etBillingState);
        etBillingCountry   = findViewById(R.id.etBillingCountry);
        etBillingZipCode   = findViewById(R.id.etBillingZipCode);
        etShippingFirstName= findViewById(R.id.etShippingFirstName);
        etShippingLastName = findViewById(R.id.etShippingLastName);
        etShippingAddress  = findViewById(R.id.etShippingAddress);
        etShippingCity     = findViewById(R.id.etShippingCity);
        etShippingState    = findViewById(R.id.etShippingState);
        etShippingCountry  = findViewById(R.id.etShippingCountry);
        etShippingZipCode  = findViewById(R.id.etShippingZipCode);
        etShippingMobileNo = findViewById(R.id.etShippingMobileNo);
        etUserName         = findViewById(R.id.etUserName);
        etSource           = findViewById(R.id.etSource);
        etIntegrationType  = findViewById(R.id.etIntegrationType);
        etHashData         = findViewById(R.id.etHashData);
        etPlatformId       = findViewById(R.id.etPlatformId);
        etRequestTime      = findViewById(R.id.etRequestTime);
    }

    public PayGView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PayGView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}
