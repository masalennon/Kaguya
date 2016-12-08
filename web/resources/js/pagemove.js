/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    //ページを表示させる箇所の設定
    var $content = $('.pageDisplay');
    //ボタンをクリックした時の処理
    $(document).on('click', '.gnavi a', function (event) {
        event.preventDefault();
        //.gnavi aのhrefにあるリンク先を保存
        var link = $(this).attr("href");
        //リンク先が今と同じであれば遷移しない
        if (link === lastpage) {
//            return false;
            $content.fadeOut(600, function () {
                getPage(link);
            });
            //今のリンク先を保存
            lastpage = link;
        } else {
            $content.fadeOut(600, function () {
                getPage(link);
            });
            //今のリンク先を保存
            lastpage = link;
        }

    });
    //初期設定
    getPage("aboutservice.xhtml");
    var lastpage = "aboutservice2.xhtml";

    //ページを取得してくる
    function getPage(elm) {
        $.ajax({
            type: 'GET',
            url: elm,
            text: 'xhtml',
            success: function (data) {
                $content.html(data).fadeIn(600);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(textStatus);

//                alert('問題がありました。');
            }
        });
    }
});