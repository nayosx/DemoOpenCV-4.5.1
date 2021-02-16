package com.ness.opencv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ness.opencv.util.PermissionUtility;
import com.ness.opencv.util.S;


public class MainActivity extends AppCompatActivity {

    private PermissionUtility permissionUtility;

    private String[] _permission = {
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionUtility = new PermissionUtility(this, _permission);
        if(permissionUtility.arePermissionsEnabled()) {
            Log.d(S.MAIN_ACTIVITY, "Permission granted 1");
        } else {
            permissionUtility.requestMultiplePermissions();
        }
        device();
    }

    public void toCaptureCode(View v) {
        startActivity(new Intent(this, OpenCVColorActivity.class));
    }

    public void toCaptureFace(View v) {
        startActivity(new Intent(this, FaceDetectorActivity.class));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(permissionUtility.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            Log.d(S.MAIN_ACTIVITY, "Permission granted 2");
        }
    }

    @SuppressLint("HardwareIds")
    private void device() {
        Log.i(S.MAIN_ACTIVITY, "DEVICE: " + Build.DEVICE);
        Log.i(S.MAIN_ACTIVITY,"MODEL: " + Build.MODEL);
        Log.i(S.MAIN_ACTIVITY,"ID: " + Build.ID);
        Log.i(S.MAIN_ACTIVITY,"Manufacture: " + Build.MANUFACTURER);
        Log.i(S.MAIN_ACTIVITY,"brand: " + Build.BRAND);
        Log.i(S.MAIN_ACTIVITY,"type: " + Build.TYPE);
        Log.i(S.MAIN_ACTIVITY,"user: " + Build.USER);
        Log.i(S.MAIN_ACTIVITY,"BASE: " + Build.VERSION_CODES.BASE);
        Log.i(S.MAIN_ACTIVITY,"INCREMENTAL " + Build.VERSION.INCREMENTAL);
        Log.i(S.MAIN_ACTIVITY,"SDK  " + Build.VERSION.SDK_INT);
        Log.i(S.MAIN_ACTIVITY,"BOARD: " + Build.BOARD);
        Log.i(S.MAIN_ACTIVITY,"BRAND " + Build.BRAND);
        Log.i(S.MAIN_ACTIVITY,"HOST " + Build.HOST);
        Log.i(S.MAIN_ACTIVITY,"FINGERPRINT: "+Build.FINGERPRINT);
        Log.i(S.MAIN_ACTIVITY,"Version Code: " + Build.VERSION.RELEASE);
    }
}