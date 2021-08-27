
package apihw.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prefs {

    @SerializedName("permissionLevel")
    @Expose
    private String permissionLevel;
    @SerializedName("hideVotes")
    @Expose
    private Boolean hideVotes;
    @SerializedName("voting")
    @Expose
    private String voting;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("selfJoin")
    @Expose
    private Boolean selfJoin;
    @SerializedName("cardCovers")
    @Expose
    private Boolean cardCovers;
    @SerializedName("isTemplate")
    @Expose
    private Boolean isTemplate;
    @SerializedName("cardAging")
    @Expose
    private String cardAging;
    @SerializedName("calendarFeedEnabled")
    @Expose
    private Boolean calendarFeedEnabled;
    @SerializedName("background")
    @Expose
    private String background;
    @SerializedName("backgroundImage")
    @Expose
    private String backgroundImage;
    @SerializedName("backgroundImageScaled")
    @Expose
    private String backgroundImageScaled;

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public Boolean getHideVotes() {
        return hideVotes;
    }

    public void setHideVotes(Boolean hideVotes) {
        this.hideVotes = hideVotes;
    }

    public String getVoting() {
        return voting;
    }

    public void setVoting(String voting) {
        this.voting = voting;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getSelfJoin() {
        return selfJoin;
    }

    public void setSelfJoin(Boolean selfJoin) {
        this.selfJoin = selfJoin;
    }

    public Boolean getCardCovers() {
        return cardCovers;
    }

    public void setCardCovers(Boolean cardCovers) {
        this.cardCovers = cardCovers;
    }

    public Boolean getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Boolean isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getCardAging() {
        return cardAging;
    }

    public void setCardAging(String cardAging) {
        this.cardAging = cardAging;
    }

    public Boolean getCalendarFeedEnabled() {
        return calendarFeedEnabled;
    }

    public void setCalendarFeedEnabled(Boolean calendarFeedEnabled) {
        this.calendarFeedEnabled = calendarFeedEnabled;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getBackgroundImageScaled() {
        return backgroundImageScaled;
    }

    public void setBackgroundImageScaled(String backgroundImageScaled) {
        this.backgroundImageScaled = backgroundImageScaled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Prefs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("permissionLevel");
        sb.append('=');
        sb.append(((this.permissionLevel == null)?"<null>":this.permissionLevel));
        sb.append(',');
        sb.append("hideVotes");
        sb.append('=');
        sb.append(((this.hideVotes == null)?"<null>":this.hideVotes));
        sb.append(',');
        sb.append("voting");
        sb.append('=');
        sb.append(((this.voting == null)?"<null>":this.voting));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
        sb.append(',');
        sb.append("selfJoin");
        sb.append('=');
        sb.append(((this.selfJoin == null)?"<null>":this.selfJoin));
        sb.append(',');
        sb.append("cardCovers");
        sb.append('=');
        sb.append(((this.cardCovers == null)?"<null>":this.cardCovers));
        sb.append(',');
        sb.append("isTemplate");
        sb.append('=');
        sb.append(((this.isTemplate == null)?"<null>":this.isTemplate));
        sb.append(',');
        sb.append("cardAging");
        sb.append('=');
        sb.append(((this.cardAging == null)?"<null>":this.cardAging));
        sb.append(',');
        sb.append("calendarFeedEnabled");
        sb.append('=');
        sb.append(((this.calendarFeedEnabled == null)?"<null>":this.calendarFeedEnabled));
        sb.append(',');
        sb.append("background");
        sb.append('=');
        sb.append(((this.background == null)?"<null>":this.background));
        sb.append(',');
        sb.append("backgroundImage");
        sb.append('=');
        sb.append(((this.backgroundImage == null)?"<null>":this.backgroundImage));
        sb.append(',');
        sb.append("backgroundImageScaled");
        sb.append('=');
        sb.append(((this.backgroundImageScaled == null)?"<null>":this.backgroundImageScaled));
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
        result = ((result* 31)+((this.comments == null)? 0 :this.comments.hashCode()));
        result = ((result* 31)+((this.hideVotes == null)? 0 :this.hideVotes.hashCode()));
        result = ((result* 31)+((this.backgroundImage == null)? 0 :this.backgroundImage.hashCode()));
        result = ((result* 31)+((this.voting == null)? 0 :this.voting.hashCode()));
        result = ((result* 31)+((this.calendarFeedEnabled == null)? 0 :this.calendarFeedEnabled.hashCode()));
        result = ((result* 31)+((this.backgroundImageScaled == null)? 0 :this.backgroundImageScaled.hashCode()));
        result = ((result* 31)+((this.permissionLevel == null)? 0 :this.permissionLevel.hashCode()));
        result = ((result* 31)+((this.cardAging == null)? 0 :this.cardAging.hashCode()));
        result = ((result* 31)+((this.isTemplate == null)? 0 :this.isTemplate.hashCode()));
        result = ((result* 31)+((this.background == null)? 0 :this.background.hashCode()));
        result = ((result* 31)+((this.cardCovers == null)? 0 :this.cardCovers.hashCode()));
        result = ((result* 31)+((this.selfJoin == null)? 0 :this.selfJoin.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Prefs) == false) {
            return false;
        }
        Prefs rhs = ((Prefs) other);
        return (((((((((((((this.comments == rhs.comments)||((this.comments!= null)&&this.comments.equals(rhs.comments)))&&((this.hideVotes == rhs.hideVotes)||((this.hideVotes!= null)&&this.hideVotes.equals(rhs.hideVotes))))&&((this.backgroundImage == rhs.backgroundImage)||((this.backgroundImage!= null)&&this.backgroundImage.equals(rhs.backgroundImage))))&&((this.voting == rhs.voting)||((this.voting!= null)&&this.voting.equals(rhs.voting))))&&((this.calendarFeedEnabled == rhs.calendarFeedEnabled)||((this.calendarFeedEnabled!= null)&&this.calendarFeedEnabled.equals(rhs.calendarFeedEnabled))))&&((this.backgroundImageScaled == rhs.backgroundImageScaled)||((this.backgroundImageScaled!= null)&&this.backgroundImageScaled.equals(rhs.backgroundImageScaled))))&&((this.permissionLevel == rhs.permissionLevel)||((this.permissionLevel!= null)&&this.permissionLevel.equals(rhs.permissionLevel))))&&((this.cardAging == rhs.cardAging)||((this.cardAging!= null)&&this.cardAging.equals(rhs.cardAging))))&&((this.isTemplate == rhs.isTemplate)||((this.isTemplate!= null)&&this.isTemplate.equals(rhs.isTemplate))))&&((this.background == rhs.background)||((this.background!= null)&&this.background.equals(rhs.background))))&&((this.cardCovers == rhs.cardCovers)||((this.cardCovers!= null)&&this.cardCovers.equals(rhs.cardCovers))))&&((this.selfJoin == rhs.selfJoin)||((this.selfJoin!= null)&&this.selfJoin.equals(rhs.selfJoin))));
    }

}
