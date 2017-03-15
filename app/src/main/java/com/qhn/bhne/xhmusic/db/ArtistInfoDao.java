package com.qhn.bhne.xhmusic.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.qhn.bhne.xhmusic.mvp.entity.db.ArtistInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ARTIST_INFO".
*/
public class ArtistInfoDao extends AbstractDao<ArtistInfo, Void> {

    public static final String TABLENAME = "ARTIST_INFO";

    /**
     * Properties of entity ArtistInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Artist_name = new Property(0, String.class, "artist_name", false, "ARTIST_NAME");
        public final static Property Number_of_tracks = new Property(1, int.class, "number_of_tracks", false, "NUMBER_OF_TRACKS");
        public final static Property Artist_id = new Property(2, long.class, "artist_id", false, "ARTIST_ID");
        public final static Property Artist_sort = new Property(3, String.class, "artist_sort", false, "ARTIST_SORT");
    }


    public ArtistInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ArtistInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ARTIST_INFO\" (" + //
                "\"ARTIST_NAME\" TEXT NOT NULL ," + // 0: artist_name
                "\"NUMBER_OF_TRACKS\" INTEGER NOT NULL ," + // 1: number_of_tracks
                "\"ARTIST_ID\" INTEGER NOT NULL ," + // 2: artist_id
                "\"ARTIST_SORT\" TEXT);"); // 3: artist_sort
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ARTIST_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ArtistInfo entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getArtist_name());
        stmt.bindLong(2, entity.getNumber_of_tracks());
        stmt.bindLong(3, entity.getArtist_id());
 
        String artist_sort = entity.getArtist_sort();
        if (artist_sort != null) {
            stmt.bindString(4, artist_sort);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ArtistInfo entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getArtist_name());
        stmt.bindLong(2, entity.getNumber_of_tracks());
        stmt.bindLong(3, entity.getArtist_id());
 
        String artist_sort = entity.getArtist_sort();
        if (artist_sort != null) {
            stmt.bindString(4, artist_sort);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public ArtistInfo readEntity(Cursor cursor, int offset) {
        ArtistInfo entity = new ArtistInfo( //
            cursor.getString(offset + 0), // artist_name
            cursor.getInt(offset + 1), // number_of_tracks
            cursor.getLong(offset + 2), // artist_id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // artist_sort
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ArtistInfo entity, int offset) {
        entity.setArtist_name(cursor.getString(offset + 0));
        entity.setNumber_of_tracks(cursor.getInt(offset + 1));
        entity.setArtist_id(cursor.getLong(offset + 2));
        entity.setArtist_sort(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(ArtistInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(ArtistInfo entity) {
        return null;
    }

    @Override
    public boolean hasKey(ArtistInfo entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
