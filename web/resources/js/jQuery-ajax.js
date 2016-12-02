/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
  $('a').on('click' , function(e){
    e.preventDefault();     //リンクの停止
    var url = this.href;    //URLをhrefからとってくる

    $('#pageDisplay').load(url + '#pageDisplay');
  });
});