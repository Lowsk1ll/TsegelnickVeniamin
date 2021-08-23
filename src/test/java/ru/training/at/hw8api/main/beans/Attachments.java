
package ru.training.at.hw8api.main.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attachments {

    @SerializedName("perBoard")
    @Expose
    private PerBoard perBoard;

    public PerBoard getPerBoard() {
        return perBoard;
    }

    public void setPerBoard(PerBoard perBoard) {
        this.perBoard = perBoard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attachments.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
          .append('[');
        sb.append("perBoard");
        sb.append('=');
        sb.append(((this.perBoard == null) ? "<null>" : this.perBoard));
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
        result = ((result * 31) + ((this.perBoard == null) ? 0 : this.perBoard.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Attachments) == false) {
            return false;
        }
        Attachments rhs = ((Attachments) other);
        return ((this.perBoard == rhs.perBoard) || ((this.perBoard != null) && this.perBoard.equals(rhs.perBoard)));
    }
}
