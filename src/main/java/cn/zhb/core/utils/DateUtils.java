package cn.zhb.core.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {
	public DateTimeFormatter longDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
	
	public String getNowDate() {
		return dateFormatter.format(LocalDateTime.now());
	}
	public String getLongNowDate() {
		return longDateFormatter.format(LocalDateTime.now());
	}
	
	public int getNowYear() {
		return LocalDate.now().getYear();
	}
	
}
