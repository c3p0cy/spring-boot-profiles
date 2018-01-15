Demo project for Spring Boot with @Profile
----------------------------------------------------
1. Use @Profile:
```java
@Service
@Profile({"development", "default"})
public class DevService implements WhoAmI {
  ...
}

@Service
@Profile({"production"})
public class ProdService implements WhoAmI {
  ....
}
```

2. Setup SpringBootApplication:
  * Implements CommandLineRunner: [Interface used to indicate that a bean should run when it is contained within a SpringApplication.](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/CommandLineRunner.html)
```java
public class SpringBootProfilesApplication implements CommandLineRunner {

	@Autowired
	private WhoAmI whoAmI;

	@Override
	public void run(String... strings) throws Exception {
		log.info(whoAmI.about());
	}
  ....
}
```

3. Just run it:
```
...
2018-01-15 15:04:38.412  INFO 16472 --- [           main] t.c.p.s.s.SpringBootProfilesApplication  : DevService
...
```
###### You will find out 'DevService' in the console log. It's the default profile that defined in DevService class.
----------------------------------------------------
###### References:
* [Spring Boot Profiles example](https://www.mkyong.com/spring-boot/spring-boot-profiles-example/)
* [Spring Boot 启动加载数据 CommandLineRunner](http://blog.csdn.net/catoop/article/details/50501710)