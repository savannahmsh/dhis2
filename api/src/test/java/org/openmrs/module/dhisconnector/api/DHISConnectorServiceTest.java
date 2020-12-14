package org.openmrs.module.dhisconnector.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.test.BaseModuleContextSensitiveTest;

/**
 * Created by k-joseph on 04/07/2017.
 */
public class DHISConnectorServiceTest extends BaseModuleContextSensitiveTest {
	
	
	@Test
	public void testServiceInit() {
		Assert.assertNotNull(Context.getService(DHISConnectorService.class));
	}
	
	@Test
	public void testReportToDataSetMappingService() {
		Assert.assertEquals(0, Context.getService(DHISConnectorService.class).getAllReportToDataSetMappings().size());
	}
	
	@Test
	public void transformToDHISPeriod() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//month is 0based index
		Calendar startDate = new GregorianCalendar(2017, 11, 01);
		Calendar endDate = new GregorianCalendar(2017, 11, 01);
		String period = "";
		
		//test daily, date now at 2017/dec/01
		period = Context.getService(DHISConnectorService.class).transformToDHISPeriod(startDate, endDate, "Daily", null);
		Assert.assertEquals("20171130", sdf.format(startDate.getTime()));
		Assert.assertEquals("20171130", sdf.format(endDate.getTime()));
		Assert.assertEquals(period, "20171130");
		
		//test weekly, date now at 2017/nov/30
		period = Context.getService(DHISConnectorService.class).transformToDHISPeriod(startDate, endDate, "Weekly", null);
		Assert.assertEquals("20171119", sdf.format(startDate.getTime()));
		Assert.assertEquals("20171125", sdf.format(endDate.getTime()));
		Assert.assertEquals(period, "2017W47");
		
		//test monthly, date now at 2017/nov/25
		period = Context.getService(DHISConnectorService.class).transformToDHISPeriod(startDate, endDate, "Monthly", null);
		Assert.assertEquals("20171001", sdf.format(startDate.getTime()));
		Assert.assertEquals("20171031", sdf.format(endDate.getTime()));
		Assert.assertEquals(period, "201710");
		
		//test daily with lastRun, date now at 2017/oct/31
		startDate = (Calendar) endDate.clone();
		period = Context.getService(DHISConnectorService.class).transformToDHISPeriod(startDate, endDate, "Daily",
		    new GregorianCalendar(2017, 9, 30).getTime());
		Assert.assertEquals("20171030", sdf.format(startDate.getTime()));
		Assert.assertEquals("20171030", sdf.format(endDate.getTime()));
		Assert.assertNull(period);
		
		//test weekly with lastRun, date now at 2017/oct/30
		startDate = (Calendar) endDate.clone();
		period = Context.getService(DHISConnectorService.class).transformToDHISPeriod(startDate, endDate, "Weekly",
		    new GregorianCalendar(2017, 9, 24).getTime());
		Assert.assertEquals("20171022", sdf.format(startDate.getTime()));
		Assert.assertEquals("20171028", sdf.format(endDate.getTime()));
		Assert.assertNull(period);
		
		//test monthly with lastRun, date now at 2017/oct/07
		startDate = (Calendar) endDate.clone();
		period = Context.getService(DHISConnectorService.class).transformToDHISPeriod(startDate, endDate, "Monthly",
		    new GregorianCalendar(2017, 8, 28).getTime());
		Assert.assertEquals("20170901", sdf.format(startDate.getTime()));
		Assert.assertEquals("20170930", sdf.format(endDate.getTime()));
		Assert.assertNull(period);
	}
}
