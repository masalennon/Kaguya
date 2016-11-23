/*
 * 注文確認メールのメールテキストを作成して返す
 */
package Db;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Dependent;

@Dependent
public class MakeText implements Serializable {

    DecimalFormat fm = new DecimalFormat("###,###,###");
    SimpleDateFormat fd = new SimpleDateFormat("y年M月d日");

    public String getText(String name) {
        String message = "正常に送信が行われました。お支払いを確認し次第、保育者様の連絡先をお教えいたします。もし万が一"
                + "保育者様と連絡が取れない場合は、こちらで確認を取った上で必ず全額返金いたしますのでご安心ください。"
                + "このメールに覚えがない場合は、お手数ですがこのメールに返信する形で運営までおしらせください。";

        String CR = System.getProperty("line.separator");
        StringBuilder buf = new StringBuilder();
        buf.append(name).append("様").append(CR);
        buf.append(message).append(CR).append("日付:");
        buf.append(ymd(new Date())).append(CR).append(CR);

        return buf.toString();
    }

    public String gaku(Integer n) {
        return fm.format(n);

    }

    public String ymd(Date d) {
        return (fd.format(d));
    }
}
