package edu.cnm.deepdive.hush.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id",
            onDelete = ForeignKey.CASCADE
        )
    },
    indices = {
        @Index(value = {"longitude_id", "latitude_id"}, unique = true),
    })
public class Hush {

  @ColumnInfo(name = "hush_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @NonNull
  @ColumnInfo(name = "user_id", index = true)
  private long user;

  @NonNull
  @ColumnInfo(name = "longitude_id")
  private double longitude;

  @NonNull
  @ColumnInfo(name = "latitude_id")
  private double latitude;

  @ColumnInfo(collate = ColumnInfo.NOCASE, index = true)
  private String title;

  @NonNull
  private int radius;

  @NonNull
  private boolean vibrate;

  @NonNull
  @ColumnInfo(index = true)
  private Date created;

  @ColumnInfo(index = true)
  private Date updated;


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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public boolean isVibrate() {
    return vibrate;
  }

  public void setVibrate(boolean vibrate) {
    this.vibrate = vibrate;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public long getId() {
    return id;
  }

  public long getUser() {
    return user;
  }

  public Date getCreated() {
    return created;
  }
}
