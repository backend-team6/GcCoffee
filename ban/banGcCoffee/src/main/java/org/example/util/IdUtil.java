package org.example.util;

import com.fasterxml.uuid.Generators;

import java.nio.ByteBuffer;
import java.util.UUID;

public class IdUtil {
    private static final char[] HEX_ARRAY = "0123456789ABCEDF".toCharArray();

    //UUID 생성 후 binary 변환
    static public byte[] createUUID(){
        UUID uuid = Generators.timeBasedGenerator().generate();
        String[] idParts = uuid.toString().split("-");
        // 생성된 UUID 순서대로 재 배치
        String seqId = idParts[2]+idParts[1]+idParts[0]+idParts[3]+idParts[4];

        String seqIdV1 = String.join("",seqId);
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(Long.parseUnsignedLong(seqIdV1.substring(0,16), 16));
        bb.putLong(Long.parseUnsignedLong(seqIdV1.substring(16), 16));

        return bb.array();
    }

    //사람이 식별 가능한 문자열로 변환
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars).toLowerCase();
    }
}
