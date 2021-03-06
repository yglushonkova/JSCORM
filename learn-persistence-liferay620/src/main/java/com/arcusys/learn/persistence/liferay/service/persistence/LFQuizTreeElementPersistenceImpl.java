package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException;
import com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizTreeElementPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the l f quiz tree element service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizTreeElementPersistence
 * @see LFQuizTreeElementUtil
 * @generated
 */
public class LFQuizTreeElementPersistenceImpl extends BasePersistenceImpl<LFQuizTreeElement>
    implements LFQuizTreeElementPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFQuizTreeElementUtil} to access the l f quiz tree element persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFQuizTreeElementImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementModelImpl.FINDER_CACHE_ENABLED,
            LFQuizTreeElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementModelImpl.FINDER_CACHE_ENABLED,
            LFQuizTreeElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZID = new FinderPath(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementModelImpl.FINDER_CACHE_ENABLED,
            LFQuizTreeElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuizID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID =
        new FinderPath(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementModelImpl.FINDER_CACHE_ENABLED,
            LFQuizTreeElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuizID",
            new String[] { Integer.class.getName() },
            LFQuizTreeElementModelImpl.QUIZID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_QUIZID = new FinderPath(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuizID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_NULL = "lfQuizTreeElement.quizID IS NULL";
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_2 = "lfQuizTreeElement.quizID = ?";
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_NULL_2 = "lfQuizTreeElement.quizID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_QUIZANDELEMENTID = new FinderPath(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementModelImpl.FINDER_CACHE_ENABLED,
            LFQuizTreeElementImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByQuizAndElementID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFQuizTreeElementModelImpl.QUIZID_COLUMN_BITMASK |
            LFQuizTreeElementModelImpl.ELEMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_QUIZANDELEMENTID = new FinderPath(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByQuizAndElementID",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_QUIZANDELEMENTID_QUIZID_NULL = "lfQuizTreeElement.quizID IS NULL";
    private static final String _FINDER_COLUMN_QUIZANDELEMENTID_QUIZID_2 = "lfQuizTreeElement.quizID = ? AND ";
    private static final String _FINDER_COLUMN_QUIZANDELEMENTID_QUIZID_NULL_2 = "lfQuizTreeElement.quizID IS NULL  AND ";
    private static final String _FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_1 = "lfQuizTreeElement.elementID IS NULL";
    private static final String _FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_NULL = "lfQuizTreeElement.elementID IS NULL";
    private static final String _FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_2 = "lfQuizTreeElement.elementID = ?";
    private static final String _FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_NULL_2 =
        "lfQuizTreeElement.elementID IS NULL ";
    private static final String _FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_3 = "(lfQuizTreeElement.elementID IS NULL OR lfQuizTreeElement.elementID = '')";
    private static final String _SQL_SELECT_LFQUIZTREEELEMENT = "SELECT lfQuizTreeElement FROM LFQuizTreeElement lfQuizTreeElement";
    private static final String _SQL_SELECT_LFQUIZTREEELEMENT_WHERE = "SELECT lfQuizTreeElement FROM LFQuizTreeElement lfQuizTreeElement WHERE ";
    private static final String _SQL_COUNT_LFQUIZTREEELEMENT = "SELECT COUNT(lfQuizTreeElement) FROM LFQuizTreeElement lfQuizTreeElement";
    private static final String _SQL_COUNT_LFQUIZTREEELEMENT_WHERE = "SELECT COUNT(lfQuizTreeElement) FROM LFQuizTreeElement lfQuizTreeElement WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfQuizTreeElement.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFQuizTreeElement exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFQuizTreeElement exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFQuizTreeElementPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFQuizTreeElement _nullLFQuizTreeElement = new LFQuizTreeElementImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFQuizTreeElement> toCacheModel() {
                return _nullLFQuizTreeElementCacheModel;
            }
        };

    private static CacheModel<LFQuizTreeElement> _nullLFQuizTreeElementCacheModel =
        new CacheModel<LFQuizTreeElement>() {
            @Override
            public LFQuizTreeElement toEntityModel() {
                return _nullLFQuizTreeElement;
            }
        };

    public LFQuizTreeElementPersistenceImpl() {
        setModelClass(LFQuizTreeElement.class);
    }

    /**
     * Returns all the l f quiz tree elements where quizID = &#63;.
     *
     * @param quizID the quiz i d
     * @return the matching l f quiz tree elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizTreeElement> findByQuizID(Integer quizID)
        throws SystemException {
        return findByQuizID(quizID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz tree elements where quizID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizID the quiz i d
     * @param start the lower bound of the range of l f quiz tree elements
     * @param end the upper bound of the range of l f quiz tree elements (not inclusive)
     * @return the range of matching l f quiz tree elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizTreeElement> findByQuizID(Integer quizID, int start,
        int end) throws SystemException {
        return findByQuizID(quizID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz tree elements where quizID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizID the quiz i d
     * @param start the lower bound of the range of l f quiz tree elements
     * @param end the upper bound of the range of l f quiz tree elements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f quiz tree elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizTreeElement> findByQuizID(Integer quizID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID;
            finderArgs = new Object[] { quizID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZID;
            finderArgs = new Object[] { quizID, start, end, orderByComparator };
        }

        List<LFQuizTreeElement> list = (List<LFQuizTreeElement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuizTreeElement lfQuizTreeElement : list) {
                if (!Validator.equals(quizID, lfQuizTreeElement.getQuizID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LFQUIZTREEELEMENT_WHERE);

            if (quizID == null) {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFQuizTreeElementModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizID != null) {
                    qPos.add(quizID.intValue());
                }

                if (!pagination) {
                    list = (List<LFQuizTreeElement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuizTreeElement>(list);
                } else {
                    list = (List<LFQuizTreeElement>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first l f quiz tree element in the ordered set where quizID = &#63;.
     *
     * @param quizID the quiz i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz tree element
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a matching l f quiz tree element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement findByQuizID_First(Integer quizID,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizTreeElementException, SystemException {
        LFQuizTreeElement lfQuizTreeElement = fetchByQuizID_First(quizID,
                orderByComparator);

        if (lfQuizTreeElement != null) {
            return lfQuizTreeElement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizID=");
        msg.append(quizID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizTreeElementException(msg.toString());
    }

    /**
     * Returns the first l f quiz tree element in the ordered set where quizID = &#63;.
     *
     * @param quizID the quiz i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz tree element, or <code>null</code> if a matching l f quiz tree element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement fetchByQuizID_First(Integer quizID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFQuizTreeElement> list = findByQuizID(quizID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f quiz tree element in the ordered set where quizID = &#63;.
     *
     * @param quizID the quiz i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz tree element
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a matching l f quiz tree element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement findByQuizID_Last(Integer quizID,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizTreeElementException, SystemException {
        LFQuizTreeElement lfQuizTreeElement = fetchByQuizID_Last(quizID,
                orderByComparator);

        if (lfQuizTreeElement != null) {
            return lfQuizTreeElement;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizID=");
        msg.append(quizID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizTreeElementException(msg.toString());
    }

    /**
     * Returns the last l f quiz tree element in the ordered set where quizID = &#63;.
     *
     * @param quizID the quiz i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz tree element, or <code>null</code> if a matching l f quiz tree element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement fetchByQuizID_Last(Integer quizID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByQuizID(quizID);

        if (count == 0) {
            return null;
        }

        List<LFQuizTreeElement> list = findByQuizID(quizID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f quiz tree elements before and after the current l f quiz tree element in the ordered set where quizID = &#63;.
     *
     * @param id the primary key of the current l f quiz tree element
     * @param quizID the quiz i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f quiz tree element
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a l f quiz tree element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement[] findByQuizID_PrevAndNext(long id,
        Integer quizID, OrderByComparator orderByComparator)
        throws NoSuchLFQuizTreeElementException, SystemException {
        LFQuizTreeElement lfQuizTreeElement = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuizTreeElement[] array = new LFQuizTreeElementImpl[3];

            array[0] = getByQuizID_PrevAndNext(session, lfQuizTreeElement,
                    quizID, orderByComparator, true);

            array[1] = lfQuizTreeElement;

            array[2] = getByQuizID_PrevAndNext(session, lfQuizTreeElement,
                    quizID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuizTreeElement getByQuizID_PrevAndNext(Session session,
        LFQuizTreeElement lfQuizTreeElement, Integer quizID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUIZTREEELEMENT_WHERE);

        if (quizID == null) {
            query.append(_FINDER_COLUMN_QUIZID_QUIZID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUIZID_QUIZID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(LFQuizTreeElementModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (quizID != null) {
            qPos.add(quizID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuizTreeElement);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuizTreeElement> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f quiz tree elements where quizID = &#63; from the database.
     *
     * @param quizID the quiz i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByQuizID(Integer quizID) throws SystemException {
        for (LFQuizTreeElement lfQuizTreeElement : findByQuizID(quizID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfQuizTreeElement);
        }
    }

    /**
     * Returns the number of l f quiz tree elements where quizID = &#63;.
     *
     * @param quizID the quiz i d
     * @return the number of matching l f quiz tree elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByQuizID(Integer quizID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_QUIZID;

        Object[] finderArgs = new Object[] { quizID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFQUIZTREEELEMENT_WHERE);

            if (quizID == null) {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizID != null) {
                    qPos.add(quizID.intValue());
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the l f quiz tree element where quizID = &#63; and elementID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException} if it could not be found.
     *
     * @param quizID the quiz i d
     * @param elementID the element i d
     * @return the matching l f quiz tree element
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a matching l f quiz tree element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement findByQuizAndElementID(Integer quizID,
        String elementID)
        throws NoSuchLFQuizTreeElementException, SystemException {
        LFQuizTreeElement lfQuizTreeElement = fetchByQuizAndElementID(quizID,
                elementID);

        if (lfQuizTreeElement == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("quizID=");
            msg.append(quizID);

            msg.append(", elementID=");
            msg.append(elementID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFQuizTreeElementException(msg.toString());
        }

        return lfQuizTreeElement;
    }

    /**
     * Returns the l f quiz tree element where quizID = &#63; and elementID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param quizID the quiz i d
     * @param elementID the element i d
     * @return the matching l f quiz tree element, or <code>null</code> if a matching l f quiz tree element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement fetchByQuizAndElementID(Integer quizID,
        String elementID) throws SystemException {
        return fetchByQuizAndElementID(quizID, elementID, true);
    }

    /**
     * Returns the l f quiz tree element where quizID = &#63; and elementID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param quizID the quiz i d
     * @param elementID the element i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f quiz tree element, or <code>null</code> if a matching l f quiz tree element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement fetchByQuizAndElementID(Integer quizID,
        String elementID, boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { quizID, elementID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_QUIZANDELEMENTID,
                    finderArgs, this);
        }

        if (result instanceof LFQuizTreeElement) {
            LFQuizTreeElement lfQuizTreeElement = (LFQuizTreeElement) result;

            if (!Validator.equals(quizID, lfQuizTreeElement.getQuizID()) ||
                    !Validator.equals(elementID,
                        lfQuizTreeElement.getElementID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFQUIZTREEELEMENT_WHERE);

            if (quizID == null) {
                query.append(_FINDER_COLUMN_QUIZANDELEMENTID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDELEMENTID_QUIZID_2);
            }

            boolean bindElementID = false;

            if (elementID == null) {
                query.append(_FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_1);
            } else if (elementID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_3);
            } else {
                bindElementID = true;

                if (elementID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizID != null) {
                    qPos.add(quizID.intValue());
                }

                if (bindElementID) {
                    if (elementID != null) {
                        qPos.add(elementID);
                    }
                }

                List<LFQuizTreeElement> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUIZANDELEMENTID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFQuizTreeElementPersistenceImpl.fetchByQuizAndElementID(Integer, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFQuizTreeElement lfQuizTreeElement = list.get(0);

                    result = lfQuizTreeElement;

                    cacheResult(lfQuizTreeElement);

                    if ((lfQuizTreeElement.getQuizID() != quizID) ||
                            (lfQuizTreeElement.getElementID() == null) ||
                            !lfQuizTreeElement.getElementID().equals(elementID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUIZANDELEMENTID,
                            finderArgs, lfQuizTreeElement);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_QUIZANDELEMENTID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFQuizTreeElement) result;
        }
    }

    /**
     * Removes the l f quiz tree element where quizID = &#63; and elementID = &#63; from the database.
     *
     * @param quizID the quiz i d
     * @param elementID the element i d
     * @return the l f quiz tree element that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement removeByQuizAndElementID(Integer quizID,
        String elementID)
        throws NoSuchLFQuizTreeElementException, SystemException {
        LFQuizTreeElement lfQuizTreeElement = findByQuizAndElementID(quizID,
                elementID);

        return remove(lfQuizTreeElement);
    }

    /**
     * Returns the number of l f quiz tree elements where quizID = &#63; and elementID = &#63;.
     *
     * @param quizID the quiz i d
     * @param elementID the element i d
     * @return the number of matching l f quiz tree elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByQuizAndElementID(Integer quizID, String elementID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_QUIZANDELEMENTID;

        Object[] finderArgs = new Object[] { quizID, elementID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFQUIZTREEELEMENT_WHERE);

            if (quizID == null) {
                query.append(_FINDER_COLUMN_QUIZANDELEMENTID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDELEMENTID_QUIZID_2);
            }

            boolean bindElementID = false;

            if (elementID == null) {
                query.append(_FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_1);
            } else if (elementID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_3);
            } else {
                bindElementID = true;

                if (elementID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_QUIZANDELEMENTID_ELEMENTID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizID != null) {
                    qPos.add(quizID.intValue());
                }

                if (bindElementID) {
                    if (elementID != null) {
                        qPos.add(elementID);
                    }
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the l f quiz tree element in the entity cache if it is enabled.
     *
     * @param lfQuizTreeElement the l f quiz tree element
     */
    @Override
    public void cacheResult(LFQuizTreeElement lfQuizTreeElement) {
        EntityCacheUtil.putResult(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementImpl.class, lfQuizTreeElement.getPrimaryKey(),
            lfQuizTreeElement);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUIZANDELEMENTID,
            new Object[] {
                lfQuizTreeElement.getQuizID(), lfQuizTreeElement.getElementID()
            }, lfQuizTreeElement);

        lfQuizTreeElement.resetOriginalValues();
    }

    /**
     * Caches the l f quiz tree elements in the entity cache if it is enabled.
     *
     * @param lfQuizTreeElements the l f quiz tree elements
     */
    @Override
    public void cacheResult(List<LFQuizTreeElement> lfQuizTreeElements) {
        for (LFQuizTreeElement lfQuizTreeElement : lfQuizTreeElements) {
            if (EntityCacheUtil.getResult(
                        LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizTreeElementImpl.class,
                        lfQuizTreeElement.getPrimaryKey()) == null) {
                cacheResult(lfQuizTreeElement);
            } else {
                lfQuizTreeElement.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f quiz tree elements.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFQuizTreeElementImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFQuizTreeElementImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f quiz tree element.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFQuizTreeElement lfQuizTreeElement) {
        EntityCacheUtil.removeResult(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementImpl.class, lfQuizTreeElement.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfQuizTreeElement);
    }

    @Override
    public void clearCache(List<LFQuizTreeElement> lfQuizTreeElements) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFQuizTreeElement lfQuizTreeElement : lfQuizTreeElements) {
            EntityCacheUtil.removeResult(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizTreeElementImpl.class, lfQuizTreeElement.getPrimaryKey());

            clearUniqueFindersCache(lfQuizTreeElement);
        }
    }

    protected void cacheUniqueFindersCache(LFQuizTreeElement lfQuizTreeElement) {
        if (lfQuizTreeElement.isNew()) {
            Object[] args = new Object[] {
                    lfQuizTreeElement.getQuizID(),
                    lfQuizTreeElement.getElementID()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUIZANDELEMENTID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUIZANDELEMENTID,
                args, lfQuizTreeElement);
        } else {
            LFQuizTreeElementModelImpl lfQuizTreeElementModelImpl = (LFQuizTreeElementModelImpl) lfQuizTreeElement;

            if ((lfQuizTreeElementModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_QUIZANDELEMENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfQuizTreeElement.getQuizID(),
                        lfQuizTreeElement.getElementID()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUIZANDELEMENTID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_QUIZANDELEMENTID,
                    args, lfQuizTreeElement);
            }
        }
    }

    protected void clearUniqueFindersCache(LFQuizTreeElement lfQuizTreeElement) {
        LFQuizTreeElementModelImpl lfQuizTreeElementModelImpl = (LFQuizTreeElementModelImpl) lfQuizTreeElement;

        Object[] args = new Object[] {
                lfQuizTreeElement.getQuizID(), lfQuizTreeElement.getElementID()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZANDELEMENTID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_QUIZANDELEMENTID, args);

        if ((lfQuizTreeElementModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_QUIZANDELEMENTID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfQuizTreeElementModelImpl.getOriginalQuizID(),
                    lfQuizTreeElementModelImpl.getOriginalElementID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZANDELEMENTID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_QUIZANDELEMENTID,
                args);
        }
    }

    /**
     * Creates a new l f quiz tree element with the primary key. Does not add the l f quiz tree element to the database.
     *
     * @param id the primary key for the new l f quiz tree element
     * @return the new l f quiz tree element
     */
    @Override
    public LFQuizTreeElement create(long id) {
        LFQuizTreeElement lfQuizTreeElement = new LFQuizTreeElementImpl();

        lfQuizTreeElement.setNew(true);
        lfQuizTreeElement.setPrimaryKey(id);

        return lfQuizTreeElement;
    }

    /**
     * Removes the l f quiz tree element with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f quiz tree element
     * @return the l f quiz tree element that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a l f quiz tree element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement remove(long id)
        throws NoSuchLFQuizTreeElementException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f quiz tree element with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f quiz tree element
     * @return the l f quiz tree element that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a l f quiz tree element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement remove(Serializable primaryKey)
        throws NoSuchLFQuizTreeElementException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFQuizTreeElement lfQuizTreeElement = (LFQuizTreeElement) session.get(LFQuizTreeElementImpl.class,
                    primaryKey);

            if (lfQuizTreeElement == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFQuizTreeElementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfQuizTreeElement);
        } catch (NoSuchLFQuizTreeElementException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFQuizTreeElement removeImpl(LFQuizTreeElement lfQuizTreeElement)
        throws SystemException {
        lfQuizTreeElement = toUnwrappedModel(lfQuizTreeElement);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfQuizTreeElement)) {
                lfQuizTreeElement = (LFQuizTreeElement) session.get(LFQuizTreeElementImpl.class,
                        lfQuizTreeElement.getPrimaryKeyObj());
            }

            if (lfQuizTreeElement != null) {
                session.delete(lfQuizTreeElement);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfQuizTreeElement != null) {
            clearCache(lfQuizTreeElement);
        }

        return lfQuizTreeElement;
    }

    @Override
    public LFQuizTreeElement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement lfQuizTreeElement)
        throws SystemException {
        lfQuizTreeElement = toUnwrappedModel(lfQuizTreeElement);

        boolean isNew = lfQuizTreeElement.isNew();

        LFQuizTreeElementModelImpl lfQuizTreeElementModelImpl = (LFQuizTreeElementModelImpl) lfQuizTreeElement;

        Session session = null;

        try {
            session = openSession();

            if (lfQuizTreeElement.isNew()) {
                session.save(lfQuizTreeElement);

                lfQuizTreeElement.setNew(false);
            } else {
                session.merge(lfQuizTreeElement);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFQuizTreeElementModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfQuizTreeElementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfQuizTreeElementModelImpl.getOriginalQuizID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID,
                    args);

                args = new Object[] { lfQuizTreeElementModelImpl.getQuizID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizTreeElementImpl.class, lfQuizTreeElement.getPrimaryKey(),
            lfQuizTreeElement);

        clearUniqueFindersCache(lfQuizTreeElement);
        cacheUniqueFindersCache(lfQuizTreeElement);

        return lfQuizTreeElement;
    }

    protected LFQuizTreeElement toUnwrappedModel(
        LFQuizTreeElement lfQuizTreeElement) {
        if (lfQuizTreeElement instanceof LFQuizTreeElementImpl) {
            return lfQuizTreeElement;
        }

        LFQuizTreeElementImpl lfQuizTreeElementImpl = new LFQuizTreeElementImpl();

        lfQuizTreeElementImpl.setNew(lfQuizTreeElement.isNew());
        lfQuizTreeElementImpl.setPrimaryKey(lfQuizTreeElement.getPrimaryKey());

        lfQuizTreeElementImpl.setId(lfQuizTreeElement.getId());
        lfQuizTreeElementImpl.setQuizID(lfQuizTreeElement.getQuizID());
        lfQuizTreeElementImpl.setElementID(lfQuizTreeElement.getElementID());
        lfQuizTreeElementImpl.setIsCategory(lfQuizTreeElement.getIsCategory());
        lfQuizTreeElementImpl.setParentID(lfQuizTreeElement.getParentID());
        lfQuizTreeElementImpl.setArrangementIndex(lfQuizTreeElement.getArrangementIndex());

        return lfQuizTreeElementImpl;
    }

    /**
     * Returns the l f quiz tree element with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz tree element
     * @return the l f quiz tree element
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a l f quiz tree element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFQuizTreeElementException, SystemException {
        LFQuizTreeElement lfQuizTreeElement = fetchByPrimaryKey(primaryKey);

        if (lfQuizTreeElement == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFQuizTreeElementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfQuizTreeElement;
    }

    /**
     * Returns the l f quiz tree element with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException} if it could not be found.
     *
     * @param id the primary key of the l f quiz tree element
     * @return the l f quiz tree element
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException if a l f quiz tree element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement findByPrimaryKey(long id)
        throws NoSuchLFQuizTreeElementException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f quiz tree element with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz tree element
     * @return the l f quiz tree element, or <code>null</code> if a l f quiz tree element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFQuizTreeElement lfQuizTreeElement = (LFQuizTreeElement) EntityCacheUtil.getResult(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizTreeElementImpl.class, primaryKey);

        if (lfQuizTreeElement == _nullLFQuizTreeElement) {
            return null;
        }

        if (lfQuizTreeElement == null) {
            Session session = null;

            try {
                session = openSession();

                lfQuizTreeElement = (LFQuizTreeElement) session.get(LFQuizTreeElementImpl.class,
                        primaryKey);

                if (lfQuizTreeElement != null) {
                    cacheResult(lfQuizTreeElement);
                } else {
                    EntityCacheUtil.putResult(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizTreeElementImpl.class, primaryKey,
                        _nullLFQuizTreeElement);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFQuizTreeElementModelImpl.ENTITY_CACHE_ENABLED,
                    LFQuizTreeElementImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfQuizTreeElement;
    }

    /**
     * Returns the l f quiz tree element with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f quiz tree element
     * @return the l f quiz tree element, or <code>null</code> if a l f quiz tree element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizTreeElement fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f quiz tree elements.
     *
     * @return the l f quiz tree elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizTreeElement> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz tree elements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz tree elements
     * @param end the upper bound of the range of l f quiz tree elements (not inclusive)
     * @return the range of l f quiz tree elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizTreeElement> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz tree elements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz tree elements
     * @param end the upper bound of the range of l f quiz tree elements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f quiz tree elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizTreeElement> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<LFQuizTreeElement> list = (List<LFQuizTreeElement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFQUIZTREEELEMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFQUIZTREEELEMENT;

                if (pagination) {
                    sql = sql.concat(LFQuizTreeElementModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFQuizTreeElement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuizTreeElement>(list);
                } else {
                    list = (List<LFQuizTreeElement>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f quiz tree elements from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFQuizTreeElement lfQuizTreeElement : findAll()) {
            remove(lfQuizTreeElement);
        }
    }

    /**
     * Returns the number of l f quiz tree elements.
     *
     * @return the number of l f quiz tree elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFQUIZTREEELEMENT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the l f quiz tree element persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFQuizTreeElement>> listenersList = new ArrayList<ModelListener<LFQuizTreeElement>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFQuizTreeElement>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFQuizTreeElementImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
