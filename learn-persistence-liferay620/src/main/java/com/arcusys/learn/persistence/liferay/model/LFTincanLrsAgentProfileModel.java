package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the LFTincanLrsAgentProfile service. Represents a row in the &quot;Learn_LFTincanLrsAgentProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAgentProfileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAgentProfileImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsAgentProfile
 * @see com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAgentProfileImpl
 * @see com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAgentProfileModelImpl
 * @generated
 */
public interface LFTincanLrsAgentProfileModel extends BaseModel<LFTincanLrsAgentProfile> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a l f tincan lrs agent profile model instance should use the {@link LFTincanLrsAgentProfile} interface instead.
     */

    /**
     * Returns the primary key of this l f tincan lrs agent profile.
     *
     * @return the primary key of this l f tincan lrs agent profile
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this l f tincan lrs agent profile.
     *
     * @param primaryKey the primary key of this l f tincan lrs agent profile
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this l f tincan lrs agent profile.
     *
     * @return the ID of this l f tincan lrs agent profile
     */
    public long getId();

    /**
     * Sets the ID of this l f tincan lrs agent profile.
     *
     * @param id the ID of this l f tincan lrs agent profile
     */
    public void setId(long id);

    /**
     * Returns the document ID of this l f tincan lrs agent profile.
     *
     * @return the document ID of this l f tincan lrs agent profile
     */
    public Integer getDocumentId();

    /**
     * Sets the document ID of this l f tincan lrs agent profile.
     *
     * @param documentId the document ID of this l f tincan lrs agent profile
     */
    public void setDocumentId(Integer documentId);

    /**
     * Returns the agent ID of this l f tincan lrs agent profile.
     *
     * @return the agent ID of this l f tincan lrs agent profile
     */
    public Integer getAgentId();

    /**
     * Sets the agent ID of this l f tincan lrs agent profile.
     *
     * @param agentId the agent ID of this l f tincan lrs agent profile
     */
    public void setAgentId(Integer agentId);

    /**
     * Returns the profile ID of this l f tincan lrs agent profile.
     *
     * @return the profile ID of this l f tincan lrs agent profile
     */
    @AutoEscape
    public String getProfileId();

    /**
     * Sets the profile ID of this l f tincan lrs agent profile.
     *
     * @param profileId the profile ID of this l f tincan lrs agent profile
     */
    public void setProfileId(String profileId);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(LFTincanLrsAgentProfile lfTincanLrsAgentProfile);

    @Override
    public int hashCode();

    @Override
    public CacheModel<LFTincanLrsAgentProfile> toCacheModel();

    @Override
    public LFTincanLrsAgentProfile toEscapedModel();

    @Override
    public LFTincanLrsAgentProfile toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}