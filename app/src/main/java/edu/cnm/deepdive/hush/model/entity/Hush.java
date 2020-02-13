package edu.cnm.deepdive.hush.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import java.util.Date;

@Entity(
    foreignKeys =  {
        @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id",
            onDelete = ForeignKey.CASCADE
        )
    },
    indices = {
        @Index(value = "longitude_id", unique = true),
        @Index(value = "latitude_id", unique = true),
        @Index(value = "hush_id", unique = true)

})
public class Hush {

  @ColumnInfo(name = "hush_id")
  @PrimaryKey(autoGenerate = true)
  private long hush;

  @ColumnInfo(name = "user_id", index = true)
  private long user;

  @ColumnInfo(name = "longitude_id")
  private double longitude;

  @ColumnInfo(name = "latitude_id")
  private double latitude;

  @ColumnInfo(name = "description_method", collate = ColumnInfo.NOCASE)
  private String description;

  @ColumnInfo(name = "private_id")
  private boolean unique;

  @ColumnInfo(name = "created_id", index = true)
  private Date created;

  @NonNull
  @Expose
  private Date date;

  @NonNull
  public Date getDate() {
    return date;
  }

  public void setDate(@NonNull Date date) {
    this.date = date;
  }

  public long getHush() {
    return hush;
  }

  public void setHush(long hush) {
    this.hush = hush;
  }

  public long getUser() {
    return user;
  }

  public void setUser(long user) {
    this.user = user;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isUnique() {
    return unique;
  }

  public void setUnique(boolean unique) {
    this.unique = unique;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }
}
