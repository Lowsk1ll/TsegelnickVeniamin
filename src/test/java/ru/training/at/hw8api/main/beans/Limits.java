
package ru.training.at.hw8api.main.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Limits {

    @SerializedName("attachments")
    @Expose
    private Attachments attachments;

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Limits.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
          .append('[');
        sb.append("attachments");
        sb.append('=');
        sb.append(((this.attachments == null) ? "<null>" : this.attachments));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.attachments == null) ? 0 : this.attachments.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Limits) == false) {
            return false;
        }
        Limits rhs = ((Limits) other);
        return ((this.attachments == rhs.attachments) || ((this.attachments != null) && this.attachments
            .equals(rhs.attachments)));
    }
}
