package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class MatchInfoId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "match_id", nullable = false)
    private String matchId;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MatchInfoId other = (MatchInfoId) obj;
        if ((this.accountId == null) ? (other.accountId != null) : !this.accountId.equals(other.accountId)) {
            return false;
        }
        if ((this.matchId == null) ? (other.matchId != null) : !this.matchId.equals(
                other.matchId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.accountId != null ? this.accountId.hashCode() : 0);
        hash = 41 * hash + (this.matchId != null ? this.matchId.hashCode() : 0);
        return hash;
    }
}
