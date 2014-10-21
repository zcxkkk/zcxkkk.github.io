/**
 *
 * @type {*|jQuery|HTMLElement}
 * window resize function
 */

$(function() {
    var win = $(window);
    $('#mainDiv').css("width", win.width());
    $('#chinaMainMap').css("width", win.width());

    $(window).resize(function () {
        var winl = $(window);
        var nowWinWidth = winl.width();
        var nowWinHeight = winl.height();
        console.log(nowWinWidth);
        console.log(nowWinHeight);
    }).resize();
});