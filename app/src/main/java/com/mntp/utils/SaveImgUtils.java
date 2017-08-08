package com.mntp.utils;

import android.content.ContentValues;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import com.mntp.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by afei on 2017/8/8.
 */

public class SaveImgUtils {

    /**
     * 保存图片到相册
     *
     * @param file
     * @return
     */
    public static void saveImgToGallery(File file) {

        if (!file.exists()) {
            return;
        }
        boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
        if (!sdCardExist)
            return;
        try {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.ImageColumns.TITLE, file.getName());
            values.put(MediaStore.Images.ImageColumns.DISPLAY_NAME, file.getName());
            values.put(MediaStore.Images.ImageColumns.DATE_TAKEN, System.currentTimeMillis());
            values.put(MediaStore.Images.ImageColumns.DATA, file.getAbsolutePath());
            values.put(MediaStore.Images.ImageColumns.MIME_TYPE, "image/jpeg");
            App.app.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            Toast.makeText(App.app, "保存成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
