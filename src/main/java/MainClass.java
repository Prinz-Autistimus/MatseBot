import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    private static final String TOKEN = "MTAxNzEyMDMxMzA3NjYxMzE3MA.GNqA_f.sZDv06wFE2uyG3stTzIZEu1SQa2nwmflCfzxXQ";

    public static void main(String[] args) throws LoginException, IOException {

        Scanner sc = new Scanner(new File("E:/Meine Daten/Discord Bots/MatseBot/Firmenliste.txt"));
        final var companies = new ArrayList<String>();

        while(sc.hasNextLine()){
            companies.add(sc.nextLine());
        }

        final var companyRoleIDs = new ArrayList<String>();





        companies.forEach(System.out::println);

        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);

        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        jdaBuilder.setActivity(Activity.listening("Java Code Conventions"));

        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        JDA bot = jdaBuilder.build();
        bot.addEventListener(new MessageReceiver());
        bot.addEventListener(new JoinListener());


    }

}
