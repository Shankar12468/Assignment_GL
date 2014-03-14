/**
 * 
 */
package com.shank.poc;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class is a unit test for Highest Share
 * 
 * @author Shankar_Keshri
 * 
 */
public class HighestShareTest {

	final HighestShare maxShare = new HighestShare();

	/**
	 * Happy Path. Test method for {@link com.shank.poc.HighestShare#processShare(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testProcessShare() throws Exception {
		ShareData[] shareDatas = maxShare.processShare(new File(HighestShare.class.getResource("Test_GL.csv").toURI()));
		Assert.assertNotNull("processed data is null", shareDatas);
		Assert.assertEquals("Highest share value of first company is not 80.0", shareDatas[0].getShare(), new Double(80.0));
		Assert.assertEquals("First company having highest share value for the Year is not 1990", shareDatas[0].getYear(), "1990");
		Assert.assertEquals("First company having highest share value for the Month is not Jan", shareDatas[0].getMonth(), "Jan");
	}

	/**
	 * This case throw exception when file not found. Test method for {@link com.shank.poc.HighestShare#processShare(java.lang.String)}. * @throws Exception
	 * 
	 * @throws Exception
	 */
	@Test(expected = FileNotFoundException.class)
	public void testProcessShareFileNotFound() throws Exception {
		maxShare.processShare(new File("FILE_NOT_FOUND.csv"));
	}

	/**
	 * When header is invalid. Test method for {@link com.shank.poc.HighestShare#processShare(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testProcessShareInvalidData() throws Exception {
		maxShare.processShare(new File(HighestShare.class.getResource("TEST_GL_INVALID_HEADER.csv").toURI()));
	}

	/**
	 * When no data in file. Test method for {@link com.shank.poc.HighestShare#processShare(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testProcessShareEmptyFile() throws Exception {
		maxShare.processShare(new File(HighestShare.class.getResource("TEST_GL_EMPTY_FILE.csv").toURI()));
	}
}
