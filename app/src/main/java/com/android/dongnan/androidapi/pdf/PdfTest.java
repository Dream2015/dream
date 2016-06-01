package com.android.dongnan.androidapi.pdf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.dongnan.androidapi.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dream on 16/6/1.
 */
public class PdfTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PdfDocument document = new PdfDocument();

        PdfDocument.PageInfo info = new PdfDocument.PageInfo.Builder(612,782,1).create();

        PdfDocument.Page page = document.startPage(info);

        TextPaint paint = new TextPaint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        Typeface textTypeface = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);
        paint.setTypeface(textTypeface);

        String text = "ImageView imageView = new ImageView(this);\n" +
                "\n" +
                "        PdfDocument document = new PdfDocument();\n" +
                "        \n" +
                "        PdfDocument.PageInfo info = new PdfDocument.PageInfo.Builder(612,782,1).create();\n" +
                "        \n" +
                "        PdfDocument.Page page = document.startPage(info);\n" +
                "\n" +
                "        TextPaint paint = new TextPaint();\n" +
                "        paint.setColor(Color.BLACK);\n" +
                "        paint.setTextSize(12);\n" +
                "        paint.setTextAlign(Paint.Align.LEFT);\n" +
                "\n" +
                "        Typeface textTypeface = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);\n" +
                "        paint.setTypeface(textTypeface);";

        StaticLayout layout = new StaticLayout(text, paint, page.getCanvas().getWidth(),
                Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);

        layout.draw(page.getCanvas());

        ImageView view = new ImageView(this);

        view.draw(page.getCanvas());

        setContentView(view);

        document.finishPage(page);

        File file = new File(Environment.getExternalStorageDirectory(), "demo.pdf");

        if(file != null && !file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try(FileOutputStream out = new FileOutputStream(file);) {
            document.writeTo(out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            document.close();
        }
    }
}
