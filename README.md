This is a simple template for a Springboot application. 

### Promethus

#### To run prometheus
```bash
$ docker run -d --net=host \
 -v $PROJECT_ROOT/src/main/resources/prometheus.yml:/etc/prometheus/prometheus.yml \
 prom/prometheus \
 --config.file=/etc/prometheus/prometheus.yml
```

#### To get the prometheus metrics
```bash
$ curl http://localhost:8080/actuator/prometheus

# HELP process_files_max_files The maximum file descriptor count
# TYPE process_files_max_files gauge
process_files_max_files 524288.0
# HELP tomcat_sessions_active_current_sessions  
# TYPE tomcat_sessions_active_current_sessions gauge
tomcat_sessions_active_current_sessions 0.0
...
# HELP books_time_get_seconds Time taken to return GET books request
# TYPE books_time_get_seconds summary
books_time_get_seconds_count{class="com.example.template.controller.BookController",exception="none",method="getBooks",} 5.0
books_time_get_seconds_sum{class="com.example.template.controller.BookController",exception="none",method="getBooks",} 0.142696108
# HELP books_time_get_seconds_max Time taken to return GET books request
# TYPE books_time_get_seconds_max gauge
books_time_get_seconds_max{class="com.example.template.controller.BookController",exception="none",method="getBooks",} 0.002485222
...
```

#### View the data
```
1. Open `http://localhost:9090/targets` to check if the target is correct and up
2. In the graph tab, put the metric e.g. process_cpu_usage to view the data
```