# SQL data definition language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `Hush`
(
    `hush_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id`      INTEGER                           NOT NULL,
    `longitude_id` REAL                              NOT NULL,
    `latitude_id`  REAL                              NOT NULL,
    `title`        TEXT COLLATE NOCASE,
    `radius`       INTEGER                           NOT NULL,
    `vibrate`      INTEGER                           NOT NULL,
    `created`      INTEGER                           NOT NULL,
    `updated`      INTEGER,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_Hush_longitude_id_latitude_id` ON `Hush` (`longitude_id`, `latitude_id`);
CREATE INDEX IF NOT EXISTS `index_Hush_user_id` ON `Hush` (`user_id`);
CREATE INDEX IF NOT EXISTS `index_Hush_title` ON `Hush` (`title`);
CREATE INDEX IF NOT EXISTS `index_Hush_created` ON `Hush` (`created`);
CREATE INDEX IF NOT EXISTS `index_Hush_updated` ON `Hush` (`updated`);
CREATE TABLE IF NOT EXISTS User
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `oauth_key` TEXT                              NOT NULL,
    `created`   INTEGER                           NOT NULL,
    `updated`   INTEGER                           NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_User_oauth_key` ON User (`oauth_key`);
CREATE INDEX IF NOT EXISTS `index_User_created` ON User (`created`);
CREATE INDEX IF NOT EXISTS `index_User_updated` ON User (`updated`);
```

[Download](ddl.sql)