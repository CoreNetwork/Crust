package us.core_network.crust.io;

import org.bukkit.Bukkit;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import us.core_network.crust.CrustPlugin;
import us.core_network.crust.claim.Claim;
import us.core_network.crust.util.AABBStore;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import static org.jooq.impl.DSL.table;

public class Database {
    private static Connection connectionSource;

    public static DSLContext create;

    public static void init(File dataFolder) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            CrustPlugin.getInstance().getLogger().log(Level.SEVERE, "Can't find SQLite JDBC class, claims won't work.", e);
            Bukkit.getPluginManager().disablePlugin(CrustPlugin.getInstance());
            return;
        }
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        String dbUrl = "jdbc:sqlite:" + dataFolder.getAbsolutePath() + File.separator +  "crust.sqlite";
        try {
            connectionSource = DriverManager.getConnection(dbUrl);
            create = DSL.using(new DefaultConfiguration()
                    .set(connectionSource)
                    .set(SQLDialect.SQLITE)
                    .set(new CustomRecordMapperProvider()));

        } catch (SQLException e) {
            CrustPlugin.getInstance().getLogger().log(Level.SEVERE, "Error while connecting to database " + dbUrl, e);
            Bukkit.getPluginManager().disablePlugin(CrustPlugin.getInstance());
            return;
        }
    }

    public static void loadClaims(AABBStore<Claim> store) {
        create.select().from(table("claim")).fetchInto(Claim.class).forEach(claim -> {
            store.put(claim.getHorizontalBounds(), claim);
        });
    }
}
