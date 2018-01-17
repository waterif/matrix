# 生成keystore
keytool -genkeypair -alias matrix -keyalg RSA -keypass matrix -keystore server.jks -storepass matrix -dname "CN=matrix,OU=matrix,O=matrix,L=SZ,S=JS,C=CN"


#加密
POST http://localhost:8888/encrypt

#解密
POST http://localhost:8888/decrypt


http://localhost:8888/info
http://localhost:8888/health
http://localhost:8888/env
http://localhost:8888/metrics
http://localhost:8888/beans

http://localhost:8888/microservice-provider/dev