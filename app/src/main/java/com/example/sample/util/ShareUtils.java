package com.example.sample.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

public class ShareUtils {

    public static final String AUTHORITY = "com.ume.browser.fileprovider";
    /**
     * 直接分享纯文本内容至QQ好友
     * @param mContext
     * @param content
     */
    public static void shareQQ(Context mContext, String content) {
        if (PlatformUtil.isInstallApp(mContext,PlatformUtil.PACKAGE_MOBILE_QQ)) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
            intent.putExtra(Intent.EXTRA_TEXT, content);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
            mContext.startActivity(intent);
        } else {
            Toast.makeText(mContext, "您需要安装QQ客户端", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 分享图片给QQ好友
     *
     * @param bitmap
     */
    public static void shareImageToQQ(Context mContext,Bitmap bitmap) {
        if (PlatformUtil.isInstallApp(mContext,PlatformUtil.PACKAGE_MOBILE_QQ)) {
            try {
                Uri uriToImage = Uri.parse(MediaStore.Images.Media.insertImage(
                        mContext.getContentResolver(), bitmap, null, null));
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, uriToImage);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.setType("image/*");
                // 遍历所有支持发送图片的应用。找到需要的应用
                ComponentName componentName = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");

                shareIntent.setComponent(componentName);
                // mContext.startActivity(shareIntent);
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"));
            } catch (Exception e) {
//            ContextUtil.getInstance().showToastMsg("分享图片到**失败");
            }
        }
    }

    /**
     * 直接分享图片到微信好友
     * @param context
     */
    public static void shareWechatFriend(Context context,Uri uri){
        if (PlatformUtil.isInstallApp(context,PlatformUtil.PACKAGE_WECHAT)){
            Intent intent = new Intent();
            ComponentName cop = new ComponentName("com.tencent.mm","com.tencent.mm.ui.tools.ShareImgUI");
            intent.setComponent(cop);
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("image/*");

            intent.putExtra(Intent.EXTRA_STREAM, uri);
//            intent.putExtra("Kdescription", !TextUtils.isEmpty(content) ? content : "");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // context.startActivity(intent);
            context.startActivity(Intent.createChooser(intent, "Share"));
        }else{
            Toast.makeText(context, "您需要安装微信客户端", Toast.LENGTH_LONG).show();
        }
    }

//    /**
//     * 直接分享文本到微信好友
//     *
//     * @param context 上下文
//     */
//    public void shareWechatFriend(Context context, String content) {
//        if (PlatformUtil.isWeChatAvailable(context)) {
//            Intent intent = new Intent();
//            ComponentName cop = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
//            intent.setComponent(cop);
//            intent.setAction(Intent.ACTION_SEND);
//            intent.putExtra("android.intent.extra.TEXT", content);
////            intent.putExtra("sms_body", content);
//            intent.putExtra("Kdescription", !TextUtils.isEmpty(content) ? content : "");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        } else {
//            Toast.makeText(context, "您需要安装微信客户端", Toast.LENGTH_LONG).show();
//        }
//    }


}
