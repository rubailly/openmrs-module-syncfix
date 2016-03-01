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
package org.openmrs.module.syncfix.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.openmrs.EncounterType;
import org.openmrs.module.sync.SyncItem;
import org.openmrs.module.sync.SyncItemKey;
import org.openmrs.module.sync.SyncItemState;
import org.openmrs.module.sync.SyncRecord;
import org.openmrs.module.sync.SyncRecordState;
import org.openmrs.util.OpenmrsConstants;

/**
 * Tests {@link $ SyncFixService} .
 */
public class SyncFixServiceTest {
	
	@Test
	public void shouldSetupContext() throws IOException {

		SyncRecord record = createValidSyncRecord();
		Collection<SyncItem> items = record.getItems();
		for (SyncItem syncItem : items) {
	        System.out.println(syncItem.getContent());
        }

	}
	
	protected SyncRecord createValidSyncRecord() {
		SyncRecord record = new SyncRecord();
		record.setUuid(UUID.randomUUID().toString());
		record.setOriginalUuid(UUID.randomUUID().toString());
		record.setState(SyncRecordState.NEW);
		record.setDatabaseVersion(OpenmrsConstants.OPENMRS_VERSION_SHORT);
		record.setRetryCount(0);
		record.setTimestamp(new Date());

		SyncItem item = new SyncItem();
		item.setContainedType(EncounterType.class);
		item.setKey(new SyncItemKey<String>(UUID.randomUUID().toString(), String.class));
		item.setContent("<items><SyncItem containedType=\"org.openmrs.Patient\" key=\"7f0b11f7-85fe-4636-aea5-c2a10308de0c\" state=\"UPDATED\"><content><![CDATA[<org.openmrs.Patient><personCreator type=\"org.openmrs.User\">70e182bd-b842-432e-b2d9-b99e84199a88</personCreator><birthdateEstimated type=\"boolean\">false</birthdateEstimated><personDateChanged type=\"timestamp\">2015-12-02T09:32:19.047+0200</personDateChanged><personVoided type=\"boolean\">false</personVoided><dateChanged type=\"timestamp\">2016-03-01T12:37:27.490+0200</dateChanged><creator type=\"org.openmrs.User\">70e182bd-b842-432e-b2d9-b99e84199a88</creator><changedBy type=\"org.openmrs.User\">5c6ca217-7398-4841-babc-756075e83ae8</changedBy><personChangedBy type=\"org.openmrs.User\">70e182bd-b842-432e-b2d9-b99e84199a88</personChangedBy><patient type=\"boolean\">true</patient><personDateCreated type=\"timestamp\">2015-05-21T10:54:01.000+0200</personDateCreated><voided type=\"boolean\">false</voided><birthdate type=\"timestamp\">1971-01-01T00:00:00.000+0200</birthdate><dateCreated type=\"timestamp\">2015-05-21T10:54:01.000+0200</dateCreated><gender type=\"string\">M</gender><uuid type=\"string\">7f0b11f7-85fe-4636-aea5-c2a10308de0c</uuid><dead type=\"boolean\">false</dead></org.openmrs.Patient>]]></content></SyncItem><SyncItem containedType=\"org.openmrs.PatientIdentifier\" key=\"3f6e7fdc-060b-4d18-abcd-78d7e20eb779\" state=\"UPDATED\"><content><![CDATA[<org.openmrs.PatientIdentifier><location type=\"org.openmrs.Location\">a2e19a9a-26fe-102b-80cb-0017a47871b2</location><dateVoided type=\"timestamp\">2015-12-02T09:32:19.047+0200</dateVoided><preferred type=\"boolean\">false</preferred><dateChanged type=\"timestamp\">2016-03-01T12:37:27.600+0200</dateChanged><creator type=\"org.openmrs.User\">615ce437-7784-4a74-9bce-acfbba308947</creator><changedBy type=\"org.openmrs.User\">5c6ca217-7398-4841-babc-756075e83ae8</changedBy><voidedBy type=\"org.openmrs.User\">70e182bd-b842-432e-b2d9-b99e84199a88</voidedBy><patient type=\"org.openmrs.Patient\">7f0b11f7-85fe-4636-aea5-c2a10308de0c</patient><voided type=\"boolean\">true</voided><dateCreated type=\"timestamp\">2015-08-14T10:53:42.000+0200</dateCreated><uuid type=\"string\">3f6e7fdc-060b-4d18-abcd-78d7e20eb779</uuid><identifier type=\"string\">41003182-c</identifier><identifierType type=\"org.openmrs.PatientIdentifierType\">c147ae5a-2700-102b-80cb-0017a47871b2</identifierType><voidReason type=\"string\"></voidReason></org.openmrs.PatientIdentifier>]]></content></SyncItem></items>");
		item.setState(SyncItemState.NEW);
		record.addItem(item);

		return record;
	}
}
