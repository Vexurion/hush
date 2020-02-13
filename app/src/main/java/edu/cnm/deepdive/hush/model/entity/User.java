package edu.cnm.deepdive.hush.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity

public class User {


  @ColumnInfo(name = "user_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  //add (..., index = true) after (name = "...") for Foreign Keys, and stuff you think you'll be searching or indexing.
  @ColumnInfo(name = "oauth_id")
  private String oauth;

  // used index = true for a IX1?? No understando
  @ColumnInfo(name = "created_id", index = true)
  private Date created;

  // @ColumnInfo(collate = ColumnInfo.NOCASE)
  @ColumnInfo(name = "update_id", index = true)
  private Date update;

  @ColumnInfo(index = true)
  private boolean success;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getOauth() {
    return oauth;
  }

  public void setOauth(String oauth) {
    this.oauth = oauth;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdate() {
    return update;
  }

  public void setUpdate(Date update) {
    this.update = update;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }
}
