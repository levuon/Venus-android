package com.venus.android.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import io.fabric.sdk.android.services.common.CommonUtils;

public class SecurityUtil {
    public static String encodeBase64(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }

    public static String decodeBase64(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }

    public String encode_md5(String str) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(CommonUtils.MD5_INSTANCE);
        instance.update(str.getBytes());
        return Base64.encodeToString(instance.digest(), 0);
    }

    public String encode_sha(String str) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE);
        instance.update(str.getBytes());
        return Base64.encodeToString(instance.digest(), 0);
    }

    public static String initMacKey() throws NoSuchAlgorithmException {
        return Base64.encodeToString(KeyGenerator.getInstance("HmacMD5").generateKey().getEncoded(), 0);
    }

    public static String encode_hmac(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        Key secretKeySpec = new SecretKeySpec(Base64.decode(str.getBytes(), 0), "HmacMD5");
        Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
        instance.init(secretKeySpec);
        return Base64.encodeToString(instance.doFinal(str2.getBytes()), 0);
    }

    public static String encode_aes(String str, String str2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        if (str == null || str.length() != 16) {
            return "keyֵ illegal";
        }
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128, new SecureRandom(str.getBytes()));
        Key secretKeySpec = new SecretKeySpec(instance.generateKey().getEncoded(), "AES");
        Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance2.init(1, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
        return Base64.encodeToString(instance2.doFinal(str2.getBytes()), 0);
    }

    public static String decode_aes(String str, String str2) throws Exception {
        if (str == null || str.length() != 16) {
            return "keyֵ illegal";
        }
        Key secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
        return new String(instance.doFinal(Base64.decode(str2.getBytes(), 0)));
    }

    public static byte[] encryptAes(String str, String str2) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128, new SecureRandom(str2.getBytes()));
            Key secretKeySpec = new SecretKeySpec(instance.generateKey().getEncoded(), "AES");
            Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = str.getBytes("utf-8");
            instance2.init(1, secretKeySpec);
            return instance2.doFinal(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptAes(byte[] bArr, String str) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128, new SecureRandom(str.getBytes()));
            Key secretKeySpec = new SecretKeySpec(instance.generateKey().getEncoded(), "AES");
            Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance2.init(2, secretKeySpec);
            return instance2.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return null;
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static String getSignValue(Map<String, Object> map) {
//        String payApiKey = ConstValue.getPayApiKey();
//        Object arrayList = new ArrayList(map.entrySet());
//        Collections.sort(arrayList, new bom());
//        StringBuilder stringBuilder = new StringBuilder();
//        Iterator it = arrayList.iterator();
//        while (it.hasNext()) {
//            Entry entry = (Entry) it.next();
//            stringBuilder.append((String) entry.getKey());
//            stringBuilder.append("=");
//            stringBuilder.append(entry.getValue().toString());
//            stringBuilder.append("&");
//        }
//        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        stringBuilder.append(payApiKey);
        return null;
    }

    public static String toMd5(String str) {
        byte[] bArr = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(CommonUtils.MD5_INSTANCE);
            instance.update(str.getBytes());
            bArr = instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return byteArray2Hex(bArr);
    }

    public static String byteArray2Hex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append("0123456789ABCDEF".charAt((b & 240) >> 4)).append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuilder.toString().toUpperCase();
    }
}
