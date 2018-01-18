nohup java -jar microservice-discovery-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
echo $! > ./microservice-discovery-eureka-0.0.1-SNAPSHOT.jar.pid
echo "microservice-discovery-eureka-0.0.1-SNAPSHOT.jar"

sleep 5

nohup java -jar microservice-admin-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
echo $! > ./microservice-admin-0.0.1-SNAPSHOT.jar.pid
echo "microservice-admin-0.0.1-SNAPSHOT.jar"

sleep 5

nohup java -jar microservice-turbine-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
echo $! > ./microservice-turbine-0.0.1-SNAPSHOT.jar.pid
echo "microservice-turbine-0.0.1-SNAPSHOT.jar"

sleep 5

nohup java -jar microservice-zipkin-dashboard-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
echo $! > ./microservice-zipkin-dashboard-0.0.1-SNAPSHOT.jar.pid
echo "microservice-zipkin-dashboard-0.0.1-SNAPSHOT.jar"

sleep 5

nohup java -jar microservice-hystrix-dashboard-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
echo $! > ./microservice-hystrix-dashboard-0.0.1-SNAPSHOT.jar.pid
echo "microservice-hystrix-dashboard-0.0.1-SNAPSHOT.jar"

sleep 5

nohup java -jar microservice-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
echo $! > ./microservice-config-0.0.1-SNAPSHOT.jar.pid
echo "microservice-config-0.0.1-SNAPSHOT.jar"

sleep 5

nohup java -jar microservice-provider-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
echo $! > ./microservice-provider-0.0.1-SNAPSHOT.jar.pid
echo "microservice-provider-0.0.1-SNAPSHOT.jar"

sleep 5

nohup java -jar microservice-consumer-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
echo $! > ./microservice-consumer-0.0.1-SNAPSHOT.jar.pid
echo "microservice-consumer-0.0.1-SNAPSHOT.jar"

sleep 5


nohup java -jar microservice-gateway-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
echo $! > ./microservice-gateway-0.0.1-SNAPSHOT.jar.pid
echo "microservice-gateway-0.0.1-SNAPSHOT.jar"

