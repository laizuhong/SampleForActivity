package com.example.sample.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


public class DisplayUtil {
	/**
	* 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	*/
	public static int dip2px(Context context, float dpValue) {
	  final float scale = context.getResources().getDisplayMetrics().density;
	  return (int) (dpValue * scale + 0.5f);
	}

	/**
	* 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	*/
	public static int px2dip(Context context, float pxValue) {
	  final float scale = context.getResources().getDisplayMetrics().density;
	  return (int) (pxValue / scale + 0.5f);
	}
    public static Rect getDefaultImageBounds(Context context) {
	       Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
	       int width = display.getWidth();
	       int height = (int) (width * 9 / 16);

	        Rect bounds = new Rect(0, 0, width, height);
	        return bounds;
	    }
	   /**
     * 将px值转换为sp值，保证文字大小不变
     * 
     * @param pxValue
     * @param context
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */ 
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity; 
        return (int) (pxValue / fontScale + 0.5f); 
    } 
   
    /**
     * 将sp值转换为px值，保证文字大小不变
     * 
     * @param spValue
     * @param context
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */ 
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity; 
        return (int) (spValue * fontScale + 0.5f); 
    }

	/**
	 * 获取屏幕宽度/高度
	 */
	public static int getScreenW(Context aty) {
		DisplayMetrics dm = aty.getResources().getDisplayMetrics();
		int w = dm.widthPixels;
		// int w = aty.getWindowManager().getDefaultDisplay().getWidth();
		return w;
	}
	public static int getScreenH(Context aty) {
		DisplayMetrics dm = aty.getResources().getDisplayMetrics();
		return dm.heightPixels;
	}

	/**
	 * 获取屏幕长宽比
	 * @param context
	 * @return
	 */
	public static float getScreenRate(Context context){
		float H = getScreenH(context);
		float W = getScreenW(context);
		return ((float)H/W);
	}

//	/**
//	 * 获取直播间标准录屏高
//	 * @param aty
//	 * @return
//	 */
//	public static float getLiveFormatScreenH(Context aty) {
//		int activityHeight = DisplayUtil.getScreenH(aty);
//
//		// 去除底部和头部
//		float videoHeight = activityHeight
//				- DisplayUtil.getStatusBarHeight(aty)
//				- aty.getResources().getDimension(R.dimen.activity_title_bar_height)
//				- aty.getResources().getDimension(R.dimen.live_operation_bottom_height);
//
//		return videoHeight;
//	}

	/**
	 * 获取状态栏高度
	 * @param context
	 * @return
	 */
	public static int getStatusBarHeight(Context context){
		int result = 0;
		int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0){
			result = context.getResources().getDimensionPixelSize(resourceId);

		}
		return result;
	}

//	/**
//	 * 获取节目的进度条的Y位置
//	 * @param aty
//	 * @return
//	 */
//	public static float getPostProgressBarY(Context aty) {
//
//		float y = aty.getResources().getDimension(R.dimen.activity_title_bar_height);
//		return y;
//	}

	/**
	 * 参考ImageView的CenterCorp方式，将预览的尺寸适应父View的尺寸
	 * （注意传参，Camera Sensor得到的宽比高要高）
	 * @return
	 */
	public static Rect getPreviewByCenterCropSize(int previewWidth, int previewHeight, int destWidth, int destHeight) {
		if (destWidth == 0 || destHeight == 0) {
			return null;
		}
		int w = previewWidth;
		int h = previewHeight;
		int x = destWidth;
		int y = destHeight;
		// 高宽比之差
		int temp = (y / x) - (h / w);

		Rect rect = new Rect();

		if (temp > 0) {
			int w1 = (w * y) / h;
			rect.left = 0;
			rect.top = 0;
			rect.right = w1;
			rect.bottom = h;
			return rect;
		} else {
			int h1 = (h * x) / w;
			rect.left = 0;
			rect.top = 0;
			rect.right = x;
			rect.bottom = h1;
			return rect;
		}
	}

	/**
	 * @param activity
	 * @param alpha 1f代表全透明 0.0f全黑
     */
	public static void setBackgroundAlpha(Activity activity, float alpha) {
		if(activity != null) {
			WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
			lp.alpha = alpha;
			activity.getWindow().setAttributes(lp);
		}
	}
}
