// ==UserScript==
// @name         重定向
// @namespace    http://tampermonkey.net/
// @homepagae    https://raw.githack.com/jsonlog/mygradle/master/myjs/src/UserScript.js
// @version      0.1
// @description  try to take over the world!
// @author       jsonlog
// @match        http*://*/*
// @grant        none
// ==/UserScript==

(function () {
    'use strict';
    //document.location.href='http://www.google.com/search?q=cache:'+escape(document.location.href)

    var url = window.location.href;
    // url = "https://link.zhihu.com/?target=https%3A//link.jianshu.com/%3Ft%3Dhttps%3A//twitter.com/timberners_lee"
    // url = "https://mijisou.com/url_proxy?proxyurl=http%3A//www.so.com/link%3Furl%3Dhttp%253A%252F%252Fwww.360kuai.com%252Fpc%252F989bbf71b2a9abcb8%253Fcota%253D3%2526kuai_so%253D1%2526sign%253D360_7bc3b157%2526refer_scene%253Dso_55%26q%3D%25E6%2596%25B0%25E9%2597%25BB%26ts%3D1569510529%26t%3D53fdd6417c9d84a4c745a17b8841fb9&token=27af8d927f81aeba45c0ebfba4174e638cb622d7151fc29974b1a8d346a86e34"
    // url = "https://www.jianshu.com/go-wild?ac=2&url=http%3A%2F%2Fmaven.apache.org%2Fref%2F3.2.2%2Fmaven-repository-metadata%2Frepository-metadata.html"
    // url = "https://www.zhihu.com";
    // url = "https://www.baidu.com";

    // Your code here...
    var Toast = function () {
    }
    Toast.prototype = {
        create: function (message, time, top) {
            // var toastHtml = '<div class="tClass">' + message + '</div>';
            var toastHtml = '<textarea class="tClass">' + message + '</textarea>';
            if (document.querySelector('.tClass')) return;
            document.body.insertAdjacentHTML('beforeend', toastHtml);
            document.querySelector('.tClass').style.display = "block";
            document.querySelector(".tClass").style.position = "fixed";
            document.querySelector('.tClass').style.top = top + "%";
            document.querySelector('.tClass').style.left = "50%";
            document.querySelector('.tClass').select();
            if (document.execCommand('copy')) {
                document.execCommand('copy');
                console.log('复制成功');
            }
            setTimeout(function () {
                if (document.querySelector('.tClass')) {
                    document.querySelector('.tClass').parentNode.removeChild(document.querySelector('.tClass'))
                }
            }, time);
        },
        creatToast: function (message, time, top) {
            return this.create(message, time, top)
        }
    }
    var toast = new Toast();
    var redirect = owlRedirectorFilter(url, toast);
    if (redirect != null) {
        document.location.href = redirect;
        // window.open(redirect);
        toast.creatToast(redirect, 360000, 50);//在页面中间弹出
    }
    // else toast.creatToast(url, 1000, 90);//在页面底端弹出

    function owlRedirectorFilter(url,toast) {
        // url = window.location.href;
        var domain = new URL(url);

        if (domain.host.indexOf("pan.baidu.com") != -1) return url.replace("baidu.com", "baiduwp.com");
        if (url == "https://www.baidu.com") return "https://www.baidu.com/?";
        if (url == "https://www.zhihu.com" || url == "https://www.zhihu.com/signin?next=%2F") return "https://www.zhihu.com/explore";

        var addUrlvideolist = [
            //http://app.baiyug.cn:2019/vip/?url=">百域学院</a>
            //http://qqe2.com/Video/default.html
            "https://www.administratorw.com/admin.php?url=",
            "https://www.sounm.com/?url=",//https://www.sounm.com/
            "https://www.administratorw.com/video.php?url=",
            "http://api.baiyug.vip/index.php?url=",//ad
            "https://jx.618g.com/?url=",//ad
            "http://www.zhmdy.top/index.php?zhm_jx=",
            "https://jiexi.071811.cc/jx.php?url=",
            "https://660e.com/?url=",

            // https://www.socarchina.com/vip.htm
        ];
        var addUrlvoicelist = [
            //http://moresound.tk/music/
            "https://www.socarchina.com/vipmusic/?url=",
        ]
        var videolist = [
            "v.youku.com",
            "v.qq.com",
            "iqiyi.com",
        ];
        var voicelist = [
            "www.1ting.com",
            "music.migu.c",
            "y.qq.com",
            "www.qingting.fm",
        ];
        if (addUrlvoicelist.indexOf(domain.host) != -1) return url;
        if (voicelist.indexOf(domain.host) != -1) {
            return addUrlvoicelist[0] + encodeURIComponent(url);
        }
        if (addUrlvideolist.indexOf(domain.host) != -1) return url;
        if (videolist.indexOf(domain.host) != -1) {
            return addUrlvideolist[0] + encodeURIComponent(url);
        }
        var _3A2F2F = [
            "mail.qq.com",//https://mail.qq.com/cgi-bin/mail_spam?action=check_link&url=https://github.com/&mailid=Gg4Gb3cLBggAFV9eXENuT2VMVFBfVUxZYXAHcAB2fw5U&spam=0
            "mijisou.com",//"https://mijisou.com/url_proxy?proxyurl=http",
            "link.zhihu.com",//"https://link.zhihu.com/?target=http",
            "www.jianshu.com",//"https://www.jianshu.com/go-wild?ac=2&url="
        ]
        var protocol = "=https%3A";//%2F%2F;
        var start = url.indexOf(protocol);
        if (start == -1) {
            protocol = "=https://";
            start = url.indexOf(protocol);
        }
        if (start == -1) {
            protocol = "=http%3A";
            start = url.indexOf(protocol);
        }
        if (start == -1) {
            protocol = "=http://";
            start = url.indexOf(protocol);
        }
        if (start != -1) {
            var _3A2F2Findex = _3A2F2F.indexOf(domain.host);//origin
            url = url.substr(start + 1);
            var end = url.length;
            if (_3A2F2Findex == 0) { end = url.indexOf("&"); }
            url = decodeURIComponent(url.substring(0, end));
            if (_3A2F2Findex != -1) return url;
            else {
                // alert(url);
                toast.creatToast(url, 360000, 10);//在页面上方弹出
                //copyRedirect(url);
            }
        }
        return null;
    }
    function copyRedirect(url){
        const input = document.createElement('input');
        document.body.appendChild(input);
        input.setAttribute('value',url);
        input.select();
        if(document.execCommand('copy')) {
            document.execCommand('copy');
            console.log('复制成功');
        }
        document.body.removeChild(input);
    }
})();