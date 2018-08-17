package com.ln.xposed_first_demo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import de.robv.android.xposed.XposedBridge;

/**
 * Created by SecretBase on 2017/2/4.
 */

/**
 * sb.append("imei: "+tm.getDeviceId()+"\n");
 * sb.append("simoperator:"+tm.getSimOperator()+"\n");
 * sb.append("networkoperator:"+tm.getNetworkOperator()+"\n");
 * sb.append("subscriberId:"+tm.getSubscriberId()+"\n");
 * sb.append("simoperatorName:"+tm.getSimOperatorName()+"\n");
 * sb.append("SimSerialNumber:"+tm.getSimSerialNumber()+"\n");
 * sb.append("SimState:"+tm.getSimState()+"\n");
 * sb.append("NetworkOperatorName:"+tm.getNetworkOperatorName()+"\n");
 * sb.append("Line1Number:"+tm.getLine1Number()+"\n");
 */
public class MyActivity extends Activity implements View.OnClickListener {
    private EditText imei
            , simoperator
            , networkoperator
            , subscriberId
            , simoperatorName
            , SimSerialNumber
            , SimState
            , NetworkOperatorName
            , Line1Number;

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

//        sp=getSharedPreferences("demo",Context.MODE_PRIVATE);
//        editor=sp.edit();
//
//        TelephonyManager tm= (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        imei= (EditText) findViewById(R.id.et_imei);
//        simoperator= (EditText) findViewById(R.id.et_simoperator);
//        networkoperator= (EditText) findViewById(R.id.et_networkoperator);
//        subscriberId= (EditText) findViewById(R.id.et_subscriberId);
//        simoperatorName= (EditText) findViewById(R.id.et_simoperatorName);
//        SimSerialNumber= (EditText) findViewById(R.id.et_SimSerialNumber);
//        SimState= (EditText) findViewById(R.id.et_SimState);
//        NetworkOperatorName= (EditText) findViewById(R.id.et_NetworkOperatorName);
//        Line1Number= (EditText) findViewById(R.id.et_Line1Number);
//
//
//        imei.setText(tm.getDeviceId());
//        simoperator.setText(tm.getSimOperator());
//        networkoperator.setText(tm.getNetworkOperator());
//        subscriberId.setText(tm.getSubscriberId());
//        simoperatorName.setText(tm.getSimOperatorName());
//        SimSerialNumber.setText(tm.getSimSerialNumber());
//        SimState.setText(tm.getSimState()+"");
//        NetworkOperatorName.setText(tm.getNetworkOperatorName());
//        Line1Number.setText(tm.getLine1Number());
//
//
//        findViewById(R.id.btn_submit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        MyContants.IMEI=imei.getText().toString();
//        MyContants.LINENUMBER=Line1Number.getText().toString();
//        MyContants.NETWORKOPERATOR=networkoperator.getText().toString();
//        MyContants.NETWORKOPERATORNAME=NetworkOperatorName.getText().toString();
//        MyContants.SIMDTATE=Integer.parseInt(SimState.getText().toString());
//        MyContants.SIMOPERATOR=simoperator.getText().toString();
//        MyContants.SIMOPERATORNAME=simoperatorName.getText().toString();;
//        MyContants.SIMSERIALNUMBER=SimSerialNumber.getText().toString();
//        MyContants.SUBSCRIBERID=subscriberId.getText().toString();
//
//
//        editor.putString("IMEI",imei.getText().toString());
//        editor.putString("LINENUMBER",Line1Number.getText().toString());
//        editor.putString("NETWORKOPERATOR",networkoperator.getText().toString());
//        editor.putString("NETWORKOPERATORNAME",NetworkOperatorName.getText().toString());
//        editor.putInt("SIMDTATE",Integer.parseInt(SimState.getText().toString()));
//        editor.putString("SIMOPERATOR",simoperator.getText().toString());
       // editor.putString("SIMOPERATORNAME");
    }
}
