package com.yao.pachong;

import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import com.xuxueli.crawler.parser.PageParser;
import lombok.Data;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-07-22 22:20
 **/
public class run {
    // PageSelect 注解：从页面中抽取出一个或多个VO对象；
    @PageSelect(cssQuery = "body")
    @Data
    public static class PageVo {

        @PageFieldSelect(cssQuery = "#mainScreen > div > div.ui.internally.grid.blog-detail.bg-wrap > div > div.twelve.wide.computer.sixteen.wide.tablet.sixteen.wide.mobile.column.body-container > div.float-menu-content > div.article-detail > h1")
        private String title;

        @PageFieldSelect(cssQuery = "#mainScreen > div > div.ui.internally.grid.blog-detail.bg-wrap > div > div.twelve.wide.computer.sixteen.wide.tablet.sixteen.wide.mobile.column.body-container > div.float-menu-content > div.article-detail > div.extra.ui.horizontal.list.blog-meta > div:nth-child(3)")
        private int read;

        @PageFieldSelect(cssQuery = "#articleContent > p:nth-child(2)")
        private List<String> comment;

        // set get
    }
    public static  void main(String args[]){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://my.oschina.net/xuxueli")
                .setWhiteUrlRegexs("https://my\\.oschina\\.net/xuxueli/blog/\\d+")
                .setThreadCount(3)
                .setPageParser(new PageParser<PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, PageVo pageVo) {
                        // 解析封装 PageVo 对象
                        String pageUrl = html.baseUri();
                        System.out.println(pageUrl + "：" + pageVo.toString());
                    }
                })
                .build();
        crawler.start(true);
    }
}
