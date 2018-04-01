package com.xiu.test;

import java.security.Key;
import java.util.Map;

import com.xiu.utils.EncodedDecodeUtils;

public class Test {
	public static void main(String[] args) throws Exception {
		String base64EncodeSafe = EncodedDecodeUtils.base64EncodeSafe("base64被加密数据");
		System.out.println("base64加密后数据:\t"+base64EncodeSafe);
		System.out.println("base64解密后数据:\t"+EncodedDecodeUtils.base64Decode(base64EncodeSafe));
		System.out.println();
		System.out.println("md5加密后数据:\t"+EncodedDecodeUtils.md5HexEncoded("md5被加密数据"));
		System.out.println();
		Map<String, Key> initKey = EncodedDecodeUtils.initKey("私钥密码");
		initKey.forEach((k,v)->{
			System.out.println("钥匙类型:"+"\t\t"+k);
			System.out.println("值:");
			System.out.println(v.toString());
		});
		System.out.println("待加密数据:\t我要被加密");
		byte[] encodeByPublicKey = EncodedDecodeUtils.encodeByPublicKey("我要被加密".getBytes("UTF-8"),EncodedDecodeUtils.getPublicKeyByte(initKey));
		System.out.println("加密后数据:");
		System.out.println("\t"+new String(encodeByPublicKey));
		byte[] decodeByPrivateKey = EncodedDecodeUtils.decodeByPrivateKey(encodeByPublicKey, EncodedDecodeUtils.getPrivateKeyByte(initKey));
		System.out.println("解密后数据:");
		System.out.println("\t"+new String(decodeByPrivateKey));
	}
}
