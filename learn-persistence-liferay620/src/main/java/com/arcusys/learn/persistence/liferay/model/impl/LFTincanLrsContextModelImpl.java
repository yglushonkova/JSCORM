package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
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
 * The base model implementation for the LFTincanLrsContext service. Represents a row in the &quot;Learn_LFTincanLrsContext&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFTincanLrsContextImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsContextImpl
 * @see com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext
 * @see com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextModel
 * @generated
 */
public class LFTincanLrsContextModelImpl extends BaseModelImpl<LFTincanLrsContext>
    implements LFTincanLrsContextModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a l f tincan lrs context model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext} interface instead.
     */
    public static final String TABLE_NAME = "Learn_LFTincanLrsContext";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "registration", Types.VARCHAR },
            { "instructorID", Types.INTEGER },
            { "teamID", Types.INTEGER },
            { "contextActivitiesID", Types.INTEGER },
            { "revision", Types.CLOB },
            { "platform", Types.CLOB },
            { "language", Types.CLOB },
            { "statement", Types.CLOB },
            { "extensions", Types.CLOB }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFTincanLrsContext (id_ LONG not null primary key,registration VARCHAR(75) null,instructorID INTEGER null,teamID INTEGER null,contextActivitiesID INTEGER null,revision TEXT null,platform TEXT null,language TEXT null,statement TEXT null,extensions TEXT null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFTincanLrsContext";
    public static final String ORDER_BY_JPQL = " ORDER BY lfTincanLrsContext.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Learn_LFTincanLrsContext.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext"),
            false);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext"),
            false);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext"));
    private static ClassLoader _classLoader = LFTincanLrsContext.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            LFTincanLrsContext.class
        };
    private long _id;
    private String _registration;
    private Integer _instructorID;
    private Integer _teamID;
    private Integer _contextActivitiesID;
    private String _revision;
    private String _platform;
    private String _language;
    private String _statement;
    private String _extensions;
    private LFTincanLrsContext _escapedModel;

    public LFTincanLrsContextModelImpl() {
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
        return LFTincanLrsContext.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsContext.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("registration", getRegistration());
        attributes.put("instructorID", getInstructorID());
        attributes.put("teamID", getTeamID());
        attributes.put("contextActivitiesID", getContextActivitiesID());
        attributes.put("revision", getRevision());
        attributes.put("platform", getPlatform());
        attributes.put("language", getLanguage());
        attributes.put("statement", getStatement());
        attributes.put("extensions", getExtensions());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String registration = (String) attributes.get("registration");

        if (registration != null) {
            setRegistration(registration);
        }

        Integer instructorID = (Integer) attributes.get("instructorID");

        if (instructorID != null) {
            setInstructorID(instructorID);
        }

        Integer teamID = (Integer) attributes.get("teamID");

        if (teamID != null) {
            setTeamID(teamID);
        }

        Integer contextActivitiesID = (Integer) attributes.get(
                "contextActivitiesID");

        if (contextActivitiesID != null) {
            setContextActivitiesID(contextActivitiesID);
        }

        String revision = (String) attributes.get("revision");

        if (revision != null) {
            setRevision(revision);
        }

        String platform = (String) attributes.get("platform");

        if (platform != null) {
            setPlatform(platform);
        }

        String language = (String) attributes.get("language");

        if (language != null) {
            setLanguage(language);
        }

        String statement = (String) attributes.get("statement");

        if (statement != null) {
            setStatement(statement);
        }

        String extensions = (String) attributes.get("extensions");

        if (extensions != null) {
            setExtensions(extensions);
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
    public String getRegistration() {
        return _registration;
    }

    @Override
    public void setRegistration(String registration) {
        _registration = registration;
    }

    @Override
    public Integer getInstructorID() {
        return _instructorID;
    }

    @Override
    public void setInstructorID(Integer instructorID) {
        _instructorID = instructorID;
    }

    @Override
    public Integer getTeamID() {
        return _teamID;
    }

    @Override
    public void setTeamID(Integer teamID) {
        _teamID = teamID;
    }

    @Override
    public Integer getContextActivitiesID() {
        return _contextActivitiesID;
    }

    @Override
    public void setContextActivitiesID(Integer contextActivitiesID) {
        _contextActivitiesID = contextActivitiesID;
    }

    @Override
    public String getRevision() {
        return _revision;
    }

    @Override
    public void setRevision(String revision) {
        _revision = revision;
    }

    @Override
    public String getPlatform() {
        return _platform;
    }

    @Override
    public void setPlatform(String platform) {
        _platform = platform;
    }

    @Override
    public String getLanguage() {
        return _language;
    }

    @Override
    public void setLanguage(String language) {
        _language = language;
    }

    @Override
    public String getStatement() {
        return _statement;
    }

    @Override
    public void setStatement(String statement) {
        _statement = statement;
    }

    @Override
    public String getExtensions() {
        return _extensions;
    }

    @Override
    public void setExtensions(String extensions) {
        _extensions = extensions;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFTincanLrsContext.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFTincanLrsContext toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (LFTincanLrsContext) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        LFTincanLrsContextImpl lfTincanLrsContextImpl = new LFTincanLrsContextImpl();

        lfTincanLrsContextImpl.setId(getId());
        lfTincanLrsContextImpl.setRegistration(getRegistration());
        lfTincanLrsContextImpl.setInstructorID(getInstructorID());
        lfTincanLrsContextImpl.setTeamID(getTeamID());
        lfTincanLrsContextImpl.setContextActivitiesID(getContextActivitiesID());
        lfTincanLrsContextImpl.setRevision(getRevision());
        lfTincanLrsContextImpl.setPlatform(getPlatform());
        lfTincanLrsContextImpl.setLanguage(getLanguage());
        lfTincanLrsContextImpl.setStatement(getStatement());
        lfTincanLrsContextImpl.setExtensions(getExtensions());

        lfTincanLrsContextImpl.resetOriginalValues();

        return lfTincanLrsContextImpl;
    }

    @Override
    public int compareTo(LFTincanLrsContext lfTincanLrsContext) {
        long primaryKey = lfTincanLrsContext.getPrimaryKey();

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

        if (!(obj instanceof LFTincanLrsContext)) {
            return false;
        }

        LFTincanLrsContext lfTincanLrsContext = (LFTincanLrsContext) obj;

        long primaryKey = lfTincanLrsContext.getPrimaryKey();

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
    }

    @Override
    public CacheModel<LFTincanLrsContext> toCacheModel() {
        LFTincanLrsContextCacheModel lfTincanLrsContextCacheModel = new LFTincanLrsContextCacheModel();

        lfTincanLrsContextCacheModel.id = getId();

        lfTincanLrsContextCacheModel.registration = getRegistration();

        String registration = lfTincanLrsContextCacheModel.registration;

        if ((registration != null) && (registration.length() == 0)) {
            lfTincanLrsContextCacheModel.registration = null;
        }

        lfTincanLrsContextCacheModel.instructorID = getInstructorID();

        lfTincanLrsContextCacheModel.teamID = getTeamID();

        lfTincanLrsContextCacheModel.contextActivitiesID = getContextActivitiesID();

        lfTincanLrsContextCacheModel.revision = getRevision();

        String revision = lfTincanLrsContextCacheModel.revision;

        if ((revision != null) && (revision.length() == 0)) {
            lfTincanLrsContextCacheModel.revision = null;
        }

        lfTincanLrsContextCacheModel.platform = getPlatform();

        String platform = lfTincanLrsContextCacheModel.platform;

        if ((platform != null) && (platform.length() == 0)) {
            lfTincanLrsContextCacheModel.platform = null;
        }

        lfTincanLrsContextCacheModel.language = getLanguage();

        String language = lfTincanLrsContextCacheModel.language;

        if ((language != null) && (language.length() == 0)) {
            lfTincanLrsContextCacheModel.language = null;
        }

        lfTincanLrsContextCacheModel.statement = getStatement();

        String statement = lfTincanLrsContextCacheModel.statement;

        if ((statement != null) && (statement.length() == 0)) {
            lfTincanLrsContextCacheModel.statement = null;
        }

        lfTincanLrsContextCacheModel.extensions = getExtensions();

        String extensions = lfTincanLrsContextCacheModel.extensions;

        if ((extensions != null) && (extensions.length() == 0)) {
            lfTincanLrsContextCacheModel.extensions = null;
        }

        return lfTincanLrsContextCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", registration=");
        sb.append(getRegistration());
        sb.append(", instructorID=");
        sb.append(getInstructorID());
        sb.append(", teamID=");
        sb.append(getTeamID());
        sb.append(", contextActivitiesID=");
        sb.append(getContextActivitiesID());
        sb.append(", revision=");
        sb.append(getRevision());
        sb.append(", platform=");
        sb.append(getPlatform());
        sb.append(", language=");
        sb.append(getLanguage());
        sb.append(", statement=");
        sb.append(getStatement());
        sb.append(", extensions=");
        sb.append(getExtensions());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>registration</column-name><column-value><![CDATA[");
        sb.append(getRegistration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>instructorID</column-name><column-value><![CDATA[");
        sb.append(getInstructorID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>teamID</column-name><column-value><![CDATA[");
        sb.append(getTeamID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contextActivitiesID</column-name><column-value><![CDATA[");
        sb.append(getContextActivitiesID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>revision</column-name><column-value><![CDATA[");
        sb.append(getRevision());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>platform</column-name><column-value><![CDATA[");
        sb.append(getPlatform());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>language</column-name><column-value><![CDATA[");
        sb.append(getLanguage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statement</column-name><column-value><![CDATA[");
        sb.append(getStatement());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>extensions</column-name><column-value><![CDATA[");
        sb.append(getExtensions());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}