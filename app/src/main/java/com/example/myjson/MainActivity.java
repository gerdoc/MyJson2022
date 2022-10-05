package com.example.myjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myjson.json.MyInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        object2Json( );
        json2Object( "{\"calificacion\":9.5,\"edad\":17,\"nombre\":\"Gerdoc 1\",\"sexo\":true}" );
        list2Json( );
        json2List( "[{\"calificacion\":7.41,\"edad\":16,\"nombre\":\"1 Gerdoc 1\",\"sexo\":true},\n" +
                "{\"calificacion\":4.98,\"edad\":17,\"nombre\":\"2 Gerdoc 2\",\"sexo\":true}]" );

    }

    public void object2Json() {
        MyInfo myInfo = null;
        Gson gson = null;
        String json = null;
        String mensaje = null;

        myInfo = new MyInfo();
        myInfo.setCalificacion(4.5f);
        myInfo.setEdad(17);
        myInfo.setNombre("Gerdoc");
        myInfo.setSexo(Boolean.FALSE);
        Log.d(TAG, "TEST");
        gson = new Gson();
        json = gson.toJson(myInfo);
        if (json != null) {
            Log.d(TAG, json);
            mensaje = "object2Json OK";
        } else {
            mensaje = "Error object2Json";
        }
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }

    public void json2Object( String json )
    {
        MyInfo myInfo2 = null;
        Gson gson = null;
        String mensaje = null;

        gson = new Gson();


        myInfo2 = gson.fromJson(json, MyInfo.class);
        if (myInfo2 != null) {
            mensaje = String.format("(%s)(%d)(%f)(%s)", myInfo2.getNombre(), myInfo2.getEdad(), myInfo2.getCalificacion()
                    , myInfo2.getSexo() ? "F" : "M");
        } else {
            mensaje = "Error2";
        }
        Log.d(TAG, mensaje);
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }

    public void list2Json( )
    {
        MyInfo myInfo3 = null;
        Gson gson = null;
        String json = null;
        List<MyInfo> list = null;

        gson = new Gson();
        list = new ArrayList<MyInfo>();
        for (int i = 0; i < 5; i++)
        {
            myInfo3 = new MyInfo();
            myInfo3.setCalificacion((float) (Math.random() * 10));
            myInfo3.setEdad((int) (Math.random() * 20));
            myInfo3.setNombre(String.format("Gerdoc %d", i + 1));
            myInfo3.setSexo(Boolean.FALSE);
            list.add(myInfo3);
        }
        json = gson.toJson(list, ArrayList.class);
        if (json == null)
        {
            Log.d(TAG, "Error json");
        }
        else
        {
            Log.d(TAG, json);
        }
        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_LONG).show();
    }

    public void json2List( String json )
    {
        List<MyInfo> list = null;
        Gson gson = null;
        String mensaje = null;
        if (json == null || json.length() == 0)
        {
            Toast.makeText(getApplicationContext(), "Error json null or empty", Toast.LENGTH_LONG).show();
            return;
        }
        gson = new Gson();
        Type listType = new TypeToken<ArrayList<MyInfo>>(){}.getType();
        list = gson.fromJson(json, listType);
        if (list == null || list.size() == 0 )
        {
            Toast.makeText(getApplicationContext(), "Error list is null or empty", Toast.LENGTH_LONG).show();
            return;
        }
        for( MyInfo myInfo : list )
        {
            if (myInfo != null)
            {
                mensaje = String.format("(%s)(%d)(%f)(%s)", myInfo.getNombre(), myInfo.getEdad(), myInfo.getCalificacion()
                        , myInfo.getSexo() ? "F" : "M");
            }
            else
            {
                mensaje = "Error2";
            }
            Log.d(TAG, mensaje);
        }
    }
}