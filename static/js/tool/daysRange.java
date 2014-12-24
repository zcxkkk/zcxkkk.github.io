/**
	 * 日期间隔天数
	 * @param startDateStr
	 * @param endDateStr
	 * @return (int)daysRange
	 */
	public static int daysRange(String startDateStr, String endDateStr) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long daysRange = 0;
		try { 
			Date startDate = sdf.parse(startDateStr);
			Date endDate = sdf.parse(endDateStr);
			daysRange = (endDate.getTime() - startDate.getTime()) / (24 *60 *60 *1000); 
		} catch (Exception e) { 
		    System.out.println(e.getMessage()); 
		} 
		return (int)daysRange;
	}
