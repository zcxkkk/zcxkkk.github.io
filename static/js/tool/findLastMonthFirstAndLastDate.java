/**
	 * 得到上个月的第一和最后一天带时间
	 * 
	 * @return MAP 
	 * {lastMonthFirstDate:当前日期上个月的第一天} 
	 * {lastMonthLastDate:当前日期上个月的最后一天}
	 */
	private static Map findLastMonthFirstAndLastDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, -1);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String lastMonthFirstDate = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(lastMonthFirstDate);
		lastMonthFirstDate = str.toString();

		calendar.add(cal.MONTH, 1);
		calendar.set(cal.DATE, 1);
		calendar.add(cal.DATE, -1);
		String lastMonthLastDate = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(lastMonthLastDate);
		lastMonthLastDate = endStr.toString();

		Map map = new HashMap();
		map.put("lastMonthFirstDate", lastMonthFirstDate);
		map.put("lastMonthLastDate", lastMonthLastDate);
		return map;
	}
