package com.ln.xposed_first_demo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by tengyu on 2016/12/11.
 */
public class TestDemo implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        //Log.d("my","XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXposed");

        XSharedPreferences xSharedPreferences = new XSharedPreferences("com.ln.xposed_first_demo", "demo");


        //filmr 视频剪辑，去广告
        if (lpparam.packageName.equals("com.filmrapp.videoeditor")) {
            XposedBridge.log("filmr is finded");
            //对应多dex
            XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    ClassLoader cl = ((Context) param.args[0]).getClassLoader();
                    Class<?> hookclass = null;
                    try {
                        hookclass = cl.loadClass("com.stey.videoeditor.App");
                    } catch (Exception e) {
                        XposedBridge.log("寻找com.stey.videoeditor.App报错" + e.getMessage());
                        return;
                    }
                    XposedBridge.log("寻找xxx.xxx.xxx成功");
                    XposedHelpers.findAndHookMethod(hookclass, "loadWatermark", new XC_MethodHook() {
                        //进行hook操作

                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                            param.setResult(null);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            //XposedBridge.log("result: " + param.getResult().toString());

                            Bitmap bitmap = Bitmap.createBitmap(1,1, Bitmap.Config.ARGB_8888);
                            XposedBridge.log("after result: " + bitmap.getHeight() + " : " + bitmap.getWidth());
                            param.setResult(bitmap);
                        }
                    });
                }
            });


//            XposedHelpers.findAndHookMethod("com.stey.videoeditor.App", lpparam.classLoader, "loadWatermark", new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    super.beforeHookedMethod(param);
//                    param.setResult(false);
//                    XposedBridge.log("immmmm0 :"+param.getResult().toString());
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                    XposedBridge.log("immmmm1  :"+param.getResult().toString());
//                    param.setResult(false);
//                    XposedBridge.log("immmmm2  :"+param.getResult().toString());
//                }
//            });
        }

        //开心消消乐
        if (lpparam.packageName.equals("com.happyelements.AndroidAnimal")) {
            XposedBridge.log("im innnnnnnnnnnn");
            XposedHelpers.findAndHookMethod("com.happyelements.android.utils.DeviceStateChecker", lpparam.classLoader, "isAirPlaneModeOn", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    param.setResult(false);
                    XposedBridge.log("immmmm0 :" + param.getResult().toString());
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    XposedBridge.log("immmmm1  :" + param.getResult().toString());
                    param.setResult(false);
                    XposedBridge.log("immmmm2  :" + param.getResult().toString());
                }
            });
            XposedHelpers.findAndHookMethod("com.happyelements.android.utils.DeviceStateChecker", lpparam.classLoader, "isAnySimCardAlready", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    param.setResult(true);
                    XposedBridge.log("immmmm  isAnySimCardAlready0 :" + param.getResult().toString());
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    XposedBridge.log("immmmm  isAnySimCardAlready1  :" + param.getResult().toString());
                    param.setResult(true);
                    XposedBridge.log("immmmm  isAnySimCardAlready2  :" + param.getResult().toString());
                }
            });
        }
    }

    //number的范围是0-100，0表示完全透明即完全看不到
    public static Bitmap getTransparentBitmap(Bitmap sourceImg, int number) {
        int[] argb = new int[sourceImg.getWidth() * sourceImg.getHeight()];

        sourceImg.getPixels(argb, 0, sourceImg.getWidth(), 0, 0, sourceImg

                .getWidth(), sourceImg.getHeight());// 获得图片的ARGB值

        number = number * 255 / 100;

        for (int i = 0; i < argb.length; i++) {

            argb[i] = (number << 24) | (argb[i] & 0x00FFFFFF);

        }

        sourceImg = Bitmap.createBitmap(argb, sourceImg.getWidth(), sourceImg

                .getHeight(), Bitmap.Config.ARGB_8888);

        return sourceImg;
    }
}
