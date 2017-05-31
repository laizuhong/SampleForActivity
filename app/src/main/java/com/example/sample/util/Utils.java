package com.example.sample.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/5/31
 * 描述:
 */

public class Utils {
    /***
     * 获取ImageUrl地址
     *
     * @param HTML
     * @return
     */
    public static List<String> getImageUrl(String HTML) {
        int p = 0;
        // 获取img标签正则
//        String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
        String IMGURL_REG = " <p><img.*src=(.*?)[^>]*?><p>";
        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(HTML);
        List<String> listImgUrl = new ArrayList<>();
        while (matcher.find()) {
            listImgUrl.add(matcher.group());
            p++;
            if (p == 3) {//三张图就够了
                break;
            }
        }


        return getImageSrc(listImgUrl);
    }

    /***
     * 获取ImageSrc地址
     *
     * @param listImageUrl
     * @return
     */
    public static List<String> getImageSrc(List<String> listImageUrl) {
        // 获取src路径的正则
        String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";
        List<String> listImgSrc = new ArrayList<>();
        for (String image : listImageUrl) {
            Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(image);
            while (matcher.find()) {
                String macherList = matcher.group().substring(0, matcher.group().length() - 1);
                if (!listImgSrc.contains(macherList)) {
                    listImgSrc.add(macherList);
                }

            }
        }
        return listImgSrc;
    }
}
