package com.sunanda.attendance_kotlin.room;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class TaskDao_Impl implements TaskDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTaskPojoUsingRoom;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTaskPojoUsingRoom;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTaskPojoUsingRoom;

  public TaskDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTaskPojoUsingRoom = new EntityInsertionAdapter<TaskPojoUsingRoom>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TaskPojoUsingRoom`(`id`,`user_id`,`address`,`task`,`lat`,`lon`,`type`,`date_from`,`date_to`,`time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskPojoUsingRoom value) {
        stmt.bindLong(1, value.getId());
        if (value.getUser_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUser_id());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        if (value.getTasks() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTasks());
        }
        if (value.getLat() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLat());
        }
        if (value.getLon() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLon());
        }
        if (value.getType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getType());
        }
        if (value.getDate_from() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDate_from());
        }
        if (value.getDate_to() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDate_to());
        }
        if (value.getTime() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTime());
        }
      }
    };
    this.__deletionAdapterOfTaskPojoUsingRoom = new EntityDeletionOrUpdateAdapter<TaskPojoUsingRoom>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TaskPojoUsingRoom` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskPojoUsingRoom value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTaskPojoUsingRoom = new EntityDeletionOrUpdateAdapter<TaskPojoUsingRoom>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TaskPojoUsingRoom` SET `id` = ?,`user_id` = ?,`address` = ?,`task` = ?,`lat` = ?,`lon` = ?,`type` = ?,`date_from` = ?,`date_to` = ?,`time` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskPojoUsingRoom value) {
        stmt.bindLong(1, value.getId());
        if (value.getUser_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUser_id());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        if (value.getTasks() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTasks());
        }
        if (value.getLat() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLat());
        }
        if (value.getLon() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLon());
        }
        if (value.getType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getType());
        }
        if (value.getDate_from() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDate_from());
        }
        if (value.getDate_to() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDate_to());
        }
        if (value.getTime() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTime());
        }
        stmt.bindLong(11, value.getId());
      }
    };
  }

  @Override
  public void insert(TaskPojoUsingRoom task) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTaskPojoUsingRoom.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(TaskPojoUsingRoom task) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTaskPojoUsingRoom.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(TaskPojoUsingRoom task) {
    __db.beginTransaction();
    try {
      __updateAdapterOfTaskPojoUsingRoom.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<TaskPojoUsingRoom> getAll() {
    final String _sql = "SELECT * FROM taskpojousingroom";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfUserId = _cursor.getColumnIndexOrThrow("user_id");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
      final int _cursorIndexOfTasks = _cursor.getColumnIndexOrThrow("task");
      final int _cursorIndexOfLat = _cursor.getColumnIndexOrThrow("lat");
      final int _cursorIndexOfLon = _cursor.getColumnIndexOrThrow("lon");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final int _cursorIndexOfDateFrom = _cursor.getColumnIndexOrThrow("date_from");
      final int _cursorIndexOfDateTo = _cursor.getColumnIndexOrThrow("date_to");
      final int _cursorIndexOfTime = _cursor.getColumnIndexOrThrow("time");
      final List<TaskPojoUsingRoom> _result = new ArrayList<TaskPojoUsingRoom>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TaskPojoUsingRoom _item;
        _item = new TaskPojoUsingRoom();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpUser_id;
        _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
        _item.setUser_id(_tmpUser_id);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _item.setAddress(_tmpAddress);
        final String _tmpTasks;
        _tmpTasks = _cursor.getString(_cursorIndexOfTasks);
        _item.setTasks(_tmpTasks);
        final String _tmpLat;
        _tmpLat = _cursor.getString(_cursorIndexOfLat);
        _item.setLat(_tmpLat);
        final String _tmpLon;
        _tmpLon = _cursor.getString(_cursorIndexOfLon);
        _item.setLon(_tmpLon);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item.setType(_tmpType);
        final String _tmpDate_from;
        _tmpDate_from = _cursor.getString(_cursorIndexOfDateFrom);
        _item.setDate_from(_tmpDate_from);
        final String _tmpDate_to;
        _tmpDate_to = _cursor.getString(_cursorIndexOfDateTo);
        _item.setDate_to(_tmpDate_to);
        final String _tmpTime;
        _tmpTime = _cursor.getString(_cursorIndexOfTime);
        _item.setTime(_tmpTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getCountData() {
    final String _sql = "SELECT count(*) FROM taskpojousingroom";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
