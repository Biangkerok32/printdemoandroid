package com.printing.printdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintJob;
import android.print.PrintManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrintFileActivity extends AppCompatActivity {

    private static final String TAG = PrintFileActivity.class.getSimpleName();


    @Bind(R.id.fab)
    FloatingActionButton fab;

    private PrintManager printManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_file);

        ButterKnife.bind(this);

        initToolbar();


        printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);


    }


    private String getFilepath(String filename) {

        return new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "/Download/" + filename).getPath();

    }

    protected void initToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    @OnClick(R.id.fab)
    void startPrintJob() {

        String jobName = getString(R.string.app_name) + " Document";
        PrintJob printJob = printManager.print(jobName, new PDFPrintDocumentAdapter(PrintFileActivity.this, "Test", getFilepath("MotoGP_stats.pdf")), null);

    }


}
