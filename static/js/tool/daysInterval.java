/**
	 * 日期间隔天数
	 * @param startDateStr
	 * @param endDateStr
	 * @return (int)daysInterval
	 */
	public static int daysInterval(String startDateStr, String endDateStr) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long daysInterval = 0;
		try { 
			Date startDate = sdf.parse(startDateStr);
			Date endDate = sdf.parse(endDateStr);
			daysInterval = (endDate.getTime() - startDate.getTime()) / (24 *60 *60 *1000); 
		} catch (Exception e) { 
		    System.out.println(e.getMessage()); 
		} 
		return (int)daysInterval;
	}
