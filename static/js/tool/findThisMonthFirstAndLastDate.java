/**
  *
  *
  *@return MAP 
  *{thisMonthFirstDate:当月的第一天}
  *{thisMonthLastDate:当月的最后一天}
	*/

private static Map findThisMonthFirstAndLastDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前月第一天
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		// 获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		Map map = new HashMap();
		map.put("thisMonthFirstDate", first);
		map.put("thisMonthLastDate", last);
		return map;
		}
