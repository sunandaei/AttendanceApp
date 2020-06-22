package com.sunanda.attendance_kotlin.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class AppDatabase_Impl extends AppDatabase {
  private volatile TaskDao _taskDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TaskPojoUsingRoom` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT, `address` TEXT, `task` TEXT, `lat` TEXT, `lon` TEXT, `type` TEXT, `date_from` TEXT, `date_to` TEXT, `time` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"b6c8ef11590e19e0756608d39d0fb03b\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `TaskPojoUsingRoom`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTaskPojoUsingRoom = new HashMap<String, TableInfo.Column>(10);
        _columnsTaskPojoUsingRoom.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsTaskPojoUsingRoom.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0));
        _columnsTaskPojoUsingRoom.put("address", new TableInfo.Column("address", "TEXT", false, 0));
        _columnsTaskPojoUsingRoom.put("task", new TableInfo.Column("task", "TEXT", false, 0));
        _columnsTaskPojoUsingRoom.put("lat", new TableInfo.Column("lat", "TEXT", false, 0));
        _columnsTaskPojoUsingRoom.put("lon", new TableInfo.Column("lon", "TEXT", false, 0));
        _columnsTaskPojoUsingRoom.put("type", new TableInfo.Column("type", "TEXT", false, 0));
        _columnsTaskPojoUsingRoom.put("date_from", new TableInfo.Column("date_from", "TEXT", false, 0));
        _columnsTaskPojoUsingRoom.put("date_to", new TableInfo.Column("date_to", "TEXT", false, 0));
        _columnsTaskPojoUsingRoom.put("time", new TableInfo.Column("time", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTaskPojoUsingRoom = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTaskPojoUsingRoom = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTaskPojoUsingRoom = new TableInfo("TaskPojoUsingRoom", _columnsTaskPojoUsingRoom, _foreignKeysTaskPojoUsingRoom, _indicesTaskPojoUsingRoom);
        final TableInfo _existingTaskPojoUsingRoom = TableInfo.read(_db, "TaskPojoUsingRoom");
        if (! _infoTaskPojoUsingRoom.equals(_existingTaskPojoUsingRoom)) {
          throw new IllegalStateException("Migration didn't properly handle TaskPojoUsingRoom(com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom).\n"
                  + " Expected:\n" + _infoTaskPojoUsingRoom + "\n"
                  + " Found:\n" + _existingTaskPojoUsingRoom);
        }
      }
    }, "b6c8ef11590e19e0756608d39d0fb03b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "TaskPojoUsingRoom");
  }

  @Override
  public TaskDao taskDao() {
    if (_taskDao != null) {
      return _taskDao;
    } else {
      synchronized(this) {
        if(_taskDao == null) {
          _taskDao = new TaskDao_Impl(this);
        }
        return _taskDao;
      }
    }
  }
}
