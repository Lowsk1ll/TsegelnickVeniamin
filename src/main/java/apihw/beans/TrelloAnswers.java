
package apihw.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrelloAnswers {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("idMemberCreator")
    @Expose
    private String idMemberCreator;
    @SerializedName("idOrganization")
    @Expose
    private String idOrganization;
    @SerializedName("pinned")
    @Expose
    private Boolean pinned;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;
    @SerializedName("prefs")
    @Expose
    private Prefs prefs;
    @SerializedName("labelNames")
    @Expose
    private LabelNames labelNames;
    @SerializedName("starred")
    @Expose
    private Boolean starred;
    @SerializedName("memberships")
    @Expose
    private String memberships;
    @SerializedName("shortLink")
    @Expose
    private String shortLink;
    @SerializedName("subscribed")
    @Expose
    private Boolean subscribed;
    @SerializedName("powerUps")
    @Expose
    private String powerUps;
    @SerializedName("dateLastActivity")
    @Expose
    private String dateLastActivity;
    @SerializedName("dateLastView")
    @Expose
    private String dateLastView;
    @SerializedName("idTags")
    @Expose
    private String idTags;
    @SerializedName("datePluginDisable")
    @Expose
    private String datePluginDisable;
    @SerializedName("creationMethod")
    @Expose
    private String creationMethod;
    @SerializedName("ixUpdate")
    @Expose
    private Integer ixUpdate;
    @SerializedName("templateGallery")
    @Expose
    private String templateGallery;
    @SerializedName("enterpriseOwned")
    @Expose
    private Boolean enterpriseOwned;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getIdMemberCreator() {
        return idMemberCreator;
    }

    public void setIdMemberCreator(String idMemberCreator) {
        this.idMemberCreator = idMemberCreator;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }

    public LabelNames getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(LabelNames labelNames) {
        this.labelNames = labelNames;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    public String getMemberships() {
        return memberships;
    }

    public void setMemberships(String memberships) {
        this.memberships = memberships;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(String powerUps) {
        this.powerUps = powerUps;
    }

    public String getDateLastActivity() {
        return dateLastActivity;
    }

    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }

    public String getDateLastView() {
        return dateLastView;
    }

    public void setDateLastView(String dateLastView) {
        this.dateLastView = dateLastView;
    }

    public String getIdTags() {
        return idTags;
    }

    public void setIdTags(String idTags) {
        this.idTags = idTags;
    }

    public String getDatePluginDisable() {
        return datePluginDisable;
    }

    public void setDatePluginDisable(String datePluginDisable) {
        this.datePluginDisable = datePluginDisable;
    }

    public String getCreationMethod() {
        return creationMethod;
    }

    public void setCreationMethod(String creationMethod) {
        this.creationMethod = creationMethod;
    }

    public Integer getIxUpdate() {
        return ixUpdate;
    }

    public void setIxUpdate(Integer ixUpdate) {
        this.ixUpdate = ixUpdate;
    }

    public String getTemplateGallery() {
        return templateGallery;
    }

    public void setTemplateGallery(String templateGallery) {
        this.templateGallery = templateGallery;
    }

    public Boolean getEnterpriseOwned() {
        return enterpriseOwned;
    }

    public void setEnterpriseOwned(Boolean enterpriseOwned) {
        this.enterpriseOwned = enterpriseOwned;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TrelloAnswers.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null)?"<null>":this.desc));
        sb.append(',');
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null)?"<null>":this.closed));
        sb.append(',');
        sb.append("idMemberCreator");
        sb.append('=');
        sb.append(((this.idMemberCreator == null)?"<null>":this.idMemberCreator));
        sb.append(',');
        sb.append("idOrganization");
        sb.append('=');
        sb.append(((this.idOrganization == null)?"<null>":this.idOrganization));
        sb.append(',');
        sb.append("pinned");
        sb.append('=');
        sb.append(((this.pinned == null)?"<null>":this.pinned));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("shortUrl");
        sb.append('=');
        sb.append(((this.shortUrl == null)?"<null>":this.shortUrl));
        sb.append(',');
        sb.append("prefs");
        sb.append('=');
        sb.append(((this.prefs == null)?"<null>":this.prefs));
        sb.append(',');
        sb.append("labelNames");
        sb.append('=');
        sb.append(((this.labelNames == null)?"<null>":this.labelNames));
        sb.append(',');
        sb.append("starred");
        sb.append('=');
        sb.append(((this.starred == null)?"<null>":this.starred));
        sb.append(',');
        sb.append("memberships");
        sb.append('=');
        sb.append(((this.memberships == null)?"<null>":this.memberships));
        sb.append(',');
        sb.append("shortLink");
        sb.append('=');
        sb.append(((this.shortLink == null)?"<null>":this.shortLink));
        sb.append(',');
        sb.append("subscribed");
        sb.append('=');
        sb.append(((this.subscribed == null)?"<null>":this.subscribed));
        sb.append(',');
        sb.append("powerUps");
        sb.append('=');
        sb.append(((this.powerUps == null)?"<null>":this.powerUps));
        sb.append(',');
        sb.append("dateLastActivity");
        sb.append('=');
        sb.append(((this.dateLastActivity == null)?"<null>":this.dateLastActivity));
        sb.append(',');
        sb.append("dateLastView");
        sb.append('=');
        sb.append(((this.dateLastView == null)?"<null>":this.dateLastView));
        sb.append(',');
        sb.append("idTags");
        sb.append('=');
        sb.append(((this.idTags == null)?"<null>":this.idTags));
        sb.append(',');
        sb.append("datePluginDisable");
        sb.append('=');
        sb.append(((this.datePluginDisable == null)?"<null>":this.datePluginDisable));
        sb.append(',');
        sb.append("creationMethod");
        sb.append('=');
        sb.append(((this.creationMethod == null)?"<null>":this.creationMethod));
        sb.append(',');
        sb.append("ixUpdate");
        sb.append('=');
        sb.append(((this.ixUpdate == null)?"<null>":this.ixUpdate));
        sb.append(',');
        sb.append("templateGallery");
        sb.append('=');
        sb.append(((this.templateGallery == null)?"<null>":this.templateGallery));
        sb.append(',');
        sb.append("enterpriseOwned");
        sb.append('=');
        sb.append(((this.enterpriseOwned == null)?"<null>":this.enterpriseOwned));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.idTags == null)? 0 :this.idTags.hashCode()));
        result = ((result* 31)+((this.pinned == null)? 0 :this.pinned.hashCode()));
        result = ((result* 31)+((this.labelNames == null)? 0 :this.labelNames.hashCode()));
        result = ((result* 31)+((this.shortUrl == null)? 0 :this.shortUrl.hashCode()));
        result = ((result* 31)+((this.dateLastActivity == null)? 0 :this.dateLastActivity.hashCode()));
        result = ((result* 31)+((this.datePluginDisable == null)? 0 :this.datePluginDisable.hashCode()));
        result = ((result* 31)+((this.shortLink == null)? 0 :this.shortLink.hashCode()));
        result = ((result* 31)+((this.memberships == null)? 0 :this.memberships.hashCode()));
        result = ((result* 31)+((this.creationMethod == null)? 0 :this.creationMethod.hashCode()));
        result = ((result* 31)+((this.subscribed == null)? 0 :this.subscribed.hashCode()));
        result = ((result* 31)+((this.starred == null)? 0 :this.starred.hashCode()));
        result = ((result* 31)+((this.idOrganization == null)? 0 :this.idOrganization.hashCode()));
        result = ((result* 31)+((this.dateLastView == null)? 0 :this.dateLastView.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.powerUps == null)? 0 :this.powerUps.hashCode()));
        result = ((result* 31)+((this.templateGallery == null)? 0 :this.templateGallery.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.prefs == null)? 0 :this.prefs.hashCode()));
        result = ((result* 31)+((this.enterpriseOwned == null)? 0 :this.enterpriseOwned.hashCode()));
        result = ((result* 31)+((this.ixUpdate == null)? 0 :this.ixUpdate.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.closed == null)? 0 :this.closed.hashCode()));
        result = ((result* 31)+((this.idMemberCreator == null)? 0 :this.idMemberCreator.hashCode()));
        result = ((result* 31)+((this.desc == null)? 0 :this.desc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TrelloAnswers) == false) {
            return false;
        }
        TrelloAnswers rhs = ((TrelloAnswers) other);
        return (((((((((((((((((((((((((this.idTags == rhs.idTags)||((this.idTags!= null)&&this.idTags.equals(rhs.idTags)))&&((this.pinned == rhs.pinned)||((this.pinned!= null)&&this.pinned.equals(rhs.pinned))))&&((this.labelNames == rhs.labelNames)||((this.labelNames!= null)&&this.labelNames.equals(rhs.labelNames))))&&((this.shortUrl == rhs.shortUrl)||((this.shortUrl!= null)&&this.shortUrl.equals(rhs.shortUrl))))&&((this.dateLastActivity == rhs.dateLastActivity)||((this.dateLastActivity!= null)&&this.dateLastActivity.equals(rhs.dateLastActivity))))&&((this.datePluginDisable == rhs.datePluginDisable)||((this.datePluginDisable!= null)&&this.datePluginDisable.equals(rhs.datePluginDisable))))&&((this.shortLink == rhs.shortLink)||((this.shortLink!= null)&&this.shortLink.equals(rhs.shortLink))))&&((this.memberships == rhs.memberships)||((this.memberships!= null)&&this.memberships.equals(rhs.memberships))))&&((this.creationMethod == rhs.creationMethod)||((this.creationMethod!= null)&&this.creationMethod.equals(rhs.creationMethod))))&&((this.subscribed == rhs.subscribed)||((this.subscribed!= null)&&this.subscribed.equals(rhs.subscribed))))&&((this.starred == rhs.starred)||((this.starred!= null)&&this.starred.equals(rhs.starred))))&&((this.idOrganization == rhs.idOrganization)||((this.idOrganization!= null)&&this.idOrganization.equals(rhs.idOrganization))))&&((this.dateLastView == rhs.dateLastView)||((this.dateLastView!= null)&&this.dateLastView.equals(rhs.dateLastView))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.powerUps == rhs.powerUps)||((this.powerUps!= null)&&this.powerUps.equals(rhs.powerUps))))&&((this.templateGallery == rhs.templateGallery)||((this.templateGallery!= null)&&this.templateGallery.equals(rhs.templateGallery))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.prefs == rhs.prefs)||((this.prefs!= null)&&this.prefs.equals(rhs.prefs))))&&((this.enterpriseOwned == rhs.enterpriseOwned)||((this.enterpriseOwned!= null)&&this.enterpriseOwned.equals(rhs.enterpriseOwned))))&&((this.ixUpdate == rhs.ixUpdate)||((this.ixUpdate!= null)&&this.ixUpdate.equals(rhs.ixUpdate))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.closed == rhs.closed)||((this.closed!= null)&&this.closed.equals(rhs.closed))))&&((this.idMemberCreator == rhs.idMemberCreator)||((this.idMemberCreator!= null)&&this.idMemberCreator.equals(rhs.idMemberCreator))))&&((this.desc == rhs.desc)||((this.desc!= null)&&this.desc.equals(rhs.desc))));
    }

}
