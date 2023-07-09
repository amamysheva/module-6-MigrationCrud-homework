import database.service.ClientService;
import org.flywaydb.core.Flyway;

import java.util.ResourceBundle;


public class JDBCDemo {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("database_url");
    private static final String JDBC_URL = "jdbcURL";

    public static void main(String[] args) {
        Flyway.configure()
                .dataSource(resourceBundle.getString(JDBC_URL), null, null)
                .load()
                .migrate();

        ClientService clientService = new ClientService();
        System.out.println(clientService.create("New_Client"));
        System.out.println(clientService.getById(6));
        clientService.setName(3, "Client_NewName");
        clientService.deleteById(1);
        System.out.println(clientService.listAll());
    }
}
