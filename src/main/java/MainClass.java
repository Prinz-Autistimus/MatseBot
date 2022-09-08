import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.requests.RateLimiter;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    private static String token = "";

    private static Color companyColor;
    private static String[] messageIDs = new String[9];

    private static File tokenFile;
    private static File configFile;

    public static void main(String[] args) throws LoginException, IOException {
        JFileChooser fc = new JFileChooser();
        Scanner sc;

        fc.showOpenDialog(null);
        fc.setDialogTitle("Choose Token File");
        tokenFile = fc.getSelectedFile();
        sc = new Scanner(tokenFile);
        token = sc.nextLine();

        fc.setDialogTitle("Choose Config File");
        fc.showOpenDialog(null);
        configFile = fc.getSelectedFile();
        sc = new Scanner(configFile);
        companyColor = Color.decode(sc.nextLine());

        for(int i = 0; i < 9; i++){
            messageIDs[i] = sc.nextLine();
        }


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
            if(matseServer != null){
                generateRoles(matseServer);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void generateRoles(Guild server){

        var roles = server.getRoles();

        outer:
        for(Company c : Company.values()){

            try {
                Thread.sleep(50);
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
