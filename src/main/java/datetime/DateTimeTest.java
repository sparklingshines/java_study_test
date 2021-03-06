package datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeTest {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2017, Month.JANUARY, 1);
		System.out.println(localDate.toString());

		localDate = LocalDate.now(); // 获取本地日期
		System.out.println(localDate.toString());
		
		localDate = LocalDate.ofYearDay(2014, 200); // 获得 2014 年的第 200 天
		System.out.println(localDate.toString());// 输出：2014-07-19
		
		localDate = LocalDate.of(2014, Month.SEPTEMBER, 10); // 2014 年 9 月 10 日
		System.out.println(localDate.toString());// 输出：2014-09-10
		
		// LocalTime
		LocalTime localTime = LocalTime.now(); // 获取当前时间
		System.out.println(localTime.toString());// 输出当前时间
		
		localTime = LocalTime.of(10, 20, 50);// 获得 10:20:50 的时间点
		System.out.println(localTime.toString());// 输出: 10:20:50
		// Clock 时钟
		Clock clock = Clock.systemDefaultZone();// 获取系统默认时区 (当前瞬时时间 )
		long millis = clock.millis();//
	}

}
