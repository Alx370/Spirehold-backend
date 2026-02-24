package com.waveinformatica.hello.foundation.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Consumer;

public class DBUtils {

    public static Boolean getBoolean(ResultSet rs, String columnName) throws SQLException {
        boolean value = rs.getBoolean(columnName);
        return rs.wasNull() ? null : value;
    }

    public static Byte getByte(ResultSet rs, String columnName) throws SQLException {
        byte value = rs.getByte(columnName);
        return rs.wasNull() ? null : value;
    }

    public static Long getLong(ResultSet rs, String columnName) throws SQLException {
        long value = rs.getLong(columnName);
        return rs.wasNull() ? null : value;
    }

    public static Integer getInt(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return rs.wasNull() ? null : value;
    }

    public static Short getShort(ResultSet rs, String columnName) throws SQLException {
        short value = rs.getShort(columnName);
        return rs.wasNull() ? null : value;
    }

    public static Float getFloat(ResultSet rs, String columnName) throws SQLException {
        float value = rs.getFloat(columnName);
        return rs.wasNull() ? null : value;
    }

    public static Double getDouble(ResultSet rs, String columnName) throws SQLException {
        double value = rs.getFloat(columnName);
        return rs.wasNull() ? null : value;
    }

    public static ZonedDateTime getZonedDateTime(ResultSet rs, String columnName) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnName);
        return ts == null ? null : ts.toInstant().atZone(ZoneId.systemDefault());
    }

    public static void doInTransaction(DataSource ds, String schema, Consumer<Connection> consumer) {
        try (Connection conn = ds.getConnection()) {
            if (schema != null) {
                conn.setSchema(schema);
            }

            conn.setAutoCommit(false);

            try {
                consumer.accept(conn);
                conn.commit();
            } catch (Throwable e) {
                conn.rollback();
                throw e;
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
