package com.shank.poc;

/**
 * This class is the simple pojo to contain the shara related data with company name
 * 
 * @author Shankar_Keshri
 */
public class ShareData {

	private String companyName;
	private Double share;
	private String year;
	private String month;

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the share
	 */
	public Double getShare() {
		return share;
	}

	/**
	 * @param share
	 *            the share to set
	 */
	public void setShare(Double share) {
		this.share = share;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

}
