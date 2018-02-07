package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("默认格式化: " + now);
		System.out.println("自定义格式化: " + now.format(dateTimeFormatter));
		LocalDateTime localDateTime = LocalDateTime.parse("2017-07-20 15:27:44", dateTimeFormatter);
		System.out.println(System.currentTimeMillis());
		System.out.println(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
		System.out.println("字符串转LocalDateTime: " + localDateTime);

		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = dateTimeFormatter.format(LocalDate.now());
		System.out.println("日期转字符串: " + dateString);

		// Date和Instant互相转换
		Date date = Date.from(Instant.now());
		Instant instant = date.toInstant();

		// Date转换为LocalDateTime
		// localDateTime = LocalDateTime.from(temporal)
		// System.out.println(localDateTime);

		// LocalDateTime转Date

		Date lcocalDateTimeToDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(lcocalDateTimeToDate);

		// LocalDate转Date
		Date localDateToDate = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(localDateToDate);

	}

}
