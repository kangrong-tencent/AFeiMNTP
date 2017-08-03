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
     * 获取网页中的img标签链接
     */
    public Observable<List<ImageInfo>> getImgUrl(final String url) {
        return Observable.create((Subscriber<? super List<ImageInfo>> sub) -> {
            if (!BasicUtils.isNotNull(url))
                return;
            Document html = null;
            try {
                html = Jsoup.connect(url).timeout(10000).post();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (html == null) return;
            Elements urls = html.select("img[src$=.jpg]");
            List<ImageInfo> imgUrls = new ArrayList<>();
            for (Element eUrl : urls) {
                String src = eUrl.attr("src");
                if (BasicUtils.isNotNull(src)) {
                    ImageInfo imageInfo = new ImageInfo();
                    imageInfo.setImgUrl(src);
                    imgUrls.add(imageInfo);
                }
            }
            sub.onNext(imgUrls);
            sub.onCompleted();
        }).subscribeOn(Schedulers.io());
    }
}
