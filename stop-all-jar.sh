PID=$(cat ./microservice-gateway-0.0.1-SNAPSHOT.jar.pid)
kill -9 $PID

sleep 5

PID=$(cat ./microservice-consumer-0.0.1-SNAPSHOT.jar.pid)
kill -9 $PID

sleep 5

PID=$(cat ./microservice-provider-0.0.1-SNAPSHOT.jar.pid)
kill -9 $PID

sleep 5

PID=$(cat ./microservice-config-0.0.1-SNAPSHOT.jar.pid)
kill -9 $PID

sleep 5

PID=$(cat ./microservice-hystrix-dashboard-0.0.1-SNAPSHOT.jar.pid)
kill -9 $PID

sleep 5

PID=$(cat ./microservice-zipkin-dashboard-0.0.1-SNAPSHOT.jar.pid)
kill -9 $PID

sleep 5

PID=$(cat ./microservice-turbine-0.0.1-SNAPSHOT.jar.pid)
kill -9 $PID

sleep 5

PID=$(cat ./microservice-admin-0.0.1-SNAPSHOT.jar.pid)
kill -9 $PID

sleep 5

PID=$(cat ./microservice-discovery-eureka-0.0.1-SNAPSHOT.jar.pid)
kill -9 $PID




