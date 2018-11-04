import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javafx.scene.input.DataFormat;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    //生成当年周及周的日期
    @Test
    public  void createWeek(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2018);
        cal.set(Calendar.WEEK_OF_MONTH,18);
        cal.set(Calendar.DAY_OF_WEEK,2);
        Date date = cal.getTime();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Test
    public void getYear(){
        Calendar cal = Calendar.getInstance();
        int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        System.out.println(weeks);
        cal.add(Calendar.YEAR, 0);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.add(Calendar.DATE, 1 * 7);
        System.out.println();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal.getFirstDayOfWeek());;
    }


    //2018 年1月份
    //获取1月份的天数
    /**
     * 获取1月1日是周几
     * （用天数-第一周剩下来的天数）/7 获取这个月有几周
     *
     */

    @Test
    public void getYear1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int weekCount=1;
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        JSONObject json = new JSONObject();
        json.put("text",year);
        JSONArray monthArray = new JSONArray();
        json.put("children",monthArray);
        Date current = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        int months = cal.get(Calendar.MONTH)+1;
        int weeks = getWeekOfYear(current);
        for(int i=1;i<=months;i++){
            JSONObject month = new JSONObject();
            month.put("text",i+"月");
            JSONArray weekArray = new JSONArray();
            for(int j=weekCount;j<=weeks;j++){
                Date date = getMonday(year,j);
                cal = Calendar.getInstance();
                cal.setTime(date);
                int monthFlag = cal.get(Calendar.MONTH)+1;
                if(monthFlag==i){
                    JSONObject week = new JSONObject();
                    week.put("text","第"+j+"周");
                    weekArray.add(week);
                    weekCount++;
                    JSONArray dayArray = new JSONArray();
                    JSONObject start = new JSONObject();
                    JSONObject end = new JSONObject();
                    start.put("text",sdf.format(getMonday(year,j)));
                    end.put("text",sdf.format(getSunday(year,j)));
                    dayArray.add(start);
                    dayArray.add(end);
                    week.put("children",dayArray);
                }

            }

            month.put("children",weekArray);
            monthArray.add(month);
        }

        System.out.println(json.toJSONString());

    }

    public Date getMonday(int year,int week){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year); // 2016年
        cal.set(Calendar.WEEK_OF_YEAR, week); // 设置为2016年的第10周
        cal.set(Calendar.DAY_OF_WEEK, 2); // 1表示周日，2表示周一，7表示周六
        Date date = cal.getTime();
        return date;
    }

    public Date getSunday(int year,int week){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year); // 2016年
        cal.set(Calendar.WEEK_OF_YEAR, week+1); // 设置为2016年的第10周
        cal.set(Calendar.DAY_OF_WEEK, 1); // 1表示周日，2表示周一，7表示周六
        Date date = cal.getTime();
        return date;
    }



        // 获取当前时间所在年的周数
        public  int getWeekOfYear(Date date) {
            Calendar c = Calendar.getInstance();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            c.setMinimalDaysInFirstWeek(7);
            c.setTime(date);

            return c.get(Calendar.WEEK_OF_YEAR);
        }
    @Test
    public void test(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(getMonday(2018,1)));
        System.out.println(getWeekOfYear(new Date()));
    }
}
