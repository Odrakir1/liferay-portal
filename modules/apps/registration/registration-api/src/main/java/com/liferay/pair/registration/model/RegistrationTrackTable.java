/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.pair.registration.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Acme_RegistrationTrack&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationTrack
 * @generated
 */
public class RegistrationTrackTable extends BaseTable<RegistrationTrackTable> {

	public static final RegistrationTrackTable INSTANCE =
		new RegistrationTrackTable();

	public final Column<RegistrationTrackTable, Long> registrationTrackId =
		createColumn(
			"registrationTrackId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<RegistrationTrackTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationTrackTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationTrackTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegistrationTrackTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RegistrationTrackTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RegistrationTrackTable, Date> eventDatetime =
		createColumn(
			"eventDatetime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RegistrationTrackTable, String> screenName =
		createColumn(
			"screenName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTrackTable, String> iPAdress = createColumn(
		"iPAdress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegistrationTrackTable, String> eventType =
		createColumn(
			"eventType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RegistrationTrackTable() {
		super("Acme_RegistrationTrack", RegistrationTrackTable::new);
	}

}