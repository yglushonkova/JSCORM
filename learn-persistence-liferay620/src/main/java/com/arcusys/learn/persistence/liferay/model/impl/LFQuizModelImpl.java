package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuiz;
import com.arcusys.learn.persistence.liferay.model.LFQuizModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the LFQuiz service. Represents a row in the &quot;Learn_LFQuiz&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFQuizModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFQuizImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizImpl
 * @see com.arcusys.learn.persistence.liferay.model.LFQuiz
 * @see com.arcusys.learn.persistence.liferay.model.LFQuizModel
 * @generated
 */
public class LFQuizModelImpl extends BaseModelImpl<LFQuiz>
    implements LFQuizModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a l f quiz model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFQuiz} interface instead.
     */
    public static final String TABLE_NAME = "Learn_LFQuiz";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "title", Types.CLOB },
            { "description", Types.CLOB },
            { "logo", Types.VARCHAR },
            { "welcomePageContent", Types.CLOB },
            { "finalPageContent", Types.CLOB },
            { "courseID", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFQuiz (id_ LONG not null primary key,title TEXT null,description TEXT null,logo VARCHAR(75) null,welcomePageContent TEXT null,finalPageContent TEXT null,courseID INTEGER null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFQuiz";
    public static final String ORDER_BY_JPQL = " ORDER BY lfQuiz.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Learn_LFQuiz.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFQuiz"),
            false);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFQuiz"),
            false);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFQuiz"),
            true);
    public static long COURSEID_COLUMN_BITMASK = 1L;
    public static long ID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFQuiz"));
    private static ClassLoader _classLoader = LFQuiz.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { LFQuiz.class };
    private long _id;
    private String _title;
    private String _description;
    private String _logo;
    private String _welcomePageContent;
    private String _finalPageContent;
    private Integer _courseID;
    private Integer _originalCourseID;
    private boolean _setOriginalCourseID;
    private long _columnBitmask;
    private LFQuiz _escapedModel;

    public LFQuizModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuiz.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuiz.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("logo", getLogo());
        attributes.put("welcomePageContent", getWelcomePageContent());
        attributes.put("finalPageContent", getFinalPageContent());
        attributes.put("courseID", getCourseID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String logo = (String) attributes.get("logo");

        if (logo != null) {
            setLogo(logo);
        }

        String welcomePageContent = (String) attributes.get(
                "welcomePageContent");

        if (welcomePageContent != null) {
            setWelcomePageContent(welcomePageContent);
        }

        String finalPageContent = (String) attributes.get("finalPageContent");

        if (finalPageContent != null) {
            setFinalPageContent(finalPageContent);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    @Override
    public String getTitle() {
        if (_title == null) {
            return StringPool.BLANK;
        } else {
            return _title;
        }
    }

    @Override
    public void setTitle(String title) {
        _title = title;
    }

    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @Override
    public String getLogo() {
        if (_logo == null) {
            return StringPool.BLANK;
        } else {
            return _logo;
        }
    }

    @Override
    public void setLogo(String logo) {
        _logo = logo;
    }

    @Override
    public String getWelcomePageContent() {
        if (_welcomePageContent == null) {
            return StringPool.BLANK;
        } else {
            return _welcomePageContent;
        }
    }

    @Override
    public void setWelcomePageContent(String welcomePageContent) {
        _welcomePageContent = welcomePageContent;
    }

    @Override
    public String getFinalPageContent() {
        if (_finalPageContent == null) {
            return StringPool.BLANK;
        } else {
            return _finalPageContent;
        }
    }

    @Override
    public void setFinalPageContent(String finalPageContent) {
        _finalPageContent = finalPageContent;
    }

    @Override
    public Integer getCourseID() {
        return _courseID;
    }

    @Override
    public void setCourseID(Integer courseID) {
        _columnBitmask |= COURSEID_COLUMN_BITMASK;

        if (!_setOriginalCourseID) {
            _setOriginalCourseID = true;

            _originalCourseID = _courseID;
        }

        _courseID = courseID;
    }

    public Integer getOriginalCourseID() {
        return _originalCourseID;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFQuiz.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFQuiz toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (LFQuiz) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        LFQuizImpl lfQuizImpl = new LFQuizImpl();

        lfQuizImpl.setId(getId());
        lfQuizImpl.setTitle(getTitle());
        lfQuizImpl.setDescription(getDescription());
        lfQuizImpl.setLogo(getLogo());
        lfQuizImpl.setWelcomePageContent(getWelcomePageContent());
        lfQuizImpl.setFinalPageContent(getFinalPageContent());
        lfQuizImpl.setCourseID(getCourseID());

        lfQuizImpl.resetOriginalValues();

        return lfQuizImpl;
    }

    @Override
    public int compareTo(LFQuiz lfQuiz) {
        long primaryKey = lfQuiz.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuiz)) {
            return false;
        }

        LFQuiz lfQuiz = (LFQuiz) obj;

        long primaryKey = lfQuiz.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        LFQuizModelImpl lfQuizModelImpl = this;

        lfQuizModelImpl._originalCourseID = lfQuizModelImpl._courseID;

        lfQuizModelImpl._setOriginalCourseID = false;

        lfQuizModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFQuiz> toCacheModel() {
        LFQuizCacheModel lfQuizCacheModel = new LFQuizCacheModel();

        lfQuizCacheModel.id = getId();

        lfQuizCacheModel.title = getTitle();

        String title = lfQuizCacheModel.title;

        if ((title != null) && (title.length() == 0)) {
            lfQuizCacheModel.title = null;
        }

        lfQuizCacheModel.description = getDescription();

        String description = lfQuizCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            lfQuizCacheModel.description = null;
        }

        lfQuizCacheModel.logo = getLogo();

        String logo = lfQuizCacheModel.logo;

        if ((logo != null) && (logo.length() == 0)) {
            lfQuizCacheModel.logo = null;
        }

        lfQuizCacheModel.welcomePageContent = getWelcomePageContent();

        String welcomePageContent = lfQuizCacheModel.welcomePageContent;

        if ((welcomePageContent != null) && (welcomePageContent.length() == 0)) {
            lfQuizCacheModel.welcomePageContent = null;
        }

        lfQuizCacheModel.finalPageContent = getFinalPageContent();

        String finalPageContent = lfQuizCacheModel.finalPageContent;

        if ((finalPageContent != null) && (finalPageContent.length() == 0)) {
            lfQuizCacheModel.finalPageContent = null;
        }

        lfQuizCacheModel.courseID = getCourseID();

        return lfQuizCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", logo=");
        sb.append(getLogo());
        sb.append(", welcomePageContent=");
        sb.append(getWelcomePageContent());
        sb.append(", finalPageContent=");
        sb.append(getFinalPageContent());
        sb.append(", courseID=");
        sb.append(getCourseID());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFQuiz");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>logo</column-name><column-value><![CDATA[");
        sb.append(getLogo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>welcomePageContent</column-name><column-value><![CDATA[");
        sb.append(getWelcomePageContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>finalPageContent</column-name><column-value><![CDATA[");
        sb.append(getFinalPageContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseID</column-name><column-value><![CDATA[");
        sb.append(getCourseID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
