package com.zzy.Utils.PublicKey;

/*
 * GetPublicKeyFromBase64����д��dex�ļ��е�x509����base64�ַ����Ĺ�Կ����Ҫ����乫Կ��ָ��
 * GetPublicKeyFromBase64Certificate���ڱ����֤�������Կ��ָ��
 */
public class GenPublicKeyAndEUse {
	public static void main(String[] args) {
		System.out.println("��base64�����x509����Ĺ�Կ���л�ȡ��Կ��ָ��");
		
		String RSABaseKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1v/vrIBIUASqx5CYjAURXqXGYuj0nApiwdK0ilUSm1HRxN2UWkK50bO2iw2P03HAPtwby6wa/OIqEAyPNvdJ5v53G3FsYAh2niyVHKaigcORLMFPB4ekadhqaCRZpmV91vvDR4MBJuvv40GtVfi4Dxlma1cYQ+2oi0n6bjqE5dPlmG+JBMcO4O7xGD8xcdYyiFHMbVxBa2dAqstcIORWBIcaAk5oULLyGOSdp8CR3uz3k7RtAmdRR3+8WJaSuPc51R8CNsiN4Zx7G8c32pf2i3Usb3xXG+2fKILN9TF7YusqSGHk1XSDr4elbM773C2/jCNLGeWR39+AYojlMHyZjwIDAQAB";
		GenPublicKeyAndEUtil.GetPublicKeyFromBase64(RSABaseKey);
		
		System.out.println("��base64�����֤���л�ȡ��Կ��ָ��");
		
		String Base64Certi ="MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk=";
		GenPublicKeyAndEUtil.GetPublicKeyFromBase64Certificate(Base64Certi);
	}
}
