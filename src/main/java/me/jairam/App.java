package me.jairam;


import me.jairam.conf.ApiConf;
import me.jairam.jdbi.TransactionsDao;
import me.jairam.resources.TransactionResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class App extends Application<ApiConf> {

    @Override
    public String getName() {
        return "Hello World";
    }

    @Override
    public void initialize(Bootstrap<ApiConf> bootstrap) {

        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                                                new EnvironmentVariableSubstitutor())
        );
        super.initialize(bootstrap);
    }

    @Override
    public void run(ApiConf conf, Environment environment) {

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, conf.getDataSourceFactory(), "wrtystore");
        final TransactionsDao dao = jdbi.onDemand(TransactionsDao.class);
//        dao.createTable();

        final TransactionResource resource = new TransactionResource(dao);
        environment.jersey().register(resource);


    }

    public static void main(String[] args ) throws Exception {
        new App().run(args);
    }
}
