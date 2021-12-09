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

package com.liferay.pair.registration.service.persistence.impl;

import com.liferay.pair.registration.exception.NoSuchRegistrationTrackException;
import com.liferay.pair.registration.model.RegistrationTrack;
import com.liferay.pair.registration.model.RegistrationTrackTable;
import com.liferay.pair.registration.model.impl.RegistrationTrackImpl;
import com.liferay.pair.registration.model.impl.RegistrationTrackModelImpl;
import com.liferay.pair.registration.service.persistence.RegistrationTrackPersistence;
import com.liferay.pair.registration.service.persistence.impl.constants.AcmePersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the registration track service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {RegistrationTrackPersistence.class, BasePersistence.class}
)
public class RegistrationTrackPersistenceImpl
	extends BasePersistenceImpl<RegistrationTrack>
	implements RegistrationTrackPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RegistrationTrackUtil</code> to access the registration track persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RegistrationTrackImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the registration tracks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching registration tracks
	 */
	@Override
	public List<RegistrationTrack> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration tracks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationTrackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration tracks
	 * @param end the upper bound of the range of registration tracks (not inclusive)
	 * @return the range of matching registration tracks
	 */
	@Override
	public List<RegistrationTrack> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration tracks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationTrackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration tracks
	 * @param end the upper bound of the range of registration tracks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration tracks
	 */
	@Override
	public List<RegistrationTrack> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<RegistrationTrack> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration tracks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationTrackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration tracks
	 * @param end the upper bound of the range of registration tracks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration tracks
	 */
	@Override
	public List<RegistrationTrack> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<RegistrationTrack> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<RegistrationTrack> list = null;

		if (useFinderCache) {
			list = (List<RegistrationTrack>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (RegistrationTrack registrationTrack : list) {
					if (groupId != registrationTrack.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_REGISTRATIONTRACK_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RegistrationTrackModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<RegistrationTrack>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first registration track in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration track
	 * @throws NoSuchRegistrationTrackException if a matching registration track could not be found
	 */
	@Override
	public RegistrationTrack findByGroupId_First(
			long groupId,
			OrderByComparator<RegistrationTrack> orderByComparator)
		throws NoSuchRegistrationTrackException {

		RegistrationTrack registrationTrack = fetchByGroupId_First(
			groupId, orderByComparator);

		if (registrationTrack != null) {
			return registrationTrack;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchRegistrationTrackException(sb.toString());
	}

	/**
	 * Returns the first registration track in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration track, or <code>null</code> if a matching registration track could not be found
	 */
	@Override
	public RegistrationTrack fetchByGroupId_First(
		long groupId, OrderByComparator<RegistrationTrack> orderByComparator) {

		List<RegistrationTrack> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last registration track in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration track
	 * @throws NoSuchRegistrationTrackException if a matching registration track could not be found
	 */
	@Override
	public RegistrationTrack findByGroupId_Last(
			long groupId,
			OrderByComparator<RegistrationTrack> orderByComparator)
		throws NoSuchRegistrationTrackException {

		RegistrationTrack registrationTrack = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (registrationTrack != null) {
			return registrationTrack;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchRegistrationTrackException(sb.toString());
	}

	/**
	 * Returns the last registration track in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration track, or <code>null</code> if a matching registration track could not be found
	 */
	@Override
	public RegistrationTrack fetchByGroupId_Last(
		long groupId, OrderByComparator<RegistrationTrack> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<RegistrationTrack> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the registration tracks before and after the current registration track in the ordered set where groupId = &#63;.
	 *
	 * @param registrationTrackId the primary key of the current registration track
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration track
	 * @throws NoSuchRegistrationTrackException if a registration track with the primary key could not be found
	 */
	@Override
	public RegistrationTrack[] findByGroupId_PrevAndNext(
			long registrationTrackId, long groupId,
			OrderByComparator<RegistrationTrack> orderByComparator)
		throws NoSuchRegistrationTrackException {

		RegistrationTrack registrationTrack = findByPrimaryKey(
			registrationTrackId);

		Session session = null;

		try {
			session = openSession();

			RegistrationTrack[] array = new RegistrationTrackImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, registrationTrack, groupId, orderByComparator, true);

			array[1] = registrationTrack;

			array[2] = getByGroupId_PrevAndNext(
				session, registrationTrack, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegistrationTrack getByGroupId_PrevAndNext(
		Session session, RegistrationTrack registrationTrack, long groupId,
		OrderByComparator<RegistrationTrack> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REGISTRATIONTRACK_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RegistrationTrackModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						registrationTrack)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationTrack> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the registration tracks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching registration tracks that the user has permission to view
	 */
	@Override
	public List<RegistrationTrack> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration tracks that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationTrackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration tracks
	 * @param end the upper bound of the range of registration tracks (not inclusive)
	 * @return the range of matching registration tracks that the user has permission to view
	 */
	@Override
	public List<RegistrationTrack> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration tracks that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationTrackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration tracks
	 * @param end the upper bound of the range of registration tracks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration tracks that the user has permission to view
	 */
	@Override
	public List<RegistrationTrack> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<RegistrationTrack> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_REGISTRATIONTRACK_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONTRACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONTRACK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(RegistrationTrackModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(RegistrationTrackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), RegistrationTrack.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, RegistrationTrackImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, RegistrationTrackImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<RegistrationTrack>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the registration tracks before and after the current registration track in the ordered set of registration tracks that the user has permission to view where groupId = &#63;.
	 *
	 * @param registrationTrackId the primary key of the current registration track
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration track
	 * @throws NoSuchRegistrationTrackException if a registration track with the primary key could not be found
	 */
	@Override
	public RegistrationTrack[] filterFindByGroupId_PrevAndNext(
			long registrationTrackId, long groupId,
			OrderByComparator<RegistrationTrack> orderByComparator)
		throws NoSuchRegistrationTrackException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				registrationTrackId, groupId, orderByComparator);
		}

		RegistrationTrack registrationTrack = findByPrimaryKey(
			registrationTrackId);

		Session session = null;

		try {
			session = openSession();

			RegistrationTrack[] array = new RegistrationTrackImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, registrationTrack, groupId, orderByComparator, true);

			array[1] = registrationTrack;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, registrationTrack, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RegistrationTrack filterGetByGroupId_PrevAndNext(
		Session session, RegistrationTrack registrationTrack, long groupId,
		OrderByComparator<RegistrationTrack> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_REGISTRATIONTRACK_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONTRACK_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_REGISTRATIONTRACK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(RegistrationTrackModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(RegistrationTrackModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), RegistrationTrack.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, RegistrationTrackImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, RegistrationTrackImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						registrationTrack)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RegistrationTrack> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the registration tracks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (RegistrationTrack registrationTrack :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(registrationTrack);
		}
	}

	/**
	 * Returns the number of registration tracks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching registration tracks
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REGISTRATIONTRACK_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of registration tracks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching registration tracks that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_REGISTRATIONTRACK_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), RegistrationTrack.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"registrationTrack.groupId = ?";

	public RegistrationTrackPersistenceImpl() {
		setModelClass(RegistrationTrack.class);

		setModelImplClass(RegistrationTrackImpl.class);
		setModelPKClass(long.class);

		setTable(RegistrationTrackTable.INSTANCE);
	}

	/**
	 * Caches the registration track in the entity cache if it is enabled.
	 *
	 * @param registrationTrack the registration track
	 */
	@Override
	public void cacheResult(RegistrationTrack registrationTrack) {
		entityCache.putResult(
			RegistrationTrackImpl.class, registrationTrack.getPrimaryKey(),
			registrationTrack);
	}

	/**
	 * Caches the registration tracks in the entity cache if it is enabled.
	 *
	 * @param registrationTracks the registration tracks
	 */
	@Override
	public void cacheResult(List<RegistrationTrack> registrationTracks) {
		for (RegistrationTrack registrationTrack : registrationTracks) {
			if (entityCache.getResult(
					RegistrationTrackImpl.class,
					registrationTrack.getPrimaryKey()) == null) {

				cacheResult(registrationTrack);
			}
		}
	}

	/**
	 * Clears the cache for all registration tracks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RegistrationTrackImpl.class);

		finderCache.clearCache(RegistrationTrackImpl.class);
	}

	/**
	 * Clears the cache for the registration track.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegistrationTrack registrationTrack) {
		entityCache.removeResult(
			RegistrationTrackImpl.class, registrationTrack);
	}

	@Override
	public void clearCache(List<RegistrationTrack> registrationTracks) {
		for (RegistrationTrack registrationTrack : registrationTracks) {
			entityCache.removeResult(
				RegistrationTrackImpl.class, registrationTrack);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RegistrationTrackImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RegistrationTrackImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new registration track with the primary key. Does not add the registration track to the database.
	 *
	 * @param registrationTrackId the primary key for the new registration track
	 * @return the new registration track
	 */
	@Override
	public RegistrationTrack create(long registrationTrackId) {
		RegistrationTrack registrationTrack = new RegistrationTrackImpl();

		registrationTrack.setNew(true);
		registrationTrack.setPrimaryKey(registrationTrackId);

		registrationTrack.setCompanyId(CompanyThreadLocal.getCompanyId());

		return registrationTrack;
	}

	/**
	 * Removes the registration track with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationTrackId the primary key of the registration track
	 * @return the registration track that was removed
	 * @throws NoSuchRegistrationTrackException if a registration track with the primary key could not be found
	 */
	@Override
	public RegistrationTrack remove(long registrationTrackId)
		throws NoSuchRegistrationTrackException {

		return remove((Serializable)registrationTrackId);
	}

	/**
	 * Removes the registration track with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the registration track
	 * @return the registration track that was removed
	 * @throws NoSuchRegistrationTrackException if a registration track with the primary key could not be found
	 */
	@Override
	public RegistrationTrack remove(Serializable primaryKey)
		throws NoSuchRegistrationTrackException {

		Session session = null;

		try {
			session = openSession();

			RegistrationTrack registrationTrack =
				(RegistrationTrack)session.get(
					RegistrationTrackImpl.class, primaryKey);

			if (registrationTrack == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegistrationTrackException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(registrationTrack);
		}
		catch (NoSuchRegistrationTrackException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected RegistrationTrack removeImpl(
		RegistrationTrack registrationTrack) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(registrationTrack)) {
				registrationTrack = (RegistrationTrack)session.get(
					RegistrationTrackImpl.class,
					registrationTrack.getPrimaryKeyObj());
			}

			if (registrationTrack != null) {
				session.delete(registrationTrack);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (registrationTrack != null) {
			clearCache(registrationTrack);
		}

		return registrationTrack;
	}

	@Override
	public RegistrationTrack updateImpl(RegistrationTrack registrationTrack) {
		boolean isNew = registrationTrack.isNew();

		if (!(registrationTrack instanceof RegistrationTrackModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(registrationTrack.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					registrationTrack);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in registrationTrack proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RegistrationTrack implementation " +
					registrationTrack.getClass());
		}

		RegistrationTrackModelImpl registrationTrackModelImpl =
			(RegistrationTrackModelImpl)registrationTrack;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (registrationTrack.getCreateDate() == null)) {
			if (serviceContext == null) {
				registrationTrack.setCreateDate(date);
			}
			else {
				registrationTrack.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!registrationTrackModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				registrationTrack.setModifiedDate(date);
			}
			else {
				registrationTrack.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(registrationTrack);
			}
			else {
				registrationTrack = (RegistrationTrack)session.merge(
					registrationTrack);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RegistrationTrackImpl.class, registrationTrackModelImpl, false,
			true);

		if (isNew) {
			registrationTrack.setNew(false);
		}

		registrationTrack.resetOriginalValues();

		return registrationTrack;
	}

	/**
	 * Returns the registration track with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the registration track
	 * @return the registration track
	 * @throws NoSuchRegistrationTrackException if a registration track with the primary key could not be found
	 */
	@Override
	public RegistrationTrack findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegistrationTrackException {

		RegistrationTrack registrationTrack = fetchByPrimaryKey(primaryKey);

		if (registrationTrack == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegistrationTrackException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return registrationTrack;
	}

	/**
	 * Returns the registration track with the primary key or throws a <code>NoSuchRegistrationTrackException</code> if it could not be found.
	 *
	 * @param registrationTrackId the primary key of the registration track
	 * @return the registration track
	 * @throws NoSuchRegistrationTrackException if a registration track with the primary key could not be found
	 */
	@Override
	public RegistrationTrack findByPrimaryKey(long registrationTrackId)
		throws NoSuchRegistrationTrackException {

		return findByPrimaryKey((Serializable)registrationTrackId);
	}

	/**
	 * Returns the registration track with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationTrackId the primary key of the registration track
	 * @return the registration track, or <code>null</code> if a registration track with the primary key could not be found
	 */
	@Override
	public RegistrationTrack fetchByPrimaryKey(long registrationTrackId) {
		return fetchByPrimaryKey((Serializable)registrationTrackId);
	}

	/**
	 * Returns all the registration tracks.
	 *
	 * @return the registration tracks
	 */
	@Override
	public List<RegistrationTrack> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the registration tracks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationTrackModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration tracks
	 * @param end the upper bound of the range of registration tracks (not inclusive)
	 * @return the range of registration tracks
	 */
	@Override
	public List<RegistrationTrack> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the registration tracks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationTrackModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration tracks
	 * @param end the upper bound of the range of registration tracks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of registration tracks
	 */
	@Override
	public List<RegistrationTrack> findAll(
		int start, int end,
		OrderByComparator<RegistrationTrack> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the registration tracks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationTrackModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration tracks
	 * @param end the upper bound of the range of registration tracks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of registration tracks
	 */
	@Override
	public List<RegistrationTrack> findAll(
		int start, int end,
		OrderByComparator<RegistrationTrack> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<RegistrationTrack> list = null;

		if (useFinderCache) {
			list = (List<RegistrationTrack>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REGISTRATIONTRACK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REGISTRATIONTRACK;

				sql = sql.concat(RegistrationTrackModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RegistrationTrack>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the registration tracks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RegistrationTrack registrationTrack : findAll()) {
			remove(registrationTrack);
		}
	}

	/**
	 * Returns the number of registration tracks.
	 *
	 * @return the number of registration tracks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REGISTRATIONTRACK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "registrationTrackId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REGISTRATIONTRACK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RegistrationTrackModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the registration track persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new RegistrationTrackModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(RegistrationTrackImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = AcmePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AcmePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AcmePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_REGISTRATIONTRACK =
		"SELECT registrationTrack FROM RegistrationTrack registrationTrack";

	private static final String _SQL_SELECT_REGISTRATIONTRACK_WHERE =
		"SELECT registrationTrack FROM RegistrationTrack registrationTrack WHERE ";

	private static final String _SQL_COUNT_REGISTRATIONTRACK =
		"SELECT COUNT(registrationTrack) FROM RegistrationTrack registrationTrack";

	private static final String _SQL_COUNT_REGISTRATIONTRACK_WHERE =
		"SELECT COUNT(registrationTrack) FROM RegistrationTrack registrationTrack WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"registrationTrack.registrationTrackId";

	private static final String _FILTER_SQL_SELECT_REGISTRATIONTRACK_WHERE =
		"SELECT DISTINCT {registrationTrack.*} FROM Acme_RegistrationTrack registrationTrack WHERE ";

	private static final String
		_FILTER_SQL_SELECT_REGISTRATIONTRACK_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {Acme_RegistrationTrack.*} FROM (SELECT DISTINCT registrationTrack.registrationTrackId FROM Acme_RegistrationTrack registrationTrack WHERE ";

	private static final String
		_FILTER_SQL_SELECT_REGISTRATIONTRACK_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN Acme_RegistrationTrack ON TEMP_TABLE.registrationTrackId = Acme_RegistrationTrack.registrationTrackId";

	private static final String _FILTER_SQL_COUNT_REGISTRATIONTRACK_WHERE =
		"SELECT COUNT(DISTINCT registrationTrack.registrationTrackId) AS COUNT_VALUE FROM Acme_RegistrationTrack registrationTrack WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "registrationTrack";

	private static final String _FILTER_ENTITY_TABLE = "Acme_RegistrationTrack";

	private static final String _ORDER_BY_ENTITY_ALIAS = "registrationTrack.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"Acme_RegistrationTrack.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RegistrationTrack exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RegistrationTrack exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RegistrationTrackPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class RegistrationTrackModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			RegistrationTrackModelImpl registrationTrackModelImpl =
				(RegistrationTrackModelImpl)baseModel;

			long columnBitmask = registrationTrackModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					registrationTrackModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						registrationTrackModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					registrationTrackModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return RegistrationTrackImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return RegistrationTrackTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			RegistrationTrackModelImpl registrationTrackModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						registrationTrackModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = registrationTrackModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}