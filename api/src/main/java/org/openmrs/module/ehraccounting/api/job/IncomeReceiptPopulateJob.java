/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */


package org.openmrs.module.ehraccounting.api.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.ehraccounting.api.EhraccountingService;
import org.openmrs.module.ehraccounting.api.utils.DateUtils;
import org.openmrs.scheduler.tasks.AbstractTask;

import java.util.Calendar;
import java.util.Date;

public class IncomeReceiptPopulateJob extends AbstractTask {
	Log log = LogFactory.getLog(getClass());
	@Override
	public void execute() {
		log.info("**********Excute IncomeReceiptPopulateJob****************");
		try {
			Context.openSession();
			/*if (!Context.isAuthenticated()) 
			{
				authenticate();
			}*/
			// do something
			
			
			EhraccountingService accountService = Context.getService(EhraccountingService.class);
			//Date curDate = DateUtils.getDateFromStr("12/3/2014");
			Date curDate = Calendar.getInstance().getTime();
			curDate = DateUtils.getDatePart(curDate);
			accountService.aggregateIncomeReceipt(curDate);
			
			Context.closeSession();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}
		log.info("**********Finished Excute IncomeReceiptPopulateJob****************");
	}
	
	@Override
	protected void authenticate() {
		// TODO Auto-generated method stub
		super.authenticate();
	}

	@Override
	public void shutdown() {
		log.info("Shutdown IncomeReceiptPopulateJob");
		super.shutdown();
	}

}
