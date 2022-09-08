import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    private static String token = "";

    private static final Color companyColor = new Color(130, 130, 22);

    public static void main(String[] args) throws LoginException, IOException {

        Scanner sc = new Scanner(new File("O:/Workspaces/MatseBot/src/token.tkn"));
        token = sc.nextLine();

        final var companyRoleIDs = new ArrayList<String>();

        JDABuilder jdaBuilder = JDABuilder.createDefault(token);

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

        generateRoles(matseServer);



    }

    public static void generateRoles(Guild server){

        var roles = server.getRoles();

        outer:
        for(Company c : Company.values()){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for(Role r : roles){
                if(r.getName().equals(c.getDisplayName())){
                    c.setRoleID(r.getId());
                    r.getManager().setHoisted(true).setColor(companyColor).queue();
                    continue outer;
                }
            }

            server.createRole().setName(c.getDisplayName()).setHoisted(true).setColor(companyColor).queue();
            System.out.println("Rolle erstellt: " + c.getDisplayName());


        }
    }

}
