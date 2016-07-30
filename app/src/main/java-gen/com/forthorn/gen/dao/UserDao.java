package com.forthorn.gen.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.forthorn.gen.bean.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "User".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "User";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Uid = new Property(1, int.class, "uid", false, "UID");
        public final static Property Nickname = new Property(2, String.class, "nickname", false, "NICKNAME");
        public final static Property Password = new Property(3, String.class, "password", false, "PASSWORD");
        public final static Property Gender = new Property(4, String.class, "gender", false, "GENDER");
        public final static Property Age = new Property(5, Integer.class, "age", false, "AGE");
        public final static Property Birthday = new Property(6, String.class, "birthday", false, "BIRTHDAY");
        public final static Property Email = new Property(7, String.class, "email", false, "EMAIL");
        public final static Property Address = new Property(8, String.class, "address", false, "ADDRESS");
        public final static Property Tel = new Property(9, String.class, "tel", false, "TEL");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"User\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"UID\" INTEGER NOT NULL ," + // 1: uid
                "\"NICKNAME\" TEXT NOT NULL ," + // 2: nickname
                "\"PASSWORD\" TEXT NOT NULL ," + // 3: password
                "\"GENDER\" TEXT," + // 4: gender
                "\"AGE\" INTEGER," + // 5: age
                "\"BIRTHDAY\" TEXT," + // 6: birthday
                "\"EMAIL\" TEXT," + // 7: email
                "\"ADDRESS\" TEXT," + // 8: address
                "\"TEL\" TEXT);"); // 9: tel
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"User\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getUid());
        stmt.bindString(3, entity.getNickname());
        stmt.bindString(4, entity.getPassword());
 
        String gender = entity.getGender();
        if (gender != null) {
            stmt.bindString(5, gender);
        }
 
        Integer age = entity.getAge();
        if (age != null) {
            stmt.bindLong(6, age);
        }
 
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(7, birthday);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(8, email);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(9, address);
        }
 
        String tel = entity.getTel();
        if (tel != null) {
            stmt.bindString(10, tel);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getUid());
        stmt.bindString(3, entity.getNickname());
        stmt.bindString(4, entity.getPassword());
 
        String gender = entity.getGender();
        if (gender != null) {
            stmt.bindString(5, gender);
        }
 
        Integer age = entity.getAge();
        if (age != null) {
            stmt.bindLong(6, age);
        }
 
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(7, birthday);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(8, email);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(9, address);
        }
 
        String tel = entity.getTel();
        if (tel != null) {
            stmt.bindString(10, tel);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // uid
            cursor.getString(offset + 2), // nickname
            cursor.getString(offset + 3), // password
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // gender
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // age
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // birthday
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // email
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // address
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // tel
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUid(cursor.getInt(offset + 1));
        entity.setNickname(cursor.getString(offset + 2));
        entity.setPassword(cursor.getString(offset + 3));
        entity.setGender(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAge(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setBirthday(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEmail(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setAddress(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setTel(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
