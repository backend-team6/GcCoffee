package org.example.handler;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.example.Util.UUIDUtil;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UUIDTypeHandler extends BaseTypeHandler<UUID> {
    // UUID를 byte 배열로 변환
    private byte[] uuidToBytes(UUID uuid) {
        byte[] bytes = new byte[16];
        long mostSigBits = uuid.getMostSignificantBits();
        long leastSigBits = uuid.getLeastSignificantBits();
        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) (mostSigBits >>> 8 * (7 - i));
            bytes[i + 8] = (byte) (leastSigBits >>> 8 * (7 - i));
        }
        return bytes;
    }

    // byte 배열을 UUID로 변환
    private UUID bytesToUuid(byte[] bytes) {
        long mostSigBits = 0;
        long leastSigBits = 0;
        for (int i = 0; i < 8; i++) {
            mostSigBits = (mostSigBits << 8) | (bytes[i] & 0xff);
            leastSigBits = (leastSigBits << 8) | (bytes[i + 8] & 0xff);
        }
        return new UUID(mostSigBits, leastSigBits);
    }
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
        //UUID -> BINARY(16)
        ps.setBytes(i, UUIDUtil.toBytes(parameter));
    }


    @Override
    public UUID getNullableResult(ResultSet rs, String columnName) throws SQLException {
        byte[] bytes = rs.getBytes(columnName);
        return (bytes != null) ? UUIDUtil.toUUID(bytes) : null;
    }

    @Override
    public UUID getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        byte[] bytes = rs.getBytes(columnIndex);
        return (bytes != null) ? UUIDUtil.toUUID(bytes) : null;
    }

    @Override
    public UUID getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        byte[] bytes = cs.getBytes(columnIndex);
        return (bytes != null) ? UUIDUtil.toUUID(bytes) : null;
    }

    public UUIDTypeHandler() {
        super();
    }

    @Override
    public void setConfiguration(Configuration c) {
        super.setConfiguration(c);
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
        super.setParameter(ps, i, parameter, jdbcType);
    }

    @Override
    public UUID getResult(ResultSet rs, String columnName) throws SQLException {
        return super.getResult(rs, columnName);
    }

    @Override
    public UUID getResult(ResultSet rs, int columnIndex) throws SQLException {
        return super.getResult(rs, columnIndex);
    }

    @Override
    public UUID getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return super.getResult(cs, columnIndex);
    }

}
