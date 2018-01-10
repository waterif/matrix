# 生成keystore
keytool -genkeypair -alias matrix -keyalg RSA -keypass matrix -keystore server.jks -storepass matrix -dname "CN=matrix,OU=matrix,O=matrix,L=SZ,S=JS,C=CN"