package com.shank.poc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class will list for each Company year and month in which the share price was highest.
 * 
 * @author Shankar_Keshri
 * 
 */
public class HighestShare {

	public static void main(String[] args) {
		try {
			new HighestShare().processShare(new File(HighestShare.class.getResource("Test_GL.csv").toURI()));
		} catch (Exception exception) {
			System.out.println("Some Exception Occured : " + exception.getMessage());
		}
	}

	/**
	 * This method will process the csv with all the logic
	 * 
	 * @param file
	 * @throws Exception
	 */
	public ShareData[] processShare(final File file) throws Exception {
		ShareData[] companyShares = null;
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String line = null;
		String data[] = null;
		try {
			String header = reader.readLine();
			data = header.split(",");
			if (data == null || data.length <= 2) {
				closeFile(reader);
				throw new Exception("Invalid header, no company record found");
			}
			companyShares = new ShareData[data.length - 2];
			for (int i = 0; i < data.length - 2; i++) {
				companyShares[i] = new ShareData();
				companyShares[i].setCompanyName(data[i + 2]);
			}
			while (null != (line = reader.readLine())) {
				processRecord(line, companyShares);
			}
			printRecords(companyShares);
		} catch (IOException ioException) {
			throw ioException;
		} catch (Exception exception) {
			throw exception;
		}
		closeFile(reader);
		return companyShares;
	}

	/**
	 * This method will close the reader object
	 * 
	 * @param reader
	 */
	private void closeFile(BufferedReader reader) {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will pring the records
	 * 
	 * @param shareDatas
	 */
	private void printRecords(ShareData[] shareDatas) {
		for (int i = 0; i < shareDatas.length; i++) {
			System.out.println("Name: " + shareDatas[i].getCompanyName());
			System.out.println("year: " + shareDatas[i].getYear());
			System.out.println("Month: " + shareDatas[i].getMonth());
			System.out.println("Share: " + shareDatas[i].getShare());
		}
	}

	/**
	 * This method will process the single record and assign the higher value into it
	 * 
	 * @param line
	 * @param shareDatas
	 */
	private void processRecord(final String line, final ShareData[] shareDatas) {
		String[] data = line.split(",");
		String year = data[0];
		String month = data[1];
		for (int i = 2; i < data.length; i++) {
			Double share = Double.parseDouble(data[i]);
			ShareData shareData = shareDatas[i - 2];
			if (shareData.getShare() == null) {
				shareData.setYear(year);
				shareData.setMonth(month);
				shareData.setShare(share);
			} else if (shareData.getShare() < share) {
				shareData.setYear(year);
				shareData.setMonth(month);
				shareData.setShare(share);
			}
		}
	}
}
