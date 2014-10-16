/**
 * Created by cru-kkk on 2014/10/16.
 * time format : hh:mm:ss
 */
var isInTimeRange = function (beginTime, endTime, nowTime) {
    var strb = beginTime.split (":");
    if (strb.length != 3) {
        return false;
    }

    var stre = endTime.split (":");
    if (stre.length != 3) {
        return false;
    }

    var strn = nowTime.split (":");
    if (stre.length != 3) {
        return false;
    }
    var b = new Date ();
    var e = new Date ();
    var n = new Date ();

    b.setHours (strb[0]);
    b.setMinutes (strb[1]);
    b.setSeconds(strb[2]);

    e.setHours (stre[0]);
    e.setMinutes (stre[1]);
    e.setSeconds(stre[2]);

    n.setHours (strn[0]);
    n.setMinutes (strn[1]);
    n.setSeconds(strn[2]);

    if (n.getTime () - b.getTime () > 0 && n.getTime () - e.getTime () < 0) {
        return true;
    } else {
//        alert ("当前时间是：" + n.getHours () + ":" + n.getMinutes () + "，不在该时间范围内！");
        return false;
    }
}
isInTimeRange ("21:30:20", "23:30:30", "22:22:20");