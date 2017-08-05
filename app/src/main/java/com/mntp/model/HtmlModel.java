package com.mntp.model;

import com.mntp.entity.ImageInfo;
import com.mntp.utils.BasicUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by afei on 2015/11/4.
 */
public class HtmlModel {

    /**
     * 获取首页图片信息
     */
    public Observable<List<ImageInfo>> getImgUrl(final String url) {
        return Observable.just(url)
                .subscribeOn(Schedulers.io())
                .map(urlStr -> {
                    if (!BasicUtils.isNotNull(urlStr))
                        return null;
                    Document html = null;
                    try {
                        html = Jsoup.connect(urlStr).timeout(5000).post();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (html == null) return null;
                    Elements datas = html.select("div.img_single");
                    Elements urls = datas.select("img[src$=.jpg]");
                    Elements infoUrl = datas.select("a[href]");
                    List<ImageInfo> imgUrls = new ArrayList<>();
                    for (int i = 0, j = urls.size(); i < j; i++) {
                        String src = urls.get(i).attr("src");
                        String href = infoUrl.get(i).attr("href");
                        if (BasicUtils.isNotNull(src)) {
                            ImageInfo imageInfo = new ImageInfo();
                            imageInfo.setImgUrl(src);
                            imageInfo.setInfoURL(href);
                            imgUrls.add(imageInfo);
                        }
                    }
                    return imgUrls;
                }).filter(imgUrls -> imgUrls != null && imgUrls.size() != 0);
    }
}
