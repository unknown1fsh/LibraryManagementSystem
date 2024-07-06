@SpringBootApplication
@ComponentScan(basePackages = {"model", "controller", "service"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
