/**
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
package org.openmrs.module.syncfix.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.syncfix.api.SyncFixService;
import org.openmrs.module.syncfix.api.db.SyncFixDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * It is a default implementation of {@link SyncFixService}.
 */
@Component
public class SyncFixServiceImpl extends BaseOpenmrsService implements SyncFixService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	@Autowired
	private SyncFixDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(SyncFixDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public SyncFixDAO getDao() {
	    return dao;
    }
}