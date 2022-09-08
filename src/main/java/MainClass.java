import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {

    private static final String TOKEN = "MTAxNzEyMDMxMzA3NjYxMzE3MA.GNqA_f.sZDv06wFE2uyG3stTzIZEu1SQa2nwmflCfzxXQ";

    public static void main(String[] args) throws LoginException, IOException {

        final var companyRoleIDs = new ArrayList<String>();

        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);

        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        jdaBuilder.setActivity(Activity.listening("Java Code Conventions"));

        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        JDA bot = jdaBuilder.build();
        bot.addEventListener(new MessageReceiver());
        bot.addEventListener(new JoinListener());
        bot.addEventListener(new RoleAddListener());


        Guild matseServer = null;
        try {
            matseServer = bot.awaitReady().getGuildById("1017119618319536168");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var roles = matseServer.getRoles();


        outer:
        for(Company c : Company.values()){

            for(Role r : roles){
                if(r.getName().equals(c.getDisplayName())){
                    c.setRoleID(r.getId());
                    continue outer;
                }
            }

            matseServer.createRole().setName(c.getDisplayName()).queue();


        }


    }

}
