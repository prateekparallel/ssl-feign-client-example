package com.jpa.transaction.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jpa.transaction.util.GRTranUtil;

public class GrTranUtilTest {

	/*@Test
	public void shouldAddRepoDetail_Into_Database() {
		assertTrue(GRTranUtil.addRepoDetail("http://jrt017.gov.in:5600/windows", 'Y', 'Y'));
	}*/
	
	
	
	@Test
	public void shouldAddGlobalRepo_Into_Database() {
		assertTrue(GRTranUtil.addGlobalRepo("Dibrugarh","http://dib001.gov.in:5600/windows", 'Y', 'Y'));
	}

}
